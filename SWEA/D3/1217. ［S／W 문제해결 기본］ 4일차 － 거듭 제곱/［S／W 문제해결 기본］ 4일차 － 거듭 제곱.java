import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();

			System.out.println("#" + T + " " + jegop(n, m));
		}
	}

	static int jegop(int n, int m) {
		if (m == 1) {
			return n;
		} else {
			return n * jegop(n, m - 1);
		}

	}
}