package org.stenerud.queens;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Finds all permutations of queens on a chess board where the queens do not threaten each other.
 */
public class BoardPermutations {
    /**
     * Find all non-threatening permutations for a board of the specified size.
     * 
     * @param boardSize the chess board size to find permutations for.
     */
    public static List<Board> findSuccessfulPermutations(int boardSize) {
        List<Board> boards = new LinkedList<>();
        Permutations.findPermutations(boardSize, new Permutations.Callback() {
            public void onNextPermutation(ArrayList<Integer> permutation) {
                Board board = new Board(permutation);
                if(!board.isThreateningBoard()) {
                    boards.add(board);
                }
            }
        });
        return boards;
    }
}
