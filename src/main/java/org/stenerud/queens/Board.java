package org.stenerud.queens;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents an x by x chess board.
 */
public class Board {
	final private int boardSize;
	private List<Integer> queens;

	public Board(List<Integer> xPositions) {
		this.boardSize = xPositions.size();
		queens = new ArrayList<>();
		for(int i = 0; i < boardSize; i++) {
			queens.add(xPositions.get(i));
		}
	}

	/**
	 * Check if this is a threatening chess board.
	 * A threatening board means a board where a queen is threatening another.
	 * It is assumed that the board is already set up for rook safety, and thus only diagonal attacks are checked.
	 */
	public boolean isThreateningBoard() {
		for(int firstY = 0; firstY < boardSize; firstY++) {
			int yStart = firstY + 1;
			int yEnd = boardSize;
			for(int secondY = yStart; secondY < yEnd; secondY++) {
				int firstX = queens.get(firstY);
				int secondX = queens.get(secondY);
				if(new Queen(firstX, firstY).canDiagonallyAttack(new Queen(secondX, secondY))) {
					return true;
				}
			}
		}
		return false;
	}

	private void addQueenToStringBuffer(int queenXPosition, StringBuffer stringBuffer) {
		for(int i = 0; i < queenXPosition; i++) {
			stringBuffer.append('-');
		}
		stringBuffer.append('*');
		for(int i = queenXPosition + 1; i < boardSize; i++) {
			stringBuffer.append('-');
		}
	}
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for(int queenXPosition: queens) {
			addQueenToStringBuffer(queenXPosition, buffer);
			buffer.append('\n');
		}
		buffer.deleteCharAt(buffer.length() - 1);
		return buffer.toString();
	}

}
