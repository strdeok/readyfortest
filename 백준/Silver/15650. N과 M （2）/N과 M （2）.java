import java.util.*;

public class Main {
	static int[] com;
	static int[] nums;
	static int n, m; // m개 고르기

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
	}

	private static void combination(int idx, int sidx) {
		if (sidx == m) {
			for (int i : com) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		} else if (idx == n) {
			return;
		} else {
			com[sidx] = nums[idx];
			combination(idx + 1, sidx + 1);
			combination(idx + 1, sidx);
		}
		
	}
}
