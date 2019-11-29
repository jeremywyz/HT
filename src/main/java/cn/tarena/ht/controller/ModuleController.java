package cn.tarena.ht.controller;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.validator.constraints.EAN;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonRawValue;

import cn.tarena.ht.pojo.Module;
import cn.tarena.ht.service.ModuleService;

@Controller
@RequestMapping("/sysadmin/module/")
public class ModuleController extends BaseController{
	
	@Resource
	private ModuleService moduleService;
	
	
	@RequestMapping("list")
	public String toList(Model model){
		List<Module> moduleList = moduleService.findAll();
		model.addAttribute("moduleList", moduleList);
		
		return "/sysadmin/module/jModuleList";
	}
	
	
	@RequestMapping("start")
	public String toStart(@RequestParam("moduleId")String[] moduleIds){
		
		int state = 1;  //状态启用
		moduleService.updateState(moduleIds,state);
		
		//重定向到模块列表页面
		return "redirect:/sysadmin/module/list";
	}
	
	@RequestMapping("stop")
	public String toStop(@RequestParam("moduleId")String[] moduleIds){
		int state = 0;  //状态停用
		moduleService.updateState(moduleIds,state);
		
		//重定向到模块列表页面
		return "redirect:/sysadmin/module/list";
	}
	
	
	@RequestMapping("delete")
	public String toDelete(String[] moduleId){
		
		moduleService.delete(moduleId);
		
		return "redirect:/sysadmin/module/list";
	}
	
	@RequestMapping("tocreate")
	public String tocreate(Model model){
		
		//为页面准备上级模块的数据
		List<Module> parentModuleList = moduleService.findAll();
		model.addAttribute("parentModuleList", parentModuleList);
		
		//转向新增页面
		return "/sysadmin/module/jModuleCreate";
	}
	
	
	@RequestMapping("save")
	public String save(Module module){
		
		
		moduleService.save(module);
		
		return "redirect:/sysadmin/module/list";
	}
	
	@RequestMapping("toview")
	public String toview(String moduleId,Model model){
		Module module = moduleService.findOne(moduleId);
		
		model.addAttribute("module", module);
		
		return "/sysadmin/module/jModuleView";

	}
	
	@RequestMapping("toupdate")
	public String toupdate(String moduleId,Model model){
		
		//准备要修改的数据
		Module module = moduleService.findOne(moduleId);
		
		//准备上级模块的下拉列表   列表除了自己之外的信息
		List<Module> parentList = moduleService.findParentModule(moduleId);
		
		model.addAttribute("module", module);
		model.addAttribute("parentList", parentList);
		
		
		return "/sysadmin/module/jModuleUpdate";
	}
	
	@RequestMapping("update")
	public String update(Module module){
		
		moduleService.updateModule(module);
		
		
		return "redirect:/sysadmin/module/list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
