package RationalComplexVector2D;

/**
 * Created by ihowardos on 21.12.2015.
 */
public class RationalComplexNumber {
public RationalFraction ai, bi;

    public RationalComplexNumber() {
        this(new RationalFraction(), new RationalFraction());
    }

    public RationalComplexNumber(RationalFraction a, RationalFraction b) {
        this.ai = a;
        this.bi = b;
    }

    public String toString() {
        return ai + " + " + bi + "i";
    }

    public RationalComplexNumber add(RationalComplexNumber rcn) {
        return new RationalComplexNumber(this.ai.add(rcn.ai), this.bi.add(rcn.bi));
    }

    public RationalComplexNumber sub(RationalComplexNumber rcn) {
        return new RationalComplexNumber(this.ai.sub(rcn.ai), this.bi.sub(rcn.bi));
    }

    public RationalComplexNumber mult(RationalComplexNumber rcn) {
        return new RationalComplexNumber(this.ai.mult(rcn.ai).sub(this.bi.mult(rcn.bi)), this.ai.mult(rcn.bi).add(this.bi.mult(rcn.ai)));
    }
}
