import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int min = Integer.MAX_VALUE;
    boolean[] visitedNodes;

    public int solution(int n, int[][] wires) {
        for (int cut = 0; cut < wires.length; cut++) {
            visitedNodes = new boolean[n + 1];

            int cnt = bfs(wires, n, cut);
            int other = n - cnt;

            min = Math.min(min, Math.abs(cnt - other));
        }

        return min;
    }

    int bfs(int[][] wires, int n, int cut) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visitedNodes[1] = true;

        int cnt = 1;

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int w = 0; w < wires.length; w++) {
                if (w == cut) continue; 

                int a = wires[w][0];
                int b = wires[w][1];

                if (a == current && !visitedNodes[b]) {
                    visitedNodes[b] = true;
                    q.add(b);
                    cnt++;
                } else if (b == current && !visitedNodes[a]) {
                    visitedNodes[a] = true;
                    q.add(a);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}