import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.stenerud.queens.Board;

public class BoardTest {
    @Test public void testToString() {
        String expected = "*-------\n-*------\n--*-----\n---*----\n----*---\n-----*--\n------*-\n-------*";
        List<Integer> queens = new ArrayList<>();
        queens.add(0);
        queens.add(1);
        queens.add(2);
        queens.add(3);
        queens.add(4);
        queens.add(5);
        queens.add(6);
        queens.add(7);
        Board board = new Board(queens);
        assertEquals(expected, board.toString());
    }

    @Test public void testThreateningBoardSize8() {
        List<Integer> queens = new ArrayList<>();
        queens.add(0);
        queens.add(1);
        queens.add(2);
        queens.add(3);
        queens.add(4);
        queens.add(5);
        queens.add(6);
        queens.add(7);
        Board board = new Board(queens);
        assertTrue(board.isThreateningBoard());
    }

    @Test public void testThreateningBoardSize3() {
        List<Integer> queens = new ArrayList<>();
        queens.add(2);
        queens.add(0);
        queens.add(1);
        Board board = new Board(queens);
        assertTrue(board.isThreateningBoard());
    }

    @Test public void testNonThreateningBoard() {
        List<Integer> queens = new ArrayList<>();
        queens.add(3);
        queens.add(6);
        queens.add(2);
        queens.add(7);
        queens.add(1);
        queens.add(4);
        queens.add(0);
        queens.add(5);
        Board board = new Board(queens);
        assertFalse(board.isThreateningBoard());
    }
}
