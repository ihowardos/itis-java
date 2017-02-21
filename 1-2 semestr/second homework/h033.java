import java.util.Scanner; 
public class h033 {
	public static void main(String[] args){
		int op=0;
		int op1=0;
		int op2=0;
		double cos=0;
		Scanner in=new Scanner(System.in);
		System.out.print("Input N = "); int n = in.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];

		for (int i=0; i<n; i++){
				System.out.print("Input a["+(i+1)+"] = ");
				a[i]=in.nextInt();
		}
		for (int i=0; i<n; i++){
				System.out.print("Input b["+(i+1)+"] = ");
				b[i]=in.nextInt();
			}
			for (int i=0; i<n; i++){
				op1=op1+a[i]*a[i];
				op2=op2+b[i]*b[i];				
			}

			for (int i=0; i<n; i++){
				op=op+a[i]*b[i];				
			}
			System.out.println("op = "+op);
				cos=op/(Math.sqrt(op1))*(Math.sqrt(op2));
				System.out.print("cos(ab) = "+cos);
			


			}
		}