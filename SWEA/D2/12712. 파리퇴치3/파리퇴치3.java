import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] map = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int most_kill = 0;

			// 좌 우 상 하
			int[] dx = { -1, 1, 0, 0 };
			int[] dy = { 0, 0, -1, 1 };

			// 가로
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int kill = map[i][j];
					for (int k = 0; k < 4; k++) {
						for (int p = 1; p < m; p++) {
							int nx = j + dx[k] * p;
							int ny = i + dy[k] * p;

							if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
								kill += map[ny][nx];
							}
						}

					}
					most_kill = Math.max(most_kill, kill);
				}
			}

			// 대각
			// 좌상 우상 좌하 우하
			int[] tx = { -1, 1, -1, 1 };
			int[] ty = { -1, -1, 1, 1 };

			// 가로
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int kill = map[i][j];
					for (int k = 0; k < 4; k++) {
						for (int p = 1; p < m; p++) {
							int nx = j + tx[k] * p;
							int ny = i + ty[k] * p;

							if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
								kill += map[ny][nx];
							}
						}

					}
					most_kill = Math.max(most_kill, kill);
				}
			}

			System.out.println("#" + test_case + " " + most_kill);
		}
	}
}