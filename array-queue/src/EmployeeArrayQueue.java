import java.util.NoSuchElementException;

public class EmployeeArrayQueue {

    private Employee[] queue;
    private int front;
    private int back; // the slot AFTER the last element.

    public EmployeeArrayQueue(int size) {
        queue = new Employee[size];
    }

    public void add(Employee employee) {
        //check if full, and double size if so
        if (back == queue.length) {
            Employee[] newArray = new Employee[queue.length * 2];
            //Cleanup by shifting all elements to the front of the new array
            System.arraycopy(queue, front, newArray, 0, back - front);
            queue = newArray;
            //Continue the cleanup by setting a new front and back
            int length = getSize();
            front = 0;
            back = length;
        }
        queue[back] = employee;
        back++;
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
        return back-front;
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
