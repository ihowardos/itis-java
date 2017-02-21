import java.util.Scanner;
public class H018 {
	public static void main(String[] args) {
 Scanner in = new Scanner(System.in);
 double a;
		int i, n;
		n = 4;
		double x, p, s;
		s = 0;
		x = 3;
		for (i = n + 1; i >= 1; i--) {
			a = in.nextDouble();
			p = Math.pow(x, i - 1)*a;
s = s + p;
		
		}
	System.out.println(s); }
}