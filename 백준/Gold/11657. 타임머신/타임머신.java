import java.io.*;
import java.util.*;

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

        Edge[] edges = new Edge[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        long[] time = new long[n + 1];
        Arrays.fill(time, Long.MAX_VALUE);
        time[1] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                int from = edge.from;
                int to = edge.to;
                int w = edge.w;

                if (time[from] != Long.MAX_VALUE && time[to] > w + time[from]) {
                    time[to] = w + time[from];
                }
            }
        }

        boolean isInCycle = false;
        for (Edge edge : edges) {
            int from = edge.from;
            int to = edge.to;
            int w = edge.w;

            if (time[from] != Long.MAX_VALUE && time[to] > w + time[from]) {
                isInCycle = true;
                break;
            }
        }

        if (isInCycle) {
            System.out.println(-1);
        } else {
            for (int t = 2; t <= n; t++) {
                System.out.println(time[t] == Long.MAX_VALUE ? -1 : time[t]);
            }
        }

    }
}