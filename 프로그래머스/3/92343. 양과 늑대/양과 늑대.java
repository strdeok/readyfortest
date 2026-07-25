import java.util.*;

class Solution {
    ArrayList<Integer>[] Tree;
    int[] Info;
    int[][] Edges;
    int answer = 1;
    
    public int solution(int[] info, int[][] edges) {        
        Tree = new ArrayList[info.length];
        
        for (int i = 0; i < info.length; i++) {
            Tree[i] = new ArrayList<Integer>();
        }
        
        for (int[] e:edges) {
            int now = e[0];
            int next = e[1];
            Tree[now].add(next);
        }
        
        Info = info;
        Edges = edges;
        ArrayList<Integer> candidates = new ArrayList<>(Tree[0]);
        search(1, 0, candidates);
        return answer;
    }
    
    void search(int sheep, int wolves, ArrayList<Integer> candidates) {     
        answer = Math.max(answer, sheep);
        
        for (Integer c: candidates) {
            int s = sheep;
            int w = wolves;
            if (Info[c] == 0) {
                s++;
            } else {
                w++;
            }
            
            if (w >= s) continue;
            
            ArrayList<Integer> nextCandidates = new ArrayList<>(candidates);

            nextCandidates.remove(c);
            nextCandidates.addAll(Tree[c]);
            search(s, w, nextCandidates);
        }
        
    }
}