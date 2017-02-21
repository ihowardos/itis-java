public class H016 {
	public static void main(String[] args) {
		int i, x, n, p, s;
		p = 1;
		s = 0;
		x = 1;
		n = 3;

		for (i = 1; i <= n; i++) {
			p = p*(x + i);
			s = s + p;
		}
	System.out.println(s); 
}
}