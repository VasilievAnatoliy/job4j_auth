package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.domain.Employee;
import ru.job4j.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employees;


    public EmployeeService(EmployeeRepository employees) {
        this.employees = employees;
    }

    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        employees.findAll().forEach(employeeList::add);
        return employeeList;
    }
}
