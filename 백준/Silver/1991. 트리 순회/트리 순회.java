import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static String[][] tree;

	public static void main(String[] args) {
		n = sc.nextInt();
		tree = new String[n + 1][3];

		for (int i = 0; i < n; i++) {
			tree[i + 1][0] = sc.next();
			tree[i + 1][1] = sc.next();
			tree[i + 1][2] = sc.next();
		}

		pre(1);
		System.out.println();
		middle(1);
		System.out.println();
		post(1);
	}

	public static void pre(int v) {
		if (v == 0 || v > n)
			return;
		System.out.print(tree[v][0]);
		pre(findLChild(v));
		pre(findRChild(v));
	}

	public static void middle(int v) {
		if (v == 0 || v > n)
			return;
		middle(findLChild(v));
		System.out.print(tree[v][0]);
		middle(findRChild(v));
	}

	public static void post(int v) {
		if (v == 0 || v > n)
			return;
		post(findLChild(v));
		post(findRChild(v));
		System.out.print(tree[v][0]);
	}

	public static int findLChild(int v) {
		String nowLchild = tree[v][1];
		for (int i = 1; i <= n; i++) {
			if (i != v && tree[i][0].equals(nowLchild)) {
				return i;
			}
		}
		return 0;
	}
	
	public static int findRChild(int v) {
		String nowRchild = tree[v][2];
		for (int i = 1; i <= n; i++) {
			if (i != v && tree[i][0].equals(nowRchild)) {
				return i;
			}
		}
		return 0;
	}
}
