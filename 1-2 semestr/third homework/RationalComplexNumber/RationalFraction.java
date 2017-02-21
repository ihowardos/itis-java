package RationalComplexNumber;

/**
 * Created by ihowardos on 05.12.2015.
 */
public class RationalFraction {
    public int a, b;

    public RationalFraction() {
        this.a = 0;
        this.b = 1;
    }

    public RationalFraction(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void reduce() {
        int b = this.b;
        int a = this.a;
            while (b != 0 && a != 0) {
                int tmp = a % b;
                a = b;
                b = tmp;
            }
            this.a /= Math.abs(a);
            this.b /= Math.abs(a);
    }

    public RationalFraction add(RationalFraction rf) {
        RationalFraction rf1;
        if (this.b == rf.b) {
            rf1 = new RationalFraction(this.a + rf.a, this.b);
            rf1.reduce();
            return rf1;
        } else {
            rf1 = new RationalFraction(this.a * rf.b + rf.a * this.b, this.b * rf.b);
            rf1.reduce();
            return rf1;
        }
    }

    public void add2(RationalFraction rf) {
        if (this.b == rf.b) {
            this.a = this.a + rf.a;
            reduce();
        } else {
            this.a = this.a * rf.b + rf.a * this.b;
            this.b = this.b * rf.b;
           reduce();
        }
        System.out.println(this.a + "/" + this.b);
    }

    public RationalFraction sub(RationalFraction rf) {
        RationalFraction rf1;
        if (this.b == rf.b) {
            rf1 = new RationalFraction(this.a - rf.a, this.b);
            rf1.reduce();
            return rf1;
        } else {
            rf1 = new RationalFraction(this.a * rf.b - rf.a * this.b, this.b * rf.b);
            rf1.reduce();
            return rf1;
        }
    }

    public void sub2(RationalFraction rf) {
        if (this.b == rf.b) {
            this.a = this.a - rf.a;
            reduce();
        } else {
            this.a = this.a * rf.b - rf.a * this.b;
            this.b = this.b * rf.b;
            reduce();
        }
        System.out.println(this.a + "/" + this.b);
    }

    public RationalFraction mult(RationalFraction rf) {
        RationalFraction rf1 = new RationalFraction(this.a * rf.a, this.b * rf.b);
        rf1.reduce();
        return rf1;
    }

    public void mult2(RationalFraction rf) {
        this.a *= rf.a;
        this.b *= rf.b;
        reduce();
        System.out.println(this.a + "/" + this.b);
    }

    public RationalFraction div(RationalFraction rf) {
        RationalFraction rf1 = new RationalFraction(this.a * rf.b, this.b * rf.a);
        rf1.reduce();
        return (rf1);
    }

    public void div2(RationalFraction rf) {
        this.a *= rf.b;
        this.b *= rf.a;
        reduce();
        System.out.println(this.a + "/" + this.b);
    }

    public String toString() {
        return this.a + "/" + this.b;
    }

    public double value() {
        return (double) this.a / this.b;
    }

    public boolean equals(RationalFraction rf) {
        boolean res = false;
        reduce();
        rf.reduce();
        if (a == rf.a && b == rf.b)
            res = true;
        return res;
    }

    public int numberPart() {
        return (int) Math.abs(Math.floor(this.a / this.b));
    }

    public static void main(String[] args) {
        RationalFraction rf1 = new RationalFraction(4, 5);
        RationalFraction rf2 = new RationalFraction(2, 3);
        System.out.println(rf1.add(rf2));
    }
}

