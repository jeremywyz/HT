package cn.tarena.ht.service;

import java.util.List;

import cn.tarena.ht.pojo.User;

public interface UserService {
	public List<User> findAll();

	public void updateState(String[] userIds, int state);
	
	public void deleteUsers(String[] userIds);
	
	public void save(User user);

	public void saveUser_Role(String[] roleIds, String userId);
	
	public User findUserAndPassword(String userName, String password);

	public User findUserByUsername(String username);
}
