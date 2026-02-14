import java.util.Scanner;
import java.util.Stack;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[][] map = new int[n][n];
            int cnt = 0;

            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    map[i][j] = sc.nextInt();
                }
            }

            int x = 0;
            int y = 0;
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (map[i][j] == 2){
                        y = i;
                        x = j;
                        break;
                    }
                }
            }

            // 세로 탐색 (상 하)
            for (int i = 1; i < n; i++){
                int ny = y + i;

                if (ny >= 0 && ny < n){
                    if (map[ny][x] == 0){
                        map[ny][x] = 1;
                    } else if (map[ny][x] == 1) {
                        break;
                    }
                }
            }
            for (int i = 1; i < n; i++){
                int ny = y - i;

                if (ny >= 0 && ny < n){
                    if (map[ny][x] == 0){
                        map[ny][x] = 1;
                    } else if (map[ny][x] == 1) {
                        break;
                    }
                }
            }

            // 가로 탐색 (좌 우)
            for (int i = 1; i < n; i++){
                int nx = x + i;

                if (nx >= 0 && nx < n){
                    if (map[y][nx] == 0){
                        map[y][nx] = 1;
                    } else if (map[y][nx] == 1) {
                        break;
                    }
                }
            }
            for (int i = 1; i < n; i++){
                int nx = x - i;

                if (nx >= 0 && nx < n){
                    if (map[y][nx] == 0){
                        map[y][nx] = 1;
                    } else if (map[y][nx] == 1) {
                        break;
                    }
                }
            }

            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (map[i][j] == 0) cnt++;
                }
            }

            System.out.println("#" + test_case + " " + cnt);
        }
    }
}