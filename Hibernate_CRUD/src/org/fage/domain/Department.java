package org.fage.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_department")
public class Department {
	private int id;
	private String name;
	private Set<Employee> employees = new HashSet<Employee>();

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(mappedBy="department",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	//一的这方默认是lazy，意思就是在同一个session里面，你不要，我就不给你取对方。
	//多的那方是Eager，意思是我马上给你取对方出来
	//双向mappedBy必设，用来标注从的那方，也就是外键列在另一个表中
	//@JoinColumn(name="department_id")
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	
	
	
}
