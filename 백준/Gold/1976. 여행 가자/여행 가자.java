import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	static int n, m;
	static int[][] nodes;
	static int[] plans;
	static boolean isPossible = true;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		

		nodes = new int[n + 1][n + 1];
		plans = new int[m];
		visited = new boolean[n + 1];

		for (int i = 1; i < n + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int k = 1; k < n + 1; k++) {
				int num = Integer.parseInt(st.nextToken());
				nodes[i][k] = num;
			}
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			plans[i] = Integer.parseInt(st.nextToken());
		}
		
		if (n == 1 && plans[0] == 1) {
			System.out.println("YES");
			return;
		}
		
		
		dfs(1, plans[0]);

		for (int i = 0; i < m; i++) {
			int goal = plans[i];
			if (visited[goal] != true) {
				isPossible = false;
			}
		}
		
		System.out.println(isPossible ? "YES" : "NO");
	}

	static void dfs(int goalIndex, int node) {
		int[] connectedNodes = nodes[node];
		for (int i = 1; i < n + 1; i++) {
			if (connectedNodes[i] == 1) {
				if (!visited[i]) {
					visited[i] = true;
					dfs(goalIndex, i);
				}
			}
		}

	}
}

