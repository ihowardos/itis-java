import java.util.Scanner; 
public class h026{
	public static void main(String[] args){
		double EPS=0.000000001;
		double s=0;
		int n=0;
		double a=1;
		Scanner in = new Scanner(System.in);
		System.out.print("Input x = ");
		int x = in.nextInt();
		int nfact=1;

	while (Math.abs(a)>=EPS){ 
		n=n+1;
		for (int i=n; i>0; i--){
			nfact=nfact*n;
		}
		a = Math.pow(x-1,n)/Math.pow(3,n)*(n*n+3)*nfact;
			s=s+a;
	}

	
	System.out.println(s);
	}
}