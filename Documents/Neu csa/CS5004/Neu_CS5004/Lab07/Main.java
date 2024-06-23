package cs5004.tictactoe;

import java.io.InputStreamReader;

/**
 * Main class to run the Tic Tac Toe game on the console.
 * This class serves as the entry point for the application, organizing the game's execution using the MVC pattern.
 */
public class Main {
    /**
     * The main method for running the Tic Tac Toe game interactively on the console.
     * It initializes the Model, View, and Controller, and starts the game.
     */
    public static void main(String[] args) {
        TicTacToeModel model = new TicTacToeModel();
        TicTacToeView view = new TicTacToeView(System.out);
        TicTacToeConsoleController controller = new TicTacToeConsoleController(
                new InputStreamReader(System.in), System.out);

        controller.setView(view); // Set the view
        controller.playGame(model); // Start the game
    }
}

