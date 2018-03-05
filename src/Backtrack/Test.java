package Backtrack;

public class Test {
    public static void main(String[] args) throws RecognitionException {
        BacktrackLexer lexer = new BacktrackLexer("[test = t, a, b, [c, d, [e, f], g], hh = hhh]"); // parse arg
        BacktrackParser parser = new BacktrackParser(lexer);
        //System.out.println(parser.LT(11)); // can look far ahead
        parser.stat(); // begin parsing at rule stat
    }
}
