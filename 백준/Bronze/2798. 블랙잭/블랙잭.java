import java.util.*;

public class Main {
	static int n, m;
	static int[] cards;
	static int[] com = new int[3];
	static int maxSum = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		cards = new int[n];

		for (int i = 0; i < n; i++) {
			cards[i] = sc.nextInt();
		}

		combination(0, 0);
		System.out.println(maxSum);
	}

	public static void combination(int start, int cnt) {
		if (cnt == 3) {
			int sum = 0;

			for (int i = 0; i < 3; i++) {
				sum += com[i];
			}

			if (sum <= m && sum > maxSum) {
				maxSum = sum;
			}
			return;
		}

		for (int i = start; i < n; i++) {
			com[cnt] = cards[i];
			combination(i + 1, cnt + 1);
		}
	}
}