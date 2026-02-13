import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			// 배열을 반으로 나누기. 홀수면 a에 +1
			// 교차로 새 배열에 삽입
			String[] arr1 = new String[(n + 1) / 2];
			String[] arr2 = new String[n / 2];
			String[] result = new String[n];

			for (int i = 0; i < n; i++) {
				if (i < (n + 1) / 2) {
					arr1[i] = sc.next();
				} else {
					arr2[i - (n + 1) / 2] = sc.next();
				}
			}
			System.out.print("#" + t + " ");

			for (int i = 0; i < (n + 1) / 2; i++) {
				if (n % 2 != 0) {
					if (i == n / 2) {
						System.out.print(arr1[i] + " ");
					} else {
						System.out.print(arr1[i] + " ");
						System.out.print(arr2[i] + " ");
					}
				} else {
					System.out.print(arr1[i] + " ");
					System.out.print(arr2[i] + " ");
				}

			}

			System.out.println();
		}
	}
}
