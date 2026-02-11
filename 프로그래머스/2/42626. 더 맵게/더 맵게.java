import java.util.PriorityQueue;

class Solution {
	public int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> hots = new PriorityQueue<Integer>();

		for (int s : scoville) {
			hots.add(s);
		}

		while (hots.size() > 1 && hots.peek() < K) {
			int least_hot = hots.poll();
			int second_hot = hots.poll();
			int new_hot = least_hot + (second_hot * 2);
			hots.add(new_hot);
			answer++;
		}
		
		if (hots.peek() < K) {
			return -1;
		}

		return answer;
	}
}