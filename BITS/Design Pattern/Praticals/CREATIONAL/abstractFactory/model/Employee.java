package creational.abstractFactory.model;

import creational.abstractFactory.taxCalculator.TaxCalculator;

public abstract class Employee {
	
	private String name;
	private int id;
	 
	private double salary;
	
	private TaxCalculator taxCalculator;
	
	private EmployeeType empType;
	
	public Employee(EmployeeType empType) {
		this.empType=empType;
	 
	}
	
	
	public EmployeeType getEmpType() {
		return empType;
	}


	public void setEmpType(EmployeeType empType) {
		this.empType = empType;
	}


	public TaxCalculator getTaxCalculator() {
		return taxCalculator;
	}


	public void setTaxCalculator(TaxCalculator taxCalculator) {
		this.taxCalculator = taxCalculator;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	 
	

}
