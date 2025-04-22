import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import javax.swing.JTextField;
import javax.swing.Timer;

public class SudokuGUI extends javax.swing.JFrame {

    private JTextField[][] cell;
    private int[][] answerGrid;
    private int[][] userGrid;

    public SudokuGUI() {
        initComponents();
        playBanner();
    }

    int count = 0;

    void playBanner() {
        Timer t = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                count %= bannerText.getText().length();
                bannerText.setText(bannerText.getText().substring(count) + bannerText.getText().substring(0, count));
            }
        });
        t.start();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        bannerText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        gridLabel = new javax.swing.JLabel();
        gridTextfield = new javax.swing.JTextField();
        generateButton = new javax.swing.JButton();
        answerTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bannerText.setText("This Application is developed by Mr. Pratik Shinde under the guidance of Prof. Akshay Fajge sir. Rights are reserved.");
        bannerText.setEditable(false);

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        gridLabel.setText("Enter grid size ->");

        generateButton.setText("Generate");
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        answerTextField.setEditable(false);
        answerTextField.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        answerTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        answerTextField.setPreferredSize(new java.awt.Dimension(200, 50));

        jLabel1.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Answer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bannerText)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gridLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gridTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(generateButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(answerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gridLabel)
                    .addComponent(gridTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(generateButton))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(answerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(bannerText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int gridSize = Integer.parseInt(gridTextfield.getText());
            if (gridSize <= 0) {
                throw new NumberFormatException("Grid size must be positive.");
            }

            answerGrid = generateAnswerGrid(gridSize);
            userGrid = fillUserGrid(answerGrid);

            jPanel1.removeAll();
            jPanel1.setLayout(new GridLayout(gridSize, gridSize));
            cell = new JTextField[gridSize][gridSize];

            for (int i = 0; i < gridSize; i++) {
                for (int j = 0; j < gridSize; j++) {
                    cell[i][j] = new JTextField(userGrid[i][j] == 0 ? "" : String.valueOf(userGrid[i][j]));
                    cell[i][j].setHorizontalAlignment(JTextField.CENTER);
                    if (userGrid[i][j] != 0) {
                        cell[i][j].setEditable(false);
                        cell[i][j].setBackground(new java.awt.Color(173, 255, 47));
                    }
                    cell[i][j].setBackground(new java.awt.Color(255, 255, 153));
                    jPanel1.add(cell[i][j]);
                }
            }

            jPanel1.revalidate();
            jPanel1.repaint();
            answerTextField.setText("Grid created of size " + gridSize + "x" + gridSize);
        } catch (NumberFormatException ex) {
            answerTextField.setText("Invalid grid size!");
        }
    }

    private int[][] generateAnswerGrid(int size) {
        Random random = new Random(System.currentTimeMillis());
        int[][] grid = new int[size][size];
    
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int number;
                boolean isUnique;
                do {
                    number = random.nextInt(size) + 1;
                    isUnique = true;
                    for (int k = 0; k < j; k++) {
                        if (grid[i][k] == number) {
                            isUnique = false;
                            break;
                        }
                    }
                    if (isUnique) {
                        for (int k = 0; k < i; k++) {
                            if (grid[k][j] == number) {
                                isUnique = false;
                                break;
                            }
                        }
                    }
    
                } while (!isUnique);
                grid[i][j] = number;
            }
        }
        return grid;
    }
    

    private int[][] fillUserGrid(int[][] fullGrid) {
        int size = fullGrid.length;
        int[][] partialGrid = new int[size][size];
        Random random = new Random();
    
        int totalCells = size * size;
        int emptyCellsCount = totalCells / 2; 
    
        HashSet<Integer> emptyCellIndices = new HashSet<>();
    
        while (emptyCellIndices.size() < emptyCellsCount) {
            int randomIndex = random.nextInt(totalCells); 
            emptyCellIndices.add(randomIndex);
        }
    
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int index = i * size + j; 
                if (emptyCellIndices.contains(index)) {
                    partialGrid[i][j] = 0;
                } else {
                    partialGrid[i][j] = fullGrid[i][j];
                }
            }
        }
    
        return partialGrid;
    }
    

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int gridSize = answerGrid.length;
        int[][] filledGrid = new int[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                try {
                    filledGrid[i][j] = Integer.parseInt(cell[i][j].getText());
                } catch (NumberFormatException e) {
                    answerTextField.setText("Invalid entry in grid!");
                    return;
                }
            }
        }

        if (Arrays.deepEquals(filledGrid, answerGrid)) {
            answerTextField.setText("Congratulations! Your solution is correct.");
        } else {
            answerTextField.setText("Incorrect solution! Please try again.");
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SudokuGUI().setVisible(true);
            }
        });
    }

    private javax.swing.JTextField bannerText;
    private javax.swing.JButton generateButton;
    private javax.swing.JLabel gridLabel;
    private javax.swing.JTextField gridTextfield;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField answerTextField;
}
