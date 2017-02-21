/**
 * Created by howardos on 11.05.2016.
 */
public class Tree<T extends Comparable> {
    Node root;

    public Node search(T x, Node root) {

        if (root.length == 2) {
            if (root.keyL == x) return root;
            else if (root.keyL.compareTo(x) > 0) search(x, root.sonL);
            else if (root.keyR.compareTo(x) < 0) search(x, root.sonR);
        } else if (root.length == 3) {
            if (root.keyL.compareTo(x) <= 0 && root.keyR.compareTo(x) >= 0) search(x, root.sonC);
            else if (root.keyL.compareTo(x) > 0) search(x, root.sonL);
            else if (root.keyR.compareTo(x) < 0) search(x, root.sonC);
        }
        return null;
    }

    public void insert(T value) {
        if (root == null){
            root = new Node(value, null);
            root.sonL.parent = root;
            root.sonR.parent = root;
        }

        else if (root.keyR == null) {
            root = new Node(root.keyL, value);
            root.sonL.parent = root;
            root.sonR.parent = root;
            root.sonR.parent = root;
            Node node = search(value, root);
        }
        else if ()
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(3);
        tree.insert(2);
    }
}
