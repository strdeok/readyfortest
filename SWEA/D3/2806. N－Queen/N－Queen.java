import java.util.*;

class Solution {
    static int n;
    static boolean[][] graph;

    // 상 좌상 우상
    static int[] dx = {-1, -1, -1};
    static int[] dy = {0, 1, -1};

    static int cnt;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            graph = new boolean[n][n];
            cnt = 0;


            dfs(0);
            System.out.println("#" + test_case + " " + (n == 1 ? 1 : cnt));
        }
    }

    public static void dfs(int depth) {
        if (depth == n) {
            cnt++;
            return;
        }

        for (int y = 0; y < n; y++) {
            if (isSafe(depth, y)) {
                graph[depth][y] = true;
                dfs(depth + 1);
                graph[depth][y] = false;
            }

        }

    }

    public static boolean isSafe(int depth, int y) {
        // 같은 열에 있는지
        for (int i = 0; i < depth; i++) {
            if (graph[i][y]) return false;
        }

        // 좌상단에 있는지
        int nx = depth;
        int ny = y;
        while (nx >= 0 && ny >= 0) {
            if (graph[nx][ny]) return false;
            nx--;
            ny--;
        }

        // 우상단에 있는지
        nx = depth;
        ny = y;
        while (nx >= 0 && ny < n) {
            if (graph[nx][ny]) return false;
            nx--;
            ny++;
        }

        return true;
    }
}