import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {

	private static int[][] rotate(int n, int[][] map) {
		int[][] temp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				temp[i][k] = map[n - k - 1][i];
			}
		}

		return temp;
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int[][] map = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int k = 0; k < n; k++) {
					map[i][k] = sc.nextInt();
				}
			}
			int[][] r90 = rotate(n, map);
			int[][] r180 = rotate(n, r90);
			int[][] r270 = rotate(n, r180);

			System.out.println("#" + test_case);
			for (int i = 0; i < n; i++) {
				for (int k = 0; k < n; k++) {
					System.out.print(r90[i][k]);
				}
				System.out.print(" ");
				for (int k = 0; k < n; k++) {
					System.out.print(r180[i][k]);
				}
				System.out.print(" ");
				for (int k = 0; k < n; k++) {
					System.out.print(r270[i][k]);
				}
				System.out.println();
			}
		}
	}
}