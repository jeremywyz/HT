package cn.tarena.ht.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.service.DeptService;

@Controller
@RequestMapping("/sysadmin/dept/")
public class DeptController extends BaseController{
	
	@Resource
	private DeptService deptService;
	
	//展现部门列表信息
	@RequestMapping("list")
	public String findAll(Model model){
		
		List<Dept> deptList = deptService.findAll();
		for (Dept dept : deptList) {
			System.out.println(dept);
		}
		model.addAttribute("deptList", deptList);
		
		//页面跳转到列表页面
		return "sysadmin/dept/jDeptList";
	}
	
	//状态的启用
	@RequestMapping("start")
	public String toStart(@RequestParam(value="deptId") String[] deptIds){
		//要求选中的数据状态改为启用模式  1启用   0停用
		
		int state = 1; //启用
		deptService.updateState(deptIds,state);
		
		//使用重定向 再次返回部门列表页面
		return "redirect:/sysadmin/dept/list";
		
	}
	
	@RequestMapping("stop")   //状态的停用
	public String toStop(@RequestParam(value="deptId") String[] deptIds){
		int state = 0; //启用
		deptService.updateState(deptIds,state);
		
		//使用重定向 再次返回部门列表页面
		return "redirect:/sysadmin/dept/list";
	}
	
	//实现批量删除
	@RequestMapping("delete")
	public String toDelete(String[] deptId){
		
		deptService.delteDepts(deptId);
		
		return "redirect:/sysadmin/dept/list";
	}
	
	@RequestMapping("tocreate")  //转向新增页面
	public String toCreate(Model model){
		
		//查询所有的上级部门
		List<Dept> parentDeptList = deptService.findAll();
		model.addAttribute("parentDeptList", parentDeptList);
		
		return "sysadmin/dept/jDeptCreate";
	}
	
	@RequestMapping("save")
	public String toSave(Dept dept){
		
		deptService.saveDept(dept);
		
		return "redirect:/sysadmin/dept/list";
	}
	
	@RequestMapping("toview")
	public String toview(String deptId,Model model){
		
		Dept dept = deptService.findOne(deptId);
		model.addAttribute("dept", dept);
		
		//转向用户查看页面
		return "sysadmin/dept/jDeptView";
	}
	
	@RequestMapping("toupdate")
	public String toupdate(String deptId,Model model){
		
		Dept dept = deptService.findOne(deptId);
		
		
		//上级部门下拉列表出自己之外的数据
		List<Dept> deptList  = deptService.findParentDeptList(deptId);
		
		model.addAttribute("dept", dept);
		model.addAttribute("deptList", deptList);
		//应该转向到部门修改页面
		return "sysadmin/dept/jDeptUpdate";
	}
	
	@RequestMapping("update")
	public String update(Dept dept){
		
		deptService.updateDept(dept);
		
		
		return "redirect:/sysadmin/dept/list";
	}
	
}
