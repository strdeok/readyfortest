import java.io.*;
import java.util.*;

public class Main {
    static int n, m, r;
    static int[][] map;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        // 시간 초과 방지를 위한 프로들의 국룰 입출력 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        result = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < m; k++) {
                map[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        
        int layer = Math.min(n, m) / 2;

        for (int i = 1; i <= layer; i++) {
            rotateSquare(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                sb.append(result[i][k]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    static void rotateSquare(int layer) {
        // 하, 우, 상, 좌 (반시계 탐색)
        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { 1, 0, -1, 0 };
        
        int count = (m - (2 * (layer - 1))) * 2 + (n - 2 * layer) * 2;
        
        int[] temp = new int[count]; 
        
        int direction = 0;
        int nowX = layer - 1;
        int nowY = layer - 1;
        
        for (int i = 0; i < count; i++) {
            temp[i] = map[nowY][nowX];
            
            if (nowX == layer - 1 && nowY == n - layer) direction = 1;
            else if (nowX == m - layer && nowY == n - layer) direction = 2;
            else if (nowX == m - layer && nowY == layer - 1) direction = 3;

            nowX += dx[direction];
            nowY += dy[direction];
        }

        
        int actualRotate = r % count; 
        
        direction = 0;
        nowX = layer - 1;
        nowY = layer - 1;
        
        for (int i = 0; i < count; i++) {
            int targetIdx = (i + count - actualRotate) % count;
            
            result[nowY][nowX] = temp[targetIdx];
            
            if (nowX == layer - 1 && nowY == n - layer) direction = 1;
            else if (nowX == m - layer && nowY == n - layer) direction = 2;
            else if (nowX == m - layer && nowY == layer - 1) direction = 3;

            nowX += dx[direction];
            nowY += dy[direction];
        }
    }
}