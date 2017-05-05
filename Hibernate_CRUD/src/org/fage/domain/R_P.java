/*package org.fage.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="r_p")
public class R_P {
	//Privilege与Role的中间表
	private int id;
	private Privilege privilege;
	private Role role;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	
	@ManyToOne
	@JoinColumn(name="privilege_id")
	public Privilege getPrivilege() {
		return privilege;
	}
	
	
	@ManyToOne
	@JoinColumn(name="role_id")
	public Role getRole() {
		return role;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
*/