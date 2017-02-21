import java.util.Scanner;
public class h036{
	public static void main(String[] args){
		int s=0;
		int smax=0;
		Scanner in = new Scanner(System.in);
		System.out.print("Import N = "); int n = in.nextInt();
		int[] a = new int[n];
		boolean flag = true;

		for (int i=0; i<n; i++){
			System.out.print("Input a["+i+"] = ");
			a[i]=in.nextInt();
		}
		for (int i=1; i<n; i++){
			flag = true;
			for (int j=0; j<i && flag; j++){
				if (a[i]<a[j])
					flag = false;
			}
			if (flag)
				System.out.println("a["+i+"] = "+a[i]);
		}
	}
}