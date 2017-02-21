public class H015 {
	public static void main(String[] args) {
		int n, x, i;
		double s;
		n = 3;
		x = 2;
		s = n + x;

		for (i = n - 1; i >= 1; i--) {
			s = i + x/s;
		
		}
	System.out.println(s);
	}
}