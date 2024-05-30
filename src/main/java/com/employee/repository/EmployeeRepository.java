package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query(value = "select * from employees where salary>=? AND salary<=?", nativeQuery = true) // here mentioned
																								// (nativeQuery =true)
																								// it is from mysqlquery so
																								// we put true.
	public List<Employee> getBySql(int sal1, int sal2);

	@Query(value = "select * from employees where name=?", nativeQuery = true)
	public List<Employee> getBySql1(String val1);

	@Query(value = "select * from employees where name like %?", nativeQuery = true)
	public List<Employee> getModName(String val2);

	@Query(value = "select * from employees where name like ?%", nativeQuery = true)
	public List<Employee> getFirstHalf(String val3);

	@Query(value = "select * from employees order by salary desc limit ?", nativeQuery = true)
	public List<Employee> getSal(int sal3);

	@Query(value = "select * from employees where name=? AND gender=?", nativeQuery = true)
	public List<Employee> getGenName(String a, String b);

	// JPA Query
	@Query(value = "select e from Employee e where e.salary>=:sal1 AND e.salary<=:sal2")
	public List<Employee> getJpaQuery(@Param("sal1") int sal1, @Param("sal2") int sal2);
	/*@Query(value="select emp from Employee emp where emp.name")
	public List<Employee> getNm(@Param() )*/
}
