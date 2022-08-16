public class Main {

    public static void main(String[] args) {
        Employee employee1 = new Employee("Steven", "Kennick", 1);
        Employee employee2 = new Employee("John", "Smith", 2);
        Employee employee3 = new Employee("Sara", "Jean", 3);
        Employee employee4 = new Employee("Archie", "Bunker", 4);

        EmployeeArrayQueue queue = new EmployeeArrayQueue(2);
        System.out.println(queue.getSize());
        System.out.println(queue.isEmpty());
        queue.add(employee1);
        System.out.println(queue.getSize());
        System.out.println(queue.isEmpty());
        System.out.println(queue.printQueue());
        queue.add(employee2);
        System.out.println(queue.printQueue());
        System.out.println(queue.getSize());
        queue.remove();
        queue.add(employee3);
        queue.add(employee4);
        queue.add(new Employee("Test", "Bigger", 5));
        System.out.println(queue.getSize());
        System.out.println(queue.printQueue());
        queue.remove();
        System.out.println(queue.printQueue());
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
    }

}
