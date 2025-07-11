package ticTacToe.WinningStrategy;

import ticTacToe.model.Board;
import ticTacToe.model.Symbol;

public class ColumnWinningStrategy implements WinningStrategy{
    
    @Override
    public boolean checkWinner(Board board, Symbol symbol){
        for (int row = 0; row < board.getSize(); row++) {
            boolean allMatch = true;
            for (int col = 0; col < board.getSize(); col++) {
                if (board.getSymbol(row, col) != symbol) {
                    allMatch = false;
                    break;
                }
            }
            if (allMatch) return true;
        }
        return false;
    }
}
