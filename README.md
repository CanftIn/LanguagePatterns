# LanguagePatterns

Here are some useful language patterns. [Basic parsing patterns](#basic-parsing-patterns) are some frequently used patterns. And [high level parsing patterns](#high-level-parsing-patterns) include some difficult ways to analysis complex language. I strongly suggest you to read Terence Parr's Language Implementation Patterns. I learn a lot. But if you read, this repo may not useful for you.

## Basic Parsing Patterns:

- [x] LL(1) recursive descendent lexer
        
    package [Lexer](./src/Lexer)
- [x] LL(1) recursive descendent syntax parsing
        
    package [Recursive_descent](./src/Recursive_descent)
- [x] LL(k) recursive descendent syntax parsing

    package [Multi](./src/Multi)


## High Level Parsing Patterns:

- [x] backtracking parser
    
    package [Backtrack](./src/Backtrack)
- [ ] memory parser

- [ ] predicate parser


## Use ANTLR To Build Abstract Syntax Tree

// TODO LIST