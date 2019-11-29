package cn.tarena.ht.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import cn.tarena.ht.tool.MD5;


public class AuthCredential extends  SimpleCredentialsMatcher{
	
	
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		//将用户的明文进行加密  需要获取用户名和密码
		UsernamePasswordToken loginToken = (UsernamePasswordToken) token;
		String username = loginToken.getUsername();
		
		//将数据转化为字符串
		String password = String.valueOf(loginToken.getPassword());
		
		//通过加密算法 获取密文
		String md5Password = MD5.getMd5Hash(username, password);
		
		//将密文设置到token中
		loginToken.setPassword(md5Password.toCharArray());
		
		
		return super.doCredentialsMatch(loginToken, info);
	}

}
