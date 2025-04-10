package textanalyzer;

public class TextAnalyzerHelper {
    
    private String inputText;
    
    private int textLength;
    private int wordCount;
    private int lineCount;
    private int tabCount;
    private int spaceCount;
    private int specWordCount;
    private String uniqueCharText = "";

    public TextAnalyzerHelper(String inputText) {
        this.inputText = inputText;
        analyze();
    }

    public int getTextLength() {
        return textLength;
    }

    public int getWordCount() {
        return wordCount;
    }

    public int getLineCount() {
        return lineCount;
    }

    public int getTabCount() {
        return tabCount;
    }

    public int getSpaceCount() {
        return spaceCount;
    }
    public int getSpecWordCount(String text){
        specWordCount=inputText.split(text,-1).length-1;
        return specWordCount;
    }
    

    public String getUniqueCharText() {
        uniqueCharText = "";
        for (char c : inputText.toCharArray()) {
            if (!uniqueCharText.contains(String.valueOf(c)) && c != '\n' && c != '\t' && c != ' ') {
                uniqueCharText += c;
            }
        }
        return uniqueCharText;
    }

    public int getUniqueCharCount(String s) {
        int count = 0;
        char c=s.charAt(0);
        for (char a : inputText.toCharArray()) {
            if (a == c) {
                count++;
            }
        }
        return count;
    }
    
    private void analyze() {
        textLength = inputText.length();
        lineCount = textLength > 0 ? inputText.split("\n", -1).length : 0;
        tabCount = inputText.split("\t", -1).length - 1;
        spaceCount = inputText.split(" ", -1).length - 1;
        
        String[] str = inputText.split("[\n\t\\s]+");
        for (String s : str) {
            if (!s.isEmpty()) {
                wordCount++;
            }
        }
    }

    @Override
    public String toString() {
        return "TextAnalyzerHelper{" +
                "inputText='" + inputText + '\'' +
                ", textLength=" + textLength +
                ", wordCount=" + wordCount +
                ", lineCount=" + lineCount +
                ", tabCount=" + tabCount +
                ", spaceCount=" + spaceCount +
                ", uniqueCharText='" + getUniqueCharText() + '\'' +
                '}';
    }
}
