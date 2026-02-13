import java.util.Scanner;

public class Solution {
	static int n;
	static int[][] map;
	static boolean[] visited;
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			n = sc.nextInt();
			map = new int[n][n];
			min = Integer.MAX_VALUE;
			visited = new boolean[n];

			// 초기 값 저장
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			combination(0, 0);
			System.out.println("#" + t + " " + min);
		}
	}

	// 조합 구하기
	public static void combination(int idx, int count) { // 재료번호, 개수
		if (count == n / 2) {
			calculate();
			return;
		}
		if (idx == n)
			return;

		// 재료 선택
		visited[idx] = true;
		combination(idx + 1, count + 1);

		// 재료 선택 안함
		visited[idx] = false;
		combination(idx + 1, count);
	}

	// 시너지 계산
	public static void calculate() {
		int a = 0;
		int b = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i] && visited[j]) {
					a += map[i][j];
				} else if (!visited[i] && !visited[j]) {
					b += map[i][j];
				}
			}
		}
		
		int diff = Math.abs(a - b);
		min = Math.min(diff, min);
	}
}
