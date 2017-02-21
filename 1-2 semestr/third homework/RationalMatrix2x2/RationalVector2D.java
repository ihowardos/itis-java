package RationalMatrix2x2;

/**
 * Created by ihowardos on 19.12.2015.
 */
public class RationalVector2D {
    RationalFraction a, b;

    public RationalVector2D() {
        a = new RationalFraction();
        b = new RationalFraction();
    }

    public RationalVector2D(RationalFraction a, RationalFraction b) {
        this.a = a;
        this.b = b;
    }

    public RationalVector2D add(RationalVector2D v) {
        RationalFraction newA = a.add(v.a);
        RationalFraction newB = b.add(v.b);
        return new RationalVector2D(newA, newB);
    }

    public String toString() {
        return a + ", " + b;
    }

    public double length() {
        RationalFraction length = a.mult(a).add(b.mult(b));
        length.reduce();
        return Math.sqrt(length.value());
    }

    public RationalFraction scalarProduct(RationalVector2D v) {
        RationalFraction R = this.a.add(a).add(this.b.add(b));
        R.reduce();
        return R;




    }

    public boolean equals(RationalVector2D v) {
        return a.equals(v.a) && b.equals(v.b);
    }

}
