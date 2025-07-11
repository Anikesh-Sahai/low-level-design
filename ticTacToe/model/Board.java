package ticTacToe.model;

import java.util.List;

import ticTacToe.WinningStrategy.WinningStrategy;

public class Board {

    private Cell[][] grid;
    private final int size;
    private final int movesCount;
    private final List<WinningStrategy> winningStrategies;

    public Board(int size, List<WinningStrategy> winningStrategies) {
        this.size = size;
        grid = new Cell[size][size];
        movesCount = 0;
        // why are we initializing the board
        // when we create grid using grid = new Cell[size][size] it will the values with
        // null thats why we are initalizing with Empty
        initializeBoard();
        this.winningStrategies = winningStrategies;
    }

    private void initializeBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                grid[row][col] = new Cell();
            }
        }
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && col >= 0 && row < size && col < size && grid[row][col].isEmpty();
    }

    public void placeMove(int row, int col, Symbol symbol) {
        grid[row][col].setSymbol(symbol);
    }

    public boolean checkWin(Symbol symbol) {
        for (WinningStrategy winningStrategy : winningStrategies) {
            if (winningStrategy.checkWinner(this, symbol)) {
                return true;
            }
        }
        return false;
    }

    public boolean isFull() {
        return movesCount == size * size;
    }

    public void reset() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j].setSymbol(Symbol.E);
            }
        }
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j].getSymbol() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public Symbol getSymbol(int row, int col) {
        return grid[row][col].getSymbol();
    }

    public int getSize() {
        return size;
    }

}