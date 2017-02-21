package Vector2D;

/**
 * Created by howardos on 05.12.2015.
 */
public class Vector2DTest {
    public static void main(String[] args) {
        Vector2D v1 = new Vector2D(3, 1);
        System.out.println("Вектор один = " + v1 + ";");
        Vector2D v2 = new Vector2D(3, 1);
        System.out.println("Вектор два = " + v2 + ";");
        Vector2D v3 = new Vector2D();
        System.out.println("Нулевой вектор = " + v3 + ";");
        v1.add2(3, 1);
        v1.sub(3, 1);
        v1.sub2(3, 1);
        v1.mult(8);
        v1.mult2(8);
        System.out.println(v1.toString());
        System.out.println(v1.length());
        System.out.println(v1.scalarProduct(v2));
        System.out.println(v1.cos(v2));
        System.out.println(v1.equals(v2));


    }
}
