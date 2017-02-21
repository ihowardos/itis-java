package Matrix;

/**
 * Created by ihowardos on 12.12.2015.
 */
public class Matrix2x2Test {
    public static void main(String[] args) {
        Matrix2x2 a1 = new Matrix2x2();
        Matrix2x2 a2 = new Matrix2x2(7);
        Matrix2x2 a3 = new Matrix2x2(new double[][] {{3, 2}, {4, 5}});
        Matrix2x2 a4 = new Matrix2x2(4, 6, 7, 3);
        Vector2D v = new Vector2D(2, 5);

        System.out.println("add: ");
        System.out.println(a3.add(a4));
        System.out.println("add2: "); a2.add2(a4);
        System.out.println();
        System.out.println("sub: ");
        System.out.println(a2.sub(a3));
        System.out.println("sub2: "); a1.sub2(a4);
        System.out.println();
        System.out.println("multNumber: ");
        System.out.println(a1.multNumber(-2));
        System.out.println("multNumber2: "); a1.multNumber2(-3);
        System.out.println();
        System.out.println("mult: ");
        System.out.println(a1.mult(a4));
        System.out.println("multNumber2: "); a2.mult2(a3);
        System.out.println();
        System.out.println("det: " + a1.det());
        System.out.println();
        System.out.println("transpon: "); a3.transpon();
        System.out.println();
        System.out.println("inverseMatrix: "); a3.inverseMatrix();
        System.out.println();
        System.out.println("equivalentDiagonal: " + a4.equivalentDiagonal());
        System.out.println();
        System.out.println("multVector: " + a3.multVector(v));
    }
}
