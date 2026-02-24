import java.util.*;

class Solution {
    static String[] tree;
    static int[][] child; 
    static int n;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10; 
        
        for (int test_case = 1; test_case <= T; test_case++) {
            if (!sc.hasNextInt()) break; 
            n = sc.nextInt();
            tree = new String[n + 1];
            child = new int[n + 1][2]; 

            sc.nextLine(); 
            for (int i = 1; i <= n; i++) {
                String[] get = sc.nextLine().split(" ");
                int currentIdx = Integer.parseInt(get[0]);
                
                tree[currentIdx] = get[1];

                if (get.length == 4) {
                    child[currentIdx][0] = Integer.parseInt(get[2]); 
                    child[currentIdx][1] = Integer.parseInt(get[3]); 
                }
            }
            
            System.out.println("#" + test_case + " " + searchTree(1));
        }
    }

    public static int searchTree(int index) {
        String val = tree[index];
        
        if (val.equals("-") || val.equals("+") || val.equals("*") || val.equals("/")) {
            int leftResult = searchTree(child[index][0]);
            int rightResult = searchTree(child[index][1]);
            
            return calculate(leftResult, rightResult, val);
        }
        else {
            return Integer.parseInt(val);
        }
    }

    public static int calculate(int num1, int num2, String cal) {
        if (cal.equals("/")) return num1 / num2;
        else if (cal.equals("*")) return num1 * num2;
        else if (cal.equals("+")) return num1 + num2;
        else return num1 - num2;
    }
}