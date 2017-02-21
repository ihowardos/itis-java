/**
 * Created by howardos on 04.03.2016.
 */
public class myMain {
    public static void main(String[] args) {
        DequeX my = new DequeX(5);
        my.insertLast(7);
        my.insertLast(2);
        my.insertFirst(5);
        my.insertFirst(3);
        my.toOutput();
        my.removeLast();
        my.toOutput();
        System.out.println(my.top());
    }



}
