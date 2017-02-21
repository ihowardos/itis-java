/**
 * Created by howardos on 05.03.2016.
 */
public class DequeX {
    private int maxsize; // ����������� ������ ������� (�������)
    private long[] dequeArray;
    final int front; // ������ �������
    private int rear; // ����� �������
    private int nItem; // ����������� ���������

    public DequeX(int s) {
        this.maxsize = s;
        this.dequeArray = new long[maxsize];
        this.front = 0;
        this.rear = -1;
        this.nItem = 0;
    }


    /*
    ����� ���������� �������� �������
    */
    public long rear() {
        if (isEmpty()) {
            return -1;
        }else {
            System.out.println("��������� ������� � �������: " + dequeArray[rear] + ".");
            return dequeArray[rear];
        }
    }

    /*
    ���������� �������� j � ����� �������
     */
    public void insertLast(int j) {
        if(rear == maxsize - 1) {
            rear = -1;
        }

        dequeArray[++rear] = j;
        nItem++;
    }

    /*
    ���������� �������� j � ������ �������
     */
    public void insertFirst(int j) {
        if(isEmpty()) {
            dequeArray[++rear] = j;
            nItem++;
        } else {
            if(rear == maxsize - 1) {
                dequeArray[rear] = dequeArray[rear - 1];

                for(int i = maxsize - 2; i > 0; i--) {
                    dequeArray[i] = dequeArray[i - 1];
                }

                dequeArray[front] = j;
                nItem++;
            } else {
                dequeArray[++rear] = dequeArray[rear - 1];

                for(int k = rear - 1; k > 0; k--) {
                    dequeArray[k] = dequeArray[k - 1];
                }

                dequeArray[front] = j;
                nItem++;
            }
        }

    }

    /*
    �������� ���������� ��������
     */
    public void removeLast() {
        if(isEmpty()) {
            System.out.println("������� ������.");
        } else {
            rear--;
            nItem--;
        }

    }

    /*
    �������� ������� �������� �� ��������� ���� �����������
     */
    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("������� ������.");
        } else  {
                for (int i = 0; i < rear; i++){
                    dequeArray[i] = dequeArray[i + 1];
                }
                rear--;
            nItem--;
            }
        }

    /*
    ����� ������� � ���� �������
     */
    public void toOutput() {
        for(int i = 0; i < maxsize; ++i) {
            if(i != maxsize - 1) {
                System.out.print(dequeArray[i] + ", ");
            } else {
                System.out.println(dequeArray[i] + ".");
            }
        }

    }

    /*
    �������� ������� �� �������
     */
    public boolean isEmpty() {
        return rear == -1;
    }

    /*
    ����������� ������� �������
     */
    public int size() {
        return nItem;
    }

    /*
    �������� ������� �� �������
     */
    public boolean isFull() {
        return rear == maxsize - 1;
    }

    /*
    ����������� ������� �������� �������
     */
    public long peekFirst() {
        return dequeArray[front];
    }

    /*
    ����������� ���������� �������� �������
     */
    public long peekLast() {
        return dequeArray[rear];
    }
}
