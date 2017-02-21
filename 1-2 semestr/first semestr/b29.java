import java.util.Scanner; 
public class b29 {
	public static void main(String[] args) {

		int k = 0;
		int s = 0;
		Scanner in = new Scanner(System.in);
		System.out.print("Vvedite 4islo: ");
		int n = in.nextInt();
		int m=n;

		while (m > 0) {
			m = m / 10;
			k++; 
		}
		int a [] = new int[k];

		for (int i=0; i<k; i++) {
			m=n%10;
			n/=10;
			a[i]=m;
			
		}
		for (int i=0; i<k; i=i+2) {
			s = s + a[i];
			s = s - a[i + 1];
			 } 
			 System.out.println(s);

	}
}
