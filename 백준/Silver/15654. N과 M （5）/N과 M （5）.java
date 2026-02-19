import java.util.*;

public class Main {
	static int[] com;
	static int[] nums;
	static boolean[] visited;
	static int n, m; // m개 고르기

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		com = new int[m];
		nums = new int[n];
		visited = new boolean[n + 1];

		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		Arrays.sort(nums);
		combination(0, 0);
		System.out.println(sb);
	}

	private static void combination(int idx, int sidx) {
		if (sidx == m) {
			for (int i : com) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		} else if (idx == n) {
			return;
		} else {
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					visited[i] = true;
					com[sidx] = nums[i];
					
					combination(i, sidx + 1);
					
					visited[i] = false;
				}
			}
			
			
		}

	}
}
