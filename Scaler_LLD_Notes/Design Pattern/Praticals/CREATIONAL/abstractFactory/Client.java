package creational.abstractFactory;

import creational.abstractFactory.model.Employee;
import creational.abstractFactory.model.InternEmployee;
import creational.abstractFactory.taxCalculator.TaxCalculator;
import creational.abstractFactory.taxCalculator.TaxCalculatorFactory;

public class Client {

//Problem is : client have set of employees and want to calculate tax on them.
	
	public static void main(String[] args) {
		Employee e = new InternEmployee();
		e.setSalary(100);
		
		TaxCalculatorFactory taxcalc= new TaxCalculatorFactory();
		
		System.out.println(taxcalc.getTaxCalculator(e).caltax(e));
	}
}
