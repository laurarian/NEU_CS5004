package cs5004.tictactoe;

import java.io.IOException;
import java.util.Scanner;

/**
 * Represents a console controller for a Tic Tac Toe game. This controller handles user input and output
 * to manage gameplay between two players on the console.
 */
public class TicTacToeConsoleController implements TicTacToeController {
    private final Readable in;
    private final Appendable out;
    private TicTacToeView view;


    /**
     * Constructs a new console controller for Tic Tac Toe.
     * @param in  Readable system input stream
     * @param out Appendable system output stream
     * @throws IllegalArgumentException if either 'in' or 'out' is null
     */
    public TicTacToeConsoleController(Readable in, Appendable out) {
        if (in == null || out == null) {
            throw new IllegalArgumentException("Input and output sources cannot be null.");
        }
        this.in = in;
        this.out = out;
    }


    /**
     * Sets the view for the Tic Tac Toe game. This method establishes the connection between the
     * controller and the user interface layer represented by the TicTacToeView.
     *
     * @param view the TicTacToeView instance that will display the game state and receive user input
     */
    public void setView(TicTacToeView view) {
        this.view = view;
    }


    /**
     * Starts a game of Tic Tac Toe using the provided game model, handles user interactions,
     * and updates the game state until the game concludes by a win, a tie, or a quit command.
     * @param m the TicTacToe game model
     * @throws IllegalArgumentException if the provided game model is null
     * @throws IllegalStateException if an IOException occurs during output
     */
    @Override
    public void playGame(TicTacToe m) {
        if (m == null) {
            throw new IllegalArgumentException("The game model cannot be null.");
        }

        Scanner scanner = new Scanner(this.in);
        boolean quit = false;

        try {
            // Display the initial state of the board using the view
            // out.append(m.toString()).append("\n");
            view.displayBoard(m.getBoard(), m.getTurn());

            while (!m.isGameOver() && !quit) {
                // Prompt now handled by the view
                // out.append("Enter a move for ").append(m.getTurn().toString()).append(":\n");
                view.displayMovePrompt(m.getTurn());

                // Check for end of input
                if (!scanner.hasNext()) {
                    // out.append("No more inputs available.\n");
                    view.displayNoMoreInputs();
                    break;
                }

                String input = scanner.next().trim();
                // Handle quit command
                if (input.equalsIgnoreCase("q")) {
                    quit = true;
                    // Display quitting game state using the view
                    // out.append("Game quit! Ending game state:\n").append(m.toString()).append("\n");
                    view.displayQuit(m.getBoard());
                } else {
                    int[] move = processInput(input, scanner);
                    // Handle valid move
                    if (move != null && move.length > 0) {
                        try {
                            m.move(move[0], move[1]);
                            // out.append(m.toString()).append("\n");
                            view.displayBoard(m.getBoard(), m.getTurn());
                        } catch (IllegalArgumentException e) {
                            // If move is invalid, call view method to display error message
                            view.displayInvalidMove();
                        }
                    }
                }
            }

            if (!quit && m.isGameOver()) {
                // out.append("Game is over! ").append(m.getWinner() == null ? "Tie game.\n" : m.getWinner().toString() + " wins.\n");
                view.displayGameOver(m.getWinner());
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed to append output, compromising game integrity.", e);
        } finally {
            scanner.close();
        }
    }

//    /**
//     * This version outputs directly using 'out' for unit testing with TicTacToeControllerTest.
//     *
//     * @param m a non-null TicTacToe model.
//     */
//    @Override
//    public void playGame(TicTacToe m) {
//        if (m == null) {
//            throw new IllegalArgumentException("The game model cannot be null.");
//        }
//
//        Scanner scanner = new Scanner(this.in);
//        boolean quit = false;
//
//        try {
//            out.append(m.toString()).append("\n");
//            while (!m.isGameOver() && !quit) {
//                out.append("Enter a move for ").append(m.getTurn().toString()).append(":\n");
//
//                // Check for end of input
//                if (!scanner.hasNext()) {
//                    out.append("No more inputs available.\n");
//                    break;
//                }
//
//                String input = scanner.next().trim();
//                // Handle quit command
//                if (input.equalsIgnoreCase("q")) {
//                    quit = true;
//                    out.append("Game quit! Ending game state:\n").append(m.toString()).append("\n");
//                } else {
//                    int[] move = processInput(input, scanner);
//                    // Handle valid move
//                    if (move != null && move.length > 0) {
//                        try {
//                            m.move(move[0], move[1]);
//                            out.append(m.toString()).append("\n");
//                        } catch (IllegalArgumentException e) {
//                            out.append("Invalid move: ").append(e.getMessage()).append("\n");
//                        }
//                    }
//                }
//            }
//
//            if (!quit && m.isGameOver()) {
//                out.append("Game is over! ").append(m.getWinner() == null ? "Tie game.\n" : m.getWinner().toString() + " wins.\n");
//            }
//        } catch (IOException e) {
//            throw new IllegalStateException("Failed to append output, compromising game integrity.", e);
//        } finally {
//            scanner.close();
//        }
//    }


    /**
     * Processes the user's input for one move, validates it, and if valid, returns the row and column as an array.
     * If the input includes a quit command or is invalid, returns null or a special flag (empty array for quit command).
     * @param firstInput the user's input for the row
     * @param scanner the scanner object to read the column input
     * @return an array containing the row and column indices, an empty array if quit command is detected, or null if the input is invalid
     */
    private int[] processInput(String firstInput, Scanner scanner) {
        if (!scanner.hasNext()) {
            // No column input is present after the row input, indicating incomplete input
            return null;
        }

        String secondInput = scanner.next().trim();
        if (secondInput.equalsIgnoreCase("q")) {
            // Quit command found during input processing
            return new int[0];
        }

        try {
            int row = Integer.parseInt(firstInput);
            int col = Integer.parseInt(secondInput);
            // Return the validated row and column indices
            return new int[]{row, col};
        } catch (NumberFormatException e) {
            // Input was not a valid integer
            return null;
        }
    }
}
