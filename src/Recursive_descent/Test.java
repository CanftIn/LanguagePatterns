package Recursive_descent;

public class Test {
    public static void main(String[] args) {
        ListLexer lexer = new ListLexer("[name, id, [home, work], phonenum]"); // parse command-line arg
        ListParser parser = new ListParser(lexer);
        parser.list(); // begin parsing at rule list
        // if wanna print result, just go Parser.match() and cancel println annotation.
    }
}
