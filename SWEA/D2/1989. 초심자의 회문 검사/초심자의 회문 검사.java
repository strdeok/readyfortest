import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			char[] arr = sc.next().toCharArray();
			int answer = 0;
			StringBuilder sb = new StringBuilder();
			
			for (char c : arr) {
				sb.append(c);
			}
			
			String original = sb.toString();
			String reversed = sb.reverse().toString();
					
			if (original.equals(reversed)){
				answer = 1;
			}
					
			
			
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}