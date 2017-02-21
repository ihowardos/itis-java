import java.util.Scanner;
public class h038{
	public static void main(String[] args){
		int k=0;
		Scanner in = new Scanner(System.in);
		System.out.print("Input N = "); int n = in.nextInt();
		int[][] a = new int [n][n];
		for (int i=0; i<n; i++){
			for (int j=0; j<n; j++){
				System.out.print("a["+i+"]["+j+"] = "); a[i][j]=in.nextInt();
			}
		}
		//k=0;
		for (int j=0; j<n; j++){
			for (int i=n-1; i>k; i--){
				if (a[i][j]>0 && a[i-1][j]>0 || a[i][j]<0 && a[i-1][j]<0){
					a[i][j]=-a[i][j]*a[i-1][j]+a[i][j]*a[i-1][j];
				}
				if (a[i][j]>0 && a[i-1][j]<0 || a[i][j]<0 && a[i-1][j]>0){
					a[i][j]=-a[i][j]*a[i-1][j]+a[i][j]*a[i-1][j];
				}
			}
			k=k+1;
		}
		

		for (int i=0; i<n; i++){
			for (int j=0; j<n; j++){
			System.out.print(a[i][j]);
			System.out.print(" ");
		}
		System.out.println();
		}
	}
}