import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
    Map<Integer, Integer> pokemons;
    public int solution(int[] nums) {
        int N = nums.length;
        int nn = N / 2;
        pokemons = new HashMap<>(nums.length);

        for (int n:nums) {            
            pokemons.put(n, 1);
        }

        Set<Integer> types = pokemons.keySet();
        if (types.size() >= nn) {
            return nn;
        } else {
            return types.size();
        }
    }
}