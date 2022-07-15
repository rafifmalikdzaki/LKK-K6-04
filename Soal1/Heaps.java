package Soal1;

class Heaps{
	public static void main(String[] args) {
		int[] angka= {1,2,3};
		int size= angka.length;
		sortingHeap(angka, size, size);
	}
	static void printHeap(int[] angka, int size) {
		for (int i = 0; i < size; i++){
			System.out.print(angka[i] + " ");
		}
		System.out.println();
	}
	static void sortingHeap(int[] angka, int size, int n) {
		if (size == 1)
		printHeap(angka, n);

	for (int i = 0; i < size; i++) {
		sortingHeap(angka, size - 1, n);

		if (size % 2 == 1) {
			int temp = angka[0];
			angka[0] = angka[size - 1];
			angka[size - 1] = temp;
		}
		
		else {
			int temp = angka[i];
			angka[i] = angka[size - 1];
			angka[size - 1] = temp;
			}
		}
	}
}
