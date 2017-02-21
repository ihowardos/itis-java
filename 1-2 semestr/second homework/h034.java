import java.util.Scanner;
public class h034{
	public static void main(String[] args){
		int s=0;
		int smax=0;
		Scanner in = new Scanner(System.in);
		System.out.print("Import N = "); int n = in.nextInt();
		int[] a = new int[n];

		for (int i=0; i<n; i++){
			System.out.print("Input a["+(i+1)+"] = ");
			a[i]=in.nextInt();
		}

		for (int i=1; i<n-1; i++){
			s=a[i-1]+a[i]+a[i+1];
			if (s>smax){
				smax=s;
			}
		}
		System.out.println("smax = "+smax);
	}
}