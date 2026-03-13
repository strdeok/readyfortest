import java.io.IOException;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		System.out.println(pow(a, b, c));
	}

	static long pow(long a, long b, long c) {
		if (b == 1) {
			return a % c;
		}

		long temp = pow(a, b / 2, c);
		long result = (temp * temp) % c;
		if (b % 2 == 1) {
			return (result * (a % c)) % c;
		}
		return result;

	}
}