import java.util.*;
import java.util.stream.Collectors;

class Solution {
	public int[] solution(String[] genres, int[] plays) {
		List<Integer> answer = new ArrayList<>();
		Map<String, Integer> genreMap = new HashMap<>();
		for (int i = 0; i < genres.length; i++) {
			if (!genreMap.containsKey(genres[i])) {
				genreMap.put(genres[i], plays[i]);
			} else {
				genreMap.put(genres[i], genreMap.get(genres[i]) + plays[i]);
			}
		}
		List<String> sortedGenres = genreMap.keySet().stream()
				.sorted((o1, o2) -> genreMap.get(o2).compareTo(genreMap.get(o1))).collect(Collectors.toList());

		for (int i = 0; i < sortedGenres.size(); i++) {
			Map<Integer, Integer> playTimes = new HashMap<>();
			for (int k = 0; k < genres.length; k++) {
				// i번째로 인기 있는 장르와 현재 곡(k)의 장르가 일치하는지 확인
				if (sortedGenres.get(i).equals(genres[k])) {
					playTimes.put(k, plays[k]); // 인덱스 k를 키로 저장!
				}
			}

			// 곡 정렬: 1순위 재생수 내림차순, 2순위 인덱스 오름차순
			List<Integer> sortedIndices = playTimes.keySet().stream().sorted((o1, o2) -> {
				if (playTimes.get(o1).equals(playTimes.get(o2)))
					return o1 - o2;
				return playTimes.get(o2).compareTo(playTimes.get(o1));
			}).collect(Collectors.toList());

			// 최대 2개까지만 추가
			int count = 0;
			for (Integer p : sortedIndices) {
				if (count == 2)
					break;
				answer.add(p);
				count++;
			}
		}

		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}