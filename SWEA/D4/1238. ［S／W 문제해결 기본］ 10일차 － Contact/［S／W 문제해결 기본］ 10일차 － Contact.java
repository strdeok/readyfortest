import java.util.*;

class Solution {
    static int n;
    static int start;
    static ArrayList<Integer>[] edges;
    static boolean[] visited;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int test_case = 1; test_case <= 10; test_case++) {
            n = sc.nextInt();
            start = sc.nextInt();
            edges = new ArrayList[101];
            visited = new boolean[101];

            for (int i = 0; i <= 100; i++) {
                edges[i] = new ArrayList<>();
            }

            for (int i = 0; i < n / 2; i++) {
                int s = sc.nextInt();
                int t = sc.nextInt();
                edges[s].add(t);
            }

            int head = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            visited[start] = true;

            while (!q.isEmpty()) {
                int size = q.size();
                int currentMax = 0;

                for (int i = 0; i < size; i++) {
                    int now = q.poll();
                    if (currentMax < now) currentMax = now;

                    for (int next : edges[now]) {
                        if (!visited[next]) {
                            visited[next] = true;
                            q.add(next);
                        }
                    }
                }
                head = currentMax;
            }
            System.out.println("#" + test_case + " " + head);
        }
    }
}