public class h025{
	public static void main(String[] args){
		double EPS=0.000000001;
		double s=0;
		int n=0;
		double a=1;

	while (Math.abs(a)>=EPS){ 
		n=n+1;
		a = Math.pow(-1,n+1)/(n*n+3*n);
			s=s+a;
	}
	System.out.println(s);
	}
}