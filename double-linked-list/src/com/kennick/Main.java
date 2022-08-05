package com.kennick;

public class Main {

    public static void main(String[] args) {
        Employee employee1 = new Employee("Steven", "Kennick", 1);
        Employee employee2 = new Employee("John", "Smith", 2);
        Employee employee3 = new Employee("Sara", "Jean", 3);
        Employee employee4 = new Employee("Archie", "Bunker", 4);

        EmployeeDoubleLinkedList list = new EmployeeDoubleLinkedList();
        System.out.println("Is Empty? " + list.isEmpty());
        list.addToFront(employee1);
        System.out.println("Added one employee");
        System.out.println("Head " + list.getHead().toString());
        System.out.println("Tail " + list.getTail().toString());
        System.out.println("Size " + list.getSize());
        list.addToFront(employee2);
        System.out.println("Added second employee");
        System.out.println("Head " + list.getHead().toString());
        System.out.println("Tail " + list.getTail().toString());
        System.out.println("Size " + list.getSize());
        list.addToFront(employee3);
        System.out.println("Added third employee");
        System.out.println("Head " + list.getHead().toString());
        System.out.println("Tail " + list.getTail().toString());
        System.out.println("Size " + list.getSize());
        list.addToFront(employee4);

        System.out.println("Size " + list.getSize());
        System.out.println("Is Empty? " + list.isEmpty());
        System.out.println(list.printList());

        System.out.println("============================================================");

        EmployeeDoubleLinkedList list2 = new EmployeeDoubleLinkedList();
        System.out.println("Is Empty? " + list2.isEmpty());
        list2.addToEnd(employee1);
        System.out.println("Added one employee");
        System.out.println("Head " + list2.getHead().toString());
        System.out.println("Tail " + list2.getTail().toString());
        System.out.println("Size " + list2.getSize());
        list2.addToEnd(employee2);
        System.out.println("Added second employee");
        System.out.println("Head " + list2.getHead().toString());
        System.out.println("Tail " + list2.getTail().toString());
        System.out.println("Size " + list2.getSize());
        list2.addToEnd(employee3);
        System.out.println("Added third employee");
        System.out.println("Head " + list2.getHead().toString());
        System.out.println("Tail " + list2.getTail().toString());
        System.out.println("Size " + list2.getSize());
        list2.addToEnd(employee4);

        System.out.println("Size " + list2.getSize());
        System.out.println("Is Empty? " + list2.isEmpty());
        System.out.println(list2.printList());

        System.out.println("Inserting New Employee");
        list2.addBefore(new Employee("New", "Employee", 5), employee3);
        System.out.println("Size " + list2.getSize());
        System.out.println(list2.printList());

        System.out.println("Inserting New Head");
        list2.addBefore(new Employee("New", "Head", 6), employee1);
        System.out.println("Size " + list2.getSize());
        System.out.println("Head " + list2.getHead().toString());
        System.out.println("Tail " + list2.getTail().toString());
        System.out.println(list2.printList());

        System.out.println("Inserting Not Found");
        list2.addBefore(new Employee("New", "Head", 6), new Employee("Test", "Fake", 7));
        System.out.println("Size " + list2.getSize());
        System.out.println("Head " + list2.getHead().toString());
        System.out.println("Tail " + list2.getTail().toString());
        System.out.println(list2.printList());
    }

}
