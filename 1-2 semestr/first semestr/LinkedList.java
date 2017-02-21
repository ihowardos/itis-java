package lesson6;

/**
 * Этот класс реализует связанный список объектов, способный хранить объекты
 * любого типа, реализующие вложенный интерфейс Linkable. Обратите внимание,
 * что все методы синхронизированы, так что класс могут безопасно
 * использовать несколько потоков одновременно.
 * Но мы пока потоки не знаем, поэтому не обращайте веимание на sinchronized,
 * пока это не суть.
 **/
public class LinkedList {
    /**
     * Этот интерфейс определяет методы, необходимые любому объекту
     * для присоединения к связанному списку.
     **/
    public interface Linkable {
        public Linkable getNext(); // Возвращает следующий элемент списка
        public void setNext(Linkable node); // Устанавливает следующий элемент списка
    }
// У этого класса есть принимаемый по умолчанию конструктор:
// public LinkedList() {}
    /** Это единственное поле класса. Оно содержит первый узел (head) списка*/
    Linkable head;
    /** Возвращает первый узел списка */
    public synchronized Linkable getHead() { return head; }
    /** Вставляет узел в начало списка */
    public synchronized void insertAtHead(Linkable node) {
        node.setNext(head);
        head = node;
    }
    /** Вставляет узел в конец списка */
    public synchronized void insertAtTail(Linkable node) {
        if (head == null) head = node;
        else {
            Linkable p, q;
            for(p = head; (q = p.getNext()) != null; p = q) /* пустой цикл */;
            p.setNext(node);
        }
    }
    /** Удаляет и возвращает в качестве значения узел,
     находящийся в начале списка */
    public synchronized Linkable removeFromHead() {
        Linkable node = head;
        if (node != null) {
            head = node.getNext();
            node.setNext(null);
        }
        return node;
    }
    /** Удаляет и возвращает в качестве значения узел,
     находящийся в конце списка */
    public synchronized Linkable removeFromTail() {
        if (head == null) return null;
        Linkable p = head, q = null, next = head.getNext();
        if (next == null) {
            head = null;
            return p;
        }
        while((next = p.getNext()) != null) {
            q = p;
            p = next;
        }
        q.setNext(null);
        return p;
    }
/**
 * Удаляет из списка узел, совпадающий с заданным. Для проверки
 * на совпадение вместо оператора == применяется метод equals().
 **/
public synchronized void remove(Linkable node) {
    if (head == null) return;
    if (node.equals(head)) {
        head = head.getNext();
        return;
    }
    Linkable p = head, q = null;
    while((q = p.getNext()) != null) {
        if (node.equals(q)) {
            p.setNext(q.getNext());
            return;
        }
        p = q;
    }
}
    /** Этот вложенный класс определяет метод main(), тестирующий LinkedList */
    public static class Test {
        /**
         * Это тестовый класс, реализующий интерфейс Linkable
         **/
        static class LinkableInteger implements Linkable {
            int i; // Данные, содержащиеся в узле
            Linkable next; // Ссылка на следующий узел в списке
            public LinkableInteger(int i) { this.i = i; } // Конструктор
            public Linkable getNext() { return next; } // Часть Linkable
            public void setNext(Linkable node) { next = node; } // Linkable
            public String toString() { return i + ""; } // Для удобства печати
            public boolean equals(Object o) { // Для сравнения
                if (this == o) return true;
                if (!(o instanceof LinkableInteger)) return false;
                if (((LinkableInteger)o).i == this.i) return true;
                return false;
            }
        }
        /**
         * Тестовая программа. Вставляет несколько узлов, удаляет несколько
         * узлов, затем печатает все элементы списка. Она должна напечатать
         * числа 4, 6, 3, 1 и 5
         **/
        public static void main(String[] args) {
            LinkedList ll = new LinkedList(); // Создание списка
            ll.insertAtHead(new LinkableInteger(1)); // Что-то вставляется
            ll.insertAtHead(new LinkableInteger(2));
            ll.insertAtHead(new LinkableInteger(3));
            ll.insertAtHead(new LinkableInteger(4));
            ll.insertAtTail(new LinkableInteger(5));
            ll.insertAtTail(new LinkableInteger(6));
            System.out.println(ll.removeFromHead()); // Удаляем и печатаем узел
            System.out.println(ll.removeFromTail()); // Снова удаляем и печатаем
            ll.remove(new LinkableInteger(2)); // Удаляем еще один узел
            // Теперь печатаем содержимое списка.
            for(Linkable l = ll.getHead(); l != null; l = l.getNext())
                System.out.println(l);
        }
    }
}