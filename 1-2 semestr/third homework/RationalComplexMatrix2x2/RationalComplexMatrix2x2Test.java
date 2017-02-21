package RationalComplexMatrix2x2;

/**
 * Created by ihowardos on 21.12.2015.
 */
public class RationalComplexMatrix2x2Test {
    public static void main(String[] args) {


        //RationalComplexMatrix2x2 m3 = new RationalComplexMatrix2x2(new RationalComplexNumber[2][2]{
            //{new RationalComplexNumber(new RationalFraction(4, 2), new RationalFraction(2,5)), new RationalComplexNumber(new RationalFraction(4, 2), new RationalFraction(2,5))},
            //{new RationalComplexNumber(new RationalFraction(4, 2), new RationalFraction(2,5)), new RationalComplexNumber(new RationalFraction(4, 2), new RationalFraction(2,5))}};
        RationalComplexMatrix2x2 m = new RationalComplexMatrix2x2
                ((new RationalComplexNumber(new RationalFraction(4, 5), new RationalFraction(3, 4))),(new RationalComplexNumber(new RationalFraction(4, 5), new RationalFraction(3, 4))),(new RationalComplexNumber(new RationalFraction(4, 5), new RationalFraction(3, 4))),(new RationalComplexNumber(new RationalFraction(4, 5), new RationalFraction(3, 4))));
        RationalComplexVector2D ve = new RationalComplexVector2D(new RationalComplexNumber(new RationalFraction(3,4), new RationalFraction(5,2)), new RationalComplexNumber(new RationalFraction(3, 2), new RationalFraction(6, 4)));
        System.out.println("add: " + m.add(m));
        System.out.println("mult: " + m.mult(m));
        System.out.println("det: " + m.det());
        System.out.println("multVector: " + m.multVector(ve));

    }
}
