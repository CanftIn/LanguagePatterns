package Lexer;

public class Test {
    public static void main(String[] args) {
        ListLexer lexer = new ListLexer("[name, id, [home, work], phonenum]");
        Token t = lexer.nextToken();
        while ( t.type != Lexer.EOF_TYPE ) {
            System.out.println(t);
            t = lexer.nextToken();
        }
        System.out.println(t); // EOF
    }
}
