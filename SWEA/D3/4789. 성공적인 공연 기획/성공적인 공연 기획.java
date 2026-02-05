import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			String s = sc.next();
			int[] arr = new int[s.length()];

			for (int i = 0; i < s.length(); i++) {
				arr[i] = s.charAt(i) - '0';
			}

			int cnt = 0; // 박수 치는 사람
			int hire = 0; // 고용할 사람
			for (int i = 0; i < arr.length; i++) {
				if (i == 0) {
					cnt += arr[i];
				} else {
					if (arr[i] != 0) {
						if (cnt >= i) {
							cnt += arr[i];
						} else {
							int need = i - cnt;
							hire += need;
							cnt += need + arr[i];
						}
					}

				}

			}
			System.out.println("#" + test_case + " " + hire);
		}
	}
}