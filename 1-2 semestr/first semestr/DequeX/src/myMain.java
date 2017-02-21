/**
 * Created by howardos on 04.03.2016.
 */
public class myMain {
    public static void main(String[] args) {
        DequeX my = new DequeX(3);

        my.insertLast(3);
        my.insertFirst(2);
        my.insertLast(1);
        my.insertFirst(2);
        my.removeFirst();
        my.toOutput();
        my.rear();
    }



}
