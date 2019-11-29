package cn.tarena.ht.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.pojo.User;
import cn.tarena.ht.service.DeptService;
import cn.tarena.ht.service.RoleService;
import cn.tarena.ht.service.UserService;

@Controller
@RequestMapping("/sysadmin/user/")
public class UserController extends BaseController{
	
	@Resource
	private UserService userService;
	@Resource
	private DeptService deptService;
	
	@Resource
	private RoleService roleService;
	
	@RequestMapping("list")
	public String findAll(Model model){
		
		List<User> userList = userService.findAll();
		
		model.addAttribute("userList", userList);
		
		//跳转到用户列表页面
		return "/sysadmin/user/jUserList";
		
	}
	
	//状态的改变  启用
	//@RequestMapping("start")
	public String toStart(@RequestParam("userId") String[] userIds){
		int state = 1;  //启用
		
		userService.updateState(userIds,state);
	
		//重定向到用户列表页面
		return "redirect:/sysadmin/user/list";
	}
	
	@RequestMapping("stop")
	public String toStop(@RequestParam("userId") String[] userIds){
		int state = 0;  //停用
		
		userService.updateState(userIds,state);
	
		//重定向到用户列表页面
		return "redirect:/sysadmin/user/list";
	}
	
	
	//批量删除
	@RequestMapping("delete")
	public String toDelete(@RequestParam("userId") String[] userIds){
		
		userService.deleteUsers(userIds);
		
		return "redirect:/sysadmin/user/list";
	}
	
	
	@RequestMapping("tocreate")
	public String tocreate(Model model){
		//为页面准备数据
		List<Dept> deptList = deptService.findAll();
		
		List<User> userList = userService.findAll();
		
		model.addAttribute("deptList", deptList);
		model.addAttribute("userList", userList);
		
		
		return "/sysadmin/user/jUserCreate";
	}
	
	@RequestMapping("save")
	public String save(User user){
		
		//新增用户
		userService.save(user);
		
		return "redirect:/sysadmin/user/list";
	}
	
	
	//为用户分配角色
	@RequestMapping("toRole")
	public String toRole(String userId,Model model) throws JsonProcessingException{
		
		//根据userId获取已经拥有的角色id
		List<String> r_list = roleService.findRoleListByUserId(userId);
		
		
		//获取角色列表信息
		List<Role> roleList = roleService.findAll();
		
		//判断用户所拥有的角色ID是否包含在roleList列表当中
		for (Role role : roleList) {
			if(r_list.contains(role.getRoleId())){
				
				role.setChecked("true");
			}
		}
		
		
		
		
		//为了实现zTree树的结构，必须将数据转化为json串，并且其中的属性必须为固定的属性。
		ObjectMapper objectMapper = new ObjectMapper();
		
		//该方法调用对象内部的get方法获取值,如果想满足zTree树的属性要求，可以修改属性
		String zTreeJson = objectMapper.writeValueAsString(roleList);
		
		//将json串传回页面
		model.addAttribute("zTreeJson", zTreeJson);
		
		//将用户ID传到页面中
		model.addAttribute("userId", userId);
		
		System.out.println(zTreeJson);
		//转向zTree树的显示页面
		return "/sysadmin/user/jUseRole";
	}
	
	
	
	//通过zTree树 选择角色信息 之后保存
	@RequestMapping("saveUserRole")
	public String saveUserRole(String[] roleIds,String userId){
		
		userService.saveUser_Role(roleIds,userId);
		
		
		return "redirect:/sysadmin/user/list";
	}
	
	
	
	
	
	
	

}
