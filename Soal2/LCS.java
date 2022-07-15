package Soal2;

// import java.util.*;

class MatrixA {
    int[][] c;
    char[][] b;

    MatrixA(int[][] c, char[][] b) {
        this.c = c;
        this.b = b;

    }

    MatrixA() {

    }
}

public class LCS {
    public static void main(String[] args) {
        String x = "ABCBDAB";
        String y = "BDCABA";
        char[] X = x.toCharArray();
        char[] Y = y.toCharArray();
        MatrixA a = LCSLength(X, Y);
        char[][] b = a.b;
        printLCS(b, X, X.length, Y.length);
    }

    public static MatrixA LCSLength(char[] x, char[] y) {
        int m = Math.max(x.length, y.length) + 1;
        int n = Math.min(x.length, y.length) + 1;
        int c[][] = new int[m][n];
        char b[][] = new char[m][n];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (x[i - 1] == y[j - 1]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = '\\';
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = '|';
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = '-';
                }
            }
        }
        MatrixA a = new MatrixA(c, b);
        return a;
    }

    public static void printLCS(char[][] b, char[] X, int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }

        if (b[i][j] == '\\') {
            printLCS(b, X, i - 1, j - 1);
            System.out.println(X[i - 1]);
        } else if (b[i][j] == '|') {
            printLCS(b, X, i - 1, j);
        } else {
            printLCS(b, X, i, j - 1);
        }
    }

}
