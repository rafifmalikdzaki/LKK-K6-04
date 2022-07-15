package Soal1;

import java.util.Scanner;

public class JohnsonTrotter{
	private final static boolean kiriKanan = true;
	private final static boolean kananKiri = false;

	public static int cariArray(int a[], int n, int value) {
		for (int i = 0; i < n; i++){
			if (a[i] == value){
				return i + 1;
			}
		}
		return 0;
	}

	public static int terbesar(int a[], boolean dir[], int n) {
		int value_prev = 0, value = 0;
		for (int i = 0; i < n; i++) {
			if (dir[a[i]-1] == kananKiri && i!=0) {
				if (a[i] > a[i-1] && a[i] > value_prev) {
					value = a[i];
					value_prev = value;
				}
			}

			if (dir[a[i] - 1] == kiriKanan && i != n - 1) {
				if (a[i] > a[i+1] && a[i] > value_prev) {
					value = a[i];
					value_prev = value;
				}
			}
		}
	
		if (value == 0 && value_prev == 0) return 0;
		else return value;
	}

	public static int printSatu(int a[], boolean dir[], int n) {
		int value = terbesar(a, dir, n);
		int pos = cariArray(a, n, value);

		if (dir[a[pos-1]-1] == kananKiri) {
			int temp = a[pos-1];
			a[pos-1] = a[pos-2];
			a[pos-2] = temp;
		}
		else if (dir[a[pos-1]-1] == kiriKanan) {
			int temp = a[pos];
			a[pos] = a[pos-1];
			a[pos-1] = temp;
		}

		for (int i=0 ; i<n; i++) {
			if (a[i] > value) {
				if (dir[a[i]-1] == kiriKanan)
					dir[a[i]-1] = kananKiri;
		
				else if (dir[a[i]-1] == kananKiri)
					dir[a[i]-1] = kiriKanan;
			}
		}

		for (int i=0 ; i<n; i++) {
			System.out.print(a[i]);
		}
		System.out.print(" ");
		
		return 0;
	}

	public static int fact(int n) {
		int res = 1;
	
		for (int i = 1; i <= n; i++) {
			res = res * i;
		}
		return res;
	}

	public static void printPermutasi(int n) {
		int[] a = new int[n];
		boolean[] dir = new boolean[n];

		System.out.printf("%-17s%s", "Permutasi ke-1",": ");
		for (int i=0 ; i<n ; i++) {
			a[i] = i + 1;
			System.out.print(a[i]);
		}
		System.out.println();
		for (int i = 0; i < n; i++){
			dir[i] = kananKiri;
		}
		for (int i=1 ; i<fact(n) ; i++){
			System.out.printf("%-17s%s", "Permutasi ke-"+(i+1),": ");
			printSatu(a, dir, n);
			System.out.println();
		}
	}
	
	public static void main(String argc[]) {
		Scanner input = new Scanner(System.in);
		System.out.print("Masukkan banyaknya angka yang ingin dimasukkan : ");
		int n = input.nextInt();
		input.close();
		System.out.println();
		printPermutasi(n);
	}
}
