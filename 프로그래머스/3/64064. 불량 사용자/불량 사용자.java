import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    boolean[] visited;
    int N;

    Set<String> s = new HashSet<>();

    String[] comb;

    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        N = banned_id.length;
        comb = new String[banned_id.length];

        dfs(0, user_id, banned_id);

        return s.size();
    }

    void dfs(int index, String[] user_id, String[] banned_id) {
        if (index == N) {
            String[] cp = comb.clone();
            Arrays.sort(cp);
            s.add(String.join(",", cp));
            return;
        }
        String now = banned_id[index];

        for (int k = 0; k < user_id.length; k++){
            if (visited[k]) continue;
            if (!isMatch(user_id[k], now)) continue;

            visited[k] = true;
            comb[index] = user_id[k];
            
            dfs(index+1, user_id, banned_id);
            
            visited[k] = false;
        }
    }

    boolean isMatch(String user_id, String now) {
        char[] nowChar = now.toCharArray();
        char[] idChar = user_id.toCharArray();
        if (nowChar.length != idChar.length) return false;

        for (int i = 0; i < now.length(); i++) {
            if (nowChar[i] == '*') continue;
            if (nowChar[i] != idChar[i]) return false;
        }
        return true;
    }
}