package org.fage.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t_person")
public class Person {
	private int id;
	private String name;
	private Date birthday;
	private IndentityCard card;
	
	
	@Temporal(TemporalType.DATE)
	public Date getBirthday() {
		return birthday;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToOne(mappedBy="person"
			//fetch=FetchType.LAZY缓慢的级联级别
			)
	public IndentityCard getCard() {
		return card;
	}

	public void setCard(IndentityCard card) {
		this.card = card;
	}
	
	
}
