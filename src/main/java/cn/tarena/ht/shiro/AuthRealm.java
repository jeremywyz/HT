package cn.tarena.ht.shiro;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.sun.org.apache.xerces.internal.xs.StringList;

import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.UserService;

public class AuthRealm extends AuthorizingRealm{
	@Resource
	private UserService userService;

	@Override
	//该方法是用来做权限管理
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection Principals) {
		
		//获取User对象---->查询该用户的角色列表------>查询模块信息
		User user = (User) SecurityUtils.getSubject().getPrincipal();
//		List<String> userPrivilegeInfo = userService.findPrivilegeInfo(user.getUserId());
		
		//用户准备权限数据交给shiro
		List<String> privilegeInfo = new ArrayList<String>();
		privilegeInfo.add("货运管理");
		privilegeInfo.add("基础信息");
		privilegeInfo.add("系统管理");
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		info.addStringPermissions(privilegeInfo);
		
		return info;
	}

	@Override
	//该方法是用来做认证模块
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		/**
		 * 该Realm是为shiro安全管理器 通过用来认证的realm,提供真实的用户数据，供给shiro安全管理器内部校验使用
		 * 提供真实的用户User  通过用户输入的username
		 */
		UsernamePasswordToken loginToken = (UsernamePasswordToken) token; //强制转化为用户的token
		
		//用户名一定是唯一的
		String username = loginToken.getUsername();
		
		//通过用户名获取用户真实信息
		User user = userService.findUserByUsername(username);
		/**
		 * principal  真实用户的对象
		 * credentials 真实的用户密码
		 * realmName   指定relam的名称 当前realm的名称
		 */
		AuthenticationInfo info = 
		new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
		return info;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
