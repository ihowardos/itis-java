package O50;

/**
 * Created by ihowardos on 05.12.2015.
 */
public class RationalFractionTest {
    public static void main(String[] args) {
        RationalFraction a1 = new RationalFraction();
        RationalFraction a2 = new RationalFraction(-3, 2);
        RationalFraction a3 = new RationalFraction(-5, 4);
        a2.reduce();
        System.out.println("add: " + a2.add(a3).toString());
        System.out.print("add2: "); a2.add2(a3);
        System.out.println("sub: " + a2.sub(a3).toString());
        System.out.print("sub2: "); a2.sub2(a3);
        System.out.println("mult: " + a2.mult(a3).toString());
        System.out.print("mult2: "); a2.mult2(a3);
        System.out.println("div: " + a2.div(a3).toString());
        System.out.print("div2: "); a2.div2(a3);
        System.out.println("value: " + a2.value());
        System.out.println("equals: " + a2.equals(a3));
        System.out.println("numberPart: " + a2.numberPart());
    }
}
