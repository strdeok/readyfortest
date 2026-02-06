import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[26];
		char[] str = sc.next().toCharArray();
				
		for (char c : str) {
			arr[c-'a']++;
		}
		
		for (int n : arr) {
			System.out.print(n + " ");
		}
	}
}