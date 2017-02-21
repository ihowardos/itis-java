/**
 * Created by howardos on 11.05.2016.
 */
public class Node<T extends Comparable> {
    public Node parent, sonL, sonC, sonR;
    public T keyL;
    public T keyR;
    public int length;

    public Node(T keyL, T keyR){
        if (keyR == null) {
            this.keyL = keyL;
            this.length = 2;
        }
        else if (keyR.compareTo(keyL) == 1) {
            this.keyL = keyL;
            this.keyR = keyR;
            this.length = 3;
        } else {
            this.keyL = keyR;
            this.keyR = keyL;
            this.length = 3;
        }
    }

    public T getKeyL() {
        return keyL;
    }

    public T getKeyR() {
        return keyR;
    }

    public int getLength() {
        return length;
    }
}
