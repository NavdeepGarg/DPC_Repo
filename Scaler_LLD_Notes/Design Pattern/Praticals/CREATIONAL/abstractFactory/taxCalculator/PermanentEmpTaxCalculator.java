package creational.abstractFactory.taxCalculator;

import creational.abstractFactory.model.Employee;

public class PermanentEmpTaxCalculator implements TaxCalculator {
	
	

	@Override
	public double caltax(Employee e) {
		
		return .2*e.getSalary();
	}
	
	

}

