import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int N;
    int M;
    boolean[][] visited;
    char[][] graph;

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    int startX;
    int startY;

    public int solution(String[] board) {
        int answer = 0;
        N = board.length;
        M = board[0].length();
        visited = new boolean[N][M];
        graph = new char[N][M];

        for (int x = 0; x < N; x++) {
            graph[x] = board[x].toCharArray();

            for (int y = 0; y < M; y++) {
                if (graph[x][y] == 'R') {
                    startX = x;
                    startY = y;
                }
            }
        }
        return bfs();
    }

    int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int moveTime = now[2];

            if (graph[now[0]][now[1]] == 'G') {
                return moveTime;
            }

            for (int dir = 0; dir < 4; dir++) {
                int time = 1;
                int x = now[0];
                int y = now[1];

                while (true) {
                    int nx = now[0] + dx[dir] * time;
                    int ny = now[1] + dy[dir] * time;

                    // 벽
                    if (nx < 0 || nx >= N ||
                            ny < 0 || ny >= M) {
                        break;
                    }

                    // 장애
                    if (graph[nx][ny] == 'D') {
                        break;
                    }
                    time++;
                    x = nx;
                    y = ny;
                }

                if ((x == now[0] && y == now[1]) || visited[x][y]) continue;

                visited[x][y] = true;
                q.add(new int[]{x, y, moveTime + 1});
            }
        }
        return -1;
    }
}