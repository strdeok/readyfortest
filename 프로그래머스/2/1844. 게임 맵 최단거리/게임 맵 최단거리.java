import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[][] Maps;
    boolean[][] visited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int n;
    int m;

    int minDistance = 10001;

    public int solution(int[][] maps) {
        Maps = maps;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];

        visited[0][0] = true;
        bfs();
        return minDistance == 10001 ? -1 : minDistance;
    }

    void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int distance = now[2];

            if (x == n - 1 && y == m - 1) {
                minDistance = Math.min(distance, minDistance);
                continue;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && Maps[nx][ny] == 1) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny, distance + 1});
                    }
                }
            }
        }


    }
}