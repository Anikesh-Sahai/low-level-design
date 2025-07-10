package ticTacToe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

import ticTacToe.model.Board;
import ticTacToe.model.Player;
import ticTacToe.model.PlayingPieceO;
import ticTacToe.model.PlayingPieceX;

public class TicTacToeGame {


    // we have taken the deque because we have to remove the user and it in the back
    Deque <Player> players;

    Board gameBoard;

    // we can take input and add multiple user
    public TicTacToeGame(){
        initializeGame();
    }

    public void initializeGame(){
        players = new LinkedList<>();
        
        PlayingPieceX pieceX = new PlayingPieceX();
        PlayingPieceO pieceO = new PlayingPieceO();

        Player p1 = new Player("player 1", pieceX);
        Player p2 = new Player("player 2", pieceO);

        players.add(p1);
        players.add(p2);

        gameBoard = new Board(3);
    }

    public String startGame(){
        boolean noWinner = true;
        while (noWinner) {

            // taking out first player for turn
            Player currenPlayer = players.removeFirst();

            gameBoard.printBoard();

            // get free spaces

            List<Pair<Integer,Integer>> freeSpaces = gameBoard.getFreeSpaces();

            if(freeSpaces.isEmpty()){
                noWinner = false;
                continue;
            }

            // read the user input 

            System.out.print("Player: " +currenPlayer.getName()+" Emter row,column :");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int row = Integer.valueOf(values[0]);
            int column = Integer.valueOf(values[1]);

            // placing piece
            boolean pieceAdded = gameBoard.addPiece(row,column,currenPlayer.getPiece());
            if(!pieceAdded){
                // player can choose this cell nned to choose other cell;
                System.out.println("Incorrect position try again");
                players.addFirst(currenPlayer);
                continue;
            }
            players.addLast(currenPlayer);
            boolean winner = isThereWinner(row,column,currenPlayer.piece.type);

            if(winner){
                return currenPlayer.getName();
            }
        }
        return "Tie";
    }
    
}