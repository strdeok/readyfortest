import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        Queue<String> qc1 = new ArrayDeque<>(Arrays.asList(cards1));
        Queue<String> qc2 = new ArrayDeque<>(Arrays.asList(cards2));
        Queue<String> qg = new ArrayDeque<>(Arrays.asList(goal));

        for (String g : qg) {
            if (g.equals(qc1.peek())) {
                qg.poll();
                qc1.poll();
            } else if (g.equals(qc2.peek())) {
                qg.poll();
                qc2.poll();
            } else {
                answer = "No";
                break;
            }
        }
        return answer;
    }
}