import java.util.Scanner;
public class H027 {
    public static void main(String[] args) {
    	int n, i;
    	n = 6;
     Scanner in = new Scanner(System.in);
        for (i = 1; i <= n; i++) {
        	int a = in.nextInt();
        	if (((a % 2 == 0) && (a % 3 == 0)) || ((a % 5 == 0) && (a % 6 == 0)))
        	System.out.println("true");
        	else 
        	System.out.println("false"); }


}
 }       //считываем целое число