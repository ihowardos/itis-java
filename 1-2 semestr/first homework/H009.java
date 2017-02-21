public class H009 {

public static void main(String[] args) {
	int x, y;
	x=2;
	if (x>2) {
y=(x*x - 1)/(x + 2); 
	}
	else if (x>0) {
y=(x*x - 1)*(x + 2);
}
else {
	y=x*x*(1 + 2*x);
}
System.out.println(y);
}
}