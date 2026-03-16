import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int[] money = new int[n];
			int Max_profit = 0;
			long result = 0;

			for (int i = 0; i < n; i++) {
				money[i] = sc.nextInt();
			}
			
			for (int i = n - 1; i >= 0; i--) {			
				if (money[i] < Max_profit) {
					result += Max_profit - money[i];
				} else {
					Max_profit = Math.max(Max_profit, money[i]);
				}
			}
			
			System.out.println("#" + test_case + " " + result);
		}
	}
}