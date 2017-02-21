import java.util.Scanner; 
public class h031 {
	public static void main(String[] args) {
		int p1=1;
		int p2=1;
		int s=0;
		Scanner in = new Scanner(System.in);
		System.out.print("Input n = "); int n = in.nextInt();
		int[] a = new int[n];

		for (int i=0; i<n; i++) {
			System.out.print("Input "+(i+1)+" number = ");
			a[i] = in.nextInt();
		}

		for (int i=2; i<n-2; i=i+2) {
		if (a[i]%3==0){
			p1=p1*1;
		}
		else {
			p1=p1*0;
		}
		}
		if (p1==1) {
			for (int i=0; i<n; i++){
				if (a[i]>0){
					s=s+a[i];
				}
			}
		}
		else {
			for (int i=0; i<n; i++){
				if (a[i]>0){
					p2=p2*a[i];
				}
			}
		}
		if (s>0) {
			System.out.println(s);
		}
		else {
			System.out.println(p2);
		}
	}
}