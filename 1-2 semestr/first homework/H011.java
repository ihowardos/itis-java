public class H011 {
	public static void main(String[] args) {
		int n, i, p;
		p = 1;
		n = 4;
		if (n % 2 == 0) {
			for (i = 2; i<=n; i = i + 2) {
				p = p*i;

			}
		}
		else
			for (i = 1; i <= n; i = i + 2) {
				p = p*i;
			}
			System.out.println(p);
	}
}