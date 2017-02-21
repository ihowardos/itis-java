package RationalMatrix2x2;

/**
 * Created by ihowardos on 20.12.2015.
 */
public class RationalMatrix2x2Test {
    public static void main(String[] args) {
        RationalMatrix2x2 a = new RationalMatrix2x2(new RationalFraction(3, 5));
        RationalMatrix2x2 b = new RationalMatrix2x2(new RationalFraction(5, 3), new RationalFraction(3, 4), new RationalFraction(6, 3), new RationalFraction(2, 4));
        RationalVector2D v = new RationalVector2D(new RationalFraction(4,4), new RationalFraction(7, 4));

        System.out.println("add: " + a.add(b).toString());
        System.out.println("mult: " + a.mult(b).toString());
        System.out.println("det: " + b.det());
        System.out.println("multVector: " + b.multVector2D(v));
    }
}

