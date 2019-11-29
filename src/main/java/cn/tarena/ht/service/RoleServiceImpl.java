package cn.tarena.ht.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.RoleMapper;
import cn.tarena.ht.pojo.Role;
@Service
public class RoleServiceImpl implements RoleService {
	
	@Resource
	private RoleMapper roleMapper;
	
	@Override
	public List<Role> findAll() {
		
		return roleMapper.findAll();
	}

	@Override
	public void saveRole(Role role) {
		//补齐角色信息
		role.setRoleId(UUID.randomUUID().toString());
		role.setCreateTime(new Date());
		roleMapper.saveRole(role);
		
	}

	@Override
	public Role findOne(String roleId) {
		
		return roleMapper.findOne(roleId);
	}

	@Override
	public void update(Role role) {
		
		roleMapper.update(role);
		
	}

	@Override
	public void deleteRoles(String[] roleId) {
		
		roleMapper.deleteRoles(roleId);
		//删除中间表的 角色ID
		roleMapper.deleteR_M(roleId);
	}

	@Override
	public List<String> findRoleListByUserId(String userId) {
		
		return roleMapper.findRoleListByUserId(userId);
	}

	@Override
	public void saveRoleModule(String roleId, String[] moduleIds){
		
		//多对多实现插入 先删除后插入
		
		roleMapper.deleteR_MByRoleId(roleId);
		
		//Thread.sleep(3000); //因项目经理要求，后期维护时 qudiao
		
		//循环遍历执行插入操作
		for (String moduleId : moduleIds) {
			roleMapper.saveRoleModule(roleId,moduleId);
		}
		
		
	}

}
