package Soal1;

import java.util.*;

public class LexicographicOrderPermutations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Jumlah Angka Dalam Array: ");
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        System.out.println();
        printPermutations(arr);
        in.close();
    }

    public static void printPermutations(int[] arr) {
        int permNum = factorial(arr.length);
        System.out.println("Hasil Permutasi: ");
        for (int i = 1; i <= permNum; i++) {
            if (i != 1) {
                getNextLexicographicOrderPermutation(arr, arr.length);
            }
            System.out.println("Permutasi-" + i + " " + Arrays.toString(arr));
        }
    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
        swap(currPerm, i - 1, j - 1);
        i++;
        j = length;
        while (i < j) {
            swap(currPerm, i - 1, j - 1);
            i++;
            j--;
        }
    }
}