package Lesson.collections_linkedList;

public class NodeNew<E> {
    E item;
    NodeNew<E> next;
    NodeNew<E> prev;

    NodeNew(NodeNew<E> prev, E element, NodeNew<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}