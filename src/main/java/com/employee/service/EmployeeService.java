package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;
import com.employee.exception.InvalidException;
import com.employee.exception.NoValueException;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empDao;

	public String addEmployee(Employee e) {
		return empDao.addEmployee(e);
	}

	public String addMultiObj(List<Employee> multi) {
		return empDao.addMultiObj(multi);
	}

	public Optional<Employee> getEmployee(int id) {
		return empDao.getEmployee(id);
	}

	public List<Employee> getAll() {
		return empDao.getAll();
	}

	public String getDelete(int id) {
		return empDao.getDelete(id);
	}

	public List<Employee> getByName(String name) {
		return this.getAll().stream().filter(x -> x.getName().equals(name)).toList();
	}

	public List<String> getBySalary(int sal1, int sal2) {
		return this.getAll().stream().filter(y -> y.getSalary() > sal1 && y.getSalary() < sal2).map(y -> y.getName())
				.toList();
	}

	public String getAge(int major) {
		this.getAll().stream().filter(z -> z.getAge() > major).toList();
		return "saved";
	}

	public List<Employee> getGen(String genz) {
		return this.getAll().stream().filter(g -> g.getGender().equals(genz)).toList();
	}

	/*public List<Employee> getMax(){
		List<Employee> e = getAll();
		List<Employee> max = e.stream().filter(x-> x.getSalary() .map(s1-> s1.getName()).toList());
	}*/

	public String getAges(Employee emp) {
		if (emp.getAge() > 18) {
			empDao.getAges(emp);
			return "Eligible";
		}
		return "Not ELigible to work";

	}

	public String getUpdate(Employee emp, int id) {
		return empDao.getUpdate(emp, id);
	}

	public String getPatchUpdates(Employee em, int id) {
		return empDao.getPatchUpdates(em, id);
	}

	public String getUp(Employee ep, int id) {
		Employee e1 = empDao.getEmployee(id).get(); // findById method here get
		e1.setDesignation(ep.getDesignation());
		empDao.addEmployee(e1);
		return "Updated Designation";
	}

	public List<Employee> getByQuery(int s1, int s2) {
		return empDao.getByQuery(s1, s2);
	}

	public List<Employee> getVal(String val) {
		return empDao.getVal(val);
	}

	public List<Employee> getNew1(String name) {
		return empDao.getNew1(name);
	}

	public List<Employee> getFirst(String name1) {
		return empDao.getFirst(name1);
	}

	public List<Employee> getLimit(int a) {
		return empDao.getLimit(a);
	}

	public List<Employee> getNGen(String name1, String name2) {
		return empDao.getNGen(name1, name2);
	}

	public List<Employee> getJquery(int s2, int s3) {
		return empDao.getJquery(s2, s3);
	}

	// Exception
	public String addAge(Employee emp) throws InvalidException {
		try {
			if (emp.getAge() >= 18) {
				empDao.addAge(emp);
				return "Employee Added Successfully";
			} else {
				throw new InvalidException("Employee Not Added");
			}
		} catch (InvalidException e) {
			return e.getMessage();
		}

	}

	public List<Employee> exeByName(String name) throws InvalidException {
		// Service Method
		List<Employee> e = empDao.getAll();
		List<Employee> emp = e.stream().filter(x -> x.getName().equals(name)).toList();
		if (emp.isEmpty()) {
			throw new InvalidException("There is No Data Base in this Name");
		} else {
			return emp;
		}
		/* 1 Service method
		 * List<Employee> e = this.getAll().stream().filter(x ->
		 * x.getName().equals(name)).toList(); if (e.isEmpty()) { throw new
		 * InvalidException("Not stored"); } else { return empDao.exeByName(name);
		 */
		/* 2 Dao method
		 * public List<Employee> exeByName(String name) { return
		 * empRep.getModName(name); }
		 */
	}

	public Employee getEmpDetail(int id) throws NoValueException {
		return empDao.getEmpDetail(id);
	}
}
