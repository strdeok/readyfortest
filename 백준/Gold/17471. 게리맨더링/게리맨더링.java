import java.io.*;
import java.util.*;

class Main {
    static int N;
    static ArrayList<Integer>[] regions;
    static int[] humans;
    static boolean[] selected;
    static boolean[] visited;

    static int MINDIFF;
    static int A;
    static int B;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        regions = new ArrayList[N + 1];
        humans = new int[N + 1];
        selected = new boolean[N + 1];
        MINDIFF = Integer.MAX_VALUE;


        for (int i = 1; i <= N; i++) {
            regions[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            humans[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            int howMany = sc.nextInt();
            for (int k = 0; k < howMany; k++) {
                int region = sc.nextInt();
                regions[i].add(region);
                regions[region].add(i);
            }
        }
        divide(0);
        System.out.println(MINDIFF == Integer.MAX_VALUE ? -1 : MINDIFF);
    }

    static void divide(int idx) {
        if (idx == N + 1) {
            check();
            return;
        }

        selected[idx] = true;
        divide(idx + 1);

        selected[idx] = false;
        divide(idx + 1);
    }

    static void check() {
        A = 0;
        B = 0;
        visited = new boolean[N + 1];
        ArrayList<Integer> teamA = new ArrayList<>();
        ArrayList<Integer> teamB = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {
            if (selected[i]) {
                teamA.add(i);
            } else {
                teamB.add(i);
            }
        }

        if (teamA.isEmpty() || teamB.isEmpty()) return;


        if (isConnected(teamA) && isConnected(teamB)) {
            for (Integer n : teamA) {
                A += humans[n];
            }
            for (Integer n : teamB) {
                B += humans[n];
            }
            MINDIFF = Math.min(MINDIFF, Math.abs(A - B));
        }
    }

    static boolean isConnected(ArrayList<Integer> region) {
        boolean isPossible = true;
        Queue<Integer> q = new LinkedList<>();
        int f = region.get(0);
        q.add(f);
        visited[f] = true;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (Integer r : regions[now]) {
                if (!visited[r] && region.contains(r)) {
                    visited[r] = true;
                    q.add(r);
                }
            }
        }

        for (Integer n : region) {
            if (!visited[n]) {
                isPossible = false;
                break;
            }
        }
        return isPossible;
    }
}