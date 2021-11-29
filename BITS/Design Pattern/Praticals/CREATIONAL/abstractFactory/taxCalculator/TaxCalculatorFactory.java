package creational.abstractFactory.taxCalculator;

import creational.abstractFactory.model.Employee;
import creational.abstractFactory.model.EmployeeType;

public class TaxCalculatorFactory   {
	
	public TaxCalculator getTaxCalculator(Employee e) {
		
		if(e.getEmpType()==EmployeeType.FULLTIME) {
			return new PermanentEmpTaxCalculator();
		}
		if(e.getEmpType()==EmployeeType.INTERN) {
			return new InternEmpTaxCalculator();
		}
		if(e.getEmpType()==EmployeeType.PARTIME) {
			return new PartTimeEmpTaxCalculator();
		}
		return null;
	}

}
