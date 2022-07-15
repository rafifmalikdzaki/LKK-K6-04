package Soal2;

// import java.util.*;

class MatrixMCM {
    double[][] harga;
    int[][] s;

    MatrixMCM(double[][] harga, int[][] s) {
        this.harga = harga;
        this.s = s;
    }
}

public class MCM {

    public static void main(String[] args) {
        int[] p = { 30, 35, 15, 5, 10, 20, 25, 70, 20, 50, 40, 30, 35, 15, 30, 35, 15, };
        MatrixMCM a = MCMopt(p);
        int[][] s = a.s;
        // System.out.println(Arrays.deepToString(a.harga));
        // System.out.println(Arrays.deepToString(a.s));
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[0].length; j++) {
                System.out.print(s[i][j] + " ");
            }
            System.out.println();
        }
        parens(a.s, 1, p.length - 1);

    }

    public static MatrixMCM MCMopt(int[] points) {
        int n = points.length;
        int p[] = points;
        double[][] harga = new double[n][n];
        int[][] s = new int[n][n];
        n = points.length - 1;

        for (int i = 0; i <= n; i++) {
            harga[i][i] = 0;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                harga[i][j] = Double.POSITIVE_INFINITY;
                for (int k = i; k <= j - 1; k++) {
                    double q = harga[i][k] + harga[k + 1][j] + (p[i - 1] * p[k] * p[j]);
                    if (q < harga[i][j]) {
                        harga[i][j] = q;
                        s[i][j] = k;
                    }
                }

            }
        }

        MatrixMCM a = new MatrixMCM(harga, s);

        return a;
    }

    public static void parens(int[][] s, int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            parens(s, i, s[i][j]);
            parens(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }
}
