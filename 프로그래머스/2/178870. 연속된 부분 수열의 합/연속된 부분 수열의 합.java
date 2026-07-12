class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while (true) {
            if (sum >= k) {
                if (sum == k) {
                    int length = right - left;

                    if (length < min) {
                        min = length;
                        answer[0] = left;
                        answer[1] = right - 1;
                    }
                }

                sum -= sequence[left];
                left++;
            } else {
                if (right == sequence.length) {
                    break;
                }

                sum += sequence[right];
                right++;
            }
        }

        return answer;
    }
}