package com.authservice.microservice.service;

import java.util.List;

import com.authservice.microservice.entity.Role;

public interface RoleService {
	public Role createRole(Role role);

	public List<Role> getAllRole();

	public Role getRoleById(Integer roleId);

	public Role deleteRoleById(Integer roleId);

}
