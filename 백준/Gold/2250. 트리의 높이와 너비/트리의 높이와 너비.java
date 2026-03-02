import java.util.*;

public class Main {
    static int n;
    static int[][] childs;
    static int[] parents;
    static int root;
    // 레벨별 최대 최소 X
    static int[] minX = new int[10001];
    static int[] maxX = new int[10001];
    static int x = 1;
    static int level = 1;
    static int targetLevel = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        childs = new int[n + 1][2];
        parents = new int[n + 1];
        Arrays.fill(minX, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            int node = sc.nextInt();
            int left = sc.nextInt();
            int right = sc.nextInt();

            childs[node] = new int[]{left, right};

            if (left != -1) {
                parents[left] = node;
            }

            if (right != -1) {
                parents[right] = node;
            }
        }

        findRoot();
        inOrder(root, level);
        int maxW = diff();
        System.out.println(targetLevel + " " + maxW);
    }

    static void findRoot() {
        for (int i = 1; i <= n; i++) {
            if (parents[i] == 0) {
                root = i;
            }
        }
    }

    static void inOrder(int node, int nowLevel) {
        if (node == -1) {
            return;
        }
        level = Math.max(nowLevel, level);
        inOrder(childs[node][0], nowLevel + 1);
        minX[nowLevel] = Math.min(minX[nowLevel], x);
        maxX[nowLevel] = Math.max(maxX[nowLevel], x);
        x++;
        inOrder(childs[node][1], nowLevel + 1);
    }

    static int diff() {
        int maxDiff = 0;
        for (int i = 1; i <= level; i++) {
            if (maxDiff < maxX[i] - minX[i] + 1) {
                targetLevel = i;
                maxDiff = maxX[i] - minX[i] + 1;
            }
        }

        return maxDiff;
    }
}
