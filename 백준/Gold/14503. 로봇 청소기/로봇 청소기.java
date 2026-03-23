import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int n, m, r, c, direction;
	static int[][] graph;
	static boolean[][] visited;

	// 북 동 남 서
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int cnt = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n][m];
		visited = new boolean[n][m];

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		direction = Integer.parseInt(st.nextToken());

		for (int x = 0; x < n; x++) {
			st = new StringTokenizer(br.readLine());
			for (int y = 0; y < m; y++) {
				graph[x][y] = Integer.parseInt(st.nextToken());
			}
		}
		visited[r][c] = true;
		dfs(r, c);

		System.out.println(cnt);
	}

	static void dfs(int x, int y) {
		boolean allTrue = true;
		// 4방 탐색
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			// 청소 가능한 칸이라면
			if (graph[nx][ny] == 0 && visited[nx][ny] == false) {
				int tx = x;
				int ty = y;
				// 반시계방향으로 회전하면서 갈 수 있는지 확인
				while (true) {
					if (direction == 0) {
						direction = 3;
					} else {
						direction--;
					}
					if (graph[tx + dx[direction]][ty + dy[direction]] == 0
							&& !visited[tx + dx[direction]][ty + dy[direction]]) {
						tx += dx[direction];
						ty += dy[direction];
						break;
					}

				}
				visited[tx][ty] = true;
				allTrue = false;
				cnt++;
				dfs(tx, ty);
				return;
			}
		}
		// 전부 true -> 뒤로 한칸 (바라보는 방향에 따라서 다름)
		if (allTrue) {
			int nx = x - dx[direction];
			int ny = y - dy[direction];
			
			// 뒤가 1이면 stop
			if (graph[nx][ny] == 1) {
				return;
			} else {
				dfs(nx, ny);
			}
		}

	}
}