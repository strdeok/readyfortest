import java.util.*;

public class Main {
	static int n;
	static int m;
	static int x;
	static int y;
	static int k;
	static int[][] graph;
	static int[] orders;
	static int[] dice = new int[] { 1, 2, 3, 4, 5, 6 };
	static int[] diceNum = new int[] { 0, 0, 0, 0, 0, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		k = sc.nextInt();

		graph = new int[n][m];
		orders = new int[k];

		for (int i = 0; i < n; i++) {
			for (int k = 0; k < m; k++) {
				graph[i][k] = sc.nextInt();
			}
		}

		for (int i = 0; i < k; i++) {
			orders[i] = sc.nextInt();
		}

		diceNum[6] = graph[x][y];
		for (int o : orders) {
			if (checkBoundary(o - 1)) {
				roll(o);
				System.out.println(diceNum[dice[0]]);
			} else {
				continue;
			}
		}
	}

	public static boolean checkBoundary(int dir) {
		// 동 서 북 남 y가 가로, x가 세로
		int[] dy = { 1, -1, 0, 0 };
		int[] dx = { 0, 0, -1, 1 };

		int ny = y + dy[dir];
		int nx = x + dx[dir];
		if (ny >= 0 && nx >= 0 && ny < m && nx < n) {
			x = nx;
			y = ny;
			return true;
		} else
			return false;

	}

	public static void roll(int order) {
		int[] copyDice = dice.clone();
		int upper = copyDice[0];
		int north = copyDice[1];
		int east = copyDice[2];
		int west = copyDice[3];
		int south = copyDice[4];
		int lower = copyDice[5];

		// 상 북 동 서 남 하
		// 0 1 2 3 4 5

		if (order == 1) { // 동
			copyDice[2] = upper;
			copyDice[5] = east;
			copyDice[0] = west;
			copyDice[3] = lower;
		}
		if (order == 2) { // 서
			copyDice[3] = upper;
			copyDice[0] = east;
			copyDice[5] = west;
			copyDice[2] = lower;
		}
		if (order == 3) { // 북
			copyDice[5] = north;
			copyDice[0] = south;
			copyDice[1] = upper;
			copyDice[4] = lower;
		}
		if (order == 4) { // 남
			copyDice[0] = north;
			copyDice[5] = south;
			copyDice[4] = upper;
			copyDice[1] = lower;
		}
		dice = copyDice;
		checkBottom();
	}

	public static void checkBottom() {
		if (graph[x][y] == 0) {
			graph[x][y] = diceNum[dice[5]];
		} else {
			diceNum[dice[5]] = graph[x][y];
			graph[x][y] = 0;
		}
	}
}