package Dontuse;

public class ListLexer extends Lexer {
    public static int plus = 2;
    public static int minus = 3;
    public static int A = 4;
    public static int S = 4;
    public static String[] tokenNames = {
            "<EOF>", "PLUS", "MINUS", "A", "S"
    };

    public ListLexer(String input) { super(input); }

    @Override
    public Token nextToken() {
        while(c != EOF){
            switch (c){
                case ' ': case '\t': case '\n': case '\r': WS(); continue;
                case '+': consume(); return new Token(plus, "+");
                case '-': consume(); return new Token(minus, "-");
                case 'a': consume(); return new Token(A, "a");
                case 'S': consume(); return new Token(S, "S");
            }
        }
        return new Token(EOF_TYPE,"<EOF>");
    }

    @Override
    public String getTokenName(int x) {
        return tokenNames[x];
    }

    /** WS : (' '|'\t'|'\n'|'\r')* ; // ignore any whitespace */
    void WS() {
        while ( c==' ' || c=='\t' || c=='\n' || c=='\r' ) consume();
    }
}
