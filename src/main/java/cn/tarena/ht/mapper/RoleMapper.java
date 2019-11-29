package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.tarena.ht.pojo.Role;

public interface RoleMapper {
	
/*	@Select
	@Insert
	@Update
	@Delete*/
	@Select(value="select * from role_p order by order_no")
	public List<Role> findAll();
	
	//由于sql语句过长，不便于读写。写到映射文件中
	//@Insert(value="insert into role_p (role_id,CREATE_BY) values ('2222',#{createBy,jdbcType=VARCHAR})")
	public void saveRole(Role role);
	
	@Select("select * from role_p where role_id = #{roleId}")
	public Role findOne(String roleId);
	
	public void update(Role role);
	
	public void deleteRoles(String[] roleId);
	
	//@Select("select role_id from role_user_p where user_id=#{userId}")
	public List<String> findRoleListByUserId(String userId);
	
	@Insert("insert into role_module_p (module_id,role_id) values(#{moduleId},#{roleId})")
	public void saveRoleModule(@Param("roleId")String roleId, @Param("moduleId")String moduleId);
	
	@Delete("delete from role_module_p where role_id = #{roleId}")
	public void deleteR_MByRoleId(String roleId);
	
	public void deleteR_M(String[] roleId);
}
