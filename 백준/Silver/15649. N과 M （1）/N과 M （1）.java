import java.util.*;

public class Main {
	static int[] com;
	static boolean[] visited;
	static int n, m; // m개 고르기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		com = new int[m];
		visited = new boolean[n + 1];
		combination(0);
	}

	private static void combination(int sidx) {
		if (sidx == m) {
			for (int i : com) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		} 
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				com[sidx] = i;
				
				combination(sidx + 1);
				visited[i] = false;
			}
		}
	}
}
