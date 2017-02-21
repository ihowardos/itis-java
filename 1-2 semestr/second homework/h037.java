import java.util.Scanner;
public class h037{
	public static void main(String[] args){
		int k=0;
		Scanner in = new Scanner(System.in);
		System.out.print("Input N = "); int n = in.nextInt();
		int[][] a = new int[n][n];
		for (int i=0; i<n; i++){
			for (int j=0; j<n; j++){
				System.out.print("a["+i+"]["+j+"] = "); a[i][j] = in.nextInt();
			}
		}
			for (int j=1; j<n-1; j++){
				a[0][j]=0;
			}
			for (int i=1; i<n/2; i++){
				k++;
				for(int j=1+k; j<n-1-k; j++){
					a[i][j]=0;
				}
			}

			for (int j=1; j<n-1; j++){
				a[n-1][j]=0;
			}
			k=0;
			for (int i=n-1-1; i>n/2; i--){
				k++;
				for(int j=1+k; j<n-1-k; j++){
					a[i][j]=0;
				}
			}
			for (int i=0; i<n; i++){
				for (int j=0; j<n; j++) {
					System.out.print(a[i][j]+" ");
				}
				System.out.println();
			}
}
}