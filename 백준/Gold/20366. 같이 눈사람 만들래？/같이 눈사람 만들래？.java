import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Snowman implements Comparable<Snowman> {
	int idx1;
	int idx2;
	int height;

	public Snowman(int idx1, int idx2, int height) {
		this.idx1 = idx1;
		this.idx2 = idx2;
		this.height = height;
	}

	public int compareTo(Snowman o) {
		return this.height - o.height;
	}
}

class Main {
	static int n;
	static int[] nums;
	static ArrayList<Snowman> sums = new ArrayList<>();
	static int Min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		nums = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			for (int k = i + 1; k < n; k++) {
				int sum = nums[i] + nums[k];
				sums.add(new Snowman(i, k, sum));
			}
		}

		Collections.sort(sums);
		search();
		System.out.println(Min);
	}

	static void search() {
		// 겹치는지 확인
		// 키 차이 최솟값 확인
		for (int i = 0; i < sums.size(); i++) {
			Snowman s1 = sums.get(i);
			for (int k = i + 1; k < sums.size(); k++) {
				Snowman s2 = sums.get(k);

				if (s1.idx1 != s2.idx1 && s1.idx1 != s2.idx2 && s1.idx2 != s2.idx1 && s1.idx2 != s2.idx2) {
					Min = Math.min(Math.abs(s1.height - s2.height), Min);
					break;
				}
			}

		}
	}

}