package Recursive_descent;

public abstract class Parser {
    Lexer input;
    Token lookahead;

    public Parser(Lexer input) { this.input = input; consume(); }

    public void match(int x) {
        if(lookahead.type == x) {
            consume();
            //System.out.println("<" + lookahead.text + ", " + lookahead.type + ">");
        }
        else throw new Error("expecting "+input.getTokenName(x)+
                "; found "+ lookahead);
    }

    public void consume() {
        lookahead = input.nextToken();
    }
}
