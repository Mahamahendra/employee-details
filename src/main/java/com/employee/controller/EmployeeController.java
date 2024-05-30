package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.exception.InvalidException;
import com.employee.exception.NoValueException;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee") // 17.5.24
public class EmployeeController {
	@Autowired // @AutoWired annotation will create an object automatically,
				// so we do not need to use the ‘new’ keyword to create an object.
				// Thus helping us achieve loose coupling
	EmployeeService empser;

	@PostMapping(value = "/save")

	public String addEmployee(@RequestBody Employee e) { // Save()
		return empser.addEmployee(e);
	}

	@PostMapping(value = "/saveAll")
	public String addMultiObj(@RequestBody List<Employee> multi) { // SaveAll()
		return empser.addMultiObj(multi);
	}

	@GetMapping(value = "/obj/{id}")
	public Optional<Employee> getEmployee(@PathVariable int id) { // FindById()
		return empser.getEmployee(id);
	}

	@GetMapping(value = "/all")
	public List<Employee> getAll() { // FindAll()
		return empser.getAll();
	}

	@DeleteMapping(value = "/delete/{id}")
	public String getDelete(@PathVariable int id) { // DeleteId()
		return empser.getDelete(id);
	}

	@GetMapping(value = "/getByName/{name}")
	public List<Employee> getByName(@PathVariable String name) { // get by name = give input as any name in db, it will
																	// show the name details.
		return empser.getByName(name);
	}

	@GetMapping(value = "/salary/{sal1}/{sal2}") // 2 salary = give i/p as (sal1=10000 & sal2=50000) it will filter and
													// o/p as name.
	public List<String> getBySalary(@PathVariable int sal1, @PathVariable int sal2) {
		return empser.getBySalary(sal1, sal2);
	}

	@GetMapping(value = "/18/{major}") // Above 18 = store the employee in db.
	public String getAge(@PathVariable int major) {
		return empser.getAge(major);
	}

	/*
	 * @GetMapping(value = "/maxsal") public List<Employee> getMax() { return
	 * empser.getMax(); }
	 */

	@GetMapping(value = "/gen/{genz}") // Gender
	public List<Employee> getGen(@PathVariable String genz) {
		return empser.getGen(genz);
	}

	@PostMapping(value = "/above")
	public String getAges(@RequestBody Employee emp) {
		return empser.getAges(emp);
	}

	// 20.5.24
	@PutMapping(value = "/update/{id}") // Update save() method
	public String getUpdate(@RequestBody Employee emp, @PathVariable int id) {
		return empser.getUpdate(emp, id);
	}

	@PatchMapping(value = "/patchupdate/{id}") // update method using patchMapping
	public String getPatchUpdates(@RequestBody Employee em, @PathVariable int id) {
		return empser.getPatchUpdates(em, id);
	}

	@PutMapping(value = "/updateservice/{id}")
	public String getUp(@RequestBody Employee ep, @PathVariable int id) {
		return empser.getUp(ep, id);
	}
	// Using MysqlQuery

	@GetMapping(value = "/getQuery/{s1}/{s2}")
	public List<Employee> getBYQuery(@PathVariable int s1, @PathVariable int s2) {
		return empser.getByQuery(s1, s2);
	}

	@GetMapping(value = "/getval/{val}")
	public List<Employee> getVal(@PathVariable String val) { // Get by name = o/p is Name and their details
		return empser.getVal(val);
	}

	@GetMapping(value = "/nameDetails/{name}")
	public List<Employee> getNew1(@PathVariable String name) { // i/p = jay; o/p = vijay name details
		return empser.getNew1(name);
	}

	@GetMapping(value = "/first/{name1}")
	public List<Employee> getFirst(@PathVariable String name1) {
		return empser.getFirst(name1);
	}

	@GetMapping(value = "/limitvalue/{a}")
	public List<Employee> getLimit(@PathVariable int a) {
		return empser.getLimit(a);
	}

	@GetMapping(value = "/nameGen/{name1}/{name2}")
	public List<Employee> getNGen(@PathVariable String name1, @PathVariable String name2) {
		return empser.getNGen(name1, name2);
	}

	// Jpa Query
	@GetMapping(value = "/Jpa/{s2}/{s3}")
	public List<Employee> getJquery(@PathVariable int s2, @PathVariable int s3) { // i/p =
		return empser.getJquery(s2, s3);
	}

	// Exception
	@PostMapping(value = "/exceptionAge")
	public String addAge(@RequestBody Employee emp) throws InvalidException {
		return empser.addAge(emp);
	}

	@GetMapping(value = "/excName/{name}")
	public List<Employee> exeByName(@PathVariable String name) throws InvalidException {
		return empser.exeByName(name);
	}
	@GetMapping(value="/IdCheck/{id}")
	public Employee getEmpDetail(@PathVariable int id) throws NoValueException {
		return empser.getEmpDetail(id);
	}
}
