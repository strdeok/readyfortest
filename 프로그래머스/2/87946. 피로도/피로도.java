

class Solution {
    int answer = 0;
    boolean[] visited;

    public int solution(int k, int[][] dungeons) { // k: 현재 피로도, dungeons: 각 던전에 대한 최소, 소모 피로도
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
    }

    void dfs(int k, int[][] dungeons, int count) {
        answer = Math.max(answer, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, count + 1);
                visited[i] = false;
            }
        }
    }
}