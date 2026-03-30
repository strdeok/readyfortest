class Solution {
	public long solution(String numbers) {
		char[] numChar = numbers.toCharArray();

		StringBuilder sb = new StringBuilder();
		StringBuilder answer = new StringBuilder();
		for (char c : numChar) {
			sb.append(c);

			if (checkNum(sb.toString()) != -1) {
				answer.append(checkNum(sb.toString()));
				sb = new StringBuilder();
			}
		}

		return Long.parseLong(answer.toString());
	}

	static int checkNum(String num) {
		if (num.equals("one")) {
			return 1;
		} else if (num.equals("two")) {
			return 2;
		} else if (num.equals("three")) {
			return 3;
		} else if (num.equals("four")) {
			return 4;
		} else if (num.equals("five")) {
			return 5;
		} else if (num.equals("six")) {
			return 6;
		} else if (num.equals("seven")) {
			return 7;
		} else if (num.equals("eight")) {
			return 8;
		} else if (num.equals("nine")) {
			return 9;
		} else if (num.equals("zero")) {
			return 0;
		} else {
			return -1;
		}
	}
}