package com.calendar.services;

import com.calendar.entity.Employee;
import com.calendar.entity.EmployeeInvite;

import java.util.List;

public interface EmployeeService {

    void addEmployee(String employeeName);
    List<EmployeeInvite> getEmployeeMeetings(String employeeName);

    Employee getEmployee(String name);
}
