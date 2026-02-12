import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			int[] a = new int[n];
			int[] b = new int[m];

			int Max = 0;

			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}

			for (int i = 0; i < m; i++) {
				b[i] = sc.nextInt();
			}

			if (m > n) {
				for (int i = 0; i <= m - n; i++) {
					int[] compare = new int[n];
					for (int k = 0; k < n; k++) {
						compare[k] = b[i + k];
					}

					int sum = 0;
					for (int k = 0; k < n; k++) {
						sum += a[k] * compare[k];
					}

					Max = Math.max(Max, sum);
				}
			} else {
				for (int i = 0; i <= n - m; i++) {
					int[] compare = new int[m];
					for (int k = 0; k < m; k++) {
						compare[k] = a[i + k];
					}
					
					int sum = 0;
					for (int k = 0; k < m; k++) {
						sum += b[k] * compare[k];
					}

					Max = Math.max(Max, sum);
				}
			}

			System.out.println("#" + t + " " + Max);
		}
	}
}
