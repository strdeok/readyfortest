import java.util.*;

public class Main {
	static int n, m;
	static int[] com;
	static int[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		num = new int[n];
		com = new int[m];

		for (int i = 0; i < n; i++) {
			num[i] = i + 1;
		}

		combination(0, 0);

	}

	public static void combination(int idx, int tidx) {
		if (tidx == m) {
			for (int n : com) {
				System.out.print(n + " ");
			}
			System.out.println();
			return;
		}
		if (idx == n)
			return;

		com[tidx] = num[idx];
		combination(idx + 1, tidx + 1);
		combination(idx + 1, tidx);

	}
}