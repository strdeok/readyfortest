import java.util.*;

class Solution {
    static int n, l;
    static int[][] ingredients;
    static int MAX_SCORE;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            l = sc.nextInt();
            ingredients = new int[n][2];
            MAX_SCORE = 0;

            for (int i = 0; i < n; i++) {
                ingredients[i][0] = sc.nextInt();
                ingredients[i][1] = sc.nextInt();
            }

            combination(0, 0, 0);

            System.out.println("#" + test_case + " " + MAX_SCORE);
        }
    }

    static void combination(int index, int totalScore, int totalCalories) {
        if (totalCalories > l) {
            return;
        }
        if (index == n) {
            MAX_SCORE = Math.max(MAX_SCORE, totalScore);
            return;
        }

        int nowScore = ingredients[index][0];
        int nowCalorie = ingredients[index][1];
        
        combination(index + 1, totalScore + nowScore, totalCalories + nowCalorie);
        combination(index + 1, totalScore, totalCalories);
    }
}