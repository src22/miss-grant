import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class RecognizerTest {

    Recognizer recognizer;

    @Before
    public void setUp() throws Exception {
        recognizer = new Recognizer("^Hello", TokenType.TT_HOWDY);
    }

    @Test
    public void testMatch() throws Exception {
        assertTrue(recognizer.match("HelloHelloHello"));
    }

    @Test
    public void testMatchNot() throws Exception {
        assertFalse(recognizer.match("HAlloHelloHello"));
    }

    @Test
    public void testMatchLen() throws Exception {
        assertEquals(5, recognizer.matchLen("HelloHelloHello"));
    }

    @Test
    public void testMatchStr() throws Exception {
        assertEquals("Hello", recognizer.matchStr("HelloAaaaaaaaa"));
    }
}