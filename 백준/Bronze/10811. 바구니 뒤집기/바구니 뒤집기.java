import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] basket = new int[n];

		for (int i = 0; i < n; i++) {
			basket[i] = i + 1;
		}

		for (int i = 0; i < m; i++) {
			int[] copied = basket.clone();
			int start = sc.nextInt() - 1;
			int end = sc.nextInt() - 1;

			int index = end;
			for (int k = start; k <= end; k++) {
				copied[index] = basket[k];
				index--;
			}
			basket = copied;
		}
		for (int i : basket) {
			System.out.print(i + " ");
		}
	}
}