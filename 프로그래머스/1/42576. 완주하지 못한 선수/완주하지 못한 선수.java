import java.util.*;

class Solution {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		Map<String, Integer> p = new HashMap<>();
		for (String person : participant) {
			if (p.containsKey(person)) {
				p.put(person, p.get(person) + 1);
			} else {
				p.put(person, 1);
			}
		}
		
		for (String c: completion) {
			if (p.containsKey(c)) {
				p.put(c, p.get(c) - 1);
			}
			if (p.get(c) == 0) {
				p.remove(c);
			}
		}
		
		for (String key : p.keySet()) {
			answer = key;
		}

		return answer;
	}
}