package cs5004.tictactoe;

/**
 * This class define a enum,representing the player of the game.
 */

public enum Player {
    X, O;

    @Override
    public String toString() {
        // Returns the name of the player
        return this.name();
    }
}
