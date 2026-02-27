import java.io.*;
import java.util.*;

public class Main {
	static int n, m, v;
	static ArrayList<Integer>[] map;
	static boolean[] dfs_visited;
	static boolean[] bfs_visited;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		dfs_visited = new boolean[n + 1];
		bfs_visited = new boolean[n + 1];

		map = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			map[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			map[a].add(b);
			map[b].add(a);
		}

		for (int i = 1; i <= n; i++) {
			map[i].sort(null);
		}
		dfs(v);
		System.out.println();
		bfs(v);
	}

	static void dfs(int index) {
		if (dfs_visited[index] == true) {
			return;
		}
		dfs_visited[index] = true;
		System.out.print(index + " ");
		for (int next : map[index]) {
			dfs(next);
		}
	}

	static void bfs(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(node);
		bfs_visited[node] = true;
		System.out.print(node + " ");
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int next : map[now]) {
				if (bfs_visited[next]) {
					continue;
				}
				System.out.print(next + " ");
				q.offer(next);
				bfs_visited[next] = true;
			}
		}

	}
}