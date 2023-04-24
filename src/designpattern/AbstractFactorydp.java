package designpattern;

//Employee class hierarchy
abstract class Employeei {
	protected String name;
	protected double salary;

	public Employeei(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public abstract void paySalary();
}

class FullTimeEmployee extends Employeei {
	public FullTimeEmployee(String name, double salary) {
		super(name, salary);
	}

	public void paySalary() {
		System.out.println("Paying full-time employee " + name + " salary of " + salary);
	}
}

class PartTimeEmployee extends Employeei {
	public PartTimeEmployee(String name, double salary) {
		super(name, salary);
	}

	public void paySalary() {
		System.out.println("Paying part-time employee " + name + " salary of " + salary);
	}
}

//Abstract factory interface
interface EmployeeFactory {
	public Employeei createEmployee(String name, double salary);
}

//Concrete factory classes
class FullTimeEmployeeFactory implements EmployeeFactory {
	public Employeei createEmployee(String name, double salary) {
		return new FullTimeEmployee(name, salary);
	}
}

class PartTimeEmployeeFactory implements EmployeeFactory {
	public Employeei createEmployee(String name, double salary) {
		return new PartTimeEmployee(name, salary);
	}
}

//Client class
class EmployeePayroll {
	private EmployeeFactory factory;

	public EmployeePayroll(EmployeeFactory factory) {
		this.factory = factory;
	}

	public void paySalary(String name, double salary) {
		Employeei employee = factory.createEmployee(name, salary);
		employee.paySalary();
	}
}

//Example usage
public class AbstractFactorydp {
	public static void main(String[] args) {
		EmployeeFactory fullTimeFactory = new FullTimeEmployeeFactory();
		EmployeeFactory partTimeFactory = new PartTimeEmployeeFactory();

		EmployeePayroll fullTimePayroll = new EmployeePayroll(fullTimeFactory);
		fullTimePayroll.paySalary("Ram", 15000.0);

		EmployeePayroll partTimePayroll = new EmployeePayroll(partTimeFactory);
		partTimePayroll.paySalary("Shiva", 20500.0);
	}
}