package RationalComplexVector2D;

/**
 * Created by ihowardos on 21.12.2015.
 */
public class RationalComplexVector2DTest {
    public static void main(String[] args) {
        RationalComplexVector2D c1 = new RationalComplexVector2D(new RationalComplexNumber(new RationalFraction(4, 5), new RationalFraction(3, 4)), new RationalComplexNumber(new RationalFraction(1, 5), new RationalFraction(2, 3)));
        RationalComplexVector2D c2 = new RationalComplexVector2D(new RationalComplexNumber(new RationalFraction(2, 4), new RationalFraction(7, 4)), new RationalComplexNumber(new RationalFraction(4, 6), new RationalFraction(3, 10)));

        System.out.println("add: " + c1.add(c2));
        System.out.println("scalarProduct: " + c1.scalarProduct(c2));
    }
}
