import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.print(isSamYukGoo(i) + " ");
		}

	}

	private static String isSamYukGoo(int num) {
		char[] boonhae = (num + "").toCharArray();
		StringBuilder sb = new StringBuilder();

		for (char b : boonhae) {
			if (b == '3' || b == '6' || b == '9') {
				sb.append("-");
			}
		}

		if (sb.length() == 0) {
			return num + "";
		} else {
			return sb.toString();
		}

	}
}
