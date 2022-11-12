import java.util.NoSuchElementException;

public class MakeQueue {

    private int Queue[];
    private int front, rear, size, l;
    public MakeQueue(int n) {
        front = -1;
        rear = -1;
        size = n;
        l = 0;
        Queue = new int[size];

    }

    public boolean isEmpty() {
        return front == -1;
    }

    public void addTOQueue(int i) {
        if (rear == -1) {
            rear = 0;
            front = 0;
            Queue[rear] = i;
        }
        else if (rear + 1 >= size)

            throw new IndexOutOfBoundsException("Overflow");
        else if (rear + 1 < size)

            Queue[++rear] = i;

           l++;
    }

    public int remove() {
        if (isEmpty())
            throw new NoSuchElementException("Underflow");
        else {
            l--;

            int element = Queue[front];

            if (front == rear) {
                front = -1;

                rear = -1;
            } else
                front++;
            return element;
        }
    }


}
