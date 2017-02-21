public class H012 {
	
	public static void main(String[] args) {
	int n, i;
	double s, u;
	n = 5;
	s = 0;
	// Sn = 1/1*1 - 1/3*3 + 1/5*5 - ... + 1/(2*n+1)*(2*n + 1)

	for (i = 1; i<=n; i++) {
		u = (1.0/((2*i - 1)*(2*i - 1)));
	if (i % 2 == 0) {
		u = -u; 
	}
	s = s + u;
}
	System.out.println(s);

}
}