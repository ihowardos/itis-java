public class H017 {
	public static void main(String[] args) {
		int i, n;
		n = 3;
		double s = 0, a;
		a = 0.5;

		for(int m = 2; m <= n; m++) {
			//fact1 *= (i-1);
			//fact2 *= 2*m*(2*m - 1);

			a *= (m - 1)*(m - 1) / ((2*m - 1.0)*2*m);
			s += a;
		}
	System.out.println(s);}
}