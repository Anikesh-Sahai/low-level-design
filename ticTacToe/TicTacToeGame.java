package ticTacToe;

import java.util.List;

import ticTacToe.WinningStrategy.ColumnWinningStrategy;
import ticTacToe.WinningStrategy.DiagonalWinningStrategy;
import ticTacToe.WinningStrategy.RowWinningStrategy;
import ticTacToe.WinningStrategy.WinningStrategy;
import ticTacToe.model.Board;
import ticTacToe.model.GameStatus;
import ticTacToe.model.Player;

public class TicTacToeGame {

    private final Board board;
    private final Player[] players;
    private int curPlyerIndex = 0;
    private GameStatus gameStatus;

    public TicTacToeGame(Player p1, Player p2, int size) {
        List<WinningStrategy> winningStrategies = List.of(new RowWinningStrategy(), new ColumnWinningStrategy(),
                new DiagonalWinningStrategy());
        this.board = new Board(size, winningStrategies);
        this.players = new Player[] { p1, p2 };
        this.gameStatus = GameStatus.IN_PROGRESS;
    }

    public synchronized boolean playMove(int row, int col) {
        if (gameStatus != GameStatus.IN_PROGRESS) {
            throw new IllegalStateException("Game already finished.");
        }

        if (!board.isValidMove(row, col)) {
            throw new IllegalStateException("Invalid Move");
        }

        Player curPlayer = players[curPlyerIndex];
        board.placeMove(row, col, curPlayer.getSymbol());

        if (board.checkWin(curPlayer.getSymbol())) {
            gameStatus = GameStatus.WIN;
            System.out.println(curPlayer.getName() + " wins!");
        } else if (board.isFull()) {
            gameStatus = GameStatus.DRAW;
            System.out.println("Game ended in a draw.");
        } else {
            // how id this working 1-0 =0 and 1-1 =0 see it s roating always but it will
            // work only for 2
            curPlyerIndex = 1 - curPlyerIndex;
        }
        return true;
    }

    public synchronized void reset() {
        board.reset();
        gameStatus = GameStatus.IN_PROGRESS;
        curPlyerIndex = 0;
    }

    public GameStatus getStatus() {
        return gameStatus;
    }

    public void printBoard() {
        board.print();
    }
}