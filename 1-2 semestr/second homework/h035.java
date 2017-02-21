import java.util.Scanner; 
public class h035 {
	public static void main(String[] args) {
		int z;
		Scanner in = new Scanner(System.in);
		System.out.print("Import n: ");
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i=0; i<n; i++) {
			System.out.print("Import a["+i+"]: ");
			a[i] = in.nextInt();
		}
		for (int j=0; j<n; j++){
			for (int i=0; i<n-1; i++) {
				if (a[i]>a[i+1]) {
					z = a[i];
					a[i] = a[i+1];
					a[i+1] = z; 
				}
			}
			for (int i=n-1; i>1; i--) {
				if (a[i]<a[i-1]) {
					z = a[i];
					a[i] = a[i-1];
					a[i-1] = z; }
		} 
		
	}
	for (int i=0; i<n; i++) {
			System.out.print(a[i]+" ");
		}


}
}
