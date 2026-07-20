import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int count = 0;

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(new int[]{i, priorities[i]});
        }

        Arrays.sort(priorities);
        int[] reversed = new int[priorities.length];
        for (int i = priorities.length - 1, j=0; i >=0; i--, j++){
            reversed[j] = priorities[i];
        }

        int max = reversed[0];
        int maxIdx = 0;

        while (true) {
            int[] now = q.poll();

            if (now[1] == max){
                count++;

                if (now[0] == location) break;

                maxIdx++;
                max = reversed[maxIdx];
            } else {
                q.add(now);
            }
        }

        return count;
    }
}