package cn.tarena.ht.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	//top.location.href = "home.action";
	//转向欢迎页面
	@RequestMapping("/home")
	public String home(){
		return "/home/fmain";
	}
	
	//转向tilte标题栏页面
	@RequestMapping("/title")
	public String title(){
		return "/home/title";
	}
	
	/*//转向home的左侧页面
	@RequestMapping("/homeLeft")
	public String homeLeft(){
		return "/home/left";
	}
	
	//转向home的操作页面
	@RequestMapping("/homeMain")
	public String homeMain(){
		return "/home/main";
	}*/
	
	@RequestMapping("/{module}/Left")
	public String sysadminLeft(@PathVariable String module){
		//实现模块的动态拼接
		return "/"+module+"/left";
	}
	
	@RequestMapping("/{module}/Main")
	public String sysadminMain(@PathVariable String module){
		return "/"+module+"/main";
	}
	
/*	@RequestMapping("/cargoLeft")
	public String cargoLeft(){
		return "/cargo/left";
	}
	
	
	
	@RequestMapping("/cargoMain")
	public String cargoMain(){
		return "/cargo/main";
	}
	
	@RequestMapping("/baseinfoLeft")
	public String baseinfoLeft(){
		return "/baseinfo/left";
	}
	
	
	@RequestMapping("/baseinfoMain")
	public String baseinfoMain(){
		return "/baseinfo/main";
	}*/
}
