import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    static int k;
    static int[][] magnetics;

    static int[] rotate;


    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            magnetics = new int[4][8];
            rotate = new int[4]; // 1 시계 / -1 반시계


            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 8; k++) {
                    magnetics[i][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken()) - 1;
                int direction = Integer.parseInt(st.nextToken());

                rotate[num] = direction;
                checkSide(num);



                for (int k = 0; k < 4; k++) {
                    move(k);
                }
                rotate = new int[4];
            }

            int score = 0;
            for (int i = 0; i < 4; i++) {
                if (magnetics[i][0] == 1) {
                    if (i == 0) score += 1;
                    if (i == 1) score += 2;
                    if (i == 2) score += 4;
                    if (i == 3) score += 8;
                }


            }

            System.out.println("#" + test_case + " " + score);
        }
    }

    static void checkSide(int num) {
        if (num == 0) {
            if (magnetics[0][2] != magnetics[1][6] && rotate[1] == 0) {
                rotate[1] = rotate[0] == 1 ? -1 : 1;
                checkSide(1);
            }
        }
        if (num == 3) {
            if (magnetics[3][6] != magnetics[2][2] && rotate[2] == 0) {
                rotate[2] = rotate[3] == 1 ? -1 : 1;
                checkSide(2);
            }
        }
        if (num == 1) {
            if (magnetics[1][2] != magnetics[2][6] && rotate[2] == 0) {
                rotate[2] = rotate[1] == 1 ? -1 : 1;
                checkSide(2);
            }
            if (magnetics[1][6] != magnetics[0][2] && rotate[0] == 0) {
                rotate[0] = rotate[1] == 1 ? -1 : 1;
                checkSide(0);
            }
        }
        if (num == 2) {
            if (magnetics[2][2] != magnetics[3][6] && rotate[3] == 0) {
                rotate[3] = rotate[2] == 1 ? -1 : 1;
                checkSide(3);
            }
            if (magnetics[2][6] != magnetics[1][2] && rotate[1] == 0) {
                rotate[1] = rotate[2] == 1 ? -1 : 1;
                checkSide(1);
            }
        }
    }

    static void move(int num) {
        if (rotate[num] == 1) {
            int tmp = magnetics[num][7];
            for (int i = 0; i < 8; i++) {
                int n = magnetics[num][i];
                magnetics[num][i] = tmp;
                tmp = n;
            }
        }
        if (rotate[num] == -1) {
            int tmp = magnetics[num][0];
            for (int i = 7; i >= 0; i--) {
                int n = magnetics[num][i];
                magnetics[num][i] = tmp;
                tmp = n;
            }
        }
    }


}