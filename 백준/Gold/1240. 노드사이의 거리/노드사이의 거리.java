import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge {
    int from, to, w;

    public Edge(int from, int to, int w) {
        this.from = from;
        this.to = to;
        this.w = w;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] nodes = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            nodes[a].add(new Edge(a, b, d));
            nodes[b].add(new Edge(b, a, d));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[n + 1];

            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{start, 0});
            visited[start] = true;

            while (!q.isEmpty()) {
                int[] now = q.poll();
                int node = now[0];
                visited[node] = true;
                int distance = now[1];
                if (node == end) {
                    System.out.println(distance);
                    break;
                }

                for (Edge next : nodes[node]) {
                    if (!visited[next.to]) q.add(new int[]{next.to, distance + next.w});
                }

            }
        }

    }
}