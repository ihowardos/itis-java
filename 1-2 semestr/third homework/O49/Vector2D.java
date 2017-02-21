package Vector2D;

/**
 * Created by ihowardos on 05.12.2015.
 */
public class Vector2D {
    public double x, y;

    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D add(double x, double y) {
        double newx = this.x + x;
        double newy = this.y + y;
        return new Vector2D(newx, newy);
    }

    public void add2(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public Vector2D sub(double x, double y) {
        double newx = this.x - x;
        double newy = this.y - y;
        return new Vector2D(newx, newy);
    }

    public void sub2(double x, double y) {
        this.x -= x;
        this.y -= y;
    }

    public Vector2D mult(double k) {
        double newx = this.x * k;
        double newy = this.y * k;
        return new Vector2D(newx, newy);
    }

    public void mult2(double k) {
        this.x *= k;
        this.y *= k;
    }

    public String toString() {
        return this.x + ", " + this.y;
    }

    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public double scalarProduct(Vector2D a) {
        return this.x * a.x + this.y * a.y;
    }

    public double cos(Vector2D a) {
        return (this.x * a.x + this.y * a.y) / (Math.sqrt(this.x * this.x + a.x * a.x) * Math.sqrt(this.y * this.y + a.y * a.y));
    }

    public boolean equals(Vector2D a) {
        boolean res = false;
        double lenght1 = Math.sqrt(this.x * this.x + this.y * this.y);
        double lenght2 = Math.sqrt(a.x * a.x + a.y * a.y);
        if (lenght1 == lenght2) {
            return res = true;
        }
        else return res;

    }
}