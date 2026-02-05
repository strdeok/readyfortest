import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;

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
			// 우 좌 상 하
			int[] dx1 = { 1, -1, 0, 0 };
			int[] dy1 = { 0, 0, -1, 1 };

			int max1 = 0;
			// 십자
			for (int i = 0; i < n; i++) { // row
				for (int j = 0; j < n; j++) { // col
					int nowKill = map[i][j];
					for (int k = 1; k < m; k++) { // m범위

						for (int p = 0; p < 4; p++) {
							int nx = j + dx1[p] * k;
							int ny = i + dy1[p] * k;

							if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
								nowKill += map[ny][nx];
							}
						}
					}
					max1 = Math.max(max1, nowKill);
				}
			}

			// 대각
			int[] dx2 = { -1, -1, 1, 1 };
			int[] dy2 = { 1, -1, -1, 1 };
			// 대각십자
			int max2 = 0;
			for (int i = 0; i < n; i++) { // row
				for (int j = 0; j < n; j++) { // col
					int nowKill = map[i][j];
					for (int k = 1; k < m; k++) { // m범위
						for (int p = 0; p < 4; p++) {
							int nx = j + dx2[p] * k;
							int ny = i + dy2[p] * k;

							if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
								nowKill += map[ny][nx];
							}
						}
					}
					max2 = Math.max(max2, nowKill);
				}
			}

			System.out.println("#" + test_case + " " + Math.max(max1, max2));
		}
	}
}