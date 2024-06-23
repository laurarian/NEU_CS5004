package cs5004.tictactoe;

import java.io.IOException;

/**
 * This class represents the view for a Tic Tac Toe game. It is responsible for
 * displaying the game state and prompts to the user.
 */
public class TicTacToeView {

    private final Appendable out;

    /**
     * Constructs a TicTacToeView with the given Appendable object to send outputs to.
     *
     * @param out the Appendable object where outputs are sent
     */
    public TicTacToeView(Appendable out) {
        this.out = out;
    }

    /**
     * Displays the current state of the game.
     *
     * @param board the current game board
     * @param turn  the player whose turn it is
     * @throws IOException if there is a failure when appending outputs
     */
    public void displayBoard(Player[][] board, Player turn) throws IOException {
        String[] lines = new String[6];
        lines[0] = "  0   1   2";
        lines[1] = "0  " + markToString(board[0][0]) + " | " + markToString(board[0][1]) + " | " + markToString(board[0][2]);
        lines[2] = "  ---------";
        lines[3] = "1  " + markToString(board[1][0]) + " | " + markToString(board[1][1]) + " | " + markToString(board[1][2]);
        lines[4] = "  ---------";
        lines[5] = "2  " + markToString(board[2][0]) + " | " + markToString(board[2][1]) + " | " + markToString(board[2][2]);

        for (String line : lines) {
            out.append(line).append("\n");
        }
    }

    /**
     * Converts a player's mark to a string representation.
     *
     * @param mark the player's mark (X or O), or null if the spot is empty
     * @return the string representation of the mark
     */
    private String markToString(Player mark) {
        return mark == null ? "-" : mark.toString();
    }

    /**
     * Prompts the current player to enter their move.
     *
     * @param turn the current player
     * @throws IOException if there is an issue appending the output
     */
    public void displayMovePrompt(Player turn) throws IOException {
        out.append("> ").append(turn.toString()).append(" player - Enter your move (row col), e.g., '0 0' for top-left:\n> ");
    }

    /**
     * Displays a message indicating no more inputs are available.
     *
     * @throws IOException if there is an issue appending the output
     */
    public void displayNoMoreInputs() throws IOException {
        out.append("No more inputs available.\n");
    }

    /**
     * Displays an error message for an invalid move.
     *
     * @throws IOException if there is a failure when appending outputs
     */
    public void displayInvalidMove() throws IOException {
        out.append("Invalid move! Try again\n");
    }

    /**
     * Displays a message for the end of the game with the outcome.
     *
     * @param winner the winning player, or null for a tie
     * @throws IOException if there is a failure when appending outputs
     */
    public void displayGameOver(Player winner) throws IOException {
        if (winner == null) {
            out.append("Game is over! Tie game.\n");
        } else {
            out.append("Game is over! ").append(winner.toString()).append(" wins.\n");
        }
    }

    /**
     * Displays a message for a game that has been quit.
     *
     * @param board the current game board at the time of quitting
     * @throws IOException if there is a failure when appending outputs
     */
    public void displayQuit(Player[][] board) throws IOException {
        // Similar to displayBoard, but with a message for quitting the game
        out.append("Game quit! Ending game state:\n");
        displayBoard(board, null);
    }
}
