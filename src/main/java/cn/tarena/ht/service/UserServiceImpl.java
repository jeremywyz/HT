package cn.tarena.ht.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.UserInfoMapper;
import cn.tarena.ht.mapper.UserMapper;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.pojo.UserInfo;
import cn.tarena.ht.tool.MD5;
@Service
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private UserInfoMapper userInfoMapper;
	
	
	@Override
	public List<User> findAll() {
		
		return userMapper.findAll();
	}


	@Override
	public void updateState(String[] userIds, int state) {
		
		userMapper.updateState(userIds,state);
		
	}


	@Override
	public void deleteUsers(String[] userIds) {
		
		userMapper.deleteUsers(userIds);
		userInfoMapper.deleteUserInfo(userIds);
	}


	@Override
	public void save(User user) {
		
		//通过UUID获取ID值
		String userId = UUID.randomUUID().toString();
		
		//获取Userinfo对象
		UserInfo info = user.getUserInfo();
		
		//补齐user对象的数据
		user.setUserId(userId);
		user.setState(1);	//状态启用
		user.setCreateTime(new Date());
		
		//为用户的密码加密
		user.setPassword(MD5.getMd5Hash(user.getUsername(), user.getPassword()));
		
		//补齐userInfo对象的数据
		info.setUserInfoId(userId);
		info.setCreateTime(new Date());
		
		userMapper.save(user);
		userInfoMapper.saveUserInfo(info);
		
		
	}


	@Override
	public void saveUser_Role(String[] roleIds, String userId) {
		
		//为了防止重复提交 现做删除
		userMapper.deleteUserRoleByUserId(userId);
		
		
		//循环遍历执行插入操作
		for (String roleId : roleIds) {
			userMapper.saveUser_Role(roleId,userId);
		}
		
		
	}


	@Override
	public User findUserAndPassword(String userName, String password) {
		
		return userMapper.findUserAndPassword(userName,password);
	}


	@Override
	public User findUserByUsername(String username) {
		
		
		return userMapper.findUserByUsername(username);
	}

}
