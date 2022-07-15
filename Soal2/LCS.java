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

        Scanner in = new Scanner(System.in);
        System.out.println("-----------");
        System.out.println("LCS Program");
        System.out.println("-----------\n");
        System.out.print("\nMasukkan String 1: ");
        String string1 = in.nextLine();
        System.out.print("Masukkan String2: ");
        String string2 = in.nextLine();

        char[] charString1 = string1.toCharArray();
        char[] charString2 = string2.toCharArray();

        MatrixLCS matrix = panjangLCS(charString1, charString2);
        char[][] arah = matrix.arah;
        int[][] harga = matrix.harga;
        System.out.println();
        printHarga(harga);
        printArah(arah);
        System.out.print("\nLongest Common Subsequence: ");
        printLCS(arah, charString1, charString1.length, charString2.length);
        in.close();
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
            System.out.print(charString1[i - 1] + " ");
        } else if (arah[i][j] == '|') {
            printLCS(arah, charString1, i - 1, j);
        } else {
            printLCS(arah, charString1, i, j - 1);
        }
    }

    public static void printHarga(int[][] harga) {
        System.out.println("Tabel Harga\n");
        for (int i = 0; i < harga.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < harga[0].length; j++) {
                System.out.print(harga[i][j] + "  ");
            }
            System.out.print("|");
            System.out.println();
        }
    }

    public static void printArah(char[][] arah) {
        System.out.println("\nTabel Arah\n");
        for (int i = 0; i < arah.length; i++) {
            System.out.print("[  ");
            for (int j = 0; j < arah[0].length; j++) {
                if (arah[i][j] == 0) {
                    System.out.print('0' + " ");
                } else
                    System.out.print(arah[i][j] + " ");
            }
            System.out.print(" ]");
            System.out.println();
        }

    }
}