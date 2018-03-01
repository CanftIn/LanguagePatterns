package Multi;

public class Test {
    public static void main(String[] args) {
        LookaheadLexer lexer = new LookaheadLexer("[name = name, id = id, [home, work], phonenum]"); // parse arg
        LookaheadParser parser = new LookaheadParser(lexer, 2);
        parser.list(); // begin parsing at rule list
    }
}
