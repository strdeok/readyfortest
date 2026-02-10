import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
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

			// 90도
			int[][] ninety = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int k = 0; k < n; k++) {
					ninety[i][k] = map[n - k - 1][i];
				}
			}

			// 180도
			int[][] hundredseighty = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int k = 0; k < n; k++) {
					hundredseighty[i][k] = map[n - i - 1][n - k - 1];
				}
			}

			// 270도
			int[][] twoseven = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int k = 0; k < n; k++) {
					twoseven[i][k] = map[k][n - i - 1];
				}
			}

			System.out.println("#" + test_case);
			for (int i = 0; i < n; i++) {
				for (int k = 0; k < n; k++) {
					System.out.print(ninety[i][k]);
				}
				System.out.print(" ");
				for (int k = 0; k < n; k++) {
					System.out.print(hundredseighty[i][k]);
				}
				System.out.print(" ");
				for (int k = 0; k < n; k++) {
					System.out.print(twoseven[i][k]);
				}
				System.out.println();
			}
		}
	}
}