import java.io.*;
import java.util.*;

class Solution {
    static int n, m, r, c, l;
    static int[][] graph;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[] reverseDir = {1, 0, 3, 2};

    static boolean[][] pipe = {
            {false, false, false, false},
            {true, true, true, true},
            {true, true, false, false},
            {false, false, true, true},
            {true, false, false, true},
            {false, true, false, true},
            {false, true, true, false},
            {true, false, true, false}
    };

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());

            graph = new int[n][m];
            visited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bfs(r, c);


            int answer = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visited[i][j]) answer++;
                }
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }

    static void bfs(int startX, int startY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, 1});
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int time = now[2];


            if (time == l) continue;

            int currentPipe = graph[x][y];

            for (int dir = 0; dir < 4; dir++) {
                if (!pipe[currentPipe][dir]) continue;

                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny] || graph[nx][ny] == 0) continue;

                int nextPipe = graph[nx][ny];
                int revDir = reverseDir[dir];


                if (pipe[nextPipe][revDir]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, time + 1});
                }
            }
        }
    }
}