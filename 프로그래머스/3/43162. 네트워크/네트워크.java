import java.util.LinkedList;
import java.util.Queue;

class Solution {
    boolean[] visited;
    int answer = 0;
    int N;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        N = n;

        for (int i = 0; i < n; i++){
                if (!visited[i]){
                    bfs(i, computers);
            }
        }
        return answer;
    }

    void bfs(int x, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < N; i++) {
                if (computers[now][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        answer++;
    }
}