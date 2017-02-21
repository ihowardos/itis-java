package Complex;

/**
 * Created by ihowardos on 11.12.2015.
 */
public class ComplexNumberTest {
    public static void main(String[] args) {
        ComplexNumber a1 = new ComplexNumber(1, 1);
        ComplexNumber a2 = new ComplexNumber(2, -6);
        System.out.println("add: " + a1.add(a2));
        System.out.print("add2: "); a1.add2(a2);
        System.out.println("sub: " + a1.sub(a2));
        System.out.print("sub2: "); a1.sub2(a2);
        System.out.println("multNumber: " + a1.multNumber(5));
        System.out.print("multNumber2: "); a1.multNumber2(5);
        System.out.println("mult: " + a1.mult(a2));
        System.out.print("mult2: "); a1.mult2(a2);
        System.out.println("div: " + a1.div(a2));
        System.out.print("div2: "); a1.div2(a2);
        System.out.println("length: " + a2.length());
        System.out.println("arg: " + a1.arg());
        System.out.println("pow: " + a1.pow(3));
        System.out.println("equals: " + a1.equals(a2));


        /*System.out.println("add: " + a1.add(a2));
        System.out.print("add2: ");
        a1.add2(a2);
        System.out.println("sub: " + a1.sub(a2));
        System.out.print("sub2: ");
        a1.sub2(a2);
        System.out.println("multNumber: " + a1.multNumber(3));
        System.out.print("multNumber2: ");
        a1.multNumber2(3);*/
    }
}
