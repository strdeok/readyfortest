import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

        for (String o: operations) {
            String[] ol = o.split(" ");
            if (ol[0].equals("I")) {
                minPQ.add(Integer.parseInt(ol[1]));
                maxPQ.add(Integer.parseInt(ol[1]));
            } else if (ol[1].equals("1") && !maxPQ.isEmpty()) {
                int max = maxPQ.poll();
                minPQ.remove(max);
            } else if (!minPQ.isEmpty()) {
                int min = minPQ.poll();
                maxPQ.remove(min);
            }
        }

        if (minPQ.isEmpty() && maxPQ.isEmpty()) {
            return answer;
        } else {
            answer[0] = maxPQ.peek();
            answer[1] = minPQ.peek();
        }

        return answer;
    }
}