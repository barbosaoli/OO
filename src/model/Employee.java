package model;

public class Employee extends Person {
	private double salary;
	private String address;

	public Employee(String name,String address, double salary,String cPF, int numID,Telefone numTel) {
		super(name, numID, cPF, numTel);
		this.salary = salary;
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalario(double salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	} 

	
	
}