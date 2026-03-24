class Solution {
	public int solution(int[][] signals) {
		int[] times = new int[10000001];

		boolean isAllYellow = true;
		for (int i = 0; i < signals.length; i++) {
			if (signals[i][0] != 0) {
				isAllYellow = false;
			}
		}
		
		if (isAllYellow) return 1;

		for (int[] signal : signals) {
			int cycle = 0;
			for (int i = 0; i < signal.length; i++) {
				cycle += signal[i];
			}
			int firstYellow = signal[0] + 1;
			int yellowTime = signal[1];
			while (firstYellow <= 10000000) {
				for (int i = 0; i < yellowTime; i++) {
					if (firstYellow + i > 10000000)
						break;
					times[firstYellow + i] += 1;
				}
				firstYellow += cycle;
			}
		}

		for (int t = 0; t < 10000001; t++) {
			if (times[t] == signals.length) {
				return t;
			}
		}

		return -1;
	}
}