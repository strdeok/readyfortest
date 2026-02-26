import java.util.*;

public class Main {
	static int n;
	static ArrayList<Integer>[] tree;
	static int[] parents;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		tree = new ArrayList[n + 1];
		parents = new int[n];
		visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 1; i < n; i++) {
			int left = sc.nextInt();
			int right = sc.nextInt();
			tree[left].add(right);
			tree[right].add(left);
		}

		find(1);
		
		for (int i = 1; i < n; i++) {
			System.out.println(parents[i]);
		}
	}

	public static void find(int nowNode) {
		if (visited[nowNode]) return;
		
		visited[nowNode] = true;
		for (int node:tree[nowNode]) {
			if (parents[nowNode - 1] != node) {
				
				parents[node - 1] = nowNode;
			}
			
			find(node);
		}
	}

}