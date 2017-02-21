public class H013 {

public static void main(String[] args) {
	int n, i;
	n = 5;
	double p, r;
	p = 1; 

	for (i = 1; i <= n; i++) {
	r = ((2.0*i)/(2*i - 1))*((2.0*i)/(2*i + 1));
	p = p*r;

	}
System.out.println(p);

}
}