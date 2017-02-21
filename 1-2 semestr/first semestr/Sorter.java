package KR;

// ��� ������, ������� ����������� ��� ���������� ������������� �����
import java.text.Collator;
import java.text.CollationKey;
import java.util.Locale;
/**
 * ���� ����� ���������� ����� ����������� ������� ��� ����������� ����������
 * �������� ����� ��� ������ ��������. �� ���������� ����� ��� ����������,
 * �������������� ��� ��������� ������� ��������� ����������� ��������.
 **/
public class Sorter {
    /**
     * ���� ��������� ���������� ����� compare(), ������������ ��� ���������
     * ���� ��������. ��� ���������� �������� ���������� ���� �� ������
     * �������� ������ Comparer ������� compare(), ��������������� ��� �������
     * ����������� ��� ��� �������.
     **/
    public static interface Comparer {
        /**
         * ������� ������������, � ������������ ��������, ������������
         * �� ������������� �������:
         * ���� (a > b), ������������ �������� > 0;
         * ���� (a == b), ������������ �������� 0;
         * ���� (a < b), ������������ �������� < 0.
         **/
        public int compare(Object a, Object b);
    }
    /**
     * ��� �������������� ���������, ������� ����� ������������
     * ��� �������������� ��������. ���� ����� ��������� ��������� Comparable,
     * �� ����� ��� ���������� ����� ������ ����� �������� ���������������
     * ����� ������ ������ compareTo().
     **/
    public static interface Comparable {
/**
 * ������� ������������, � ������������ ��������, ������������
 * �� ������������� �������:
 * ���� (a > b), ������������ �������� > 0;
 * ���� (a == b), ������������ �������� 0;
 * ���� (a < b), ������������ �������� < 0.
 **/
public int compareTo(Object other);
    }
    /**
     * ��� ���������� ������ Comparer (��������� ���������� �������),
     * ������������ ��� ������ ASCII. �� ������������ ���� �������� sortAscii.
     **/
    private static Comparer ascii_comparer = new Comparer() {
        public int compare(Object a, Object b) {
            return ((String)a).compareTo((String)b);
        }
    };
    /**
     * ��� ��� ���� ���������� ������ Comparer. �� ������������ ��� ���������
     * ���� �������� Comparable. ���� �� ������������ �������� sort(),
     * ������������ � �������� ���������� ������� Comparable ������
     * ������������ ��������.
     **/
    private static Comparer comparable_comparer = new Comparer() {
        public int compare(Object a, Object b) {
            return ((Comparable)a).compareTo(b);
        }
    };
    /** ������ ����� ASCII ����������� �� ����������� */
    public static void sortAscii(String[] a) {
// �������� �������� �� ���������� ������� ascii_comparer
        sort(a, null, 0, a.length-1, true, ascii_comparer);
    }
    /**
     * ����� ������� ����� ASCII ����������� �� ����������� ��� �� ��������
     * � ����������� �� ��������� up.
     **/
    public static void sortAscii(String[] a, int from, int to, boolean up) {
// �������� �������� �� ���������� ������� ascii_comparer
        sort(a, null, from, to, up, ascii_comparer);
    }
    /** ������ ����� ASCII ����������� �� ����������� ��� ����� �������� */
    public static void sortAsciiIgnoreCase(String[] a) {
        sortAsciiIgnoreCase(a, 0, a.length-1, true);
    }
    /**
     * ����� ������� ����� ASCII ����������� ��� ����� ��������: �� �����������,
     * ���� up ����� �������� true, � ��������� ������ � �� ��������.
     **/
    public static void sortAsciiIgnoreCase(String[] a, int from, int to,
                                           boolean up) {
        if ((a == null) || (a.length < 2)) return;
// ��������� ��������� ������ �����, ���������� ��������
// (� ������ ��������) ������ ���� �������� �����.
        String b[] = new String[a.length];
        for(int i = 0; i < a.length; i++) b[i] = a[i].toLowerCase();
// ����������� ���� ��������� ������, � ����������� ������
// ������������������� ����� � ����� �� �������, � ���������� ����������
// ����������, �� ��������� �� ��������. �������� ��������
// �� ���������� ������� ascii_comparer
        sort(b, a, from, to, up, ascii_comparer);
    }
    /**
     * ������ ����� ����������� �� ����������� � �����������
     * ��������� �� ��������� �������� ������� ��������
     **/
    public static void sort(String[] a) {
        sort(a, 0, a.length-1, true, false, null);
    }
    /**
     * ����� ������� ����� ����������� � ����������� ��������� �� ���������
     * �������� ������� ��������: �� ����������� � ���� �������� up �����
     * �������� true, � ��������� ������ � �� ��������. ���� ignorecase �����
     * �������� true, �������� ����� ��������� � ���������� ������� ������������.
     **/
    public static void sort(String[] a, int from, int to,
                            boolean up, boolean ignorecase) {
        sort(a, from, to, up, ignorecase, null);
    }
    /**
     * ����� ������� ����� ����������� � ����������� ��������� �� ���������
     * �������� ������� ��������: �� ����������� � ���� �������� up �����
     * �������� true, � ��������� ������ � �� ��������. ���� ignorecase �����
     * �������� true, �������� ����� ��������� � ���������� ������� ������������.
     **/
    public static void sort(String[] a, int from, int to,
                            boolean up, boolean ignorecase,
                            Locale locale) {
// �� ���������, ���� ����������� ������
        if ((a == null) || (a.length < 2)) return;
// ������ java.text.Collator ������������ ����������������������
// ��������� �����. �� ��������� ��� �������� ��� �����������
// �� ��������� �����������.
        Collator c;
        if (locale == null) c = Collator.getInstance();
        else c = Collator.getInstance(locale);
// �����������, ������� �� ��� ���������� ��������� �� �������� �������.
// ���������: ���� �������, �������, �� ����� ��������� �������� � JDK 1.1.1
// ��� ������������� ����������� �� ��������� ����������� American English.
        if (ignorecase) c.setStrength(Collator.SECONDARY);
// ����������� ������ Collator ��� �������� ������� ��������
// CollationKey, ��������������� ������ �� �����. ��������� ��������
// CollationKeys ���������� ����������� ������� ��������� �����.
        CollationKey[] b = new CollationKey[a.length];
        for(int i = 0; i < a.length; i++) b[i] = c.getCollationKey(a[i]);
// ������ ������������ ������ Comparer ��� ��������� ��������
// CollationKey � ����������� ����������� ������.
        Comparer comp = new Comparer() {
            public int compare(Object a, Object b) {
                return ((CollationKey)a).compareTo((CollationKey)b);
            }
        };
// �������, ����������� ������ �������� CollationKey,
// � ����������� ������ ����� ������������������� ����� ��� ��.
        sort(b, a, from, to, up, comp);
    }
    /** ������ �������� Comparable ����������� �� ����������� */
    public static void sort(Comparable[] a) {
        sort(a, null, 0, a.length-1, true);
    }
    /**
     * ����������� ����� ������� �������� Comparable: �� ����������� �
     * ���� �������� up ����� �������� true, � ��������� ������ � �� ��������.
     **/
    public static void sort(Comparable[] a, int from, int to, boolean up) {
        sort(a, null, from, to, up, comparable_comparer);
    }
    /**
     * ����������� ����� ������� �������� Comparable a: �� ����������� �
     * ���� �������� up ����� �������� true, � ��������� ������ � �� ��������.
     * ������ b ������������������� ����� � ��� �� �������, ��� � ������ a.
     **/
    public static void sort(Comparable[] a, Object[] b,
                            int from, int to, boolean up) {
        sort(a, b, from, to, up, comparable_comparer);
    }
    /**
     * ������ ������������ �������� ����������� �� �����������
     * � ����������� ���������, ������������� �������� Comparer �
     **/
    public static void sort(Object[] a, Comparer c) {
        sort(a, null, 0, a.length-1, true, c);
    }
    /**
     * ����� ������� �������� ����������� � ����������� ���������,
     * ������������� �������� Comparer �: �� ����������� � ���� �������� up
     * ����� �������� true, � ��������� ������ � �� ��������.
     **/
    public static void sort(Object[] a, int from, int to, boolean up,
                            Comparer c)
    {
        sort(a, null, from, to, up, c);
    }
    /**
     * ��� ������� ��������� sort(). ��� ��������� ������� ���������� (quicksort)
     * ������� a �� �������� from �� �������� to. �������� up
     * ���������, ������� �� ����������� � ������������ (true) ���
     * ��������� (false) �������. �������� Comparer �� ������������
     * ��� ��������� ��������� �������. �������� ������� b
     * ������������������� ����� ��� ��, ��� �������� ������� a.
     **/
    public static void sort(Object[] a, Object[] b,
                            int from, int to,
                            boolean up, Comparer c)
    {
// If there is nothing to sort, return
        if ((a == null) || (a.length < 2)) return;
// ��� �������� �������� ������� ����������, �� �������� ������
// �����������, �������� ��� ��� �������, �� � ��� ����������,
// ��� ������. �� ������ ��������, ��� ������ ���������, �� �������,
// ��� �������� ����, ��� ������ ����� ������������...
// �������� �������� �� ���������� ������ compare() ������� Comparer.
        int i = from, j = to;
        Object center = a[(from + to) / 2];
        do {
            if (up) { // �� �����������
                while((i < to) && (c.compare(center, a[i]) > 0)) i++;
                while((j > from) && (c.compare(center, a[j]) < 0)) j--;
            } else { // �� ��������
                while((i < to) && (c.compare(center, a[i]) < 0)) i++;
                while((j > from) && (c.compare(center, a[j]) > 0)) j--;
            }
            if (i < j) {
                Object tmp = a[i]; a[i] = a[j]; a[j] = tmp; // �������������� ��������
                if (b != null) { tmp = b[i]; b[i] = b[j]; b[j] = tmp; } // ������������
            }
            if (i <= j) { i++; j--; }
        } while(i <= j);
        if (from < j) sort(a, b, from, j, up, c); // ���������� �����������
// ����������
        if (i < to) sort(a, b, i, to, up, c);
    }
    /**
     * ���� ��������� ����� ���������� �������� ���������, ���������������
     * ��������� �������� ���������� ������ Sorter ��� ����������
     * �������� ������ ComplexNumber
     **/
    public static class Test {
/**
 * ���� �������� ������ ComplexNumber ��������� ��������� Comparable
 * � ���������� ����� compareTo() ��� ��������� ����������� �����.
 * �� ���������� ����� �� �� ���������� ��������. �� ���� �� �� ����������
 * �� ������ ���������.
 **/
static class SortableComplexNumber extends ComplexNumber
        implements Sorter.Comparable {
    public SortableComplexNumber(double x, double y) { super(x, y); }
    public int compareTo(Object other) {
        return sign(this.magnitude()-((ComplexNumber)other).magnitude());
    }
}
        /** �������� ���������, ����������� ����������� ����� ������� ���������. */
        public static void main(String[] args) {
// ������������ ������ �������� SortableComplexNumber.
// �� ���������������� ���������� ������������ �������.
            SortableComplexNumber[] a = new SortableComplexNumber[5];
            for(int i = 0; i < a.length; i++)
                a[i] = new SortableComplexNumber(Math.random()*10,
                        Math.random()*10);
// ������ �������������� ���������� � ����������� ������ compareTo()
// ������ SortableComplexNumber, ���������������� �����
// �� ���������� ��������. ��������� ����������.
            System.out.println("������������� �� ���������� ��������:");
            Sorter.sort(a);
            for(int i = 0; i < a.length; i++) System.out.println(a[i]);
// ����� ����������� ����������� ����� � ����������� ������� Comparer,
// ������������� ����� �� ��������� ���� �� ��������������
// � ������ ������.
            System.out.println("������������� �� ����� �������������� � ������ ������:");
            Sorter.sort(a, new Sorter.Comparer() {
                public int compare(Object a, Object b) {
                    ComplexNumber i = (ComplexNumber)a;
                    ComplexNumber j = (ComplexNumber)b;
                    return sign((i.real() + i.imaginary())-(j.real() + j.imaginary()));
                }
            });
            for(int i = 0; i < a.length; i++) System.out.println(a[i]);
// ��� ����������� ����� � ����������� ������� Comparer, �������������
// ������� �� ��������������, � ����� ������ �����.
            System.out.println("������������� � ������� �������� ������� �� ��������������, � ����� �� ������ ������:");
            Sorter.sort(a, 0, a.length-1, false, new Sorter.Comparer() {
                public int compare(Object a, Object b) {
                    ComplexNumber i = (ComplexNumber) a;
                    ComplexNumber j = (ComplexNumber) b;
                    double result = i.real() - j.real();
                    if (result == 0) result = i.imaginary()-j.imaginary();
                    return sign(result);
                }
            });
            for(int i = 0; i < a.length; i++) System.out.println(a[i]);
        }
        /** ��� ��������������� ���������, ������������ ����������� ��������� */
        public static int sign(double x) {
            if (x > 0) return 1;
            else if (x < 0) return-1;
            else return 0;
        }
    }
}