import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Fireball {
	int x, y, m, s, d;

	public Fireball(int x, int y, int m, int s, int d) {
		this.x = x;
		this.y = y;
		this.m = m;
		this.s = s;
		this.d = d;
	}

}

class Main {
	static int n, m, k;
	static ArrayList<Fireball> fireballs = new ArrayList<>();

	// 상 우상 우 우하 하 좌하 좌 좌상
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			Fireball fireball = new Fireball(r, c, m, s, d);
			fireballs.add(fireball);
		}

		for (int i = 0; i < k; i++) {
			simulate();
		}

		int sum = 0;
		for (Fireball fb : fireballs) {
			sum += fb.m;
		}
		System.out.println(sum);
	}

	public static void simulate() {
		int[][] graph = new int[n][n];

		for (Fireball f : fireballs) {
			int x = f.x;
			int y = f.y;

			int nx = x + f.s * dx[f.d];
			int ny = y + f.s * dy[f.d];

			// 넘어가면?
			// 0보다 크면 n 빼기
			// 0 아래면 +n
			while (nx < 0 || ny < 0 || nx >= n || ny >= n) {
				if (nx < 0) {
					nx += n;
				}
				if (ny < 0) {
					ny += n;
				}
				if (nx >= n) {
					nx -= n;
				}
				if (ny >= n) {
					ny -= n;
				}
			}

			f.x = nx;
			f.y = ny;
			graph[nx][ny]++;
		}

		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				if (graph[x][y] > 1) {
					calculate(graph[x][y], x, y);
				}
			}
		}
	}

	static void calculate(int cnt, int x, int y) {
		Fireball[] fbs = new Fireball[cnt];
		int index = 0;
		for (int i = 0; i < fireballs.size(); i++) {
			Fireball f = fireballs.get(i);
			if (f.x == x && f.y == y) {
				fbs[index] = f;
				index++;
			}
		}

		int mass = 0;
		int speed = 0;
		boolean isAllOdd = true;
		boolean isAllEven = true;
		for (Fireball f : fbs) {
			mass += f.m;
			speed += f.s;
			if (f.d % 2 == 0) {
				isAllEven = false;
			}
			if (f.d % 2 != 0) {
				isAllOdd = false;
			}
			fireballs.remove(f);
		}

		int dir = 0;
		for (int i = 0; i < 4; i++) {
			if (isAllOdd || isAllEven) {
				dir = 2 * i;
			} else {
				dir = 2 * i + 1;
			}

			if (mass / 5 < 1) {
				break;
			}
			Fireball fb = new Fireball(x, y, mass / 5, speed / cnt, dir);
			fireballs.add(fb);
		}
	}
}
