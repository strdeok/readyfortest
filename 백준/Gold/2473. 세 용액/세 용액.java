import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] solution = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			solution[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(solution);

		int rLeft = 0;
		int rRight = 0;
		int rMid = 0;
		long minSum = Long.MAX_VALUE;

		for (int i = 0; i < n - 2; i++) {
			int left = i + 1;
			int right = n - 1;
			int initV = solution[i];

			// 투포인터
			while (left < right) {
				long sum = (long) solution[left] + solution[right] + initV;

				if (Math.abs(sum) < Math.abs(minSum)) {
					minSum = sum;
					rLeft = i;
					rRight = right;
					rMid = left;
				}
				if (sum == 0) {
					rLeft = i;
					rRight = right;
					rMid = left;
					minSum = 0;
					break;
				}
				if (sum < 0) {
					left++;
				}
				if (sum > 0) {
					right--;
				}
			}
		}

		System.out.println(solution[rLeft] + " " + solution[rMid] + " " + solution[rRight]);
	}
}