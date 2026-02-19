import java.util.*;

public class Main {
	static int[] com;
	static int[] nums;
	static int n, m; // m개 고르기

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		com = new int[m];
		nums = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}
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
			com[sidx] = nums[idx];
			combination(idx, sidx + 1);
			combination(idx + 1, sidx);
		}

	}
}
