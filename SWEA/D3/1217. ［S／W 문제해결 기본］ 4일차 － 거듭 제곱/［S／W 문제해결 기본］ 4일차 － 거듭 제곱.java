import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int test_case = 1; test_case <= 10; test_case++) {
        	int T = sc.nextInt();
        	int n = sc.nextInt();
        	int m = sc.nextInt();
        	int[] arr = new int[m];
        	
        	for (int i = 0; i < m; i++) {
        		arr[i] = n;
        	}
        	
        	int result = 1;
        	for (int i = m - 1; i >= 0; i--) {
        		result *= arr[i];
        	}
        	
            

            System.out.println("#" + T + " " + result);
        }
    }
}