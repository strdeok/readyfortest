import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            char[][] map = new char[n][n];

            for (int i = 0; i < n; i++){
                map[i] = sc.next().toCharArray();
            }



            // 가로, 세로, 우하, 좌하
            int[] dr = {0, 1, 1, 1};
            int[] dc = {1, 0, 1, -1};

            String answer = "NO";
            boolean found = false;
            for (int r = 0; r < n; r++) { // 가로
                if(found) break;
                for (int c = 0; c < n; c++) { // 세로
                    if(found) break;

                    if (map[r][c] == 'o') {
                        for (int d = 0; d < 4; d++) { // 방향 탐색
                            int count = 0;

                            for (int k = 0; k < 5; k++) { // 범위 탐색
                                int nr = r + dr[d] * k;
                                int nc = c + dc[d] * k;

                                if (nr < 0 || nr >= n || nc < 0 || nc >= n) break;

                                if (map[nr][nc] != 'o') break;

                                count++;
                            }
                            if (count >= 5) {
                                answer = "YES";
                                found = true;
                                break;
                            }
                        }
                    }
                }
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }
}