import java.util.ArrayList;
import java.util.List;

class Solution {

    int n;
    boolean[][] columns;
    boolean[][] beams;

    public int[][] solution(int n, int[][] buildFrame) {
        this.n = n;
        columns = new boolean[n + 2][n + 2];
        beams = new boolean[n + 2][n + 2];

        for (int[] command : buildFrame) {
            int x = command[0];
            int y = command[1];
            int type = command[2];   // 0: 기둥, 1: 보
            int action = command[3]; // 0: 삭제, 1: 설치

            boolean previous;

            if (type == 0) {
                previous = columns[x][y];
                columns[x][y] = action == 1;
            } else {
                previous = beams[x][y];
                beams[x][y] = action == 1;
            }

            // 명령 적용 후 전체 구조가 유효하지 않으면 원상 복구
            if (!isAllValid()) {
                if (type == 0) {
                    columns[x][y] = previous;
                } else {
                    beams[x][y] = previous;
                }
            }
        }

        List<int[]> result = new ArrayList<>();

        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (columns[x][y]) {
                    result.add(new int[]{x, y, 0});
                }

                if (beams[x][y]) {
                    result.add(new int[]{x, y, 1});
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    private boolean isAllValid() {
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (columns[x][y] && !isValidColumn(x, y)) {
                    return false;
                }

                if (beams[x][y] && !isValidBeam(x, y)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidColumn(int x, int y) {
        // 바닥 위
        if (y == 0) {
            return true;
        }

        // 다른 기둥 위
        if (columns[x][y - 1]) {
            return true;
        }

        // 왼쪽 보의 오른쪽 끝 위
        if (x > 0 && beams[x - 1][y]) {
            return true;
        }

        // 오른쪽 보의 왼쪽 끝 위
        if (beams[x][y]) {
            return true;
        }

        return false;
    }

    private boolean isValidBeam(int x, int y) {
        // 보의 왼쪽 끝 아래에 기둥
        if (y > 0 && columns[x][y - 1]) {
            return true;
        }

        // 보의 오른쪽 끝 아래에 기둥
        if (y > 0 && columns[x + 1][y - 1]) {
            return true;
        }

        // 양쪽 끝이 다른 보와 연결됨
        if (x > 0 && beams[x - 1][y] && beams[x + 1][y]) {
            return true;
        }

        return false;
    }
}