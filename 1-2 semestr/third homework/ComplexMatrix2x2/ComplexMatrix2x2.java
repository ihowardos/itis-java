package ComplexMatrix2x2;

/**
 * Created by ihowardos on 20.12.2015.
 */
public class ComplexMatrix2x2 {
    public ComplexNumber[][] c;

    public ComplexMatrix2x2() {
        this.c = new ComplexNumber[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.c[i][j] = new ComplexNumber();
            }
        }
    }

    public ComplexMatrix2x2(ComplexNumber c) {
        this.c = new ComplexNumber[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.c[i][j] = new ComplexNumber();
            }
        }
    }

    public ComplexMatrix2x2(ComplexNumber c1, ComplexNumber c2, ComplexNumber c3, ComplexNumber c4) {
        c = new ComplexNumber[][]{{c1, c2}, {c3, c4}};

    }

    public ComplexMatrix2x2 add(ComplexMatrix2x2 c) {
        ComplexMatrix2x2 cn = new ComplexMatrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                cn.c[i][j] = this.c[i][j].add(c.c[i][j]);
            }
        }
        return new ComplexMatrix2x2();
    }

    public ComplexMatrix2x2 mult(ComplexMatrix2x2 c) {
        ComplexMatrix2x2 cn = new ComplexMatrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; i++) {
                cn.c[i][j] = this.c[i][j].mult(c.c[i][j]);
            }
        }
        return cn;
    }

    public ComplexNumber det() {
        ComplexNumber det = c[0][0].mult(c[1][1].sub(c[0][1].mult(c[1][0])));
        return det;
    }

    public ComplexVector2D multVector2D(ComplexVector2D v) {
        ComplexNumber x = c[0][0].mult(v.x).add(c[0][1].mult(v.y));
        ComplexNumber y = c[1][0].mult(v.x).add(c[0][1].mult(v.y));
        return new ComplexVector2D(x, y);
    }
}
