import java.util.*;

class Solution {
    public boolean solution(int n, int[][] path, int[][] order) {
        List<Integer>[] graph = new ArrayList[n];
        List<Integer>[] unlocks = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            unlocks[i] = new ArrayList<>();
        }

        for (int[] edge : path) {
            int a = edge[0];
            int b = edge[1];

            graph[a].add(b);
            graph[b].add(a);
        }

        // prerequisite[room] = room을 방문하기 전에 방문해야 하는 방
        int[] prerequisite = new int[n];
        Arrays.fill(prerequisite, -1);

        for (int[] condition : order) {
            int first = condition[0];
            int second = condition[1];

            prerequisite[second] = first;
            unlocks[first].add(second);
        }

        // 시작 방에 선행 조건이 있으면 시작 자체가 불가능
        if (prerequisite[0] != -1) {
            return false;
        }

        boolean[] reachable = new boolean[n];
        boolean[] visited = new boolean[n];
        boolean[] queued = new boolean[n];

        Queue<Integer> queue = new ArrayDeque<>();

        reachable[0] = true;
        queued[0] = true;
        queue.offer(0);

        int visitedCount = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (visited[now]) {
                continue;
            }

            // 안전장치
            int required = prerequisite[now];
            if (required != -1 && !visited[required]) {
                continue;
            }

            visited[now] = true;
            visitedCount++;

            // now를 방문해서 조건이 해제된 방 처리
            for (int unlockedRoom : unlocks[now]) {
                if (reachable[unlockedRoom]
                        && !visited[unlockedRoom]
                        && !queued[unlockedRoom]) {

                    queued[unlockedRoom] = true;
                    queue.offer(unlockedRoom);
                }
            }

            // 인접한 방 탐색
            for (int next : graph[now]) {
                if (visited[next]) {
                    continue;
                }

                reachable[next] = true;

                int nextRequired = prerequisite[next];

                if ((nextRequired == -1 || visited[nextRequired])
                        && !queued[next]) {

                    queued[next] = true;
                    queue.offer(next);
                }
            }
        }

        return visitedCount == n;
    }
}