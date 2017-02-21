package RationalVector2D;

/**
 * Created by howardos on 19.12.2015.
 */
public class RationalVector2DTest {
    public static void main(String[] args) {
        RationalVector2D a1 = new RationalVector2D(new RationalFraction(3, 2), new RationalFraction(4, 5));
        RationalVector2D a2 = new RationalVector2D(new RationalFraction(4, 2), new RationalFraction(4, 5));

        System.out.println("add: " + a1.add(a2));
        System.out.println("length: " + a2.length());
        System.out.println("scalarProduct: " + a1.scalarProduct(a2));
        System.out.println("equals: " + a1.equals(a2));

    }

}

