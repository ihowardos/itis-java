import java.util.Scanner; 
public class task{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Input N = ");
		int n = in.nextInt();
		System.out.print("Input M = ");
		int m = in.nextInt();
		int [][] a = new int[n][m];
		int [][] b = new int[m][n];

		for (int i=0; i<n; i++){
			for (int j=0; j<m; j++){
				System.out.print("Input a["+i+"]["+j+"] =");
				a[i][j] = in.nextInt();
			}
		}
   
		for (int i=0; i<m; i++){
			for (int j=0; j<n; j++){
				System.out.print("Input b["+i+"]["+j+"] =");
				b[i][j] = in.nextInt();
			}
		}

		int [][] c = new int [n][m];
		for (int i=0; i<m; i++){
			int s=0;
			for (int j=n-1; j<=0; j--){
				s = s + a[i][j]*b[j][i];
				c[i][j]=s;
		}
}
		for (int i=0; i<m; i++){
			for (int j=0; j<n; j++){
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	
}
}