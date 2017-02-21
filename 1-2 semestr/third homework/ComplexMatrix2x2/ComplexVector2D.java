package ComplexMatrix2x2;

/**
 * Created by howardos on 20.12.2015.
 */
public class ComplexVector2D {
    public ComplexNumber x, y;

    public ComplexVector2D() {
        x = new ComplexNumber();
        y = new ComplexNumber();
    }

    public ComplexVector2D(ComplexNumber a, ComplexNumber b) {
        this.x = a;
        this.y = b;
    }

    public ComplexVector2D add(ComplexVector2D v) {
        return new ComplexVector2D(this.x.add(v.x), this.y.add(v.x));
    }

    public String toString() {
        return "(" + this.x + "), (" + this.y + ")";
    }

    public ComplexNumber scalarProduct(ComplexVector2D v) {
        ComplexNumber c = this.x.add(v.x).add(this.y.add(y));
        return c;
    }

    public boolean equals(ComplexVector2D v) {
        return this.x.equals(v.x) && this.y.equals(v.y);
    }
}

