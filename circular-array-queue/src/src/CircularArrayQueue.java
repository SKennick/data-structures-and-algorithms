package src;

import java.util.NoSuchElementException;

public class CircularArrayQueue {

    private Employee[] queue;
    private int front;
    private int back; // the slot AFTER the last element.

    public CircularArrayQueue(int size) {
        queue = new Employee[size];
    }

    public void add(Employee employee) {
        int size = getSize();
        if (getSize() == queue.length - 1) {
            Employee[] newQueue = new Employee[queue.length * 2];
            int frontCopyLength = back < front ? queue.length - front : back - front;
            System.arraycopy(queue, front, newQueue, 0, frontCopyLength);
            if (back < front) {
                System.arraycopy(queue, 0, newQueue, frontCopyLength, back);
            }
            queue = newQueue;
            back = getSize();
            front = 0;
        }

        queue[back] = employee;
        if (back < queue.length - 1) {
            back++;
        } else {
            back = 0;
        }
    }

    public Employee remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Employee employee = queue[front];
        queue[front] = null;
        front++;
        //cleanup pointers if size is now 0
        if (isEmpty()) {
            front = 0;
            back = 0;
        }
        return employee;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public int getSize() {
        if (front <= back) {
            return back - front;
        } else {
            return back - front + queue.length;
        }
    }

    public String printQueue() {
        StringBuilder sb = new StringBuilder("FRONT -> ");
        for (int x = front; x < back; x++) {
            sb.append(queue[x]);
            sb.append(" - ");
        }
        sb.append("BACK");
        return sb.toString();
    }
}
