public class h023{
	public static void main(String[] args){
		double EPS=0.000000001;
		double s=0;
		int n=0;
		double a=1;
	while (Math.abs(a)>=EPS){ 
		n=n+1;
		a = ((2*n+3)/(5*Math.pow(n,4)+1));
			s=s+a;
	}
	System.out.println(s);
	}
}