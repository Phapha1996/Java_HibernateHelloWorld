package org.fage.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="t_indentityCard")
public class IndentityCard {
	private int id;
	private int number;
	private String address;
	private Person person;

	
	public String getAddress() {
		return address;
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public int getNumber() {
		return number;
	}
	@OneToOne(cascade=CascadeType.ALL,
			  fetch=FetchType.EAGER)//设置级联增删改
	@JoinColumn(name="person_id")
	public Person getPerson() {
		return person;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	
	
	
}
