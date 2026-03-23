import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Hero {
	int x;
	int y;
	boolean hasSword;
	int seconds;

	public Hero(int x, int y, boolean hasSword, int seconds) {
		this.x = x;
		this.y = y;
		this.hasSword = hasSword;
		this.seconds = seconds;
	}
}

class Main {
	static int N, M, T;
	static ArrayList<Hero> succeed = new ArrayList<>();
	static int[][] graph;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		graph = new int[N][M];
		visited = new boolean[N][M];

		for (int x = 0; x < N; x++) {
			st = new StringTokenizer(br.readLine());
			for (int y = 0; y < M; y++) {
				int num = Integer.parseInt(st.nextToken());
				graph[x][y] = num;
			}
		}

		Queue<Hero> q = new LinkedList<>();
		q.add(new Hero(0, 0, false, 0));
		visited[0][0] = true;

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		while (!q.isEmpty()) {
			Hero now = q.poll();
			int x = now.x;
			int y = now.y;

			for (int dir = 0; dir < 4; dir++) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];

				if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if (!visited[nx][ny]) {
						if (graph[nx][ny] != 1) {
							visited[nx][ny] = true;

							if (graph[nx][ny] == 2) {
								int directDist = Math.abs((N - 1) - nx) + Math.abs((M - 1) - ny);
								int totalSeconds = now.seconds + 1 + directDist;
								succeed.add(new Hero(N - 1, M - 1, true, totalSeconds));
							} else if (graph[nx][ny] == 0) {
								Hero newPos = new Hero(nx, ny, false, now.seconds + 1);

								if (nx == N - 1 && ny == M - 1) {
									succeed.add(newPos);
								} else {
									q.add(newPos);
								}
							}
						}
					}
				}
			}
		}

		int Min = T + 1;
		for (Hero h : succeed) {
			if (h.seconds <= T) {
				Min = Math.min(h.seconds, Min);
			}
		}

		// BFS로 용사 넣고 탐색
		// 도달한 용사만 따로 넣고 seconds가 작은 것만 찾기
		System.out.println(Min == T + 1 ? "Fail" : Min);
	}
}