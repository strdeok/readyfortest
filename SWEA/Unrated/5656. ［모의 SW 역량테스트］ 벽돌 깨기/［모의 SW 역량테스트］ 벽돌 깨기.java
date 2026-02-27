import java.util.*;

class Solution {
	static int n, w, h;
	static int[][] map;
	static int[] com;
	static int MINBRICKS;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			n = sc.nextInt();
			w = sc.nextInt();
			h = sc.nextInt();
			map = new int[h][w];
			com = new int[n];
			MINBRICKS = Integer.MAX_VALUE;

			for (int i = 0; i < h; i++) {
				for (int k = 0; k < w; k++) {
					map[i][k] = sc.nextInt();
				}
			}

			shoot(0);

			System.out.println("#" + test_case + " " + MINBRICKS);
		}
	}

	// 쏠 라인 선택
	static void shoot(int cnt) {
		if (cnt == n) {
			int[][] tempMap = new int[h][w];
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					tempMap[i][j] = map[i][j];
				}
			}

			for (int c : com) {
				int topR = findTopBrick(tempMap, c);
				if (topR != -1) {
					explode(tempMap, topR, c);
					gravity(tempMap);
				}
			}

			countBricks(tempMap);
			return;
		}

		for (int i = 0; i < w; i++) {
			com[cnt] = i;
			shoot(cnt + 1);
		}
	}

	// 상위 블록 찾기
	static int findTopBrick(int[][] tempMap, int c) {
		for (int r = 0; r < h; r++) {

			if (tempMap[r][c] != 0) {
				return r;
			}
		}
		return -1;
	}

	// 연쇄작용
	// 좌표와 폭발 범위를 담을 객체 또는 배열이 필요합니다.
	static void explode(int[][] tempMap, int r, int c) {
		Queue<int[]> q = new LinkedList<>();

		if (tempMap[r][c] > 1) {
			q.offer(new int[] { r, c, tempMap[r][c] });
		}
		tempMap[r][c] = 0;

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			int range = now[2];

			for (int i = 0; i < 4; i++) {
				for (int k = 1; k < range; k++) {
					int nx = nowX + (dx[i] * k);
					int ny = nowY + (dy[i] * k);

					if (nx < 0 || nx >= h || ny < 0 || ny >= w)
						continue;

					// 4. 벽돌이 있다면?
					if (tempMap[nx][ny] != 0) {
						if (tempMap[nx][ny] > 1) {
							q.offer(new int[] { nx, ny, tempMap[nx][ny] });
						}
						tempMap[nx][ny] = 0;
					}
				}
			}
		}
	}

	// 밑으로 다운
	static void gravity(int[][] tempMap) {
		for (int c = 0; c < w; c++) {
			Queue<Integer> q = new LinkedList<>();

			for (int r = h - 1; r >= 0; r--) {
				if (tempMap[r][c] != 0) {
					q.offer(tempMap[r][c]);
					tempMap[r][c] = 0;
				}
			}

			int r = h - 1;
			while (!q.isEmpty()) {
				tempMap[r][c] = q.poll();
				r--;
			}
		}
	}

	static void countBricks(int[][] tempMap) {
		int sum = 0;
		for (int i = 0; i < h; i++) {
			for (int k = 0; k < w; k++) {
				if (tempMap[i][k] != 0) {
					sum++;
				}
			}
		}
		MINBRICKS = Math.min(sum, MINBRICKS);
	}
}
