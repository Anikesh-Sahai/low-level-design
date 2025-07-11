package ticTacToe.WinningStrategy;

import ticTacToe.model.Board;
import ticTacToe.model.Symbol;

public interface WinningStrategy {

    boolean checkWinner(Board board, Symbol symbol);
} 