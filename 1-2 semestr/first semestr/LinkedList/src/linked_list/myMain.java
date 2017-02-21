package linked_list;

/**
 * Created by howardos on 01.03.2016.
 */
public class myMain {
    public static void main(String[] args) {
        myLinkedList<Integer> list = new myLinkedList<>();
        list.add(3);
        list.add(3);
        list.add(4);
        list.addValue(1, 2);
        System.out.println(list.size());
    }
}
