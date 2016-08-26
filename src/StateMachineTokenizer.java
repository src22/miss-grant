import java.util.ArrayList;
import java.util.List;

public class StateMachineTokenizer extends GenericTokenizer {

    public StateMachineTokenizer() {
        addRecognizer("^events", TokenType.TT_EVENT);
        addRecognizer("^resetEvents", TokenType.RESET);
        addRecognizer("^commands", TokenType.COMMAND);
        addRecognizer("^end", TokenType.END);

        addRecognizer("^state", TokenType.STATE);
        addRecognizer("^actions", TokenType.ACTIONS);

        addRecognizer("^\\{", TokenType.LEFT);
        addRecognizer("^\\}", TokenType.RIGHT);

        addRecognizer("^=>", TokenType.TRANSITION);
        addRecognizer("^(\\w)+", TokenType.IDENTIFIER);

        addRecognizer("^(\\s)+", TokenType.WHITESPACE, false);
        addRecognizer("^\\\\(.)*$", TokenType.COMMENT, false);

        // this does not work, as expected by me...
        // addRecognizer("^EOF", TokenType.EOF, false);

    }


}
