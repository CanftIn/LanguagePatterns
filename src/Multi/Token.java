package Multi;

public class Token {
    public int type;
    public String text;
    public Token(int type, String text) {
        this.type = type;
        this.text = text;
    }

    public String toString() {
        String tname = LookaheadLexer.tokenNames[type];
        return "<'" + text + "'," + tname + ">";
    }
}
