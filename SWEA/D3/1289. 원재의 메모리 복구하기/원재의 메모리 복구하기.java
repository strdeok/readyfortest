import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            String target = sc.next();
            char currentState = '0';  
            int count = 0;         

            for (int i = 0; i < target.length(); i++) {
                if (target.charAt(i) != currentState) {
                    count++; 
                    currentState = target.charAt(i);
                }
            }

            System.out.println("#" + t + " " + count);
        }
    }
}