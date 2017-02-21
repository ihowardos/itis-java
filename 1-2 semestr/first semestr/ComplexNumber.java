package KR;

/**
 * Этот класс представляет комплексные числа и определяет методы, реализующие
 * арифметику комплексных чисел.
 **/
public class ComplexNumber {
    // Это переменные экземпляра. Каждый объект класса ComplexNumber содержит
// два значения типа double, обозначаемые x и y. Они описаны как private и,
// значит, недоступны извне этого класса. Доступ к ним осуществляется
// посредством описанных ниже методов real() и imaginary().
    private double x, y;
    /** Это конструктор. Он инициализирует переменные x и y */
    public ComplexNumber(double real, double imaginary) {
        this.x = real;
        this.y = imaginary;
    }
    /**
     * Метод доступа. Возвращает действительную часть комплексного числа.
     * Обратите внимание на отсутствие метода setReal() для установки
     * действительной части числа. Это означает, что класс ComplexNumber
     * является «неизменяемым».
     **/
    public double real() { return x; }
    /** Метод доступа. Возвращает мнимую часть комплексного числа */
    public double imaginary() { return y; }
    /** Вычисляет абсолютную величину комплексного числа */
    public double magnitude() { return Math.sqrt(x*x + y*y); }
    /**
     * Этот метод преобразует ComplexNumber в строку. Это метод класса Object,
     * который мы замещаем так, чтобы комплексные числа можно было осмысленно
     * преобразовать в строки, которые удобно выводить посредством метода
     * System.out.println() и подобных ему
     **/
    public String toString() { return "{" + x + "," + y + "}"; }
    /**
     * Это статический метод класса. Он берет два комплексных числа, складывает
     * их и возвращает результат в виде третьего числа. Поскольку метод
     * статический, для него не существует «текущий экземпляр», или объект
     * «this». Применяется он так: ComplexNumber c = ComplexNumber.add(a, b);
     **/
    public static ComplexNumber add(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.x + b.x, a.y + b.y);
    }
    /**
     * Это нестатический метод экземпляра с тем же именем. Он прибавляет
     * заданное комплексное число к текущему комплексному числу.
     * Применяется он так:
     * ComplexNumber c = a.add(b);
     **/
    public ComplexNumber add(ComplexNumber a) {
        return new ComplexNumber(this.x + a.x, this.y+a.y);
    }
    /** Статический метод класса для умножения комплексных чисел */
    public static ComplexNumber multiply(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.x*b.x - a.y*b.y, a.x*b.y + a.y*b.x);
    }
    /** Метод экземпляра для умножения на комплексное число */
    public ComplexNumber multiply(ComplexNumber a) {
        return new ComplexNumber(x*a.x - y*a.y, x*a.y + y*a.x);
    }
}