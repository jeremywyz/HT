package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.tarena.ht.pojo.Module;

public interface ModuleMapper {
	
	public List<Module> findAll();
	
	public void updateState(@Param("moduleIds") String[] moduleIds,@Param("state") int state);

	public void delete(String[] moduleId);
	
	public void save(Module module);
	
	public Module findOne(String moduleId);
	
	public List<Module> findParentModule(String moduleId);

	public void updateModule(Module module);
	
	@Select("select module_id from role_module_p where role_id = #{roleId}")
	public List<String> findModuleList(String roleId);

	public void deleteR_M(String[] moduleId);
}
