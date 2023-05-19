package com.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao ed;

	public String setEmp(List<Employee> emp) {
		return ed.setEmp(emp);
	}

	public List<Employee> getByGender(String gender) {
		List<Employee> allEmployee = ed.getAllEmployee();
		return allEmployee.stream().filter(x -> x.getGender().equalsIgnoreCase("female")).toList();

	}

	public List<Employee> getBySalary(int salary1, int salary2) {
		List<Employee> allEmployee = ed.getAllEmployee();
		return allEmployee.stream().filter(x -> x.getSalary() >= salary1 && x.getSalary() <= salary2).toList();

	}

	public List<Employee> getByName(String name) {
		List<Employee> allEmployee = ed.getAllEmployee();
		return allEmployee.stream().filter(x -> x.getName().equalsIgnoreCase(name)).toList();

	}

	public List<Employee> getById(int id) {
		List<Employee> allEmployee = ed.getAllEmployee();
		return allEmployee.stream().filter(x -> x.getId() == id).toList();

	}

	public List<Employee> getByNames(String name) {
		return ed.getByNames(name);
	}

	public List<Employee> contains(String name) {
		return ed.contains(name);
	}

	public List<Employee> getbygender(String gender) {
		return ed.getbygender(gender);
	}

	public List<Employee> getbyage(int age) {
		return ed.getbyage(age);
	}

	public List<Employee> getbysalary(int salary1, int salary2) {
		return ed.getbysalary(salary1, salary2);
	}

	public List<Employee> sortAsc() {
		return ed.sortAsc();
	}

	public List<Employee> sortDesc() {
		return ed.sortDesc();
	}

	public Employee getMax() {
		return ed.getMax();
	}

	public Employee getMin() {
		return ed.getMin();
	}

	public List<Employee> getSecMax() {
		return ed.getSecMax();
	}

	public Employee getSecMin() {
		return ed.getSecMin();
	}

	public List<Employee> getsalarybyrange(int a, int b) {
		List<Employee> allEmployee = ed.getAllEmployee();
		return allEmployee.stream().filter(x -> x.getSalary() >= a && x.getSalary() <= b).toList();
	}

	// Exception starts
	public Employee findbyId(int a) throws EmployeeNotFoundException {
		return ed.findbyId(a);
	}

	public List<Employee> getByNam(String name) throws NameNotFoundException {
		return ed.getByNam(name);
	}

	public String setEmps(List<Employee> emp) throws AgeLimitException  {
		for(Employee x:emp) {
			if(x.getAge()<18) {
				throw new AgeLimitException() ;
			}
		}
		return setEmps(emp);
	}
}
