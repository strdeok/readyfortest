import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int test_case = 1; test_case <= 10; test_case++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#" + test_case + " ");
            int v = sc.nextInt();
            int e = sc.nextInt();

            ArrayList<Integer>[] nodes = new ArrayList[v + 1];
            int[] degree = new int[v + 1];

            for (int i = 0; i < v + 1; i++) {
                nodes[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                int u = sc.nextInt();
                int w = sc.nextInt();
                nodes[u].add(w);
                degree[w]++;
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i < v + 1; i++) {
                if (degree[i] == 0) {
                    q.add(i);
                }
            }

            while (!q.isEmpty()) {
                int now = q.poll();
                sb.append(now + " ");
                for (int next : nodes[now]) {
                    if (degree[next] > 0){
                        degree[next]--;
                        if (degree[next] == 0) {
                            q.add(next);
                        }
                    }

                }
            }

            System.out.println(sb.toString());
        }
    }
}