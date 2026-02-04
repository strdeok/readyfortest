import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> work = new ArrayDeque<>();

        for (int i = 0; i < progresses.length; i++) {
            int day = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            work.add(day);
        }
        int cnt = 1;
        int max = work.poll();

        while (!work.isEmpty()) {
            int now = work.poll();
            if (max < now) {
                answer.add(cnt);
                max = now;
                cnt = 1;
            } else {
                cnt++;
            }
        }

        answer.add(cnt);

        return answer.stream().mapToInt(i -> i).toArray();
    }
}