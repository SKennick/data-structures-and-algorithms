package com.kennick;

public class EmployeeDoubleLinkedList {

    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addToFront(Employee employee) {
        EmployeeNode employeeNode = new EmployeeNode(employee);
        if (head != null) {
            EmployeeNode oldHead = head;
            employeeNode.setNext(oldHead);
            oldHead.setPrevious(employeeNode);
        } else {
            tail = employeeNode;
        }
        head = employeeNode;
        size++;
    }

    public void addToEnd(Employee employee) {
        EmployeeNode newTail = new EmployeeNode(employee);
        if (size > 0) {
            EmployeeNode oldTail = tail;
            oldTail.setNext(newTail);
            newTail.setPrevious(oldTail);
        } else {
            head = newTail;
        }
        tail = newTail;
        size++;
    }

    public boolean addBefore(Employee newEmployee, Employee before) {
        EmployeeNode newNode = new EmployeeNode(newEmployee);

        if (size == 0) {
            return false;
        }

        EmployeeNode insertBefore = head;
        while (insertBefore != null && !insertBefore.getEmployee().equals(before)) {
            insertBefore = insertBefore.getNext();
        }

        if (insertBefore == null) {
            return false;
        }

        if (insertBefore.getEmployee().equals(head.getEmployee())) {
            this.addToFront(newEmployee);
        } else {
            insertBefore.getPrevious().setNext(newNode);
            newNode.setPrevious(insertBefore.getPrevious());
            newNode.setNext(insertBefore);
            insertBefore.setPrevious(newNode);
            size++;
        }
        return true;
    }

    public EmployeeNode getHead() {
        return head;
    }

    public EmployeeNode getTail() {
        return tail;
    }

    public String printList() {
        StringBuilder print = new StringBuilder("HEAD -> ");
        EmployeeNode node = head;
        while (node != null) {
            print.append(node.toString());
            print.append(" <-> ");
            node = node.getNext();
        }
        print.append("null");
        return print.toString();
    }
}
