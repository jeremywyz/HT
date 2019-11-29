package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import cn.tarena.ht.pojo.User;

public interface UserMapper {
	public List<User> findAll();
	
	public void updateState(@Param("userIds")String[] userIds, @Param("state")int state);

	public void deleteUsers(String[] userIds);

	public void save(User user);
	
	@Insert("insert into role_user_p (role_id,user_id) values(#{roleId},#{userId})")
	public void saveUser_Role(@Param("roleId")String roleId, @Param("userId")String userId);
	
	@Delete("delete from role_user_p where user_id = #{userId}")
	public void deleteUserRoleByUserId(String userId);

	public User findUserAndPassword(@Param("userName") String userName, @Param("password")String password);
	
	public User findUserByUsername(String username);
	
}
