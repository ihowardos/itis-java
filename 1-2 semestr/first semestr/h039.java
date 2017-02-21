import java.util.Scanner;
public class h039{
	public static void main(String[] args){
		int k = 0;
		boolean flag; 
		int c = 0;
		Scanner in = new Scanner(System.in);
		//Вводится массив p с положительными числами, не привыщающие число 999999.
		System.out.print("Input P = "); int p = in.nextInt();
		int[] p1 = new int[p];
		for (int i=0; i<p; i++){
			System.out.print("p["+i+"] = "); p1[i] = in.nextInt();
		}
		//Конец вывода массива р.


		// Вводится прямоугольная матрицаразмером MxN.
		System.out.print("Input M = "); int m = in.nextInt();
		System.out.print("Input N = "); int n = in.nextInt();
		int[][] b = new int[m][n];
		for (int i=0; i<m; i++){
			for (int j=0; j<n; j++){
				System.out.print("b["+i+"]["+j+"] = "); b[i][j] = in.nextInt();
		}
			}
			// Конец вывода прямоугольной матрицы размером MxN.
			c=0;
 			for (int i=0; i<p; i++){
 				k=0;
 				while (p1[i]>0){
 					c=p1[i]%10; 
 					p1[i]=p1[i]/10;
 					k=k+1;
 				}
 				//Количество элементов в числе
 			int[][] p2 = new int[k][p];
 			for (int j=i; j<=i; i++){
 				for (int g=0; g<k; g++){
 					while ()
 				}
 			}

			}
}
}