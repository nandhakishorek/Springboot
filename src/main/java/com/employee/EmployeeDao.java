package com.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository er;

	public String setEmp(List<Employee> emp) {
		er.saveAll(emp);
		return "Saved";
	}

	public List<Employee> getAllEmployee() {
		return er.findAll();
	}

	public List<Employee> getByNames(String name) {
		return er.getByNames(name);

	}

	public List<Employee> contains(String name) {
		return er.contains(name);
	}

	public List<Employee> getbygender(String gender) {
		return er.getByGender(gender);
	}

	public List<Employee> getbyage(int age) {
		return er.getbyage(age);
	}

	public List<Employee> getbysalary(int salary1, int salary2) {
		return er.getbysalary(salary1, salary2);
	}
	 public List<Employee> sortAsc(){
		return er.sortAsc();
	}
	
	public List<Employee> sortDesc(){
		return er.sortDesc();
	}
	
	public Employee getMax(){
		return er.getMax();
	}
	
	public Employee getMin(){
		return er.getMin();
	}
	
	public List<Employee> getSecMax(){
		return er.getSecMax();
	}
	
	public Employee getSecMin(){
		return er.getSecMin();
	}
	 //Exception starts
	public Employee findbyId(int a) throws EmployeeNotFoundException{
		return er.findById(a).orElseThrow(()-> new EmployeeNotFoundException());
	}
  
	public List<Employee> getByNam(String name) throws NameNotFoundException {
		if(er.getByNames(name).isEmpty()) {
			throw new NameNotFoundException();
		}
		else {
			return er.getByNames(name);
		}
	}
	public String setEmps(List<Employee> emp){
		er.saveAll(emp);
		return "Posted Successfully";
	}

}
