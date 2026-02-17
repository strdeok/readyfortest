import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int lo = sc.nextInt();
            int hi = sc.nextInt();
            int[] fruits = new int[n];

            for (int i = 0; i < n; i++){
                fruits[i] = sc.nextInt();
            }

            Arrays.sort(fruits);
            Set<Integer> f = new HashSet<>();
            for (int fruit:fruits) {
                f.add(fruit);
            }
            int cnt = f.size();
            if (cnt < 3){ // 세 등급 분류 안되면 실패
                System.out.println("#" + test_case + " " + -1);
                continue;
            }
            int[] counts = new int[cnt];

            int current = -1;
            int idx = -1;
            for (int i = 0; i < n; i++) {
                if (current != fruits[i]){
                    idx++;
                    current = fruits[i];
                }
                counts[idx]++;
            }
            int min = 100001;
            for (int i = 0; i < cnt - 2; i++){ // low
                for (int j = i + 1; j < cnt - 1; j++){ // middle
                    int low = 0;
                    int middle = 0;
                    int high = 0;


                    for (int k = 0; k <= i; k++) low+=counts[k];
                    for (int k = i + 1; k <= j; k++) middle+=counts[k];
                    for (int k = j+1; k < cnt; k++) high+=counts[k];

                    if (low >= lo && low <= hi && middle >= lo && middle <= hi && high >= lo && high <= hi){
                        min = Math.min(min, Math.abs(Math.max(low, Math.max(middle, high)) - Math.min(low, Math.min(middle, high))));
                    }
                }
            }




            System.out.println("#" + test_case + " " + min);

        }
    }
}