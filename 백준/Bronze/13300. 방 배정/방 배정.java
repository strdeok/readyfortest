import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] student = new int[6][2];

        for (int i = 0; i < N; i++){
            int S = sc.nextInt();
            int Y = sc.nextInt();
            student[Y-1][S]++;
        }
        int cnt = 0;
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 2; j++){
                if (student[i][j] == 0){
                    continue;
                }
                if (student[i][j] > K){
                    cnt += student[i][j] / K + 1;
                } else cnt++;
            }
        }
        System.out.println(cnt);
    }
}