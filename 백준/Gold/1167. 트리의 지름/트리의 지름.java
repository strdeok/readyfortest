import java.util.*;

class Edge {
    int to;
    int distance;

    public Edge(int to, int distance) {
        this.to = to;
        this.distance = distance;
    }
}

public class Main {
    static int n;
    static ArrayList<Edge>[] graph;
    static boolean[] visited;

    static int maxDistance = 0;
    static int farthestNode = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int nowNode = sc.nextInt();
            while (true) {
                int node = sc.nextInt();
                if (node == -1) break;
                int d = sc.nextInt();
                graph[nowNode].add(new Edge(node, d));
            }
        }
        visited = new boolean[n + 1];
        dfs(1, 0);

        visited = new boolean[n + 1];
        maxDistance = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDistance);
    }

    static void dfs(int node, int totalDistance) {
        visited[node] = true;

        if (totalDistance > maxDistance) {
            maxDistance = totalDistance;
            farthestNode = node;
        }
        
        for (Edge next : graph[node]) {
            if (!visited[next.to]) {
                dfs(next.to, totalDistance + next.distance);
            }
        }
    }
}