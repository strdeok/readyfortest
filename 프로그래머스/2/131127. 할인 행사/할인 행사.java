import java.util.*;

class Solution {
	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;
		Map<String, Integer> wantMap = new HashMap<>();

		// 맵으로 저장
		for (int i = 0; i < want.length; i++) {
			wantMap.put(want[i], number[i]);
		}


		// 조건 판정
		// discount에서 discount의 개수 ~ 10개까지의 범위를 좁혀가면서 wantMap과 비교
		// 만약 wantMap이 비어있다면 통과.
			List<String> arr = new ArrayList<>();		
			// 할인 품목을 잘라 arr에 저장			
			// 시작일 i는 0일부터, 마지막으로 10일을 채울 수 있는 날까지
			for (int i = 0; i <= discount.length - 10; i++) {
			    Map<String, Integer> copy = new HashMap<>(wantMap);
			    
			    for (int k = i; k < i + 10; k++) {
			        String item = discount[k];
			        if (copy.containsKey(item)) {
			            copy.put(item, copy.get(item) - 1);
			            if (copy.get(item) == 0) {
			                copy.remove(item);
			            }
			        }
			    }
			    
			    if (copy.isEmpty()) {
			        answer++;
			    }
			}
			
			
		return answer;
	}
}