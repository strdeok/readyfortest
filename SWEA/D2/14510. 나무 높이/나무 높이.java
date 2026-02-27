import java.util.*;

class Solution {
	static int n;
	static int[] trees;
	static int MAX;
	static int Day;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			n = sc.nextInt();
			trees = new int[n];
			MAX = 0;
			Day = 0;

			for (int i = 0; i < n; i++) {
				trees[i] = sc.nextInt();
			}
			getMAX();
			calculate();
			System.out.println("#" + test_case + " " + Day);
		}
	}

	static void getMAX() {
		for (int i = 0; i < n; i++) {
			MAX = Math.max(trees[i], MAX);
		}
	}

	static void calculate() {
	    int cnt1 = 0;
	    int cnt2 = 0;

	    for (int i = 0; i < n; i++) {
	        int goal = MAX - trees[i];
	        cnt1 += goal % 2;
	        cnt2 += goal / 2;
	    }

	    while (cnt2 > cnt1 + 1) {
	        cnt2 -= 1;
	        cnt1 += 2;
	    }

	    if (cnt1 > cnt2) {
	        Day = cnt1 * 2 - 1;
	    } else if (cnt2 > cnt1) {
	        Day = cnt2 * 2;
	    } else {
	        Day = cnt1 + cnt2;
	    }
	}
}