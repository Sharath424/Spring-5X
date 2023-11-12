package com.example.cons;


public class Technology {
    private Employee employee;

    public Technology(Employee employee) {
        this.employee = employee;
    }

    public void start() {
        System.out.println("employee is  good at  " + employee.getUser() );
    }
}
