import java.util.*;
import java.io.*;

public class Solution {
    static int N, X;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int totalCnt = 0;
            // 가로 행 체크
            for (int i = 0; i < N; i++) {
                if (checkPath(map[i])) totalCnt++;
            }
            // 세로 열 체크
            for (int j = 0; j < N; j++) {
                int[] col = new int[N];
                for (int i = 0; i < N; i++) col[i] = map[i][j];
                if (checkPath(col)) totalCnt++;
            }

            System.out.println("#" + tc + " " + totalCnt);
        }
    }

    static boolean checkPath(int[] line) {
        boolean[] occupied = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            if (line[i] == line[i + 1]) continue;

            int diff = line[i] - line[i + 1];

            if (Math.abs(diff) > 1) return false;

            if (diff == 1) {
                for (int j = 1; j <= X; j++) {
                    if (i + j >= N || line[i + 1] != line[i + j] || occupied[i + j]) return false;
                    occupied[i + j] = true;
                }
            } else if (diff == -1) {
                for (int j = 0; j < X; j++) {
                    if (i - j < 0 || line[i] != line[i - j] || occupied[i - j]) return false;
                    occupied[i - j] = true;
                }
            }
        }
        return true;
    }
}