public class H020 {
	public static void main(String[] args) {
		int i, n, z;
        n = 5;
		for (i = 0; i <= n; i++){
			z = 2*i + 1; 
		for (int j = 1; j <= n-i; j++)
			System.out.print("*");
		for (int k = 1; k <= 2*i + 1; k++)
			System.out.print("0");
		for(int j = 1; j <= n-i; j++)
			System.out.print("*");
System.out.println();
}
	for (i = n; i >= 0; i--) {
		z = 2*i + 1;
		for (int j = 1; j <= n-i; j++)
			System.out.print("*");
		for (int k = 1; k <= 2*i + 1; k++)
			System.out.print("0");
		for(int j = 1; j <= n-i; j++)
			System.out.print("*");
		System.out.println();
	}
	}
}