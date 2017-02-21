package lesson.Iterator.linked_list;


/**
 * Created by ihowardos on 28.02.2016.
 */


public class myLinkedList<E> {
    protected myNode<E> header;
    protected int size = 0;

    public void addValue(int index, E item) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        myNode<E> node = header;
        for (int i = size; i > 0; i--) {
            node = node.getPrev();
            if (index == i) {
                if (node == null) {
                    myNode<E> newNode = new myNode<>(null, item, node.getNext());
                    node = newNode;
                } else {
                    myNode<E> newNode = new myNode<>(node.getPrev(), item, node.getNext());
                    node = newNode;
                    size++;
                }
            }
        }

    }

    public void removeValue(int index, E item) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        myNode<E> node = header;
        for (int i = size; i > 0; i--) {
            node = node.getPrev();
            if (index == i) {
                if (node == null) {
                    node.getNext().getNext().setPrev(null);
                    size--;
                } else {
                    node.getNext().getNext().setPrev(node);
                    node.setNext(node.getNext().getNext());
                    size--;
                }
            }
        }

    }

    public void addFirst(E item) {

        myNode<E> node = header;
        for (int i = size; i > 0; i--)
            node = node.getPrev();
        myNode<E> newNode = new myNode<>(null, item, node.getNext());
        node = newNode;
        size++;
    }

    public void removeFirst() {
        myNode<E> node = header;
        for (int i = size; i > 0; i--)
            node = node.getPrev();

        node.getNext().getNext().setPrev(null);
        size--;

    }

    public void addLast(E item) {
        add(item);
        size++;
    }

    public void removeLast(E item) {
        header = header.getPrev();
        size--;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E item) {
        myNode<E> newNode = new myNode(header, item, null);
        newNode.setPrev(header);
        //header.setNext(newNode);
        header = newNode;
        size++;
    }

    public void remove(E element) {
        myNode<E> node = header.getPrev();

        for (int i = size; i > 0; i--) {
            node = node.getPrev();
            if (node.equals(element)) {
                if (node.getPrev() != null) {
                    node.getPrev().setNext(node.getNext());
                    node.getNext().setPrev(node.getPrev());
                    size--;
                } else {
                    node.getNext().setPrev(null);
                    size--;
                }
            }

            if (header.getItem().equals(element)) {
                header = header.getPrev();
                size--;
            }
        }
    }
}


