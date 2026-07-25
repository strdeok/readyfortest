import java.util.*;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]
        );
        boolean[] isGate = new boolean[n + 1];
        boolean[] isSummit = new boolean[n + 1];
        
        for (int gate : gates) {
            isGate[gate] = true;
        }

        for (int summit : summits) {
            isSummit[summit] = true;
        }
        
        ArrayList<int[]>[] nodes = new ArrayList[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for (int i = 1; i <= n; i++) {
           nodes[i] = new ArrayList<>();
        }   
        
        for (int[] path : paths) {
            int now = path[0];
            int next = path[1];
            int weight = path[2];

            nodes[now].add(new int[]{next, weight});
            nodes[next].add(new int[]{now, weight});
        }
        
        for (int gate : gates) {
            dist[gate] = 0;
            pq.add(new int[]{gate, 0});
        }
        
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int now = p[0];
            int d = p[1];
            
            if (dist[now] < d) continue;
            if (isSummit[now]) continue;
            
            for (int[] nd: nodes[now]) {
                int next = nd[0];
                int weight = nd[1];
                
                if (isGate[next]) continue;

                int sibal = Math.max(d, weight);

                if (sibal < dist[next]) {
                    dist[next] = sibal;
                    pq.add(new int[]{next, sibal});
                }
            }
        }
        
        Arrays.sort(summits);
        
        int[] answer = new int[]{0, Integer.MAX_VALUE};

        for (int summit : summits) {
            int d = dist[summit];

            if (d < answer[1]) {
                answer[0] = summit;
                answer[1] = d;
            }
        }
        return answer;
        
    }
}