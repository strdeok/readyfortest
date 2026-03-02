import java.util.*;

class Node {
    int x;
    int distance;

    Node(int x, int distance) {
        this.x = x;
        this.distance = distance;
    }
}

public class Main {
    static int n;
    static ArrayList<Node>[] trees;
    static boolean[] visited;
    static int fartestNode = 0;
    static int MAX_DISTANCE = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        trees = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        
        if (n == 1) {
            System.out.println(0);
            return;
        }

        for (int i = 1; i <= n; i++) {
            trees[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            int distance = sc.nextInt();
            trees[node1].add(new Node(node2, distance));
            trees[node2].add(new Node(node1, distance));
        }
        dfs(1, 0);

        visited = new boolean[n + 1];
        MAX_DISTANCE = 0;
        dfs(fartestNode, 0);
        System.out.println(MAX_DISTANCE);
    }

    static void dfs(int node, int totalDistance) {
        visited[node] = true;
        if (totalDistance > MAX_DISTANCE) {
            MAX_DISTANCE = totalDistance;
            fartestNode = node;
        }

        for (Node n : trees[node]) {
            if (!visited[n.x]) {
                dfs(n.x, totalDistance + n.distance);
            }
        }
    }

}