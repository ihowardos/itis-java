//import java.util.Scaner;
public class H019 {
	public static void main(String[] args) {
		//Scanner in = new Scanner(System.in);
		int n = 1000000, i, s = 0;
		for (i = 1; i <= n; i++) {
			if (n % i == 0) {
				System.out.println(i);
			}
		}
	}
}