import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int k;
    static int w;
    static int[] times;
    static ArrayList<Integer>[] nodes;
    static int[] nodeDepth;

    static int MIN_TIME;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            MIN_TIME = Integer.MAX_VALUE;

            times = new int[n + 1];
            nodes = new ArrayList[n + 1];
            nodeDepth = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                nodes[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= n; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                nodes[a].add(b);
                nodeDepth[b] += 1;
            }

            w = Integer.parseInt(br.readLine());

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            for (int i = 1; i <= n; i++) {
                if (nodeDepth[i] == 0) {
                    pq.add(new int[]{i, times[i]});
                }
            }

            while (!pq.isEmpty()) {
                int[] now = pq.poll();
                int node = now[0];
                int time = now[1];
                if (node == w) {
                    MIN_TIME = Math.min(MIN_TIME, time);
                    continue;
                }

                for (int n : nodes[node]) {
                    nodeDepth[n]--;
                    if (nodeDepth[n] == 0) {
                        pq.add(new int[]{n, time + times[n]});
                    }
                }

            }

            System.out.println(MIN_TIME);
        }
    }
}