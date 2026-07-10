import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] map = new int[rows][columns];

        int num = 1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                map[r][c] = num++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;

            int previous = map[x1][y1];
            int min = previous;

            // 왼오
            for (int c = y1 + 1; c <= y2; c++) {
                int current = map[x1][c];
                map[x1][c] = previous;
                previous = current;
                min = Math.min(min, current);
            }

            //  위아래
            for (int r = x1 + 1; r <= x2; r++) {
                int current = map[r][y2];
                map[r][y2] = previous;
                previous = current;
                min = Math.min(min, current);
            }

            // 오왼
            for (int c = y2 - 1; c >= y1; c--) {
                int current = map[x2][c];
                map[x2][c] = previous;
                previous = current;
                min = Math.min(min, current);
            }

            // 아래위
            for (int r = x2 - 1; r >= x1; r--) {
                int current = map[r][y1];
                map[r][y1] = previous;
                previous = current;
                min = Math.min(min, current);
            }

            answer[i] = min;
        }

        return answer;
    }
}