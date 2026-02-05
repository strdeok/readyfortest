import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();

			int[] counts = new int[5001];

			for (int i = 0; i < n; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();

				for (int j = start; j <= end; j++) {
					counts[j]++;
				}

			}
			System.out.print("#" + test_case);
			int p = sc.nextInt();

			for (int i = 0; i < p; i++) {
				int c = sc.nextInt();
				System.out.print(" " + counts[c]);
			}
			System.out.println();
		}
	}
}