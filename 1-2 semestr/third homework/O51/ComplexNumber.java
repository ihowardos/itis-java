package Complex;

/**
 * Created by ihowardos on 11.12.2015.
 */
public class ComplexNumber {
    public double a, b;

    public ComplexNumber() {
        this.a = 0;
        this.b = 0;
    }

    public ComplexNumber(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public String toString() {
        if (this.a == 0 && this.b == 0)
            return "0";
        if (this.a == 0 && this.b > 0)
            return this.b + "i";
        if (this.b == 0)
            return "" + this.a;
        if (this.b < 0)
            return (this.a + " - " + Math.abs(this.b) + "i");
        else return (this.a + " + " + this.b + "i");
    }

    public ComplexNumber add(ComplexNumber a2) {
        return new ComplexNumber(this.a + a2.a, this.b + a2.b);
    }

    public void add2(ComplexNumber a2) {
        this.a += a2.a;
        this.b += a2.b;
        if (this.b == 0)
            System.out.println(this.a);
        if (this.a == 0)
            System.out.println(this.b + "i");
        if (this.b < 0)
            System.out.println(this.a + " - " + Math.abs(this.b) + "i");
        else System.out.println(this.a + " + " + this.b + "i");
    }

    public ComplexNumber sub(ComplexNumber a2) {
        return new ComplexNumber(this.a - a2.a, this.b - a2.b);
    }

    public void sub2(ComplexNumber a2) {
        this.a -= a2.a;
        this.b -= a2.b;
        if (this.b < 0)
            System.out.println(this.a + " - " + Math.abs(this.b) + "i");
        else System.out.println(this.a + " + " + this.b + "i");
        if (this.b == 0)
            System.out.println("" + this.a);
        if (this.a == 0)
            System.out.println(this.b + "i");

    }

    public ComplexNumber multNumber(double n) {
        return new ComplexNumber(this.a * n, this.b * n);
    }

    public void multNumber2(double n) {
        this.a *= n;
        this.b *= n;
        if (this.b == 0)
            System.out.println(this.a);
        if (this.a == 0)
            System.out.println(this.b + "i");
        if (this.b < 0)
            System.out.println(this.a + " - " + Math.abs(this.b) + "i");
        else System.out.println(this.a + " + " + this.b + "i");
    }

    public ComplexNumber mult(ComplexNumber a2) {
        return new ComplexNumber(a2.a * this.a - this.b * a2.b, this.b * a2.a + this.a * a2.b);
    }

    public void mult2(ComplexNumber a2) {
        double a = this.a;
        double b = this.b;
        this.a = a2.a * a - b * a2.b;
        this.b = b * a2.a + a * a2.b;
        if (this.b == 0)
            System.out.println(this.a);
        if (this.a == 0)
            System.out.println(this.b + "i");
        if (this.b < 0)
            System.out.println(this.a + " - " + Math.abs(this.b) + "i");
        else System.out.println(this.a + " + " + this.b + "i");
    }

    public ComplexNumber div(ComplexNumber a2) {
        return new ComplexNumber((this.a * a2.a + this.b * a2.b) / (a2.a * a2.a + a2.b * a2.b), (this.b * a2.a - this.a * a2.a) / (a2.a * a2.a + a2.b + a2.b));
    }

    public void div2(ComplexNumber a2) {
        double a = this.a;
        double b = this.b;
        this.a = (a * a2.a + b * a2.b) / (a2.a * a2.a + a2.b * a2.b);
        this.b = (b * a2.a - a * a2.a) / (a2.a * a2.a + a2.b + a2.b);
        if (this.b == 0)
            System.out.println(this.a);
        if (this.a == 0)
            System.out.println(this.b + "i");
        if (this.b < 0)
            System.out.println(this.a + " - " + Math.abs(this.b) + "i");
        else System.out.println(this.a + " + " + this.b + "i");
    }

    public double length() {
        return Math.sqrt(Math.pow(this.a, 2) + Math.pow(this.b, 2));
    }

    public double arg() {
        double arg = 0;
        if (this.a > 0) {
            if (this.b == 0) arg = 0;
            if (this.b > 0) arg = Math.atan(this.b / this.a);
            if (this.b < 0) arg = - Math.atan(this.b / this.a);
            return arg;
        }
        else
        if (this.b == 0) arg = Math.PI;
        if (this.b > 0) arg = Math.PI + Math.atan(this.b / this.a);
        if (this.b < 0) arg = - Math.PI + Math.atan(this.b / this.a);
        return arg;

    }

    public double pow(double n) {
        double pow = Math.pow(length(), n) * (Math.cos(n * arg()) + Math.sin(n * arg()));
        return pow;

    } // Через ComplexNumber не получается

    public boolean equals(ComplexNumber a2) {
        if(this.a == a2.a && this.b == a2.b)
            return true;
        else return false;
    }
}
