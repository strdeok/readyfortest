import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] flag = new char[n][m];

            for (int i = 0; i < n; i++) {
                flag[i] = sc.next().toCharArray();
            }


            List<int[]> cases = new ArrayList<>();

            // 깃발 채우기
            for (int w = 0; w < n - 2; w++) {
                for (int b = 1; b < n - 1 - w; b++) {
                    int r = n - 1;
                    int[] c = {w, b, r};
                    cases.add(c);
                }
            }

            int cnt = Integer.MAX_VALUE;
            for (int[] c:cases){
                int tmp = 0;
                // 하양
                for (int w = 0; w <= c[0]; w++){
                    for (char f:flag[w]){
                        if (f != 'W') tmp++;
                    }
                }
                // 파랑
                for (int b = c[0] + 1; b <= c[0] + c[1]; b++){
                    for (char f:flag[b]){
                        if (f != 'B') tmp++;
                    }
                }

                // 빨강
                for (int r = c[0] + c[1] + 1; r <= c[2]; r++){
                    for (char f:flag[r]){
                        if (f != 'R') tmp++;
                    }
                }

                cnt = Math.min(tmp, cnt);
            }
            System.out.println("#" + test_case + " " + cnt);
        }
    }
}