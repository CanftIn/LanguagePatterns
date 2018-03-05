package Backtrack;

import java.util.ArrayList;
import java.util.List;

public abstract class Parser {
    Lexer input;
    List<Integer> markers;
    List<Token> lookhead;
    int p = 0;

    public Parser(Lexer input){
        this.input = input;
        markers = new ArrayList<Integer>();
        lookhead = new ArrayList<Token>();
        sync(1);
    }

    public void consume() {
        p++;
        if(p == lookhead.size() && !isSpeculating()) {
            p = 0;
            lookhead.clear();
        }
        sync(1);
    }
    public void sync(int i){
        if(p+i-1 > (lookhead.size()-1)){
            int n = (p+i-1) - (lookhead.size()-1);
            fill(n);
        }
    }

    public void fill(int n){
        for(int i = 1; i <= n; ++i){
            lookhead.add(input.nextToken());
        }
    }

    public Token LT(int i){
        sync(i);
        return lookhead.get(p+i-1);
    }

    public int LA(int i){
        return LT(i).type;
    }

    public void match(int x) throws MismatchedTokenException {
        if(LA(1) == x) consume();
        else throw new MismatchedTokenException("expecting " +
                        input.getTokenName(x) + " found " + LT(1));
    }

    public int mark() {
        markers.add(p);
        return p;
    }

    public void release() {
        int marker = markers.get(markers.size()-1);
        markers.remove(markers.size()-1);
        seek(marker);
    }

    public void seek(int idx){
        p = idx;
    }

    public boolean isSpeculating() {
        return markers.size() > 0;
    }
}
