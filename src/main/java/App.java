import java.util.List;
import org.stenerud.queens.Board;
import org.stenerud.queens.BoardPermutations;

/**
 * Solution app for the n queens problem.
 * Doesn't check command line arguments since it's a royal pain in the ass to do it via gradle.
 */
public class App {

    public static void main(String[] args) {
        int boardSize = 8;
        System.out.println("Finding all non-threatening permutations for board size " + boardSize + "...");
        List<Board> boards = BoardPermutations.findSuccessfulPermutations(boardSize);
        System.out.println("Found " + boards.size() + " boards");
        if(boards.size() < 100) {
            for(Board board: boards) {
                System.out.println(board + "\n");
            }
        }
    }
}
