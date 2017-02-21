package O50;

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
        if (a == 0) {
            this.a = 0;
            this.b = 1;
        } else {
            while (b != 0 && a != 0) {
                int tmp = a % b;
                a = b;
                b = tmp;
            }
            this.a /= Math.abs(a);
            this.b /= Math.abs(a);
        }
    }

    public RationalFraction add(RationalFraction a3) {
        if (this.b == a3.b) {
            RationalFraction a4 = new RationalFraction(this.a + a3.a, this.b);
            a4.reduce();
            return a4;
        } else {
            RationalFraction a4 = new RationalFraction(this.a * a3.b + a3.a * this.b, this.b * a3.b);
            a4.reduce();
            return a4;
        }
    }

    public void add2(RationalFraction a3) {
        if (this.b == a3.b) {
            this.a = this.a + a3.a;
            reduce();
        } else {
            this.a = this.a * a3.b + a3.a * this.b;
            this.b = this.b * a3.b;
           reduce();
        }
        System.out.println(this.a + "/" + this.b);
    }

    public RationalFraction sub(RationalFraction a3) {
        if (this.b == a3.b) {
            RationalFraction a4 = new RationalFraction(this.a - a3.a, this.b);
            a4.reduce();
            return a4;
        } else {
            RationalFraction a4 = new RationalFraction(this.a * a3.b - a3.a * this.b, this.b * a3.b);
            a4.reduce();
            return a4;
        }
    }

    public void sub2(RationalFraction a3) {
        if (this.b == a3.b) {
            this.a = this.a - a3.a;
            reduce();
        } else {
            this.a = this.a * a3.b - a3.a * this.b;
            this.b = this.b * a3.b;
            reduce();
        }
        System.out.println(this.a + "/" + this.b);
    }

    public RationalFraction mult(RationalFraction a3) {
        RationalFraction a4 = new RationalFraction(this.a * a3.a, this.b * a3.b);
        a4.reduce();
        return (a4);
    }

    public void mult2(RationalFraction a3) {
        this.a *= a3.a;
        this.b *= a3.b;
        reduce();
        System.out.println(this.a + "/" + this.b);
    }

    public RationalFraction div(RationalFraction a3) {
        RationalFraction a4 = new RationalFraction(this.a * a3.b, this.b * a3.a);
        a4.reduce();
        return (a4);
    }

    public void div2(RationalFraction a3) {
        this.a *= a3.b;
        this.b *= a3.a;
        reduce();
        System.out.println(this.a + "/" + this.b);
    }

    public String toString() {
        return this.a + "/" + this.b;
    }

    public double value() {
        return (double) this.a / this.b;
    }

    public boolean equals(RationalFraction a3) {
        boolean res = false;
        reduce();
        a3.reduce();
        if (a == a3.a && b == a3.b)
            res = true;
        return res;
    }

    public int numberPart() {
        return (int) Math.abs(Math.floor(this.a / this.b));
    }
}

