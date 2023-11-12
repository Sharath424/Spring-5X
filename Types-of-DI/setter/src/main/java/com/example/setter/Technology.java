package com.example.setter;


public class Technology {
    private Employee employee;


    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    public void start() {
        System.out.println("employee is  good at  " + employee.getUser() );
    }
}