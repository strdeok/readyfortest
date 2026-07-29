import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        int n = files.length;
        String[] answer = new String[n];
        // head -> number -> tail
        // head 대소문자 구분 X
        // number 0 무시
        // 둘 다 같으면 기존 정렬 유지
        Arrays.sort(files, (a, b) -> {
            String headA;
            String headB;
            int numberA;
            int numberB;
            
            int idx = 0;
            int start = 0;
            int end = 0;
            for (char c:a.toCharArray()) {
                // .이라면
                if (start > 0 && !Character.isDigit(c)) {
                    end = idx;
                    break;  
                } 
                
                // 숫자라면
                if (Character.isDigit(c) && start == 0) {
                    start = idx;
                }
                idx++;
            }
            end = end == 0 ? a.length() : end;
            headA = a.substring(0, start);
            numberA = Integer.parseInt(a.substring(start, end));
            
            idx = 0;
            start = 0;
            end = 0;
            for (char c:b.toCharArray()) {
                // .이라면
                if (start > 0 && !Character.isDigit(c)) {
                    end = idx;
                    break;  
                } 
                
                // 숫자라면
                if (Character.isDigit(c) && start == 0) {
                    start = idx;
                }
                idx++;
            }
            end = end == 0 ? b.length() : end;
            headB = b.substring(0, start);
            numberB = Integer.parseInt(b.substring(start, end));

            int headCompare = headA.compareToIgnoreCase(headB);
            if (headCompare != 0) {
                return headCompare;
            }

            return numberA - numberB;
        });
        
        return files;
    }
}