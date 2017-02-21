package homework.linked_list;

import java.util.Collection;

/**
 * Created by ihowardos on 28.02.2016.
 */



public class myLinkedList<E> {
    protected myNode<E> header;
    protected int size = 0;

    private void addValue(int index, E item) {

    }

    private void addFirst(E item) {
    }

    private void addLast(E item) {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return header == null;
    }

    public E add(E item) {
        myNode<E> newNode = new myNode(header, item, null);
        newNode.setPrev(header);
        header = newNode;
        size++;
        return item;
    }

    public boolean remove(Object o) {
        myNode<E> node = header.getNext();
        while (node != null) {
            myNode<E> prev = node.getPrev();
            myNode<E> next = node.getNext();
            if (node.getItem().equals(o) && node.getNext() != null) {
                prev.setNext(next);
                next.setPrev(prev);
            } else
                prev.setNext(null);


            size--;
        }
        return true;
    }

    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {

    }
}
