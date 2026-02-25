import java.util.*;

public class Main {
	static int n, m, tn;
	static int[] whoKnowsTruth;
	static int[][] parties;
	static Set<Integer> truthRoom;
	static Set<Integer> newPerson;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 사람 수
		m = sc.nextInt(); // 파티 수
		tn = sc.nextInt();
		if (tn == 0) {
			System.out.println(m);
			return;
		}

		parties = new int[m][n];

		whoKnowsTruth = new int[tn];
		truthRoom = new HashSet<>();
		newPerson = new HashSet<>();

		for (int i = 0; i < tn; i++) {
			whoKnowsTruth[i] = sc.nextInt();
		}

		// i = 파티장 번호, k = 파티원 번호
		for (int i = 0; i < m; i++) {
			int pn = sc.nextInt();
			for (int k = 0; k < pn; k++) {
				parties[i][k] = sc.nextInt();
			}
		}

		for (int i = 0; i < tn; i++) {
			find(0, whoKnowsTruth[i], 0);
			newPerson.add(whoKnowsTruth[i]);
		}
		System.out.println(m - truthRoom.size());
	}

	public static void find(int room, int person, int pc) { // room= 어디 파티장인지. pc = 돈 파티장 개수
		if (pc == m) {
			return;
		}

		// 파티장 돌기
		for (int i = room; i < m; i++) { // 파티장 번호
			for (int k = 0; k < n; k++) {
				if (parties[i][k] == person) {
					if (pc == 0) {
						truthRoom.add(i);
						searchPartyRoom(i, person);
					}
					if (parties[i][k] == person && room != i) {
						truthRoom.add(i);
						searchPartyRoom(i, person);
					}
				}

			}
		}
	}

	// 같은 파티장에 있는 사람들 찾기
	public static void searchPartyRoom(int room, int person) {
		for (int i = 0; i < n; i++) {
			if (newPerson.contains(parties[room][i])) {
				continue;
			} else if (parties[room][i] != person && parties[room][i] != 0) {
				newPerson.add(parties[room][i]);
				find(0, parties[room][i], 0);
			}
		}
	}
}