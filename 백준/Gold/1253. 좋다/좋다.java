import java.util.*;

class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] numbers = new int[n];

		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		}

		int cnt = 0;

		Arrays.sort(numbers);

		for (int i = 0; i < n; i++) {
			int target = numbers[i];

			int left = 0;
			int right = n - 1;

			while (left < right) {
				int sum = numbers[left] + numbers[right];
				if (target == sum) {
					if (left == i) {
						left++;
					} else if (right == i) {
						right--;
					} else {
						cnt++;
						break;
					}
				} else if (target > sum) {
					left++;
				} else if (target < sum) {
					right--;
				}
			}
		}
		System.out.println(cnt);
	}
}