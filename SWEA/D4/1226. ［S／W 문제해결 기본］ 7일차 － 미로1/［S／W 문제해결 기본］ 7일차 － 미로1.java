import java.util.*;
import java.io.*;

public class Solution {
    static int N;
    static int[][] map;
    static boolean[][] visited;

    static int startX, startY, endX, endY;
    static boolean can;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            String trash = br.readLine();
            N = 16;
            map = new int[N][N];
            visited = new boolean[N][N];
            can = false;
            for (int x = 0; x < N; x++) {
                char[] input = br.readLine().toCharArray();
                for (int y = 0; y < N; y++) {
                    int num = input[y];
                    map[x][y] = input[y];
                    if (num == '2') {
                        startX = x;
                        startY = y;
                    }
                    if (num == '3') {
                        endX = x;
                        endY = y;
                    }
                }
            }

            visited[startX][startY] = true;
            dfs(startX, startY);
            System.out.println("#" + tc + " " + (can ? 1 : 0));
        }
    }

    static void dfs(int x, int y) {
        if (x == endX && y == endY) {
            can = true;
            return;
        }
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= 0 && nx < 16 && ny >= 0 && ny < 16) {
                if (map[nx][ny] != '1' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny);
                }
            }
        }
    }
}