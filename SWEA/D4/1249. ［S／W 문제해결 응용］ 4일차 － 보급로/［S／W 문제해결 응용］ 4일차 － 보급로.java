import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge> {
    int[] to;
    int w;

    public Edge(int[] to, int w) {
        this.to = to;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return this.w - o.w;
    }
}

class Solution {
    static int n;
    static int[][] map;
    static int[][] dist;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            // 다익스트라
            int INF = Integer.MAX_VALUE;
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i], INF);
            }
            for (int x = 0; x < n; x++) {
                char[] l = br.readLine().toCharArray();
                for (int y = 0; y < n; y++) {
                    map[x][y] = l[y] - '0';
                }
            }

            PriorityQueue<Edge> pq = new PriorityQueue<>();
            dist[0][0] = 0;
            dist[0][1] = map[0][1];
            dist[1][0] = map[1][0];
            pq.add(new Edge(new int[]{0, 1}, map[0][1]));
            pq.add(new Edge(new int[]{1, 0}, map[1][0]));

            while (!pq.isEmpty()) {
                Edge e = pq.poll();
                int[] next = e.to;
                int x = next[0];
                int y = next[1];
                int w = e.w;

                if (dist[x][y] < e.w) continue;

                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n){
                        if (dist[nx][ny] > dist[x][y] + map[nx][ny]){
                            dist[nx][ny] = w + map[nx][ny];
                            pq.add(new Edge(new int[]{nx, ny}, dist[nx][ny]));
                        }
                    }
                }
            }

            System.out.println("#" + test_case + " " + dist[n - 1][n - 1]);
        }
    }

}