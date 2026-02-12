import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[][] map = new int[n][n];
			int profit = 0;

			for (int i = 0; i < n; i++) {
				char[] tmp = sc.next().toCharArray();
				for (int k = 0; k < n; k++) {
					map[i][k] = tmp[k] - '0';
				}
			}
			int center = n / 2;
			for (int i = 0; i <= center; i++) { // y
				for (int j = 0; j <= i; j++) { // 범위
					if (j == 0) {
						if (i == center) {
							profit += map[i][center];
						} else {
							profit += map[i][center];
							profit += map[n - i - 1][center];
						}
					} else {
						if (i == center) {
							profit += map[i][center + j];
							profit += map[i][center - j];
						} else {
							// 양옆으로 퍼지는 로직
							// 맞은편 보는 로직
							profit += map[i][center + j];
							profit += map[i][center - j];
							profit += map[n - i - 1][center + j];
							profit += map[n - i - 1][center - j];
						}

					}

				}
			}
			System.out.println("#" + t + " " + profit);
		}
	}
}
