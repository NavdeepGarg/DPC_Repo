package creational.abstractFactory.taxCalculator;

import creational.abstractFactory.model.Employee;

public class InternEmpTaxCalculator implements TaxCalculator {
	
	

	@Override
	public double caltax(Employee e) {
		
		return .5*e.getSalary();
	}
	
	

}