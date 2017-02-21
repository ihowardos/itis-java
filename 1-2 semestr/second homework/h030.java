import java.util.Scanner; 
public class h030 {
	public static void main(String[] args) {
		int k;
		int l1=0;
		int l2=0;
		int l3=0;
		int q=0;
		Scanner in = new Scanner(System.in);
		System.out.println("input n: ");
		int n = in.nextInt();
		int[] a = new int[n];

		for (int i=0; i<n; i++) {
			System.out.print((i+1)+" number=");
			a[i] = in.nextInt();
		}
		for (int i=0; i<n; i++) {
				l1=0;
				l2=0;
				l3=0;
				while (a[i]>0) {

				k=a[i]%10;
				a[i]=a[i]/10;
				if (k%2==0) {
					l1++;
				}
					else {
						l2++;
				}
				l3++;
			}
			if ((l3==3 || l3==5) && (l1==l3 || l2==l3)) {
				q++;
			}
		}
		
			if (q==2) {
				System.out.println("TRUE");
			}
			else {
				System.out.println("FALSE");
			}
	}
}