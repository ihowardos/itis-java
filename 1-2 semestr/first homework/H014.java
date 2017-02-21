public class H014 {
	public static void main(String[] args) {
		int i,n;
		double x = 1;
		double q = x;
		n = 3;

		for (i = 1; i <= n; i++) {
			q = x + Math.cos(q);
		}
	System.out.println(q);
}
}