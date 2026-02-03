import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Deque<Character> q = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            q.offer(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            Deque<Character> stack = new ArrayDeque<>();
            boolean isCorrect = true;

            for (char c : q) {
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                }
                else {
                    if (stack.isEmpty()) {
                        isCorrect = false;
                        break;
                    }

                    char top = stack.pop();

                    if (c == ')' && top != '(') { isCorrect = false; break; }
                    if (c == ']' && top != '[') { isCorrect = false; break; }
                    if (c == '}' && top != '{') { isCorrect = false; break; }
                }
            }
            
            if (isCorrect && stack.isEmpty()) {
                answer++;
            }

            q.offerLast(q.pollFirst());
        }

        return answer;
    }
}