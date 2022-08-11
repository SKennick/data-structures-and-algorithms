import java.util.EmptyStackException;

public class ArrayStack {

    private Employee[] stack;
    private int top;

    public ArrayStack(int size) {
        stack = new Employee[size];
        top = 0;
    }

    public void push(Employee employee) {
        // If we have reached the length of the array, double the size.
        // This is an O(n) operation
        if (top == stack.length) {
            Employee[] newStack = new Employee[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }

        stack[top++] = employee; //Add the employee, and increment the top.
    }

    public Employee pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[--top];
    }

    public Employee peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public String printStack() {
        StringBuilder sb = new StringBuilder("--TOP--");
        for (int x = top-1; x >= 0; x--) {
            sb.append("\n");
            sb.append(stack[x].toString());
        }
        return sb.toString();
    }
}
