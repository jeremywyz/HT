package cn.tarena.ht.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.jdbc.StringUtils;

import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.UserService;
import cn.tarena.ht.tool.MD5;

@Controller
public class LoginController extends BaseController{
	
	@Resource
	private UserService userService;
	
	//跳转到登陆页面
	@RequestMapping("toLogin.action")
	public String tologin(){
		
		return "/sysadmin/login/login";
	}
	
	@RequestMapping("login.action")
	public String login(String userName,String password,Model model,HttpSession session){
		
		if(StringUtils.isNullOrEmpty(userName) || StringUtils.isNullOrEmpty(password)){
			//输入的数据为空
			model.addAttribute("errorInfo", "用户名或密码不能为空");
			
			return "/sysadmin/login/login";
		}
		
		
		//1.创建token   传入用户收动输入的用户名和密码
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		
		//2.创建Subject对象   就是一个“用户”
		Subject subject = SecurityUtils.getSubject();
		
		//3.通过subject实现登陆,该方法会调用Shiro内部的校验，如果校验不通过则会抛出异常信息。
		try {
			
			subject.login(token);
			
			//需要将用户信息存入到session中
			User user = (User) subject.getPrincipal();
			subject.getSession().setAttribute("userSession", user);
			return "redirect:/home.action";
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorInfo", "用户名或密码错误");
			return "/sysadmin/login/login";
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//将密码进行加密
		/*password = MD5.getMd5Hash(userName, password);
		System.out.println(password);
		
		//根据用户名和密码查询数据库
		User user = userService.findUserAndPassword(userName,password);
		
		if(user==null){
			model.addAttribute("errorInfo", "用户名或密码错误");
			return "/sysadmin/login/login";
		}
		
		//将用户信息存放到session中
		session.setAttribute("userSession", user);
		
		return "redirect:/home.action";
		*/
		
		
		
	}
}
