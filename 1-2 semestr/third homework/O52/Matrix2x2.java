package Matrix;

import java.util.*;

/**
 * Created by ihowardos on 12.12.2015.
 */
public class Matrix2x2 {
    double[][] a;

    public Matrix2x2() {
        a = new double[2][2];
    }

    public Matrix2x2(double k) {
        this(k, k, k, k);
    }

    public Matrix2x2(double[][] a) {
        this.a = a;
    }

    public Matrix2x2(double x, double y, double z, double u) {
        this(new double[][]{{x, y}, {z, u}});
    }

    public Matrix2x2 add(Matrix2x2 a) {
        double[][] aCopy = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                aCopy[i][j] += a.a[i][j];
            }
        }
        return new Matrix2x2(aCopy);
    }

    public void add2(Matrix2x2 a) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.a[i][j] += a.a[i][j];
            }
        }
        System.out.println(Arrays.deepToString(this.a));
    }

    public Matrix2x2 sub(Matrix2x2 a) {
        double[][] aCopy = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                aCopy[i][j] -= a.a[i][j];
            }
        }
        return new Matrix2x2(aCopy);
    }

    public void sub2(Matrix2x2 a) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.a[i][j] -= a.a[i][j];
            }
        }
        System.out.println(Arrays.deepToString(this.a));
    }

    public Matrix2x2 multNumber(double k) {
        double[][] aCopy = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                aCopy[i][j] = this.a[i][j] * k;
            }
        }
        return new Matrix2x2(aCopy);
    }

    public void multNumber2(double k) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j] *= k;
            }
        }
        System.out.println(Arrays.deepToString(a));
    }

    public Matrix2x2 mult(Matrix2x2 a) {
        double[][] aCopy = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    aCopy[i][j] += this.a[i][k] * a.a[k][j];
                }
            }
        }
        return new Matrix2x2(aCopy);
    }

    public void mult2(Matrix2x2 a) {
        double[][] aCopy = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                double s = 0;
                for (int k = 0; k < 2; k++) {
                    aCopy[i][j] += this.a[i][k] * a.a[k][j];
                }
            }
        }
        this.a = aCopy;
        System.out.println(Arrays.deepToString(this.a));
    }

    public double det() {
        double det = this.a[0][0] * this.a[1][1] - this.a[0][1] * this.a[1][0];
        return det;
    }

    public void transpon() {
        double[][] aCopy = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                aCopy[i][j] = a[j][i];
            }
        }
        a = aCopy;
        System.out.println(Arrays.deepToString(a));
    }

    public Matrix2x2 inverseMatrix() {
        if (det() != 0) {
            System.out.println("Matrix: " + Arrays.deepToString(a));
            System.out.print("transpon: ");
            transpon();
            System.out.print("transponMatrix * " + Math.abs(det()) + ": ");
            multNumber2(1 / Math.abs(det()));
        } else {
            System.out.println("no inversive matrix");
            a = new double[2][2];
        }
        return new Matrix2x2(a);
    }

    public Matrix2x2 equivalentDiagonal() {
        System.out.println(Arrays.deepToString(a));
        double[][] aCopy;
        aCopy = a;
        if(aCopy[0][0] == 0) {
            if(aCopy[0][1] != 0) {
                aCopy[0][0] += aCopy[0][1];
                aCopy[1][0] += aCopy[1][1];
            } else if(aCopy[1][0] != 0) {
                aCopy[0][0] += aCopy[1][0];
                aCopy[0][1] += aCopy[1][1];
            }
        }
        if(aCopy[1][1] == 0) {
            if(aCopy[0][1] != 0) {
                aCopy[1][1] += aCopy[0][1];
                aCopy[1][0] += aCopy[0][0];
            } else if(aCopy[1][0] != 0) {
                aCopy[1][1] += aCopy[1][0];
                aCopy[0][1] += aCopy[0][0];
            }
        }
        aCopy[0][0] -= aCopy[0][1] * aCopy[1][0] / aCopy[1][1];

        aCopy[0][1] = 0;
        aCopy[1][0] = 0;
        return new Matrix2x2(aCopy);
    }

    public Vector2D multVector(Vector2D v) {
        double[] aCopy = new double[2];
        aCopy[0] = a[0][0] * v.x + a[0][1] * v.y;
        aCopy[1] = a[1][0] * v.x + a[1][1] * v.y;
        return new Vector2D(aCopy[0], aCopy[1]);
    }

    public String toString() {
        return Arrays.deepToString(a);
    }
}



