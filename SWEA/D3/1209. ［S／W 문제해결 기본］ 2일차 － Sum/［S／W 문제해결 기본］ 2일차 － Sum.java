import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();
			int[][] map = new int[100][100];

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int max1 = 0;

			// 가로
			for (int i = 0; i < 100; i++) {
				int tmp = 0;
				for (int j = 0; j < 100; j++) {
					tmp += map[i][j];
				}
				max1 = Math.max(max1, tmp);
			}

			// 세로
			int max2 = 0;

			for (int i = 0; i < 100; i++) {
				int tmp = 0;
				for (int j = 0; j < 100; j++) {
					tmp += map[j][i];
				}
				max2 = Math.max(max2, tmp);
			}
			// 좌대각
			int max3 = 0;

			for (int i = 0; i < 100; i++) {
				max3 += map[i][i];

			}
			// 우대각
			int max4 = 0;

			for (int i = 0; i < 100; i++) {
				max4 += map[i][99 - i];

			}

			System.out.println("#" + T + " " + Math.max(Math.max(max1, max2), Math.max(max3, max4)));
		}
	}
}