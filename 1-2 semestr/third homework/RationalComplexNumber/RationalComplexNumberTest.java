package RationalComplexNumber;

/**
 * Created by ihowardos on 21.12.2015.
 */
public class RationalComplexNumberTest {
    public static void main(String[] args) {
        RationalComplexNumber c1 = new RationalComplexNumber(new RationalFraction(3,5), new RationalFraction(7, 2));
        RationalComplexNumber c2 = new RationalComplexNumber(new RationalFraction(3,3), new RationalFraction(2, 4));

        System.out.println("add: " + c1.add(c2));
        System.out.println("sub: " + c1.sub(c2));
        System.out.println("mult: " + c1.mult(c2));
    }
}
