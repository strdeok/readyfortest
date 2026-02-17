import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[] now = new int[n];
            int[] target = new int[n];
            int cnt = 0;

            for (int i = 0; i < n * 2; i++) {
                if (i < n) {
                    now[i] = sc.nextInt();
                } else {
                    target[i % n] = sc.nextInt();
                }
            }


            for (int i = 0; i < n; i++) {
                if (now[i] != target[i]){
                    for (int k = i; k < n; k++){
                        if (now[k] == 0) now[k] = 1;
                        else now[k] = 0;
                    }
                    cnt++;
                }
            }

            System.out.println("#" + test_case + " " + cnt);
        }
    }
}