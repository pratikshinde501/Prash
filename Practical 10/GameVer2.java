import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameVer2 {
    static String[][] gameGrid;
    static String[][] answerGrid;
    static String[][] playerGrid;
    static int numberLength;
    static int gridSize;
    static int blankCellCount;

    static String[][] generateGrid(int size) {
        String sizeString = Integer.toString(size);
        numberLength = sizeString.length();

        gameGrid = new String[2 * size + 1][2 * size + 1];
        playerGrid = new String[2 * size + 1][2 * size + 1];
        answerGrid = new String[2 * size + 1][2 * size + 1];

        for (int i = 0; i < gameGrid.length; i++) {
            Arrays.fill(gameGrid[i], "0");
        }

        String underscore = "_".repeat(numberLength);
        String space = " ".repeat(numberLength);

        for (int i = 0; i < 2 * size + 1; i++) {
            for (int j = 0; j < 2 * size + 1; j++) {
                if (i % 2 == 0) {
                    gameGrid[i][j] = (j % 2 == 0) ? "." : underscore;
                } else {
                    gameGrid[i][j] = (j % 2 == 0) ? "|" : space;
                }
            }
        }

        fillGrid(gameGrid, size);

        for (int i = 0; i < 2 * size + 1; i++) {
            System.arraycopy(gameGrid[i], 0, answerGrid[i], 0, gameGrid[i].length);
        }

        deleteRandomCells(gameGrid, size);

        for (int i = 0; i < 2 * size + 1; i++) {
            System.arraycopy(gameGrid[i], 0, playerGrid[i], 0, gameGrid[i].length);
        }

        return gameGrid;
    }

    static void fillGrid(String[][] grid, int size) {
        int start = (int) (System.nanoTime() % size + 1);
        for (int i = 1; i < 2 * size + 1; i += 2) {
            int temp = start;
            for (int j = 1; j < 2 * size + 1; j += 2) {
                grid[i][j] = String.format("%" + numberLength + "d", start);
                start = start % size + 1;
            }
            start = temp % size + 1;
        }
    }

    static void deleteRandomCells(String[][] grid, int size) {
        int count = 0;
        Random random = new Random();

        while (count < (size * size) / 3) {
            int row = random.nextInt(2 * size + 1);
            int column = random.nextInt(2 * size + 1);

            if (row % 2 == 0 || column % 2 == 0) {
                continue;
            }

            if (!grid[row][column].trim().isEmpty()) {
                grid[row][column] = " ".repeat(numberLength);
                count++;
            }
        }
    }

    static void updateGrid(int row, int column, int value) throws InterruptedException {
        if (row < 1 || row > gridSize || column < 1 || column > gridSize) {
            System.out.println("Invalid input. Please enter a valid row and column.");
            return;
        }

        row--;
        column--;

        if (playerGrid[2 * row + 1][2 * column + 1].trim().isEmpty()) {
            playerGrid[2 * row + 1][2 * column + 1] = String.format("%" + numberLength + "d", value);
            blankCellCount--;
        } else {
            System.out.println("Cell already filled.");
        }

        displayGrid(playerGrid);
    }

    static void displayGrid(String[][] grid) throws InterruptedException {
        for (String[] row : grid) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
        System.out.println("=".repeat(50));
        Thread.sleep(500);
    }

    public static void main(String[] args) throws InterruptedException {
        if (args.length == 0) {
            System.out.println("Please provide a valid grid size as a command-line argument.");
            return;
        }

        gridSize = Integer.parseInt(args[0]);

        if (gridSize < 1) {
            System.out.println("Please provide a positive integer for grid size.");
            return;
        }

        blankCellCount = 0;

        String[][] initialGrid = generateGrid(gridSize);

        for (String[] row : initialGrid) {
            for (String cell : row) {
                if (cell.trim().isEmpty()) {
                    blankCellCount++;
                }
            }
        }

        displayGrid(initialGrid);

        Scanner scanner = new Scanner(System.in);
        while (blankCellCount > 0) {
            System.out.println("Enter row number:");
            int row = scanner.nextInt();
            System.out.println("Enter column number:");
            int column = scanner.nextInt();
            System.out.println("Enter the number to place:");
            int number = scanner.nextInt();

            updateGrid(row, column, number);

            System.out.println("Do you want to continue? (0 - No, 1 - Yes):");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Thank you for playing!");
                return;
            }
        }

        boolean correct = true;
        for (int i = 0; i < 2 * gridSize + 1; i++) {
            for (int j = 0; j < 2 * gridSize + 1; j++) {
                if (!answerGrid[i][j].equals(playerGrid[i][j])) {
                    correct = false;
                    break;
                }
            }
        }

        if (correct) {
            System.out.println("Congratulations! You solved the puzzle.");
        } else {
            System.out.println("Some mistakes were found. Better luck next time!");
        }

        System.out.println("Thank you for playing!");
    }
}
