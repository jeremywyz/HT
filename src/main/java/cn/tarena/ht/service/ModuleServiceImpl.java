package cn.tarena.ht.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.ModuleMapper;
import cn.tarena.ht.pojo.Module;
@Service
public class ModuleServiceImpl implements ModuleService {
	
	@Resource
	private ModuleMapper moduleMapper;
	
	@Override
	public List<Module> findAll() {
		
		return moduleMapper.findAll();
	}

	@Override
	public void updateState(String[] moduleIds, int state) {
		
		moduleMapper.updateState(moduleIds,state);
		
	}

	@Override
	public void delete(String[] moduleId) {
		
		moduleMapper.delete(moduleId);
		//删除中间表数据
		moduleMapper.deleteR_M(moduleId);
		
	}

	@Override
	public void save(Module module) {
		module.setModuleId(UUID.randomUUID().toString());
		module.setCreateTime(new Date());
		module.setState(1);  //状态启用
		
		moduleMapper.save(module);
		
	}

	@Override
	public Module findOne(String moduleId) {
		
		return moduleMapper.findOne(moduleId);
	}

	@Override
	public List<Module> findParentModule(String moduleId) {
		
		return moduleMapper.findParentModule(moduleId);
	}

	@Override
	public void updateModule(Module module) {
		
		module.setUpdateTime(new Date());
		
		moduleMapper.updateModule(module);
		
	}

	@Override
	public List<String> findModuleList(String roleId) {
		
		return moduleMapper.findModuleList(roleId);
	}

}
