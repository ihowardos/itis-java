public class H010 {

public static void main(String[] args) {
	int x, y;
	x=2;
	y = (x>2) ? (x*x - 1)/(x +2) : (x>0) ? (x*x - 1)*(x + 2) : x*x*(1 + 2*x); 
System.out.println(y);
}
}