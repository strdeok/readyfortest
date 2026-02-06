import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = sc.nextInt();
			int[][] map = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int k = 0; k < n; k++) {
					map[i][k] = sc.nextInt();
				}
			}
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				boolean isN = false;
				for (int k = 0; k < n; k++) {
					int num = map[k][i];

					if (num == 1) {
						isN = true;
					} else if (num == 2 && isN) {
						cnt++;
						isN = false;
					}
				}
			}
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}