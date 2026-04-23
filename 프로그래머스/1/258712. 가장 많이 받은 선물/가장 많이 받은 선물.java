    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.HashMap;
    import java.util.Map;

    class Solution {
        public int solution(String[] friends, String[] gifts) {
            int answer = 0;
            int n = friends.length;
            Map<String, Integer> nameMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                nameMap.put(friends[i], i);
            }

            int[][] linked = new int[n][n];

            for (String g : gifts) {
                String[] s = g.split(" ");
                String from = s[0];
                String to = s[1];

                linked[nameMap.get(from)][nameMap.get(to)]++;
            }

            int[] giftScore = new int[n];
            int idx = 0;
            while (idx < n) {
                int giveScore = 0;
                int getScore = 0;

                for (int y = 0; y < n; y++) {
                    getScore += linked[idx][y];
                }


                for (int x = 0; x < n; x++) {
                    giveScore += linked[x][idx];
                }

                giftScore[idx] = getScore - giveScore;
                idx++;
            }

            int[] nextMonth = new int[n];
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (x == y) continue;
                    int giveCnt = linked[x][y];
                    int getCnt = linked[y][x];

                    if (giveCnt > getCnt) {
                        nextMonth[x]++;
                    }

                    if (giveCnt == getCnt) {
                        int xScore = giftScore[x];
                        int yScore = giftScore[y];
                        if (xScore > yScore) {
                            nextMonth[x]++;
                        }

                    }
                }
            }

            for (int score : nextMonth) {
                answer = Math.max(answer, score);
            }


            return answer;
        }
    }