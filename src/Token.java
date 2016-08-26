public class Token {

    final TokenType type;
    final String content;


    public Token(String content, TokenType type) {
        this.content = content;
        this.type = type;
    }


    public TokenType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", content='" + content + '\'' +
                '}';
    }

}
