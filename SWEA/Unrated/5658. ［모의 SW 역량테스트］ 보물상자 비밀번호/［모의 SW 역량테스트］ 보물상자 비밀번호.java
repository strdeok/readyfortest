import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int cycle = n / 4;
            Queue<Character> lines = new LinkedList<>();
            char[] nums = sc.next().toCharArray();

            for (char num : nums) {
                lines.add(num);
            }

            Set<Integer> possibles = new HashSet<>();

            for (int rotate = 0; rotate < cycle; rotate++) {
                // 큐에 있는거 cycle 개씩 뽑아서 possibles에 넣어야함.

                for (int side = 0; side < 4; side++) {
                    StringBuilder sb = new StringBuilder();

                    for (int i = 0; i < cycle; i++) {
                        char c = lines.poll();
                        sb.append(c);
                        lines.add(c);
                    }
                    int v = Integer.parseInt(sb.toString(), 16);
                    possibles.add(v);
                }
                lines.add(lines.poll());
            }
            List<Integer> list = new ArrayList<>(possibles);
            list.sort(Collections.reverseOrder());

            System.out.println("#" + test_case + " " + list.get(k - 1));
        }
    }
}