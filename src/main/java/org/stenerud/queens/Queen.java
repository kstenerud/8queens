package org.stenerud.queens;

/**
 * Represents a queen for the purpose of checking for threats with another queen.
 */
public class Queen {
    public final int xPosition;
    public final int yPosition;

    public Queen(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public boolean canDiagonallyAttack(Queen otherQueen) {
        int xDiff = xPosition - otherQueen.xPosition;
        int yDiff = yPosition - otherQueen.yPosition;
        return Math.abs(xDiff) == Math.abs(yDiff);
    }
}
