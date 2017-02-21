import java.util.Scanner; 
public class h024{
	public static void main(String[] args){
		double EPS=0.000000001;
		double s=0;
		int n=0;
		double a=1;
		Scanner in = new Scanner(System.in);
		System.out.print("Input x = ");
		int x = in.nextInt();

	while (Math.abs(a)>=EPS){ 
		n=n+1;
		a = 1/n*Math.pow(9,n)*Math.pow(x-1,2*n);
			s=s+a;
	}
	System.out.println(s);
	}
}