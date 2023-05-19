package com.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestController
public class EmployeeController {
	@Autowired
	EmployeeService es;

	@PostMapping(value = "/setEmp")
	public String setEmp(@RequestBody List<Employee> emp) {
		return es.setEmp(emp);
	}

	@GetMapping(value = "/getEmpByGender/{gender}")
	public List<Employee> getByGender(@PathVariable String gender) {
		return es.getByGender(gender);
	}

	@GetMapping(value = "/getEmpBySalary/{salary1}/{salary2}")
	public List<Employee> getBySalary(@PathVariable int salary1, @PathVariable int salary2) {
		return es.getBySalary(salary1, salary2);
	}

	@GetMapping(value = "/getEmpByName/{name}")
	public List<Employee> getByName(@PathVariable String name) {
		return es.getByName(name);
	}

	@GetMapping(value = "/getEmpById/{id}")
	public List<Employee> getById(@PathVariable int id) {
		return es.getById(id);
	}

	@GetMapping(value = "/getbyNames/{name}")
	public List<Employee> getByNam(@PathVariable String name) {
		return es.getByNames(name);
	}

	@GetMapping(value = "/contains/{name}")
	public List<Employee> contains(@PathVariable String name) {
		return es.contains(name);
	}

	@GetMapping(value = "/getbygender/{gender}")
	public List<Employee> getbygender(@PathVariable String gender) {
		return es.getbygender(gender);
	}

	@GetMapping(value = "/getbyage/{age}")
	public List<Employee> getbyage(@PathVariable int age) {
		return es.getbyage(age);
	}

	@GetMapping(value = "/getbysalary/{salary1}/{salary2}")
	public List<Employee> getbysalary(@PathVariable int salary1, @PathVariable int salary2) {
		return es.getbysalary(salary1, salary2);
	}

	@GetMapping(value = "/getsortasc")
	public List<Employee> sortAsc() {
		return es.sortAsc();
	}

	@GetMapping(value = "/getsortdesc")
	public List<Employee> sortDesc() {
		return es.sortDesc();
	}

	@GetMapping(value = "/getmax")
	public Employee getMax() {
		return es.getMax();
	}

	@GetMapping(value = "/getmin")
	public Employee getMin() {
		return es.getMin();
	}

	@GetMapping(value = "/getsecmax")
	public List<Employee> getSecMax() {
		return es.getSecMax();
	}

	@GetMapping(value = "/getsecmin")
	public Employee getSecMin() {
		return es.getSecMin();
	}
    @GetMapping(value ="/getbyrange/{a}/{b}")
    public List<Employee> getsalarybyrange(@PathVariable int a,@PathVariable int b) {
		return es.getsalarybyrange(a,b);
	}
  //Exception starts
    @GetMapping(value="/findbyIdEmp/{a}")
	public Employee findbyId(@PathVariable int a) throws EmployeeNotFoundException {
		return es.findbyId(a);
	}
    @GetMapping(value = "/findbyNames/{name}")
	public List<Employee> findbyNames(@PathVariable String name) throws NameNotFoundException {
		return es.getByNam(name);
    }
    @PostMapping(value = "/setEmp")
	public String setEmps(@RequestBody List<Employee> emp) throws AgeLimitException {
		return es.setEmps(emp);
    }

}
