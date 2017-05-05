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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_role")
public class Role {
	private int id;
	private String name;
	private Set<Privilege> privileges = new HashSet<Privilege>();
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=Privilege.class)
	@JoinTable(
			name="r_p",
			joinColumns={@JoinColumn(name="role_id",referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="privilege_id",referencedColumnName="id")}
			)
	public Set<Privilege> getPrivileges() {
		return privileges;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}
	
	
	
}
