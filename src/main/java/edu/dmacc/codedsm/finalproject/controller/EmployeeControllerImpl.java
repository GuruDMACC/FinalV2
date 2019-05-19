package edu.dmacc.codedsm.finalproject.controller;

import edu.dmacc.codedsm.finalproject.model.Employee;
import edu.dmacc.codedsm.finalproject.repository.EmployeeRepository;
import edu.dmacc.codedsm.finalproject.service.EmployeeService;
import edu.dmacc.codedsm.finalproject.service.EmployeeServiceImpl;
import edu.dmacc.codedsm.finalproject.view.AllEmployeeView;

import java.util.List;

public class EmployeeControllerImpl implements EmployeeController {
	
    private   EmployeeService employeeService;

    public EmployeeControllerImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public AllEmployeeView getAll() {
        AllEmployeeView allEmployeeView = new AllEmployeeView();
        List<Employee> allEmployees = employeeService.getAll();
        allEmployeeView.setEmployees(allEmployees);
        return allEmployeeView;
    }

    @Override
    public Employee getEmployee(String empId) {
        return employeeService.getById(empId);
    }

    @Override
    public void updateEmployee(Employee emp) {
        employeeService.getById(emp.getId().toString()).setHoursWorked(emp.getHoursWorked());
    }
}




