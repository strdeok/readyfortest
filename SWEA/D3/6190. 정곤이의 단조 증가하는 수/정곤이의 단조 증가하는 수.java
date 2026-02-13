import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();

			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			List<Integer> multiples = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					multiples.add(arr[i] * arr[j]);
				}
			}

			int max = -1;
			for (Integer num : multiples) {
				char[] cNum = num.toString().toCharArray();

				boolean isDanjo = true;
				for (int i = 0; i < cNum.length - 1; i++) {
					if (cNum[i] > cNum[i + 1]) {
						isDanjo = false;
					}
				}

				if (isDanjo) {
					max = Math.max(max, num);
				}
			}

			System.out.println("#" + t + " " + max);
		}
	}
}
