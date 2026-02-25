import java.util.*;

public class Main {
	static int n, m;
	static int[] com;
	static int[] num;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		n = sc.nextInt();
		m = sc.nextInt();
		num = new int[n];
		com = new int[m];

		for (int i = 0; i < n; i++) {
			num[i] = i + 1;
		}

		combination(0, 0);
		System.out.println(sb.toString());
	}

	public static void combination(int idx, int tidx) {
		if (tidx == m) {
			for (int i : com) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		if (idx == n)
			return;

		for (int i = idx; i < n; i++) {
			com[tidx] = num[i];
			combination(idx, tidx + 1);
		}

	}
}