import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = sc.nextInt();
			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			int cnt = 0;			
			for (int i = 2; i < n - 2; i++) {
				int max = 0;
				for (int j = 1; j <= 2; j++) {
					max = Math.max(max, arr[j+i]);
					max = Math.max(max, arr[i-j]);
				}
				if (arr[i] > max) {
					cnt += arr[i] - max;
				}
			}

			System.out.println("#" + test_case + " " + cnt);
		}
	}
}