package lesson2;

public class Rect {
    // Ёто пол€ данных класса
    public int x1, y1, x2, y2;
    /**
     * ћетод Rect Ц главный конструктор класса. ќн просто использует свои
     * аргументы дл€ инициализации полей нового объекта. ќбратите внимание
     * на то, что его им€ совпадает с именем класса и что в его сигнатуре
     * нет возвращаемого значени€.
     **/
    public Rect(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
/**
 * Ёто еще один конструктор. ќн определ€етс€ через предыдущий конструктор
 **/
public Rect(int width, int height) { this(0, 0, width, height); }

    /** Ёто еще один конструктор. */
    public Rect() { this(0, 0, 0, 0); }
    /** ѕеремещение пр€моугольника на указанные рассто€ни€ */
    public void move(int deltax, int deltay) {
        x1 += deltax; x2 += deltax;
        y1 += deltay; y2 += deltay;
    }
    /** ѕровер€ем, находитс€ ли заданна€ точка внутри пр€моугольника */
    public boolean isInside(int x, int y) {


        return ((x >= x1) && (x <= x2) && (y >= y1) && (y <= y2));
        //return (true);
    }
    /**
     * ¬озвращаетс€ объединение этого пр€моугольника с другим. ƒругими
     словами,
     * возвращаетс€ наименьший пр€моугольник, содержащий оба пр€моугольника.
     **/
    public Rect union(Rect r) {
        return new Rect((this.x1 < r.x1) ? this.x1 : r.x1,
                (this.y1 < r.y1) ? this.y1 : r.y1,
                (this.x2 > r.x2) ? this.x2 : r.x2,
                (this.y2 > r.y2) ? this.y2 : r.y2);
    }

    /**
     * ¬озвращаетс€ пересечение этого пр€моугольника с другим.
     * ƒругими словами, возвращаетс€ область их наложени€.
     **/
    public Rect intersection(Rect r) {
        Rect result =  new Rect((this.x1 > r.x1) ? this.x1 : r.x1,
                (this.y1 > r.y1) ? this.y1 : r.y1,
                (this.x2 < r.x2) ? this.x2 : r.x2,
                (this.y2 < r.y2) ? this.y2 : r.y2);
        if (result.x1 > result.x2) { result.x1 = result.x2 = 0; }
        if (result.y1 > result.y2) { result.y1 = result.y2 = 0; }
        return result;
    }
    /**
     * Ёто метод нашего базового класса Object. ћы замещаем его так, чтобы
     * объекты класса Rect можно было осмысленно преобразовывать в строки,
     * складывать с другими строками при помощи оператора + и передавать
     * таким методам, как System.out.println().
     **/
    public String toString() {
        return "[" + x1 + "," + y1 + "; " + x2 + "," + y2 + "]";
    }
}
