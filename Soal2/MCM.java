package DynamicProgramming;

// import java.util.*;

class Matrix {
    double[][] m;
    int[][] s;

    Matrix(double[][] m, int[][] s) {
        this.m = m;
        this.s = s;
    }
}

public class MCM {

    public static void main(String[] args) {
        int[] p = { 30, 35, 15, 5, 10, 20, 25 };
        Matrix a = MCMopt(p);
        int[][] s = a.s;
        // System.out.println(Arrays.deepToString(a.m));
        // System.out.println(Arrays.deepToString(a.s));
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[0].length; j++) {
                System.out.print(s[i][j] + " ");
            }
            System.out.println();
        }
        parens(a.s, 1, 5);

    }

    public static Matrix MCMopt(int[] points) {
        int n = points.length;
        int p[] = points;
        double[][] m = new double[n][n];
        int[][] s = new int[n][n];
        n = points.length - 1;

        for (int i = 0; i <= n; i++) {
            m[i][i] = 0;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Double.POSITIVE_INFINITY;
                for (int k = i; k <= j - 1; k++) {
                    double q = m[i][k] + m[k + 1][j] + (p[i - 1] * p[k] * p[j]);
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }

            }
        }

        Matrix a = new Matrix(m, s);

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
