import java.util.*;
import java.io.*;

public class Solution {
    static int N;
    static char[][] map;
    static int startX, startY;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == 'X') {
                        startX = i; startY = j;
                    }
                }
            }

            int Q = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc);

            for (int i = 0; i < Q; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int cmdLen = Integer.parseInt(st.nextToken());
                String commands = st.nextToken();

                sb.append(" ").append(solve(commands));
            }
            System.out.println(sb.toString());
        }
    }

    static int solve(String cmds) {
        int cx = startX;
        int cy = startY;
        int cd = 0;

        for (char c : cmds.toCharArray()) {
            if (c == 'A') {
                int nx = cx + dx[cd];
                int ny = cy + dy[cd];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] != 'T') {
                    cx = nx;
                    cy = ny;
                }
            } else if (c == 'L') {
                cd = (cd + 3) % 4;
            } else if (c == 'R') {
                cd = (cd + 1) % 4;
            }
        }

        return map[cx][cy] == 'Y' ? 1 : 0;
    }
}