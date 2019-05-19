package edu.dmacc.codedsm.finalproject;

import edu.dmacc.codedsm.finalproject.controller.*;
import edu.dmacc.codedsm.finalproject.model.Employee;
import edu.dmacc.codedsm.finalproject.repository.EmployeeRepository;
import edu.dmacc.codedsm.finalproject.service.EmployeeService;
import edu.dmacc.codedsm.finalproject.service.EmployeeServiceImpl;
import edu.dmacc.codedsm.finalproject.view.AllEmployeeView;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        EmployeeRepository repository= new EmployeeRepository(); // should only have one repository
        EmployeeService service= new EmployeeServiceImpl(repository); // should only have one repository
        EmployeeController employeeController = new EmployeeControllerImpl(service);
        PayrollController payrollController = new PayrollControllerImpl(repository);
        DataLoadController dataLoadController = new DataLoadControllerImpl(repository);
        dataLoadController.load();

        System.out.println(repository);

        //MenuView view = new MenuView();
        //view.render(repository);

        boolean isRunning = true;
        Scanner in = new Scanner(System.in);

        while (isRunning) {
            System.out.println("1	List all known employees");
            System.out.println("2	Update an employee's hours ");
            System.out.println("3	Process payroll and exit");
            System.out.println("4	Exit");
            String response = in.next();


            if (response.equals("4")) {
                isRunning = false;
            } else if (response.equals("3")) {
                payrollController.processPayroll();
                isRunning = false;
            } else if (response.equals("2")) {
                System.out.print("Employee ID: ");
                String empId = in.next();
                Employee e = employeeController.getEmployee(empId);
                System.out.println("");
                if (e == null) {
                    System.out.println("Employee not found");
                } else {
                    System.out.print("Employee hours: ");
                    String empHours = in.next();
                    e.setHoursWorked(Integer.parseInt(empHours));
                    employeeController.updateEmployee(e);
                    System.out.println("");
                }
            } else if (response.equals("1")) {
                AllEmployeeView allView = employeeController.getAll();
                allView.render();
            }
            else
                System.out.println("Please enter 1, 2, 3, or 4.");
        }
    }
}

