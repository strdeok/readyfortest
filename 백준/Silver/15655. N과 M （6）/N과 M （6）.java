import java.util.*;

public class Main {
    static int n;
    static int m;
    static boolean[] visited;
    static int[] nums;
    static int[] com;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n];
        nums = new int[n];
        com = new int[m];
        sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);
        combination(0, 0);
        System.out.println(sb);
    }


    public static void combination(int idx, int sidx) {
        if (sidx == m) {
            for (int i : com) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        if (idx == n) return;
        com[sidx] = nums[idx];
        combination(idx + 1, sidx + 1);
        combination(idx + 1, sidx);
    }
}