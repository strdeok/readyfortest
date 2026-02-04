import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] map = new char[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = sc.next().toCharArray();
        }

        char[] pattern1 = {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'};
        char[] pattern2 = {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'};

        // 맵 떼기
        int minCnt = 64; // 최악의 경우 64개를 칠해야함
        for (int rowStart = 0; rowStart <= n - 8; rowStart++) {
            for (int colStart = 0; colStart <= m - 8; colStart++) {
                int countB = 0; // pattern1이라고 무조건 생각
                for (int row = 0; row < 8; row++) { // 초기 row 위치
                    for (int col = 0; col < 8; col++) { // 초기 col 위치
                        char current = map[rowStart + row][colStart + col];

                        if ((row + col) % 2 == 0) { // row + col이 짝수면 B
                            if (current != 'B') countB++;
                        } else { // row + col이 홀수면 W
                            if (current != 'W') countB++;
                        }
                    }
                }

                int countA = 64 - countB;
                minCnt = Math.min(minCnt, Math.min(countA, countB));
            }
        }
        System.out.println(minCnt);
    }
}