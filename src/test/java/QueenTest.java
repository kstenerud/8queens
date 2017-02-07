import org.junit.Test;
import static org.junit.Assert.*;

import org.stenerud.queens.Queen;

public class QueenTest {
    @Test public void testValidAttack() {
        Queen q1 = new Queen(0, 0);
        Queen q2 = new Queen(5, 5);
        assertTrue(q1.canDiagonallyAttack(q2));
        assertTrue(q2.canDiagonallyAttack(q1));
    }

    @Test public void testValidAttackBackwards() {
        Queen q1 = new Queen(4, 4);
        Queen q2 = new Queen(2, 2);
        assertTrue(q1.canDiagonallyAttack(q2));
        assertTrue(q2.canDiagonallyAttack(q1));
    }

    @Test public void testInvalidAttack() {
        Queen q1 = new Queen(0, 0);
        Queen q2 = new Queen(5, 6);
        assertFalse(q1.canDiagonallyAttack(q2));
        assertFalse(q2.canDiagonallyAttack(q1));
    }
}
