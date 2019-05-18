package com.calendar.services;

import com.calendar.entity.Employee;
import com.calendar.entity.EmployeeInvite;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public void addEmployee(String employeeName) {
        Employee employee = new Employee();
        employee.setName(employeeName);
        DBService.employeeList.add(employee);
    }

    @Override
    public List<EmployeeInvite> getEmployeeMeetings(String employeeName) {
        return DBService.employeeInviteList.stream()
                .filter(employeeInvite -> employeeInvite.getEmployee().getName().equals(employeeName))
                .collect(Collectors.toList());
    }

    @Override
    public Employee getEmployee(String name) {
        System.out.println(DBService.employeeList);
        System.out.println(name);
        return DBService.employeeList.stream()
                .filter(employee -> employee.getName().equals(name)).findAny().get();
    }
}
