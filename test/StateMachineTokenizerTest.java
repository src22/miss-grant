import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class StateMachineTokenizerTest {

    StateMachineTokenizer tokenizer;

    String text = ""
            + "events "
            + "  doorClosed D1CL "
            + "  drawerOpened D2OP "
            + "end "
            + "  \n\n\n\n"
            + "commands "
            + "  unlockPanel PNUL "
            + "  lockPanel PNLK "
            + "end "
            + "  \n\n\n\n"
            + "state idle "
            + "  actions {unlockDoor lockPanel} "
            + "  doorClosed => active "
            + "end "

            ;

    @Before
    public void setUp() {
        tokenizer = new StateMachineTokenizer();
    }


    @Test
    public void testDoTheScan() throws Exception {

        tokenizer.setInputText(text);
        tokenizer.doTheScan();

        List<Token> tokenList = tokenizer.getTokenList();

        traceTokenList(tokenList);

        assertEquals(23, tokenList.size());
        assertToken(TokenType.TT_EVENT, tokenList.get(0));

    }



    // ---------------------------------------------------------

    private static void traceTokenList(List<Token> tokenList) {
        for(Token token : tokenList) {
            note(token.toString());
        }
    }

    private static void note(String str) {
        System.out.println(str);
    }


    private static void assertToken(TokenType expectedType, Token token) {
        assertEquals(expectedType, token.getType());

    }
}