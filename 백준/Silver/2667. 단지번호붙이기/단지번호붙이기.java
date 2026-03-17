import java.util.*;
import java.io.*;

class Main {
	static int n;
	static int[][] graph;
	static boolean[][] visited;
	static ArrayList<Integer> answer = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		graph = new int[n][n];
		visited = new boolean[n][n];

		for (int x = 0; x < n; x++) {
			char[] nums = sc.next().toCharArray();
			for (int y = 0; y < n; y++) {
				int num = nums[y] - '0';
				if (num == 0) {
					visited[x][y] = true;
				}
				if (num == 1) {
					graph[x][y] = 1;
				}
			}
		}
		search();

		Collections.sort(answer);
		
		System.out.println(answer.size());
		for (Integer num : answer) {
			System.out.println(num);
		}
	}

	static void search() {
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				if (graph[x][y] == 1 && visited[x][y] == false) {
					bfs(x, y);
				}
			}
		}
	}

	static void bfs(int x, int y) {
		int cnt = 1;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		visited[x][y] = true;

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		while (!q.isEmpty()) {
			int[] get = q.poll();
			int nowX = get[0];
			int nowY = get[1];
			for (int i = 0; i < 4; i++) {
				int nx = nowX + dx[i];
				int ny = nowY + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if (!visited[nx][ny] && graph[nx][ny] == 1) {
						visited[nx][ny] = true;
						cnt++;
						q.add(new int[] { nx, ny });
					}
				}
			}
		}

		answer.add(cnt);
	}
}