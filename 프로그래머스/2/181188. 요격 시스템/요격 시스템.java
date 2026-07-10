import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        boolean[] shot = new boolean[targets.length];

        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));

        for (int i = 0; i < targets.length; i++){
            if (!shot[i]){
                shot[i] = true;
                answer++;

                int end = targets[i][1];

                for (int k = 0; k < targets.length; k++){
                    if (!shot[k]) {
                        int start = targets[k][0];
                        if (start < end) {
                            shot[k] = true;
                        }
                    }
                }
            }
        }
        return answer;
    }
}