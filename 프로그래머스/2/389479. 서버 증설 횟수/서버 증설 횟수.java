import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] timetable = new int[100]; // 해당 시간 서버갯수

        for (int t = 0; t < 24; t++) {
            int playerCnt = players[t];

            if (playerCnt >= m) {
                if (playerCnt > timetable[t] * m) {
                    int addCnt = 0;
                    if (timetable[t] == 0) {
                        addCnt = playerCnt/ m;
                    } else {
                        addCnt = ((playerCnt - timetable[t] * m))  / m;
                    }
                    for (int i = t; i < t + k; i++) {
                        timetable[i] += addCnt;
                    }
                    answer += addCnt;
                }
            }
        }
        return answer;
    }
}