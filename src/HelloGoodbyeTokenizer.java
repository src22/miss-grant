public class HelloGoodbyeTokenizer extends GenericTokenizer {

    public HelloGoodbyeTokenizer() {
        addRecognizer("^Hello", TokenType.TT_HOWDY);
        addRecognizer("^Goodbye", TokenType.TT_BYEBYE);

    }


}
