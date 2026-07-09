class Solution {
    int N;
    int[] peach;
    int[] answer = {-1};
    int maxDiff = 0;

    public int[] solution(int n, int[] info) {
        N = n;
        peach = info;

        dfs(0, n, new int[11]);

        return answer;
    }

    void dfs(int idx, int arrowsLeft, int[] lion) {
        if (idx == 11) {
            check(lion);
            return;
        }

        if (idx == 10) {
            lion[idx] = arrowsLeft;
            dfs(idx + 1, 0, lion);
            lion[idx] = 0;
            return;
        }

        int need = peach[idx] + 1;

        if (arrowsLeft >= need) {
            lion[idx] = need;
            dfs(idx + 1, arrowsLeft - need, lion);
            lion[idx] = 0;
        }

        dfs(idx + 1, arrowsLeft, lion);
    }

    void check(int[] lion) {
        int lionScore = 0;
        int apeachScore = 0;

        for (int i = 0; i < 11; i++) {
            int score = 10 - i;

            if (lion[i] == 0 && peach[i] == 0) {
                continue;
            }

            if (lion[i] > peach[i]) {
                lionScore += score;
            } else {
                apeachScore += score;
            }
        }

        int diff = lionScore - apeachScore;

        if (diff <= 0) {
            return;
        }

        if (diff > maxDiff) {
            maxDiff = diff;
            answer = lion.clone();
        } else if (diff == maxDiff) {
            if (isBetter(lion, answer)) {
                answer = lion.clone();
            }
        }
    }

    boolean isBetter(int[] lion, int[] current) {
        for (int i = 10; i >= 0; i--) {
            if (lion[i] > current[i]) {
                return true;
            } else if (lion[i] < current[i]) {
                return false;
            }
        }

        return false;
    }
}