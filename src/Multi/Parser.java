package Multi;

public abstract class Parser {
    Lexer input;
    Token[] lookahead;  // circular lookahead buffer
    int k;              // number of lookahead symbols
    int p = 0;          // next token

    public Parser(Lexer input, int k){
        this.input = input;
        this.k = k;
        lookahead = new Token[k];
        for (int i = 1; i <= k; ++i)
            consume();
    }

    public void consume() {
        lookahead[p] = input.nextToken();
        p = (p + 1) % k;
    }

    public Token LT(int i) {return lookahead[(p+i-1) % k];} // circular fetch
    public int LA(int i) { return LT(i).type; }
    public void match(int x) {
        if ( LA(1) == x ) {
            consume();
        }
        else throw new Error("expecting "+input.getTokenName(x)+
                "; found "+LT(1));
    }
}
