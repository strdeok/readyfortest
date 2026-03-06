    import java.util.*;

    class Core {
        int x;
        int y;

        public Core(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Solution {
        static int n;
        static boolean[][] visited;
        static ArrayList<Core> cores;

        static int Min;
        static int Max_core;

        static int[] dx = {-1, 1, 0, 0};
        static int[] dy = {0, 0, -1, 1};

        public static void main(String args[]) throws Exception {
            Scanner sc = new Scanner(System.in);
            int T;
            T = sc.nextInt();
            for (int test_case = 1; test_case <= T; test_case++) {
                n = sc.nextInt();
                visited = new boolean[n][n];
                cores = new ArrayList<>();
                Min = Integer.MAX_VALUE;
                Max_core = Integer.MIN_VALUE;

                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < n; y++) {
                        int node = sc.nextInt();

                        if (node == 1) {
                            if (x == 0 || y == 0 || x == n - 1 || y == n - 1) {
                                visited[x][y] = true;
                                continue;
                            }
                            Core c = new Core(x, y);
                            cores.add(c);
                            visited[x][y] = true;
                        }
                    }
                }

                aloneCore();
                dfs(0, 0, 0);
                System.out.println("#" + test_case + " " + Min);
            }
        }

        static void dfs(int idx, int totalCores, int coreCnt) {
            if (idx == cores.size()) {
                if (Max_core < coreCnt) {
                    Max_core = coreCnt;
                    Min = totalCores;
                } else if (Max_core == coreCnt){
                    Min = Math.min(totalCores, Min);
                }

                return;
            }
            for (int dir = 0; dir < 4; dir++) {
                boolean[][] clone = new boolean[n][n];

                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < n; y++) {
                        clone[x][y] = visited[x][y];
                    }
                }

                int distance = select(cores.get(idx), dir);
                if (distance == -1){
                    continue;
                }
                dfs(idx + 1, totalCores + distance, coreCnt + 1);
                visited = clone;
            }
            dfs(idx + 1, totalCores, coreCnt);
        }

        static int select(Core core, int dir) {
            int x = core.x;
            int y = core.y;
            int distance = 0;

            while (true) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (visited[nx][ny]) {
                        return -1;
                    }
                    x = nx;
                    y = ny;
                    distance++;
                } else {
                    break;
                }
            }

            x = core.x;
            y = core.y;
            while (true) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    visited[nx][ny] = true;
                    x = nx;
                    y = ny;
                } else {
                    break;
                }
            }

            return distance;
        }

        static void aloneCore() {
            ArrayList<Core> aloneCores = new ArrayList<>();
            for (Core c: cores){
                boolean isAlone = true;
                for (int dir = 0; dir < 4; dir++){
                    int nx = c.x + dx[dir];
                    int ny = c.y + dy[dir];

                    if (!visited[nx][ny]) {
                        isAlone = false;
                    }
                }
                if (isAlone){
                    aloneCores.add(c);
                }
            }

            for (Core c:aloneCores){
                cores.remove(c);
            }
        }

    }