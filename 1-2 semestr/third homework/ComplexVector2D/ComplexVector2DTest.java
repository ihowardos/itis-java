package ComplexVector2D;

/**
 * Created by howardos on 20.12.2015.
 */
public class ComplexVector2DTest {
    public static void main(String[] args) {
        ComplexVector2D a1 = new ComplexVector2D(new ComplexNumber(3, -1), new ComplexNumber(4, 5));
        ComplexVector2D a2 = new ComplexVector2D(new ComplexNumber(2, 3), new ComplexNumber(-4, 7));

        System.out.println("add: " + a1.add(a2));
        System.out.println("scalarProduct: " + a1.scalarProduct(a2));
        System.out.println("equals: " + a1.equals(a2));
    }
}
