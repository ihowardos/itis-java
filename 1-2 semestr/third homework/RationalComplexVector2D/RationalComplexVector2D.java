package RationalComplexVector2D;

/**
 * Created by ihowardos on 21.12.2015.
 */
public class RationalComplexVector2D {
    public RationalComplexNumber x, y;

    public RationalComplexVector2D() {
        this(new RationalComplexNumber(), new RationalComplexNumber());
    }

    public RationalComplexVector2D(RationalComplexNumber c1, RationalComplexNumber c2) {
        this.x = c1;
        this.y = c2;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";

    }

    public RationalComplexVector2D add(RationalComplexVector2D rcv) {
        return new RationalComplexVector2D(this.x.add(rcv.x), this.y.add(rcv.y));
    }

    public RationalComplexNumber scalarProduct(RationalComplexVector2D rcv) {
        RationalComplexNumber c = this.x.add(rcv.x).add(this.y.add(rcv.y));
        return c;
    }
}
