class Solution {
    public int solution(int[][] info, int n, int m) {
        boolean[][] dp = new boolean[n][m];
        dp[0][0] = true;

        for (int[] item : info) {
            int a = item[0];
            int b = item[1];

            boolean[][] next = new boolean[n][m];

            for (int aSum = 0; aSum < n; aSum++) {
                for (int bSum = 0; bSum < m; bSum++) {
                    if (!dp[aSum][bSum]) continue;

                    // A가 훔치는 경우
                    if (aSum + a < n) {
                        next[aSum + a][bSum] = true;
                    }

                    // B가 훔치는 경우
                    if (bSum + b < m) {
                        next[aSum][bSum + b] = true;
                    }
                }
            }

            dp = next;
        }

        for (int aSum = 0; aSum < n; aSum++) {
            for (int bSum = 0; bSum < m; bSum++) {
                if (dp[aSum][bSum]) {
                    return aSum;
                }
            }
        }

        return -1;
    }
}