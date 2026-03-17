import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			Stack<Integer> st = new Stack<>();
			int Max_profit = 0;
			long result = 0;

			for (int i = 0; i < n; i++) {
				st.add(sc.nextInt());
			}
			
			while (!st.isEmpty()) {
				int num = st.pop();
				if (num > Max_profit) {
					Max_profit = num;
				} else {
					result += Max_profit - num;
				}
			}
			
			System.out.println("#" + test_case + " " + result);
		}
	}
}