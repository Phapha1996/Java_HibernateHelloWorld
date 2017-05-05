package org.fage.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t_privilege")
public class Privilege {
	private int id;
	private String name;
	private Date makeTime;
	private Set<Role> roles = new HashSet<Role>();
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	@Temporal(TemporalType.TIME)
	public Date getMakeTime() {
		return makeTime;
	}
	public String getName() {
		return name;
	}
	
	@ManyToMany(mappedBy="privileges",cascade=CascadeType.ALL,fetch=FetchType.LAZY,targetEntity=Role.class)
	/*@JoinTable(
			name="r_p",
			joinColumns={@JoinColumn(name="privilege_id",referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="role_id",referencedColumnName="id")}
			)*/
	public Set<Role> getRoles() {
		return roles;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMakeTime(Date makeTime) {
		this.makeTime = makeTime;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
