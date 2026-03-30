class Solution {
	public int[] solution(String[] keyinput, int[] board) {
		int[] answer = {};
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		int x = 0;
		int y = 0;

		int xLength = board[0] - 1;
		int yLength = board[1] - 1;

		for (int i = 0; i < keyinput.length; i++) {
			int nx = x;
			int ny = y;

			int dir = 0;

			if (keyinput[i].equals("left")) {
				dir = 0;
			}
			if (keyinput[i].equals("right")) {
				dir = 1;
			}
			if (keyinput[i].equals("up")) {
				dir = 2;
			}
			if (keyinput[i].equals("down")) {
				dir = 3;
			}

			nx += dx[dir];
			ny += dy[dir];

			if (nx >= 0 - xLength / 2 && ny >= 0 - yLength / 2 && nx <= xLength / 2 && ny <= yLength / 2) {
				x = nx;
				y = ny;
			}

		}
		return new int[] { x, y };
	}
}