import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= 10; test_case++) {
			int t = sc.nextInt();
			String str = sc.next();
			char[] target = sc.next().toCharArray();
			
			int cnt = 0;
			for (int i = 0; i <= target.length - str.length(); i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < str.length(); j++) {
					sb.append(target[i+j]);
				}
				if (str.equals(sb.toString())) {
					cnt++;
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
}