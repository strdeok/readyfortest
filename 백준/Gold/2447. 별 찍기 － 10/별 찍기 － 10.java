import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (재귀(i, j, n)) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        // 기본 네모
        System.out.print(sb);
    }

    static boolean 재귀(int r, int c, int size) {
        if (size == 1) {
            return true;
        }

        if (r / (size / 3) % 3 == 1 && c / (size / 3) % 3 == 1) {
            return false;
        }

        return 재귀(r, c, size / 3);
    }
}