package edu.dmacc.codedsm.finalproject.controller;

import edu.dmacc.codedsm.finalproject.repository.EmployeeRepository;
import edu.dmacc.codedsm.finalproject.service.PayrollService;
import edu.dmacc.codedsm.finalproject.service.PayrollServiceImpl;

public class PayrollControllerImpl implements PayrollController {
	
    private PayrollService payrollService = new PayrollServiceImpl();
    private EmployeeRepository employees;

    

	public PayrollControllerImpl(EmployeeRepository employees) {
		super();
		this.employees = employees;
	}

	@Override
    public void processPayroll() {
        payrollService.processPayroll(employees);
        savePayrollToFile(employees);
    }

    private void savePayrollToFile(EmployeeRepository employees) {
        payrollService.savePayrollToFile(employees);
    }

	 
};

