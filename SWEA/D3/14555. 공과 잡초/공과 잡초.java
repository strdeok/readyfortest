import java.util.Scanner;
import java.util.Stack;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            char[] ground = sc.next().toCharArray();
            Stack<Character> stack = new Stack<>();

            for (char g:ground){
                stack.push(g);
            }
            int cnt = 0;
            while (!stack.isEmpty()){
                char p = stack.pop();

                if (stack.isEmpty()) break;

                if (p == ')' && stack.peek() == '(' || p == ')' && stack.peek() == '|'){
                    stack.pop();
                    cnt++;
                }
                if (p == '|' && stack.peek() == '('){
                    stack.pop();
                    cnt++;
                }
            }

            System.out.println("#" + test_case + " " + cnt);
        }
    }
}