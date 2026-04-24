import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] nums = new int[n + 1];
		long[] sums = new long[n + 1];
		// 1, 1+2, 1+2+3, 1+2+3+4
		for (int i = 1; i <= n; i++) {
			nums[i] = sc.nextInt();
		}

		sums[0] = 0;
		sums[1] = nums[1];
		for (int i = 2; i <= n; i++) {
			sums[i] = sums[i - 1] + nums[i];
		}

		for (int i = 0; i < m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			System.out.println(sums[end] - sums[start - 1]);
		}

	}
}