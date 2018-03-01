package Multi;

public abstract class Lexer {
    public static final char EOF = (char)-1;
    public static final int EOF_TYPE = 1;
    String input;
    int idx = 0;    // index into input of current character
    char c;         // current character

    public Lexer(String input){
        this.input = input;
        c = input.charAt(idx);
    }

    public void consume() {
        advance();
        WS();
    }

    public void advance() {
        idx++;
        if(idx >= input.length()) c = EOF;
        else c = input.charAt(idx);
    }

    public void match(char x){
        if(c == x) consume();
        else throw new Error("expecting " + x + "; found " + c);
    }

    public abstract Token nextToken();
    abstract void WS();
    public abstract String getTokenName(int tokenType);
}