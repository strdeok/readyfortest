import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = sc.nextInt(); // 암호문 개수
			List<Integer> arr = new LinkedList<Integer>();

			for (int i = 0; i < n; i++) {
				arr.add(sc.nextInt()); // 원본 암호문
			}

			int orderCnt = sc.nextInt(); // 명령어 개수

			for (int i = 0; i < orderCnt; i++) {
				String order = sc.next(); // 명령어
				
				// 삽입
				if (order.equals("I")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					
					for (int k = 0; k < y; k++) {
						int s = sc.nextInt();
						arr.add(x + k, s);
					}
				}
				
				// 삭제
				if (order.equals("D")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					
					for (int k = 0; k < y; k++) {
						arr.remove(x);
					}
				}
				
			}
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(arr.get(i) + " ");
			}
			System.out.println();

		}
	}
}