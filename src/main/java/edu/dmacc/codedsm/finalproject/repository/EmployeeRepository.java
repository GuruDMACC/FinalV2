package edu.dmacc.codedsm.finalproject.repository;

import edu.dmacc.codedsm.finalproject.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeRepository implements Repository {

    private Map<String, Employee> employees = new HashMap<>();

    public List<Employee> getAll() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList = employees.values().stream().collect(Collectors.toList());
        return employeeList;
    }

    public Employee getById(String id) {
        Employee employee = employees.get(id);
        return employee;
    }

    @Override
    public void save(Employee employee) {
        employees.put(employee.getId().toString(), employee);
    }
}
