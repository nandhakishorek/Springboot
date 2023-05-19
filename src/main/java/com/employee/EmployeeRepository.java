package com.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "select * from emp_details where name like ? ", nativeQuery = true)
	public List<Employee> getByNames(String name);

	@Query(value = "select * from emp_details where name like %?% ", nativeQuery = true)
	public List<Employee> contains(String name);

	@Query(value = "select * from emp_details where gender like ? ", nativeQuery = true)
	public List<Employee> getByGender(String gender);

	@Query(value = " select * from emp_details where age > ? ", nativeQuery = true)
	public List<Employee> getbyage(int age);

	@Query(value = " select * from emp_details where salary >= ? and salary <= ? ", nativeQuery = true)
	public List<Employee> getbysalary(int salary1, int salary2);

	@Query(value = "select * from emp_details order by name", nativeQuery = true)
	public List<Employee> sortAsc();

	@Query(value = "select * from emp_details order by name desc", nativeQuery = true)
	public List<Employee> sortDesc();

	@Query(value = "select * from emp_details where salary = ( select max(salary) from emp_details)", nativeQuery = true)
	public Employee getMax();

	@Query(value = "select * from emp_details where salary = ( select min(salary) from emp_details)", nativeQuery = true)
	public Employee getMin();

	@Query(value = "select * from emp_details where salary = ( select max(salary) from emp_details where salary < ( select max(salary) from emp_details ))", nativeQuery = true)
	public List<Employee> getSecMax();

	@Query(value = "select * from emp_details order by salary asc limit 1,1 ", nativeQuery = true)
	public Employee getSecMin();

	@Query(value = " select * from emp_details where age > ? ", nativeQuery = true)
	public List<Employee> findbyage(int age);
	
}
