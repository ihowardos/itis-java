package H024;

/**
 * Created by ihowardos on 13.12.2015.
 */
public class New {
    int x;
    double EPS;

    public New(int x, double EPS) {
        this.x = x;
        this.EPS = EPS;
    }

    public New(double s) {
    }

    public void sum() {
        int n = 0;
        double s = 0;
        double k = 1;
        while (Math.abs(k) >= this.EPS) {
            n += 1;
            k = 1 / (n * Math.pow(9, n) * Math.pow(this.x-1, 2*n));
            s = s + k;
        }
        System.out.println(s);
    }

    public New sum2() {
        int n = 0;
        double s = 0;
        double k = 1;
        while (Math.abs(k) >= this.EPS) {
            n += 1;
            k = 1 / (n * Math.pow(9, n) * Math.pow(x-1, 2*n));
            s = s + k;
        }
        System.out.println(s);
        return new New(s);
    }

}
