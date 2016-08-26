import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class HelloGoodbyeTokenizerTest {

    HelloGoodbyeTokenizer tokenizer;

    @Before
    public void setUp() {
        tokenizer = new HelloGoodbyeTokenizer();
    }


    @Test
    public void testDoTheScan() throws Exception {

        tokenizer.setInputText("Hello"+"Goodbye"+"Hello"+"Hello"+"Goodbye");
        tokenizer.doTheScan();

        List<Token> tokenList = tokenizer.getTokenList();

        assertEquals(5, tokenList.size());
        assertToken(TokenType.TT_HOWDY, tokenList.get(0));
        assertToken(TokenType.TT_BYEBYE, tokenList.get(1));
        assertToken(TokenType.TT_HOWDY, tokenList.get(2));
        assertToken(TokenType.TT_HOWDY, tokenList.get(3));
        assertToken(TokenType.TT_BYEBYE, tokenList.get(4));

    }


    // ---------------------------------------------------------

    private static void assertToken(TokenType expectedType, Token token) {
        assertEquals(expectedType, token.getType());

    }
}