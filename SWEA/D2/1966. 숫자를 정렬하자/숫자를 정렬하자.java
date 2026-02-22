    import java.util.*;

    class Solution {
        public static void main(String args[]) throws Exception {
            Scanner sc = new Scanner(System.in);
            int T;
            T = sc.nextInt();
            for (int test_case = 1; test_case <= T; test_case++) {
                int n = sc.nextInt();
                PriorityQueue<Integer> arr = new PriorityQueue<>();
                for (int i = 0; i < n; i++){
                    arr.offer(sc.nextInt());
                }

                System.out.print("#" + test_case + " ");
                while (!arr.isEmpty()){
                    System.out.print(arr.poll() + " ");
                }
                System.out.println();
            }
        }
    }