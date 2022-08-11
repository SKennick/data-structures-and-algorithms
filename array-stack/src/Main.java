public class Main {

    public static void main(String[] args) {
        Employee employee1 = new Employee("Steven", "Kennick", 1);
        Employee employee2 = new Employee("John", "Smith", 2);
        Employee employee3 = new Employee("Sara", "Jean", 3);
        Employee employee4 = new Employee("Archie", "Bunker", 4);

        ArrayStack stack = new ArrayStack(5);
        System.out.println("Is Stack Empty? " + stack.isEmpty());

        stack.push(employee1);
        System.out.println("Added one employee");
        System.out.println(stack.printStack());

        stack.push(employee2);
        stack.push(employee3);
        stack.push(employee4);
        System.out.println("Added all four employees");
        System.out.println(stack.printStack());

        System.out.println("Peeking " + stack.peek());
        System.out.println("Pop 1 " + stack.pop());
        System.out.println("Pop 2 " + stack.pop());

        System.out.println(stack.printStack());

        stack.push(employee3);
        stack.push(employee4);
        stack.push(new Employee("Big", "Stack", 5));
        stack.push(new Employee("Bigger", "Stack", 6));
        stack.push(new Employee("Biggest", "Stack", 7));
        System.out.println(stack.printStack());
    }

}
