//import java.util.Scanner;
public class H028 {
	public static void main(String[] args) {
		int k = 3, m = 100, i;
		//Scanner in = new Scanner(System.in);
		for (i = k + 1; i <= m - 1; i++) {
			if (i % 3 == 0) {
				System.out.print(i);
				System.out.print(", ");
			}
		}
	}
}