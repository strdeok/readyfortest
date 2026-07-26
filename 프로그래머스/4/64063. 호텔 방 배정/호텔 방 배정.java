import java.util.*;


class Solution {
    Map<Long, Long> parent = new HashMap<>();
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        
        for (int i = 0; i < room_number.length; i++) {
            long room = room_number[i];
            long found = find(room);
            
            answer[i] = found;
            parent.put(found, found+ 1);
            
        }
        
        return answer;
    }
    
    long find(long n) {
        if (!parent.containsKey(n)) {
            return n;
        }
        
        long next = find(parent.get(n));
        parent.put(n, next);
        return next;
    }
}