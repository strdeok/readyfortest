import java.util.*;
import java.io.*;

class Main {
	static int n;
	static int[] nums;
	static int[] calculators;
	static int Min = Integer.MAX_VALUE;
	static int Max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		calculators = new int[4];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			calculators[i] = Integer.parseInt(st.nextToken());
		}

		dfs(nums[0], 1);
		System.out.println(Max);
		System.out.println(Min);
	}

	static void dfs(int sum, int idx) {
		if (idx == n) {
			Min = Math.min(sum, Min);
			Max = Math.max(sum, Max);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (calculators[i] > 0) {
				calculators[i]--;
				if (i == 0) {
					dfs(sum + nums[idx], idx + 1);
				}
				if (i == 1) {
					dfs(sum - nums[idx], idx + 1);
				}
				if (i == 2) {
					dfs(sum * nums[idx], idx + 1);
				}
				if (i == 3) {
					dfs(sum / nums[idx], idx + 1);
				}
				calculators[i]++;
			}

		}
	}
}