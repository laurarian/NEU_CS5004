package cs5004.tictactoe;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TicTacToeModel implements TicTacToe {
    // add your implementation here
    private Player[][] board; // Represents the game boarda
    private Player currentPlayer; // Tracks the current player

    /**
     * Constructs a new TicTacToeModel. Initializes the game board to be empty and sets
     * the starting player to X, according to Tic Tac Toe rules.
     */
    public TicTacToeModel() {
        this.board = new Player[3][3];
        this.currentPlayer = Player.X; // X starts the game
    }

    /**
     * Execute a move in the position specified by the given row and column.
     *
     * @param r the row of the intended move
     * @param c the column of the intended move
     * @throws IllegalArgumentException if the space is occupied or the position is otherwise invalid
     * @throws IllegalStateException if the game is over
     */
    @Override
    public void move(int r, int c) {
        if (r < 0 || r >= 3 || c < 0 || c >= 3) {
            throw new IllegalArgumentException("Invalid board position.");
        }
        if (board[r][c] != null) {
            throw new IllegalArgumentException("Position already taken.");
        }
        if (isGameOver()){
            throw new IllegalStateException("Game is already over.");
        }

        board[r][c] = currentPlayer;
        currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X;
    }

    /**
     * Get the current turn, i.e., the player who will mark on the next call to move().
     *
     * @return the {@link Player} whose turn it is
     */
    @Override
    public Player getTurn() {
        return currentPlayer;
    }

    /**
     * Return whether the game is over. The game is over when either the board is full, or
     * one player has won.
     *
     * @return true if the game is over, false otherwise
     */
    @Override
    public boolean isGameOver() {
        // If there's a winner, the game is over
        if (getWinner() != null) {
            return true;
        }
        // If all cells are filled and no winner, the game is over
        for (Player[] row : board) {
            for (Player p : row) {
                if (p == null) {
                    return false;// There's at least one cell not filled
                }
            }
        }
        return true;
    }

    /**
     * Return the winner of the game, or {@code null} if there is no winner. If the game is not
     * over, returns {@code null}.
     *
     * @return the winner, or null if there is no winner
     */
    @Override
    public Player getWinner() {
        // Check all rows, columns, and both diagonals
        for (int i = 0; i < 3 ; i++) {
            // Check rows
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != null ) {
                return board[i][0];
            }
            // Check colums
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != null ) {
                return board[0][i];
            }
        }
        // Check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != null ) {
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != null ) {
            return board[0][2];
        }
        // No winner
        return null;
    }

    /**
     * Return the current game state, as a 2D array of Player. A {@code null} value in the grid
     * indicates an empty position on the board.
     *
     * @return the current game board
     */
    @Override
    public Player[][] getBoard() {
        Player[][] copy = new Player[3][3];
        for (int i = 0; i < 3 ; i++) {
            System.arraycopy(board[i], 0,copy[i],0,board[i].length);

        }
        return copy;
    }

    /**
     * Return the current {@link Player} mark at a given row and column, or {@code null} if the
     * position is empty.
     *
     * @param r the row
     * @param c the column
     * @return the player at the given position, or null if it's empty
     */
    @Override
    public Player getMarkAt(int r, int c) {
        if (r < 0 || r >= 3 || c < 0 || c >= 3) {
            throw new IllegalArgumentException("Invalid board position.");
        }
        return board[r][c];
    }

    @Override
    public String toString() {
        // Using Java stream API to save code:
        return Arrays.stream(getBoard()).map(
                        row -> " " + Arrays.stream(row).map(
                                p -> p == null ? " " : p.toString()).collect(Collectors.joining(" | ")))
                .collect(Collectors.joining("\n-----------\n"));
        // This is the equivalent code as above, but using iteration, and still using
        // the helpful built-in String.join method.
        /**********
         List<String> rows = new ArrayList<>();
         for(Player[] row : getBoard()) {
         List<String> rowStrings = new ArrayList<>();
         for(Player p : row) {
         if(p == null) {
         rowStrings.add(" ");
         } else {
         rowStrings.add(p.toString());
         }
         }
         rows.add(" " + String.join(" | ", rowStrings));
         }
         return String.join("\n-----------\n", rows);
         ************/
    }
}
