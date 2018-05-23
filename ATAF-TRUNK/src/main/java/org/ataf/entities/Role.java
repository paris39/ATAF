/**
 * 
 */
package org.ataf.entities;

import java.util.HashSet;
import java.util.Set;

//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;

/**
 * @author javier.paris
 */
//@Entity
//@Table(name = "LOGIN_ROL")
public class Role {
	
	private Integer id;
	private String name;
	private Boolean active;
	
	private Set<User> users = new HashSet<User>(0);
	
	/**
	 * Constructor
	 */
	public Role() {
	}
	
	/**
	 * @param id
	 * @param name
	 * @param active
	 */
	public Role(Integer id, String name, Boolean active) {
		this.id = id;
		this.name = name;
		this.active = active;
	}

	/**
	 * @return the id
	 */
//	@Id
//	@GeneratedValue
//	@Column(name = "ID")
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
//	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the active
	 */
//	@Column(name = "ACTIVE")
	public Boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	/**
	 * @return 
	 * @param object the Object
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (!this.getClass().equals(obj.getClass())) return false;

		Role obj2 = (Role)obj;
		if ((this.id == obj2.getId()) && (this.name.equals(obj2.getName()))) {
			return true;
		}
		return false;
	}
	
	/**
	 * @return
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		int tmp = 0;
		tmp = ( id + name ).hashCode();
		return tmp;
	}

	/**
	 * @return the users
	 */
	public Set<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
}