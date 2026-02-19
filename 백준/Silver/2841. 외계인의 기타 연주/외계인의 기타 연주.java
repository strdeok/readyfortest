import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p = sc.nextInt();

		// 기타줄 6개
		Stack[] guitar = { new Stack<>(), new Stack<>(), new Stack<>(), new Stack<>(), new Stack<>(), new Stack<>() };
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			int line = sc.nextInt() - 1;
			int melody = sc.nextInt();

			if (guitar[line].isEmpty()) {
				guitar[line].push(melody);
				cnt++;
			} else {
				if ((int) guitar[line].peek() < melody) {
					guitar[line].push(melody);
					cnt++;
				} else if ((int) guitar[line].peek() == melody) {
					continue;
				} else {
					while ((int) guitar[line].peek() > melody) {
						guitar[line].pop();
						cnt++;
						if (guitar[line].size() == 0)
							break;
					}
					if (guitar[line].size() != 0 && (int) guitar[line].peek() != melody) {
						guitar[line].push(melody);
						cnt++;
					} else if (guitar[line].size() == 0) {
						guitar[line].push(melody);
						cnt++;
					}

				}
			}
		}
		System.out.println(cnt);
	}
}
