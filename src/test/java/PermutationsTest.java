import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.stenerud.queens.Permutations;

public class PermutationsTest {
    private void sortPermutations(List<List<Integer>> list) {
        Collections.sort(list, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> listA, List<Integer> listB) {
                if(listA.size() > listB.size()) {
                    return 1;
                } else if(listA.size() < listB.size()) {
                    return -1;
                }
                for(int i = 0; i < listA.size(); i++) {
                    int valueA = listA.get(i);
                    int valueB = listB.get(i);
                    if(valueA != valueB) {
                        return valueA - valueB;
                    }
                }
                return 0;
            }
        });
    }

    @Test public void testToString() {
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> permutation;
        permutation = new ArrayList<>();
        permutation.add(0);
        permutation.add(1);
        permutation.add(2);
        expected.add(permutation);
        permutation = new ArrayList<>();
        permutation.add(0);
        permutation.add(2);
        permutation.add(1);
        expected.add(permutation);
        permutation = new ArrayList<>();
        permutation.add(1);
        permutation.add(0);
        permutation.add(2);
        expected.add(permutation);
        permutation = new ArrayList<>();
        permutation.add(1);
        permutation.add(2);
        permutation.add(0);
        expected.add(permutation);
        permutation = new ArrayList<>();
        permutation.add(2);
        permutation.add(0);
        permutation.add(1);
        expected.add(permutation);
        permutation = new ArrayList<>();
        permutation.add(2);
        permutation.add(1);
        permutation.add(0);
        expected.add(permutation);
        sortPermutations(expected);

        List<List<Integer>> actual = new ArrayList<>();
        Permutations.findPermutations(3, new Permutations.Callback() {
            @Override
            public void onNextPermutation(ArrayList<Integer> permutation) {
                actual.add((ArrayList<Integer>)permutation.clone());
            }
        });
        sortPermutations(actual);

        assertEquals(expected, actual);
    }
}
