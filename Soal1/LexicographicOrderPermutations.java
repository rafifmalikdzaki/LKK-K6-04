package Soal1;

public class LexicographicOrderPermutations {
    public static void main(String[] args) {
    }

    public static void getNextLexicographicOrderPermutation(int[] currPerm, int length) {
        int i = length - 1;
        while (i >= 0 && currPerm[i - 1] >= currPerm[i]) {
            i--;
        }

        if (i < 0) {
            return;
        }

        int j = length;
        while (j > i && currPerm[j - 1] <= currPerm[i - 1]) {
            j--;
        }
    }
}