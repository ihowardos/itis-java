/**
 * Created by howardos on 05.03.2016.
 */
public class DequeX {
    private int maxsize; // максимальны размер массива (очереди)
    private long[] dequeArray;
    final int front; // начало очереди
    private int rear; // конец очереди
    private int nItem; // колличество элементов

    public DequeX(int s) {
        this.maxsize = s;
        this.dequeArray = new long[maxsize];
        this.front = 0;
        this.rear = -1;
        this.nItem = 0;
    }


    /*
    Вывод последнего элемента очереди
    */
    public long rear() {
        if (isEmpty()) {
            return -1;
        }else {
            System.out.println("Последний элемент в очереди: " + dequeArray[rear] + ".");
            return dequeArray[rear];
        }
    }

    /*
    Добавление элемента j в конец очереди
     */
    public void insertLast(int j) {
        if(rear == maxsize - 1) {
            rear = -1;
        }

        dequeArray[++rear] = j;
        nItem++;
    }

    /*
    Добавление элемента j в начало очереди
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
    Удаление последнего элемента
     */
    public void removeLast() {
        if(isEmpty()) {
            System.out.println("Очередь пустая.");
        } else {
            rear--;
            nItem--;
        }

    }

    /*
    Удаление первого элемента со смещением всех последующих
     */
    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Очередь пустая.");
        } else  {
                for (int i = 0; i < rear; i++){
                    dequeArray[i] = dequeArray[i + 1];
                }
                rear--;
            nItem--;
            }
        }

    /*
    Вывод очереди в виде массива
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
    Проверка очереди на пустоту
     */
    public boolean isEmpty() {
        return rear == -1;
    }

    /*
    Возвращение размера очереди
     */
    public int size() {
        return nItem;
    }

    /*
    Проверка очереди на полноту
     */
    public boolean isFull() {
        return rear == maxsize - 1;
    }

    /*
    Возвращение первого элемента очереди
     */
    public long peekFirst() {
        return dequeArray[front];
    }

    /*
    Возвращение последнего элемента очереди
     */
    public long peekLast() {
        return dequeArray[rear];
    }
}
