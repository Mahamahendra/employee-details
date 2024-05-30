package com.employee.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;
import com.employee.exception.InvalidException;
import com.employee.exception.NoValueException;
import com.employee.repository.EmployeeRepository;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository empRep;

	public String addEmployee(Employee e) {
		empRep.save(e);
		return "Succesfully Saved";
	}

	public String addMultiObj(List<Employee> multi) {
		empRep.saveAll(multi);
		return "SUCCESSFULLY SAVED";
	}

	public Optional<Employee> getEmployee(int id) {
		return empRep.findById(id);
	}

	public List<Employee> getAll() {
		return empRep.findAll();
	}

	public String getDelete(int id) {
		empRep.deleteById(id);
		return "SUCCESSFULLY DELETED";
	}

	public Employee getAges(Employee emp) {
		return empRep.save(emp);
	}

	public String getUpdate(Employee emp, int id) { // Update
		Employee m = empRep.findById(id).get();
		m.setName(emp.getName());
		m.setAge(emp.getAge());
		empRep.save(m);
		return "Updated Successfully";
	}

	public String getPatchUpdates(Employee em, int id) {
		Employee e = empRep.findById(id).get(); // get from dao
		e.setAge(em.getAge());
		e.setDesignation(em.getDesignation());
		// Values get from em & set the values to e.
		empRep.save(e);
		return "Patch Updated Successfully";
	}

	public List<Employee> getByQuery(int s1, int s2) {
		return empRep.getBySql(s1, s2);
	}

	public List<Employee> getVal(String val) {
		return empRep.getBySql1(val);
	}

	public List<Employee> getNew1(String name) {
		return empRep.getModName(name);
	}

	public List<Employee> getFirst(String name1) {
		return empRep.getFirstHalf(name1);
	}

	public List<Employee> getLimit(int a) {
		return empRep.getSal(a);
	}

	public List<Employee> getNGen(String name1, String name2) {
		return empRep.getGenName(name1, name2);
	}

	public List<Employee> getJquery(int s2, int s3) {
		return empRep.getJpaQuery(s2, s3);
	}

	public String addAge(Employee emp) {
		empRep.save(emp);
		return "Saved";
	}
	public Employee getEmpDetail(int id) throws NoValueException {
		Optional<Employee> em = empRep.findById(id);
		return em.orElseThrow(()-> new NoValueException("Invalid id"+id));
	}
}
