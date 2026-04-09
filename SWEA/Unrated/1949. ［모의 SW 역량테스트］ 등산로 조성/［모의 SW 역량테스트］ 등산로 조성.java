import java.util.*;

class Solution {
    static int n;
    static int k;

    static int[][] graph;
    static int[][] tops;

    static int max_distance;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            k = sc.nextInt();
            max_distance = Integer.MIN_VALUE;
            graph = new int[n][n];

            int top = 0;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    int num = sc.nextInt();
                    graph[x][y] = num;
                    if (num > top) {
                        top = num;
                    }
                }
            }

            boolean[][] visited = new boolean[n][n];
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (graph[x][y] == top) {
                        dfs(x, y, top, false, 1, visited);
                    }
                }
            }

            System.out.println("#" + test_case + " " + max_distance);
        }
    }


    static void dfs(int x, int y, int now_height, boolean usedK, int distance, boolean[][] visited) {
        max_distance = Math.max(max_distance, distance);
        visited[x][y] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) continue;

            // 다음 봉우리가 지금보다 낮음
            if (graph[nx][ny] < now_height) {
                dfs(nx, ny, graph[nx][ny], usedK, distance + 1, visited);
            }
            // 다음 봉우리가 같거나 큼
            else if (!usedK && graph[nx][ny] - k < now_height) {
                dfs(nx, ny, now_height - 1, true, distance + 1, visited);
            }
        }

        visited[x][y] = false;
    }
}