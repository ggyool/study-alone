package org.ggyool.daoexam.dto;

public class Role {
	private int roleId;
	private String description;
	public int getroleId() {
		return roleId;
	}
	public void setroleId(int roleId) {
		this.roleId = roleId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", description=" + description + "]";
	}	
}
