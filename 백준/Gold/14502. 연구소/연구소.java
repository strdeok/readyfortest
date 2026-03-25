import java.util.*;

class Main {
	static int n;
	static int m;
	static int[][] graph;
	static int Max;
	static ArrayList<int[]> virus;
	static int[][] walls;
	static boolean[][] visited;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		virus = new ArrayList<>();

		graph = new int[n][m];
		walls = new int[3][2];
		visited = new boolean[n][m];
		
		Max = 0;

		for (int x = 0; x < n; x++) {
			for (int y = 0; y < m; y++) {
				int get = sc.nextInt();
				graph[x][y] = get;
				if (get == 2) {
					virus.add(new int[] { x, y });
				}
			}
		}
		
		makeWall(0);
		System.out.println(Max);
	}

	static void makeWall(int count) {
		if (count == 3) {
			int[][] copy = new int[n][m];
			for (int i = 0; i < n; i++) {
				copy[i] = graph[i].clone();
			}
			bfs(copy);
			return;
		}

		for (int x = 0; x < n; x++) {
			for (int y = 0; y < m; y++) {
				if (graph[x][y] == 0) {
					graph[x][y] = 1;
					makeWall(count + 1);
					graph[x][y] = 0;
				}
			}
		}
	}

	static void bfs(int[][] map) {
		Queue<int[]> q = new LinkedList<>();
		for (int[] v : virus) {
			q.add(v);
		}

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nx = now[0] + dx[dir];
				int ny = now[1] + dy[dir];

				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (map[nx][ny] == 0) {
						map[nx][ny] = 2;
						q.add(new int[] { nx, ny });
					}
				}
			}
		}
		
		safeZone(map);
	}

	static void safeZone(int[][] map) {
		int tmp = 0;
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < m; y++) {
				if (map[x][y] == 0) {
					tmp++;
				}
			}
		}
		Max = Math.max(tmp, Max);
	}

}