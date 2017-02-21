package Lesson.collections_linkedList;

import java.util.LinkedList;

/**
 * Created by howardos on 19.02.2016.
 */
public class Lesson {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        long st = System.nanoTime();
        long startTime = System.currentTimeMillis();

            for (char i = 0; i < 1000; i++) {
                String c = new String();
                c += i;
                    list.add(c);

            }
        long en = System.nanoTime();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        System.out.println(en - st);

        String[] array = new String[1000];
        st = System.nanoTime();
        long stTime = System.currentTimeMillis();

        for (int j = 0; j < 1000; j++) {
            String k = new String();
            k += j;
            array[j] = k;
        }
        en = System.nanoTime();
        long enTime = System.currentTimeMillis();
        System.out.println(en - st);
        System.out.println(enTime - stTime);





    }
}
/**
 * By anthony.kryloff@gmail.com
 * Date: 24.02.16 9:42
 */
package classwork.cw2402_collection;

        import classwork.cw1702_linked_list.Elem;

        import java.util.*;
        import java.util.Collection;

/**
 * By anthony.kryloff@gmail.com
 * Date: 24.02.16 9:42
 */
public class LinkedCollection implements java.util.Collection<Integer> {

    protected Elem head;
    protected int size = 0;

    @Override
    public boolean remove(Object o) {
        int x = (int)o;
        Elem i = head;
        Elem prev = new Elem(0,head);
        while (i != null) {
            if(i.getValue() == x) {
                deleteAfter(prev);
                if(i == head) {
                    head = i.getNext();
                }
                return true;
            }
            prev = i;
            i = i.getNext();
        }
        return false;
    }

    protected void deleteAfter(Elem prev) {
        Elem p = prev.getNext();
        prev.setNext(p.getNext());
        size--;
    }

    @Override
    public boolean contains(Object o) {
        int x = (int)o;
        for(Elem i = head; i != null; i = i.getNext()) {
            if(i.getValue() == x) return true;
        }
        return false;
    }

    @Override
    public boolean add(Integer x) {
        head = new Elem(x, head);
        size++;
        return true;
    }

    public static void insertAfter(Elem p, int x) {
        Elem t = new Elem(x, p.getNext());
        p.setNext(t);
    }
    public static void insertBefore(Elem p, int x) {
        insertAfter(p, p.getValue());
        p.setValue(x);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    //TODO
    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    //TODO
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    //TODO
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for(Object i: c) {
            if(!contains(i))
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        for(int i: c) {
            add(i);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for(Object i: c) {
            remove(i);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Elem p = head;
        Elem prev = new Elem(0, head);
        while (p != null) {
            if(!c.contains(p.getValue())) {
                deleteAfter(prev);
            }
            prev = p;
            p = p.getNext();
        }
        return true;
    }

    @Override
    public void clear() {
        head.setNext(null);
        head = null;
    }
}

