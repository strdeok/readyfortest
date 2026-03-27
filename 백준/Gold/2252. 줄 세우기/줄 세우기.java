import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
	static int n, m;
	static ArrayList<Integer>[] smalls;
	static int[] tallerCnt;
	static boolean[] visited;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		smalls = new ArrayList[n + 1];
		tallerCnt = new int[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			smalls[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int taller = Integer.parseInt(st.nextToken());
			int smaller = Integer.parseInt(st.nextToken());

			smalls[taller].add(smaller);
			tallerCnt[smaller]++;
		}
		
		for (int i = 1; i <= n ; i++) {
			if (!visited[i]) {
				if (tallerCnt[i] == 0) {
					visited[i] = true;
					sb.append(i).append(" ");
					dfs(i);									
				}
			}
		}
		System.out.println(sb.toString());
	}

	static void dfs(int index) {
		for (Integer h : smalls[index]) {
			tallerCnt[h]--;
			if (tallerCnt[h] == 0) {
				visited[h] = true;
				sb.append(h).append(" ");
				dfs(h);
			}
		}
	}
}