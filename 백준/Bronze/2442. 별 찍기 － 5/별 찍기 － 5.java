import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i ++){
            for (int k = 0; k < n - i; k ++){
                System.out.print(" ");
            }
            for (int k = 0; k < i*2-1; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
