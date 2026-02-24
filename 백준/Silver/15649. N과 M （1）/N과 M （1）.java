import java.util.*;

public class Main {
	static int n, m;
	static int[] com;
	static int[] num;
	static boolean visit[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		num = new int[n];
		com = new int[m];
		visit = new boolean[n];

		for (int i = 0; i < n; i++) {
			num[i] = i + 1;
		}

		combination(0);

	}

	public static void combination(int idx) {
		if (idx == m) {
			for (int n : com) {
				System.out.print(n + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				com[idx] = num[i];
				combination(idx + 1);
				visit[i] = false;
			}

		}
	}
}