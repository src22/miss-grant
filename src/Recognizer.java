import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Recognizer {

    private Pattern pattern;
    private TokenType type;
    private boolean outputToken = true;

    public Recognizer(String regex, TokenType type) {
        pattern = Pattern.compile(regex);
        this.type = type;
    }

    public Recognizer(String regex, TokenType type, boolean outputToken) {
        pattern = Pattern.compile(regex);
        this.type = type;
        this.outputToken = outputToken;
    }

    public boolean match(String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    public int matchLen(String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.end();
        }
        return 0;
    }

    public String matchStr(String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }

    public TokenType getType() {
        return type;
    }

    public boolean isOutputToken() {
        return outputToken;
    }
}
