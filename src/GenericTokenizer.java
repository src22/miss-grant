import java.util.ArrayList;
import java.util.List;

public class GenericTokenizer {
    String inputText;
    List<Token> tokenList = new ArrayList<>();
    List<Recognizer> recognizerList = new ArrayList<>();
    boolean parseInProgress = false;

    public void doTheScan() {
        tokenList = new ArrayList<>();
        parseInProgress = true;
        while (parseInProgress) {
            matchAllRecognizers();
        }
    }

    private void matchAllRecognizers() {
        for (Recognizer recognizer : recognizerList) {
            boolean match = matchRecognizer(recognizer);
            if (match) return;
        }

        // did not match anything
        parseInProgress = false;
    }

    private boolean matchRecognizer(Recognizer recognizer) {
        if (recognizer.match(inputText)) {
            int len = recognizer.matchLen(inputText);
            String word = recognizer.matchStr(inputText);

            if (recognizer.isOutputToken())
            addToken(recognizer.getType(), word);

            inputText = inputText.substring(len);
            return true;
        }
        return false;
    }

    private void addToken(TokenType type, String word) {
        Token token = new Token(word, type);
        tokenList.add(token);
    }

    protected void addRecognizer(String regex, TokenType type) {
        recognizerList.add(new Recognizer(regex, type));
    }

    protected void addRecognizer(String regex, TokenType type, boolean outputToken) {
        recognizerList.add(new Recognizer(regex, type, outputToken));
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public List<Token> getTokenList() {
        return tokenList;
    }

    public void setTokenList(List<Token> tokenList) {
        this.tokenList = tokenList;
    }
}
