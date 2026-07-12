import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int n = elements.length;

        for (int start = 0; start < n; start++) {
            int sum = 0;

            for (int l = 0; l < n; l++) {
                int index = (start + l) % n;
                sum += elements[index];
                set.add(sum);
            }
        }

        return set.size();
    }
}