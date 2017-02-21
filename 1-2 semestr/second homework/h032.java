import java.util.Scanner;
public class h032 {
	public static void main(String[] args){
		int max;
		int c = 0;
		Scanner in = new Scanner(System.in);
		System.out.print("The length of the a array = "); int n = in.nextInt();
		System.out.print("The length of the b array = "); int m = in.nextInt();
		if (n>m){
			max=n;
		}
		else {
			max=m;
		}

		int[] a = new int[max];
		int[] b = new int[max];

		for (int i=0; i<n; i++){
			System.out.print("a["+i+"] = "); a[i]=in.nextInt();
			if (a[i]>9 || a[i]<0){
				System.out.println("error");
				return;
			}
		} 
		for (int i=0; i<m; i++){
			System.out.print("b["+i+"] = "); b[i]=in.nextInt();
			if (b[i]>9 || b[i]<0){
				System.out.println("error");
				return;
			}
		}
			for (int i=0; i<max; i++){
				int s = 0;
				s=a[i]+b[i];
				s=s+c;
				if (s>9){
					c=0;
					c=s/10;
					s=s%10;
					}
				
				
				System.out.println("a["+i+"]+b["+i+"] = "+s);
			}
	}
}