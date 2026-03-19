import java.util.*;

class Pos {
    int time;
    int pos;

    public Pos(int time, int pos) {
        this.time = time;
        this.pos = pos;
    }
}

public class Main {
    static int n;
    static int k;
    static int Min = Integer.MAX_VALUE;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        bfs();
        System.out.println(Min);
    }

    public static void bfs() {
        Deque<Pos> dq = new ArrayDeque<>();
        dq.push(new Pos(0, n));
        visited[n] = true;
        while (!dq.isEmpty()) {
            Pos curr = dq.poll();
            if (curr.pos == k) {
                Min = Math.min(Min, curr.time);
                break;
            }

            int teleport = curr.pos * 2;
            if (teleport <= 100000 && !visited[teleport]) {
                dq.addFirst(new Pos(curr.time, teleport));
                visited[teleport] = true;
            }

            if (curr.pos - 1 >= 0 && !visited[curr.pos - 1]) {
                visited[curr.pos - 1] = true;
                dq.addLast(new Pos(curr.time + 1, curr.pos - 1));
            }

            if (curr.pos + 1 <= 100000 && !visited[curr.pos + 1]) {
                visited[curr.pos + 1] = true;
                dq.addLast(new Pos(curr.time + 1, curr.pos + 1));
            }

        }
    }
}