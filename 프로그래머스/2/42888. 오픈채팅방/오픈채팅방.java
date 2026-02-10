import java.util.*;

class Solution {
	public String[] solution(String[] record) {
		List<String> answer = new ArrayList<>();
		Map<String, String> users = new HashMap<>();

		for (String r : record) {
			String[] message = r.split(" ");
			if (message.length == 3) {
				String name = message[2];
				String condition = message[0];
				String uid = message[1];
				
				if (condition.equals("Enter")) {
					users.put(uid, name);
				}
				if (condition.equals("Change")) {
					users.put(uid, name);
				}
			} else
				continue;

		}

		for (String r : record) {
			String[] message = r.split(" ");

			String condition = message[0];
			String uid = message[1];
			if (condition.equals("Leave")) {
				String getName = users.get(uid);
				answer.add(getName + "님이 나갔습니다.");
			} else if (condition.equals("Enter")) {
				answer.add(users.get(uid) + "님이 들어왔습니다.");
			}

		}

		return answer.stream().toArray(String[]::new);
	}
}