package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tarena.ht.pojo.Dept;

public interface DeptMapper {
	
	//查询全部的部门信息
	public List<Dept> findAll();
	
	//使用注解将多值传递封装为Map 其中注解的值表示Map中的key 参数的值表示Map中的value
	public void updateState(@Param("deptIds") String[] deptIds, @Param("state") int state);
	
	public void delteDepts(String[] deptId);
	
	public void saveDept(Dept dept);
	
	public Dept findOne(String deptId);

	public List<Dept> findParentDeptList(String deptId);

	public void updateDept(Dept dept);
}
