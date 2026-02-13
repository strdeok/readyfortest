import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int q = sc.nextInt();
			int[] arr = new int[n];
			
			for (int i = 1; i <= q; i++) {
				int l = sc.nextInt();
				int r = sc.nextInt();
				
				for (int k = l; k <= r; k++) {
					arr[k - 1] = i;
				}				
			}
			

			System.out.print("#" + t + " ");
			for (int num:arr) {
				System.out.printf(num + " ");
			}
			System.out.println();
		}
	}
}
