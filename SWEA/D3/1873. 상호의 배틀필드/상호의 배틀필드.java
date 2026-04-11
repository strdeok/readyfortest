import java.util.Arrays;
import java.util.Scanner;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[] head = {'^', 'v', '<', '>'};

    static int h;
    static int w;
    static char[][] field;
    static int[] tank_location;
    static int dir = 0;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            h = sc.nextInt();
            w = sc.nextInt();
            field = new char[h][w];

            for (int x = 0; x < h; x++) {
                char[] input = sc.next().toCharArray();
                for (int y = 0; y < w; y++) {
                    char now = input[y];
                    if (now == '<') {
                        dir = 2;
                        tank_location = new int[]{x, y};
                    }
                    if (now == '>') {
                        dir = 3;
                        tank_location = new int[]{x, y};
                    }
                    if (now == '^') {
                        dir = 0;
                        tank_location = new int[]{x, y};
                    }
                    if (now == 'v') {
                        dir = 1;
                        tank_location = new int[]{x, y};
                    }
                    field[x][y] = now;
                }
            }

            int n = sc.nextInt();
            char[] orders = new char[n];
            orders = sc.next().toCharArray();
            for (char order : orders) {
                simulate(order);
            }
            System.out.print("#" + test_case + " ");
            for (char[] c : field) {
                for (char f:c){
                    System.out.print(f);
                }
                System.out.println();            }
        }
    }

    static void simulate(char order) {
        int x = tank_location[0];
        int y = tank_location[1];
        if (order != 'S') {
            if (order == 'U') {
                dir = 0;
            }
            if (order == 'D') {
                dir = 1;
            }
            if (order == 'L') {
                dir = 2;
            }
            if (order == 'R') {
                dir = 3;
            }
            field[x][y] = head[dir];

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                if (field[nx][ny] == '.') {
                    field[nx][ny] = field[x][y];
                    field[x][y] = '.';
                    tank_location[0] = nx;
                    tank_location[1] = ny;
                }
            }
        }

        if (order == 'S') {
            int cnt = 1;
            while (true) {
                int nx = x + dx[dir] * cnt;
                int ny = y + dy[dir] * cnt;

                if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                    if (field[nx][ny] == '*') {
                        field[nx][ny] = '.';
                        break;
                    }
                    if (field[nx][ny] == '#'){
                        break;
                    }
                    cnt++;
                } else {
                    break;
                }
            }
        }
    }
}