package ticTacToe.model;

public class Cell {
    private Symbol symbol;

    public Cell() {
        this.symbol = Symbol.E;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public boolean isEmpty() {
        return symbol == Symbol.E;
    }
}
