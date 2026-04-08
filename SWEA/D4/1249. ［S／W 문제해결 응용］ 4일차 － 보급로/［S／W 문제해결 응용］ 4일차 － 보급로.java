import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[][] graph = new int[n][n];
            for (int x = 0; x < n; x++) {
                char[] line = sc.next().toCharArray();
                for (int y = 0; y < n; y++) {
                    graph[x][y] = line[y] - '0';
                }
            }

            int[][] dist = new int[n][n];
            for (int x = 0; x < n; x++) {
                Arrays.fill(dist[x], Integer.MAX_VALUE);
            }


            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
            pq.add(new int[]{0, 0, 0});
            dist[0][0] = 0;

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            while (!pq.isEmpty()) {
                int[] now = pq.poll();
                int x = now[0];
                int y = now[1];
                int w = now[2];

                if (dist[x][y] < w) continue;

                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        if (dist[nx][ny] > w + graph[nx][ny]) {
                            dist[nx][ny] = w + graph[nx][ny];
                            pq.add(new int[]{nx, ny, dist[nx][ny]});
                        }
                    }
                }
            }

            System.out.println("#" + test_case + " " + dist[n - 1][n - 1]);
        }
    }

}