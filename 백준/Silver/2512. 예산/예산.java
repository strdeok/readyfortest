import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] budgets = new int[n];
        int max_sum = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            max_sum += num;
            max = Math.max(max, num);
            min = Math.min(min, num);
            budgets[i] = num;
        }
        int tmp_max_sum = sc.nextInt();

        if (tmp_max_sum >= max_sum) {
            System.out.println(max);
            return;
        } else {
            max_sum = tmp_max_sum;
        }


        int left = 0;
        int right = max;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;
            for (int b : budgets) {
                if (b > mid) sum += mid;
                else sum += b;
            }

            if (sum <= max_sum) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}