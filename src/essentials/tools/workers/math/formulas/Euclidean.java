package essentials.tools.workers.math.formulas;

public class Euclidean {

	// recursive form
	public static int gcd(int a, int b) {
		if (b == 0) return a;
		else return gcd(b, a % b);
	}

	// non-recursive form
	public static int gcd2(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}
