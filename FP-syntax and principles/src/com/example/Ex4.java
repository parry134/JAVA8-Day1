package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.IntPredicate;


/**
 * 
 * @author nag-training
 *
 *
 *         FP => principles
 *
 *
 *         functions are first-class values/citizens
 *
 *         => A function can be stored in a variable 
 *         => A parameter of a function can be a function 
 *         => The return value of a function can be a function
 * 
 * 
 * 
 * 
 *         Higher-Order-Programming/Function:
 *
 *
 *         A function that does at least one of the following is a Higher Order
 *         Function.
 *
 *
 *         1. Takes one or more functions as arguments 
 *         2. Returns a function as its result.
 *
 *
 *         why we need HOF?
 * 
 * 
 *         ==> promotes function-composition
 * 
 *         -> can build complex algorithms from small functions by composing
 * 
 * 
 * 
 * 
 */

public class Ex4 {

	public static IntPredicate and(IntPredicate predicate1, IntPredicate predicate2) {
		return n -> {
			return predicate1.test(n) && predicate2.test(n);
		};
	}

	public static void main(String[] args) {

		// -------------------------------------------------

		IntPredicate isMin = n -> n >= 100;
		IntPredicate isMax = n -> n <= 1000;

//		IntPredicate andPredicate=and(isMin, isMax); // function composition  with HOF
		// or
		IntPredicate andPredicate = isMin.and(isMax); // function composition with HOF

		boolean result = andPredicate.test(500);
		System.out.println(result);

		// -------------------------------------------------

		Consumer<String> consoleLogger = log -> System.out.println(log);
		Ex4 ex3 = new Ex4();
		Consumer<String> fileLogger = log -> ex3.writeInLogFile(log);

		String message = "session started..";

		//way-1
//		consoleLogger.accept(message);
//		fileLogger.accept(message);

//		way-2
		Consumer<String> logger = consoleLogger.andThen(fileLogger); // function composition with HOF
		logger.accept(message);

		// ----------------------------------------------------------

		Employee employee1 = new Employee("Nag", 1000.00);
		Employee employee2 = new Employee("Nag", 10000.00);

		Comparator<Employee> byName = (e1, e2) -> e1.getName().compareTo(e2.getName());
		Comparator<Employee> bySalary = (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary());

		Comparator<Employee> byNameAndbySalary = byName.thenComparing(bySalary); // function composition with HOF

		int diff = byNameAndbySalary.compare(employee1, employee2);
		System.out.println(diff);

		// -----------------------------------------------------------

	}

	private static FileWriter out = null;

	public Ex4() {
		try {
			out = new FileWriter("log.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeInLogFile(String log) {
		try {
			out.write(log);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

class Employee {
	private String name;
	private double salary;

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
