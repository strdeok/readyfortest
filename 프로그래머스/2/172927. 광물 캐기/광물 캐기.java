class Solution {
    int minEx = Integer.MAX_VALUE;
    int[] Picks;
    String[] Minerals;


    public int solution(int[] picks, String[] minerals) {
        Picks = picks;
        Minerals = minerals;

          dfs(0, 0);

        return minEx;
    }

    // 완탐
    void dfs(int mineralIdx, int ex) {
        // 내구도 오링
        if (Picks[0] == 0 && Picks[1] == 0 && Picks[2] == 0) {
            minEx = Math.min(minEx, ex);
            return;
        }

        if (mineralIdx >= Minerals.length) {
            minEx = Math.min(minEx, ex);
            return;
        }

        for (int axeIdx = 0; axeIdx < 3; axeIdx++){
            if (Picks[axeIdx] == 0) continue;
            int tmpEx = 0;
            for (int i = mineralIdx; i < mineralIdx + 5; i++) {
                if (i == Minerals.length) {
                    break;
                }
                tmpEx += cal(axeIdx, Minerals[i]);
            }

            Picks[axeIdx]--;
            dfs(mineralIdx + 5, ex + tmpEx);
            Picks[axeIdx]++;
        }


    }

    // 피로도 계산
    int cal(int axe, String mineral) {
        if (axe == 0) {
            return 1;
        } else if (axe == 1) {
            if (mineral.equals("diamond")) return 5;
            else return 1;
        } else {
            if (mineral.equals("diamond")) return 25;
            else if (mineral.equals("iron")) return 5;
            else return 1;
        }
    }
}