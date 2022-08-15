import java.util.LinkedList;

public class LinkedListStack {

    LinkedList<Employee> stack;

    public LinkedListStack() {
        stack = new LinkedList<>();
    }

    public void push(Employee employee) {
        stack.push(employee);
    }

    public Employee pop() {
        return stack.pop();
    }

    public Employee peek() {
        return stack.peek();
    }

    public String printStack() {
        return stack.toString();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
