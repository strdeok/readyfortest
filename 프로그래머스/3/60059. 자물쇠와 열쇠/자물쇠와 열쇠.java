import java.util.*;

class Solution {
    int[][] graph;
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int n = lock.length;
        int m = key.length;
        
        graph = new int[n*3][n*3];
        
        for (int[] row : graph) {
            Arrays.fill(row, -1);
        }
        
        int target = 0;
        for (int x = 0; x < n; x++){
            for (int y = 0; y < n; y++) {
                if (lock[x][y] == 0) target++;
            }
        }
        
        for (int x = 0; x < n; x++){
            for (int y = 0; y < n; y++){
                graph[x + n][y + n] = lock[x][y];
            }
        }
        
        for (int rotate = 0; rotate < 4; rotate++) {
            key = rotateKey(key);
            for (int x = 0; x < n * 3; x++) {
                for (int y = 0; y < n * 3; y++) {
                    int startX = x;
                    int startY = y;
                    
                    int cnt = 0;
                    for (int nx = startX; nx < startX + m; nx++) {
                        for (int ny = startY; ny < startY + m; ny++) {
                            if (nx < 0 || ny < 0 || nx >= n * 3 || ny >= n * 3) continue;
                            int kx = nx - startX;
                            int ky = ny - startY;
                            
                            if (key[kx][ky] == 1 && graph[nx][ny] == 1) break;
                            
                            if (key[kx][ky] == 1 && graph[nx][ny] == 0) {
                                cnt++;                            
                            }
                        }
                    }
                    if (cnt == target) return true;
                }
            }
        }
        
        
        
        return answer;
    }
    
    int[][] rotateKey(int[][] key) {
        int m = key[0].length;
        int[][] cloned = new int[m][m];
        
        for (int x = 0; x < m; x++){
            for (int y = 0; y < m; y++){
                cloned[y][m - 1 - x] = key[x][y];
            }
        }
        
        return cloned;
    }
}