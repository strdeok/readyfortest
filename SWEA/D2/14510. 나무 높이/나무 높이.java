import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[] trees = new int[n];
            int MAXHEIGHT = Integer.MIN_VALUE;

            int oddCnt = 0;
            int evenCnt = 0;

            for (int i = 0; i < n; i++) {
                int h = sc.nextInt();
                trees[i] = h;
                MAXHEIGHT = Math.max(MAXHEIGHT, h);
            }

            for (int i = 0; i < n; i++) {
                int h = trees[i];
                oddCnt += (MAXHEIGHT - h) % 2;
                evenCnt += (MAXHEIGHT - h) / 2;
            }

            while (evenCnt - oddCnt > 1) {
                evenCnt--;
                oddCnt += 2;
            }

            int answer = 0;
            if (evenCnt == oddCnt) {
                answer = evenCnt + oddCnt;
            }

            if (evenCnt > oddCnt) {
                answer = evenCnt * 2;
            }

            if (evenCnt < oddCnt) {
                answer = oddCnt * 2 - 1;
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }

}