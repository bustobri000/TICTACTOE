package org.WalkerCC_CompSci;


import java.util.Scanner;

public class Game {
    private GameBoard gameBoard;
    private Player player1;
    private Player player2;
    private boolean isComplete = false;

    public Game(){
        gameBoard = new GameBoard();
        player1 = new Player(Space.X, 1);
        player2 = new Player(Space.O, 2);
    }

    public void Play() {
        //Clean this up so that it handles repetition and ends the game when its over.

        Scanner myScan = new Scanner(System.in);
        gameBoard.Draw();

        while(true) {
            System.out.println("Player 1:  Enter a location number.");
            int location = myScan.nextInt();

            gameBoard.PlaceOnBoard(player1.getPiece(), location);
            boolean ifWon = CheckForWin();
            if (ifWon) {
                System.out.println("Player 1 Wins");
                gameBoard.Draw();
                return;
            }
            if (IsFilled()) {
                System.out.println("Draw:  All Spaces Filled");
                gameBoard.Draw();
                return;
            }
            gameBoard.Draw();

            System.out.println("Player 2:  Enter a location number.");
            location = myScan.nextInt();

            gameBoard.PlaceOnBoard(player2.getPiece(), location);
            ifWon = CheckForWin();
            if (ifWon) {
                System.out.println("Player 2 Wins");
                gameBoard.Draw();
                return;
            }
            if (IsFilled()) {
                System.out.println("Draw:  All Spaces Filled");
                gameBoard.Draw();
                return;
            }
            gameBoard.Draw();
        }

    }

    private boolean CheckForWin() {
        //Implement this method.

        if (gameBoard.spacesText[0].equals(gameBoard.spacesText[1]) && gameBoard.spacesText[2].equals(gameBoard.spacesText[1])){
            return true;
        } else if (gameBoard.spacesText[3].equals(gameBoard.spacesText[4]) && gameBoard.spacesText[5].equals(gameBoard.spacesText[3])){
            return true;
        } else if (gameBoard.spacesText[6].equals(gameBoard.spacesText[7]) && gameBoard.spacesText[8].equals(gameBoard.spacesText[7])){
            return true;
        } else if (gameBoard.spacesText[0].equals(gameBoard.spacesText[3]) && gameBoard.spacesText[6].equals(gameBoard.spacesText[3])){
            return true;
        } else if (gameBoard.spacesText[1].equals(gameBoard.spacesText[4]) && gameBoard.spacesText[7].equals(gameBoard.spacesText[4])){
            return true;
        } else if (gameBoard.spacesText[2].equals(gameBoard.spacesText[5]) && gameBoard.spacesText[8].equals(gameBoard.spacesText[5])){
            return true;
        } else if (gameBoard.spacesText[0].equals(gameBoard.spacesText[4]) && gameBoard.spacesText[8].equals(gameBoard.spacesText[4])){
            return true;
        } else if (gameBoard.spacesText[2].equals(gameBoard.spacesText[4]) && gameBoard.spacesText[6].equals(gameBoard.spacesText[4])){
            return true;
        } else {
            return false;
        }

    }

    private boolean IsFilled() {
        for (int i = 0; i < 9; i++) {
            if (gameBoard.spaces[i] == Space.EMPTY){
                    return false;
            }
        }
        return true;
    }
}
