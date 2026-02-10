import java.util.*;

class Solution {
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		Map<String, List<String>> reporter = new HashMap<>(); // 신고자
		Map<String, Integer> reported = new HashMap<>(); // 신고 당한 사람
		Set<String> setReport = new HashSet<>(Arrays.asList(report));
		List<String> reports = new ArrayList<>(setReport);

		for (String id : id_list) {
			reporter.put(id, new ArrayList<>());
			reported.put(id, 0);
		}


		for (String r : reports) {
			String[] arr = r.split(" ");
			String a = arr[0];
			String b = arr[1];
			List<String> getA = reporter.get(a);
			getA.add(b);

			reporter.put(a, getA);
			reported.put(b, reported.get(b) + 1);
		}

		for (int i = 0; i < id_list.length; i++) {
			String id = id_list[i];
			List<String> getV = reporter.get(id);
			int cnt = 0;
			
			// 신고 당한 사람
			for (String a : getV) {
				if (reported.get(a) >= k) {
					cnt++;
				}
			}

			answer[i] = cnt;
		}

		return answer;
	}
}