import java.util.*;
import java.io.*;

public class Solution {
    static int N;
    static int W;
    static int H;
    static int[][] map;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int MinCnt;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new int[H][W];
            MinCnt = Integer.MAX_VALUE;

            for (int x = 0; x < H; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < W; y++) {
                    map[x][y] = Integer.parseInt(st.nextToken());
                }
            }


            shoot(0, map);


            System.out.println("#" + tc + " " + MinCnt);
        }
    }

    static void shoot(int cnt, int[][] currentMap) {
        if (cnt == N) {
            updateMax(currentMap);
            return;
        }

        for (int y = 0; y < W; y++) {
            int[][] backup = copyMap(currentMap);

            int x = findTopBrick(y, backup);

            if (x != -1) {
                boom(x, y, backup);
                drop(backup);
            }

            shoot(cnt + 1, backup);
        }
    }

    static void updateMax(int[][] map) {
        int cnt = 0;
        for (int x = 0; x < H; x++) {
            for (int y = 0; y < W; y++) {
                if (map[x][y] > 0) {
                    cnt++;
                }
            }
        }
        MinCnt = Math.min(cnt, MinCnt);

    }

    static int[][] copyMap(int[][] map) {
        int[][] backup = new int[H][W];
        for (int x = 0; x < H; x++) {
            for (int y = 0; y < W; y++) {
                backup[x][y] = map[x][y];
            }
        }
        return backup;
    }

    static int findTopBrick(int y, int[][] map) {
        int top = -1;
        for (int x = 0; x < H; x++) {
            if (map[x][y] > 0) {
                top = x;
                break;
            }
        }
        return top;
    }

    static void boom(int x, int y, int[][] map) {
        if (map[x][y] <= 0) {
            return;
        }
        int range = map[x][y];
        map[x][y] = 0;
        for (int r = 1; r < range; r++) {
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir] * r;
                int ny = y + dy[dir] * r;
                if (nx >= 0 && ny >= 0 && nx < H && ny < W) {
                    boom(nx, ny, map);
                }
            }
        }
    }

    static void drop(int[][] map) {
        for (int y = 0; y < W; y++) {
            Queue<Integer> q = new LinkedList<>();
            for (int x = H - 1; x >= 0; x--) {
                if (map[x][y] != 0) {
                    q.add(map[x][y]);
                    map[x][y] = 0;
                }
            }
            int index = H - 1;
            while (!q.isEmpty()) {
                map[index][y] = q.poll();
                index--;
            }
        }
    }
}