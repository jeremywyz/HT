package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.Role;

public interface RoleService {
	public List<Role> findAll();

	public void saveRole(Role role);

	public Role findOne(String roleId);

	public void update(Role role);

	public void deleteRoles(String[] roleId);

	public List<String> findRoleListByUserId(String userId);

	public void saveRoleModule(String roleId, String[] moduleIds);
}
