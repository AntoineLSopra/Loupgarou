package fr.loupgarou.model;

import javax.persistence.*;

public class Participation {

	@Enumerated (EnumType.ORDINAL)
	private Role role = Role.LOUP;

	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
}
