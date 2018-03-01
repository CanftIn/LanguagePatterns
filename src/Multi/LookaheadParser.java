package Multi;

public class LookaheadParser extends Parser {

    public LookaheadParser(Lexer input, int k) {
        super(input, k);
    }

    public void list() {
        match(LookaheadLexer.LBRACK);
        System.out.println("<" + lookahead[0].text + ", " + lookahead[0].type + ">");
        elements();
        match(LookaheadLexer.RBRACK);
        System.out.println("<" + lookahead[0].text + ", " + lookahead[0].type + ">");
    }

    void elements() {
        element(); while ( LA(1)==LookaheadLexer.COMMA ) {
            match(LookaheadLexer.COMMA);
            System.out.println("<" + lookahead[0].text + ", " + lookahead[0].type + ">");
            element();
        }
    }

    /** element : NAME '=' NAME | NAME | list ; assignment, NAME or list */
    void element() {
        if ( LA(1)==LookaheadLexer.NAME && LA(2)==LookaheadLexer.EQUALS ) {
            match(LookaheadLexer.NAME);
            match(LookaheadLexer.EQUALS);
            match(LookaheadLexer.NAME);
            System.out.println("<" + lookahead[0].text + ", " + lookahead[0].type + ">");
            System.out.println("<" + lookahead[1].text + ", " + lookahead[1].type + ">");
        }
        else if ( LA(1)==LookaheadLexer.NAME ) {
            match(LookaheadLexer.NAME);
            System.out.println("<" + lookahead[0].text + ", " + lookahead[0].type + ">");
        }
        else if ( LA(1)==LookaheadLexer.LBRACK ) {
            list();
            System.out.println("<" + lookahead[0].text + ", " + lookahead[0].type + ">");
        }
        else throw new Error("expecting name or list; found "+LT(1));
    }
}
