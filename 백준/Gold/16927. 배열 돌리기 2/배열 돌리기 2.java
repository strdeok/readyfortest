import java.util.*;

public class Main {
	static int n;
	static int m;
	static int r;
	static int[][] map;
	static int[][] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		r = sc.nextInt();
		map = new int[n][m];
		result = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int k = 0; k < m; k++) {
				map[i][k] = sc.nextInt();
			}
		}

		// 몇 중인지 구하기
		int layer = calculateSquareLayer();

		for (int i = 1; i <= layer; i++) {
			rotateSquare(i);
		}

		for (int[] x : result) {
			for (int y : x) {
				System.out.print(y + " ");
			}
			System.out.println();
		}
	}

	static int calculateSquareLayer() {
		int total = n * m;
		int layer = 1;
		while (total > 0) {
			int next = (m - (2 * (layer - 1))) * 2 + (n - 2 * layer) * 2;
			total = total - next;
			if (total == 0)
				break;
			layer++;
		}
		return layer;
	}

	static void rotateSquare(int layer) {
		Queue<Integer> q = new LinkedList<>();
		// 하 우 상 좌
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		int direction = 0;
		int count = (m - (2 * (layer - 1))) * 2 + (n - 2 * layer) * 2;
		int nowX = layer - 1;
		int nowY = layer - 1;
		for (int i = 0; i < count; i++) {
			// 좌상단 하
			if (nowX == layer - 1 && nowY == layer - 1) {
				direction = 0;
			}
			// 좌하단 우
			if (nowX == layer - 1 && nowY == n - layer) {
				direction = 1;
			}
			// 우상단 좌
			if (nowY == layer - 1 && nowX == m - layer) {
				direction = 3;
			}
			// 우하단 상
			if (nowY == n - layer && nowX == m - layer) {
				direction = 2;
			}

			nowX = nowX + dx[direction];
			nowY = nowY + dy[direction];

			q.offer(map[nowY][nowX]);
		}
		int actualRotate = r % count;
		for (int i = 0; i < Math.abs(count - actualRotate); i++) {
			int head = q.poll();
			q.offer(head);
		}
		direction = 0;
		nowX = layer - 1;
		nowY = layer - 1;
		for (int i = 0; i < count; i++) {
			// 좌상단 하
			if (nowX == layer - 1 && nowY == layer - 1) {
				direction = 0;
			}
			// 좌하단 우
			if (nowX == layer - 1 && nowY == n - layer) {
				direction = 1;
			}
			// 우상단 좌
			if (nowY == layer - 1 && nowX == m - layer) {
				direction = 3;
			}
			// 우하단 상
			if (nowY == n - layer && nowX == m - layer) {
				direction = 2;
			}

			nowX = nowX + dx[direction];
			nowY = nowY + dy[direction];

			result[nowY][nowX] = q.poll();
		}

	}
}