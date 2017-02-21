public class math{
	public static void main(String[] args){
		int n = 500;
		double s=0;
		

		double a=1;
		for (int i=0; i<=n; i++){
		a*=-1*Math.pow(Math.PI, 2)/(4*(2*n+3)*(2*n+2));
		s+=a;
		}

		System.out.println(s);
	}
}