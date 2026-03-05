import java.util.*;

public class Main {
    static int n;
    static int l;
    static int r;
    static int[][] countries;
    static boolean[][] visited;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static int days;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        countries = new int[n][n];
        visited = new boolean[n][n];

        days = 0;

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                countries[i][k] = sc.nextInt();
            }
        }
        while (true) {
            visited = new boolean[n][n];
            boolean isPossible = selectCountry();
            if (!isPossible) {
                break;
            }
            days++;
        }
        System.out.println(days);
    }

    public static boolean selectCountry() {
        boolean isPossible = false;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (!visited[x][y]) {
                    if (bfs(x, y)) {
                        isPossible = true;
                    }
                }
            }
        }
        return isPossible;
    }

    public static boolean bfs(int x, int y) {
        ArrayList<int[]> union = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        union.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (!visited[nx][ny]) {
                        int diff = Math.abs(countries[now[0]][now[1]] - countries[nx][ny]);
                        if (diff >= l && diff <= r) {
                            visited[nx][ny] = true;
                            union.add(new int[]{nx, ny});
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        makeUnion(union);
        if (union.size() > 1) {
            return true;
        } else return false;
    }

    public static void makeUnion(ArrayList<int[]> union) {
        int human = 0;
        for (int[] u : union) {
            human += countries[u[0]][u[1]];
        }
        human /= union.size();
        for (int[] u : union) {
            countries[u[0]][u[1]] = human;
        }
    }
}
