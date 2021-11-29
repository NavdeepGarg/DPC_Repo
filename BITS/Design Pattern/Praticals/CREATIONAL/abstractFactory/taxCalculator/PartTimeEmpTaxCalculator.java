package creational.abstractFactory.taxCalculator;

import creational.abstractFactory.model.Employee;

public class PartTimeEmpTaxCalculator implements TaxCalculator {
	
	

	@Override
	public double caltax(Employee e) {
		
		return .1*e.getSalary();
	}
	
	

}
