import java.util.*;

class Solution {
    static int[] answer;
    static HashMap<String, Integer> nameMap = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        answer = new int[enroll.length];

        for (int i = 0; i < enroll.length; i++) {
            nameMap.put(enroll[i], i);
        }

        for (int i = 0; i < seller.length; i++) {
            String nowSeller = seller[i];
            int price = amount[i] * 100;
            goUp(nowSeller, enroll, referral, price);
        }

        return answer;
    }

    static void goUp(String name, String[] enroll, String[] referral, int price) {
        if (name.equals("-") || price == 0) {
            return;
        }

        int idx = nameMap.get(name);
        
        int toParent = price / 10;    
        int mine = price - toParent; 
        
        answer[idx] += mine;
        String parentName = referral[idx];
        goUp(parentName, enroll, referral, toParent);
    }
}