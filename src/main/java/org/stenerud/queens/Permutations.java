package org.stenerud.queens;

import java.util.Collections;
import java.util.ArrayList;

/**
 * Finds all permutations of a list.
 */
public class Permutations {
    public interface Callback {
        /**
         * Called whenever a new permutation is found.
         */
        public void onNextPermutation(ArrayList<Integer> permutation);
    }

    /**
     * Find all unique permutations from of a list of n integers ranging from 0 - n.
     * 
     * @param listSize the size of list to check.
     * @param callback gets called for each permutation.
     */
    public static void findPermutations(int listSize, Callback callback) {
        ArrayList<Integer> permutation = new ArrayList<>();
        for(int i = 0; i < listSize; i++) {
            permutation.add(i);
        }
        findPermutations(permutation, listSize, callback);
    }

    private static void findPermutations(ArrayList<Integer> permutation, int n, Callback callback) {
        if (n == 1) {
            callback.onNextPermutation(permutation);
            return;
        }
        for (int i = 0; i < n; i++) {
            Collections.swap(permutation, i, n-1);
            findPermutations(permutation, n-1, callback);
            Collections.swap(permutation, i, n-1);
        }
    }
}
