package homework.linked_list;

/**
 * Created by ihowardos on 28.02.2016.
 */
public class myNode<E> {

    private E item;
    private myNode<E> next;
    private myNode<E> prev;

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public myNode<E> getNext() {
        return next;
    }

    public void setNext(myNode<E> next) {
        this.next = next;
    }

    public myNode<E> getPrev() {
        return prev;
    }

    public void setPrev(myNode<E> prev) {
        this.prev = prev;
    }

    public myNode(myNode<E> prev, E item, myNode<E> next){
        this.item = item;
        this.next = next;
        this.prev = prev;
    }

}