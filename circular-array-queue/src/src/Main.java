package src;

public class Main {

    public static void main(String[] args) {

        Employee[] array = new Employee[5];

        Employee employee1 = new Employee("Steven", "Kennick", 1);
        Employee employee2 = new Employee("John", "Smith", 2);
        Employee employee3 = new Employee("Sara", "Jean", 3);
        Employee employee4 = new Employee("Archie", "Bunker", 4);

        System.out.println(employee1.getLastName().length() % array.length);
        System.out.println(employee2.getLastName().length() % array.length);
        System.out.println(employee3.getLastName().length() % array.length);
        System.out.println(employee4.getLastName().length() % array.length);

//
//        CircularArrayQueue queue = new CircularArrayQueue(4);
//        queue.add(employee1);
//        queue.add(employee2);
//        queue.add(employee3);
//        queue.remove();
//        queue.add(employee4);
//        queue.add(new Employee("Test", "Bigger", 5));
//        queue.add(new Employee("Trigger", "Resize", 6));



//        System.out.println(queue.getSize());
//        System.out.println(queue.isEmpty());
//        queue.add(employee1);
//        System.out.println(queue.getSize());
//        System.out.println(queue.isEmpty());
//        System.out.println(queue.printQueue());
//        queue.add(employee2);
//        System.out.println(queue.printQueue());
//        System.out.println(queue.getSize());
//        queue.remove();
//        queue.add(employee3);
//        queue.add(employee4);
//        queue.add(new Employee("Test", "Bigger", 5));
//        System.out.println(queue.getSize());
//        System.out.println(queue.printQueue());
//        queue.remove();
//        System.out.println(queue.printQueue());
//        queue.remove();
//        queue.remove();
//        queue.remove();
//        queue.remove();
    }

}
