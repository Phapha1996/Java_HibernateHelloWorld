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
	//һ���ⷽĬ����lazy����˼������ͬһ��session���棬�㲻Ҫ���ҾͲ�����ȡ�Է���
	//����Ƿ���Eager����˼�������ϸ���ȡ�Է�����
	//˫��mappedBy���裬������ע�ӵ��Ƿ���Ҳ�������������һ������
	//@JoinColumn(name="department_id")
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	
	
	
}
