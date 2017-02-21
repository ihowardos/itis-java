/**
 * Created by howardos on 05.03.2016.
 */
public class DequeX {
    private int maxsize;
    private long[] dequeArray;
    private int front;
    private int top;
    private int nItem;

    public DequeX(int s) {
        this.maxsize = s;
        this.dequeArray = new long[this.maxsize];
        this.front = 0;
        this.top = -1;
        this.nItem = 0;
    }

    public int top() {
        return this.top;
    }

    public void insertLast(int j) {
        if(this.top == this.maxsize - 1) {
            this.top = -1;
        }

        this.dequeArray[++this.top] = (long)j;
        ++this.nItem;
    }

    public void insertFirst(int j) {
        if(this.top == -1) {
            this.dequeArray[++this.top] = (long)j;
            ++this.nItem;
        } else {
            int k;
            if(this.top == this.maxsize - 1) {
                this.dequeArray[this.top] = this.dequeArray[this.maxsize - 2];

                for(k = this.maxsize - 2; k > 0; --k) {
                    this.dequeArray[k] = this.dequeArray[k - 1];
                }

                this.dequeArray[this.front] = (long)j;
                ++this.nItem;
            } else {
                this.dequeArray[++this.top] = this.dequeArray[this.top - 1];

                for(k = this.top - 1; k > 0; --k) {
                    this.dequeArray[k] = this.dequeArray[k - 1];
                }

                this.dequeArray[this.front] = (long)j;
                ++this.nItem;
            }
        }

    }

    public void removeLast() {
        if(this.nItem == 0) {
            System.out.println("Очередь пустая");
        } else {
            this.dequeArray[this.top--] = this.dequeArray[this.top];
            --this.nItem;
        }

    }

    public void toOutput() {
        for(int i = 0; i < this.maxsize; ++i) {
            if(i != this.maxsize - 1) {
                System.out.print(this.dequeArray[i] + ", ");
            } else {
                System.out.println(this.dequeArray[i] + ".");
            }
        }

    }
}
