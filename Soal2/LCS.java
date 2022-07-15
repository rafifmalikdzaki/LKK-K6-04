package Soal2;

import java.util.*;

class MatrixLCS {
    int[][] harga;
    char[][] arah;

    MatrixLCS(int[][] harga, char[][] arah) {
        this.harga = harga;
        this.arah = arah;
    }

    MatrixLCS() {
    }
}

public class LCS {
    public static void main(String[] args) {
        String string1 = "ABCBDAB";
        String string2 = "BDCABA";
        char[] charString1 = string1.toCharArray();
        char[] charString2 = string2.toCharArray();
        MatrixLCS a = panjangLCS(charString1, charString2);
        char[][] arah = a.arah;
        printLCS(arah, charString1, charString1.length, charString2.length);
        System.out.println(Arrays.deepToString(arah));
    }

    public static MatrixLCS panjangLCS(char[] string1, char[] string2) {
        int m = Math.max(string1.length, string2.length) + 1;
        int n = Math.min(string1.length, string2.length) + 1;
        int harga[][] = new int[m][n];
        char arah[][] = new char[m][n];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (string1[i - 1] == string2[j - 1]) {
                    harga[i][j] = harga[i - 1][j - 1] + 1;
                    arah[i][j] = '\\';
                } else if (harga[i - 1][j] >= harga[i][j - 1]) {
                    harga[i][j] = harga[i - 1][j];
                    arah[i][j] = '|';
                } else {
                    harga[i][j] = harga[i][j - 1];
                    arah[i][j] = '-';
                }
            }
        }
        MatrixLCS a = new MatrixLCS(harga, arah);
        return a;
    }

    public static void printLCS(char[][] arah, char[] charString1, int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }

        if (arah[i][j] == '\\') {
            printLCS(arah, charString1, i - 1, j - 1);
            System.out.println(charString1[i - 1]);
        } else if (arah[i][j] == '|') {
            printLCS(arah, charString1, i - 1, j);
        } else {
            printLCS(arah, charString1, i, j - 1);
        }
    }

}
