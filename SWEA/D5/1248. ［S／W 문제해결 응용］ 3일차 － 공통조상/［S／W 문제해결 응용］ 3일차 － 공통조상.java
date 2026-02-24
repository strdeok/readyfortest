import java.util.*;

class Solution {
	static int[] parents;
	static int[][] childs;
	static int v;
	static int e;
	static int ancestor;
	static int cnt;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			if (!sc.hasNextInt())
				break;
			v = sc.nextInt();
			e = sc.nextInt();
			cnt = 0;

			int find1 = sc.nextInt();
			int find2 = sc.nextInt();

			parents = new int[v + 1];
			childs = new int[v + 1][2];

			for (int i = 0; i < e; i++) {
				int parent = sc.nextInt();
				int child = sc.nextInt();

				parents[child] = parent;

				if (childs[parent][0] == 0) {
					childs[parent][0] = child;
				} else {
					childs[parent][1] = child;
				}
			}

			Set<Integer> ancestors = new HashSet<>();

			int current1 = find1;
			while (current1 != 0) {
				ancestors.add(current1);
				current1 = parents[current1];
			}

			int current2 = find2;
			while (current2 != 0) {
				if (ancestors.contains(current2)) {
					ancestor = current2;
					break;
				}
				current2 = parents[current2];
			}
			down(ancestor);
			System.out.println("#" + test_case + " " + ancestor + " " +(cnt - 1));
		}
	}

	public static void down(int index) {
		if (index > v || index == 0) {
			cnt++;
			return;
		}
		int[] child = childs[index];
		int left = child[0];
		int right = child[1];
		down(left);
		down(right);
	}

}