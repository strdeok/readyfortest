import java.util.*;

class Solution {

    int K;
    int N;

    int[][] Reqs;
    ArrayList<int[]>[] Counsels;

    int Answer = Integer.MAX_VALUE;

    public int solution(int k, int n, int[][] reqs) {
        K = k;
        N = n;
        Reqs = reqs;

        Counsels = new ArrayList[K + 1];

        for (int type = 1; type <= K; type++) {
            Counsels[type] = new ArrayList<>();
        }

        for (int[] req : Reqs) {
            int type = req[2];
            Counsels[type].add(req);
        }

        for (int type = 1; type <= K; type++) {
            Counsels[type].sort(
                Comparator.comparingInt(req -> req[0])
            );
        }
        dfs(0, 1, 0);

        return Answer;
    }

    // 상담 유형마다 상담사 인원 분배
    void dfs(int counselor, int type, int time) {
        if (time >= Answer) {
            return;
        }

        if (type > K) {
            if (counselor == N) {
                Answer = Math.min(Answer, time);
            }

            return;
        }

        
        int remainingTypes = K - type;

        int maxCounselorCount =
            N - counselor - remainingTypes;

        for (
            int counselorCount = 1;
            counselorCount <= maxCounselorCount;
            counselorCount++
        ) {
            int[] schedules = new int[counselorCount];

            int delayTime = dfs2(
                schedules,
                0,
                type,
                0
            );

            dfs(
                counselor + counselorCount,
                type + 1,
                time + delayTime
            );
        }
    }

    int dfs2(
        int[] schedules,
        int cnt,
        int type,
        int time
    ) {
        if (cnt == Counsels[type].size()) {
            return time;
        }

        int[] counsel = Counsels[type].get(cnt);

        int requestTime = counsel[0];
        int counselTime = counsel[1];

        int counselorIndex = 0;

        for (int i = 1; i < schedules.length; i++) {
            if (schedules[i] < schedules[counselorIndex]) {
                counselorIndex = i;
            }
        }

        int endTime = schedules[counselorIndex];

        if (endTime <= requestTime) {
            schedules[counselorIndex] =
                requestTime + counselTime;
        } else {
            int waitingTime = endTime - requestTime;

            schedules[counselorIndex] =
                endTime + counselTime;

            time += waitingTime;
        }

        return dfs2(
            schedules,
            cnt + 1,
            type,
            time
        );
    }
}