package cn.tarena.ht.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.pojo.Role;
import cn.tarena.ht.service.ModuleService;
import cn.tarena.ht.service.RoleService;

@Controller
@RequestMapping("/sysadmin/role/")
public class RoleController extends BaseController{
	
	@Resource
	private RoleService roleService;
	
	@Resource
	private ModuleService moduleService;
	
	@RequestMapping("list")
	public String findlist(Model model){
		
		List<Role> roleList = roleService.findAll();
		model.addAttribute("roleList", roleList);
		
		
		for (Role role : roleList) {
			System.out.println(role);
		}
		//转向角色列表页面
		return "/sysadmin/role/jRoleList";
	}
	
	@RequestMapping("tocreate")
	public String tocreate(){
		
		//直接跳转页面
		return "/sysadmin/role/jRoleCreate";
	}
	
	@RequestMapping("save")
	public String save(Role role){
		
		roleService.saveRole(role);
		
		return "redirect:/sysadmin/role/list";
	}
	
	
	@RequestMapping("toupdate")
	public String toupdate(String roleId,Model model){
		
		//根据roleId 查询数据
		Role role = roleService.findOne(roleId);
		model.addAttribute("role", role);
		
		//页面跳转到修改页面
		return "/sysadmin/role/jRoleUpdate";
	}
	
	@RequestMapping("update")
	public String update(Role role){
		
		roleService.update(role);
		
		return "redirect:/sysadmin/role/list";
	}
	
	
	@RequestMapping("toview")
	public String toView(String roleId,Model model){
		
		Role role = roleService.findOne(roleId);
		model.addAttribute("role", role);
		
		return "/sysadmin/role/jRoleView";
	}
	
	
	@RequestMapping("delete")
	public String toDelete(String[] roleId){
		
		roleService.deleteRoles(roleId);
		
		return "redirect:/sysadmin/role/list";
	}
	
	
	//为角色添加模块信息
	@RequestMapping("toModule")
	public String toModule(String roleId,Model model) throws JsonProcessingException{
		
		//获取模块信息的ID
		List<String> m_list = moduleService.findModuleList(roleId);
		
		//准备页面显示的模块信息
		List<Module> moduleList = moduleService.findAll();
		
		
		//角色中的模块信息与全部的模块信息做比较
		for (Module module : moduleList) {
			if(m_list.contains(module.getModuleId())){
				module.setChecked("true");
			}
		}
		
		
		//将数据转化为JSON串
		ObjectMapper objectMapper = new ObjectMapper();
		
		String zTreeJSON = objectMapper.writeValueAsString(moduleList);
		
		model.addAttribute("zTreeJSON", zTreeJSON);
		model.addAttribute("roleId",roleId);	//角色ID
		
		return "/sysadmin/role/jRoleModule";
	}
	
	@RequestMapping("saveRoleModule")
	public String saveRoleModule(String roleId,String[] moduleIds){
		
		roleService.saveRoleModule(roleId,moduleIds);
		
		return "redirect:/sysadmin/role/list";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
