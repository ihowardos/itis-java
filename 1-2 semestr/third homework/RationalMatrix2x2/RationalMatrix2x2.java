package RationalMatrix2x2;

import java.util.Arrays;

/**
 * Created by howardos on 20.12.2015.
 */
public class RationalMatrix2x2 {
    public RationalFraction[][] m;

    public RationalMatrix2x2() {
        m = new RationalFraction[2][2];
        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m[i][j] = new RationalFraction();
            }
        }
    }

    public RationalMatrix2x2(RationalFraction r) {
        this(r, r, r, r);
    }

    public RationalMatrix2x2(RationalFraction r1, RationalFraction r2, RationalFraction r3, RationalFraction r4) {
        m = new RationalFraction[][]{{r1, r2}, {r3, r4}};
    }

    public RationalMatrix2x2 add(RationalMatrix2x2 m) {
        RationalMatrix2x2 rm = new RationalMatrix2x2();
        for (int i = 0; i < 2; i ++) {
            for (int j = 0; j < 2; j++) {
                rm.m[i][j] = this.m[i][j].add(m.m[i][j]);
                rm.m[i][j].reduce();
            }
        }
        return rm;
    }

    public String toString() {
        return Arrays.deepToString(m);
    }

    public RationalMatrix2x2 mult(RationalMatrix2x2 m) {
        RationalMatrix2x2 rm = new RationalMatrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    rm.m[i][j] = rm.m[i][j].add(this.m[i][k].mult(m.m[k][j]));
                }
            }
        }
        return rm;
    }

    public RationalFraction det() {
        RationalFraction det = this.m[0][0].mult(this.m[1][1]).sub(this.m[0][1].mult(this.m[1][0]));
        return det;
    }

    public RationalVector2D multVector2D(RationalVector2D v) {
    RationalFraction x = m[0][0].mult(v.a).add(m[0][1].mult(v.b));
        RationalFraction y = m[1][0].mult(v.a).add(m[1][1].mult(v.b));
        return new RationalVector2D(x, y);
    }


}
