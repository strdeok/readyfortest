import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int[] liquids;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		liquids = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			liquids[i] = Integer.parseInt(st.nextToken());
		}

		int min = Integer.MAX_VALUE;
		int left = 0;
		int right = n - 1;
		while (left < right) {
			int sum = liquids[left] + liquids[right];
			int absSum = Math.abs(sum);
			int absMin = Math.abs(min);

			if (sum < 0) {
				left++;				
			}
			if (sum > 0) {
				right--;
			}
			if (sum == 0) {
				min = 0;
				break;
			}
			
			if (absSum < absMin) {
				min = sum;
			}

		}
		System.out.println(min);
	}
}
