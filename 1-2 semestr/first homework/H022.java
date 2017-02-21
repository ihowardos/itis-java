public class H022 {
	public static void main(String[] args){
		int n = 6, x1, x2, y, x;

		
			for (y = n; y >= -n; y--) {
				x1 = -(int)(Math.sqrt((n - y)*(n + y)));
				x2 = (int)Math.sqrt((n - y)*(n + y));
for (x = -n; x <= x1 - 1; x++)
	System.out.print("*");
for (x = x1; x <= x2; x++)
	System.out.print("0");
for (x = x2; x <= n - 1; x++)
	System.out.print("*");
			System.out.println();
		}



	}
}