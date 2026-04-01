import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int[][] graph;
	static int sharkX, sharkY;
	static int sharkSize = 2;
	static int eatCount = 0;
	static int totalTime = 0;

	// 상하좌우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] == 9) {
					sharkX = i;
					sharkY = j;
					graph[i][j] = 0;
				}
			}
		}

		while (true) {
			int time = findFish();

			if (time == 0) {
				break;
			}
			totalTime += time;
		}

		System.out.println(totalTime);
	}

	static int findFish() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1[2] != o2[2])
				return Integer.compare(o1[2], o2[2]);
			if (o1[0] != o2[0])
				return Integer.compare(o1[0], o2[0]);
			return Integer.compare(o1[1], o2[1]);
		});

		boolean[][] visited = new boolean[n][n];
		pq.add(new int[] { sharkX, sharkY, 0 });
		visited[sharkX][sharkY] = true;

		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int x = now[0];
			int y = now[1];
			int dist = now[2];

			if (graph[x][y] != 0 && graph[x][y] < sharkSize) {
				graph[x][y] = 0;
				sharkX = x;
				sharkY = y;
				eatCount++;

				if (eatCount == sharkSize) {
					sharkSize++;
					eatCount = 0;
				}

				return dist;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
					if (graph[nx][ny] <= sharkSize) {
						visited[nx][ny] = true;
						pq.add(new int[] { nx, ny, dist + 1 });
					}
				}
			}
		}

		return 0;
	}
}