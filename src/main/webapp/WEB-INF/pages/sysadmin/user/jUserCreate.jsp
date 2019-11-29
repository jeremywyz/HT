<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>用户新增</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="save"><a href="#" onclick="formSubmit('save','_self');this.blur();">保存</a></li>
	<li id="back"><a href="#" onclick="window.history.go(-1);this.blur();">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    用户新增
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<tbody class="tableBody" >
	
	<tr class="odd">
		<td>用户名：</td>
		<td><input type="text" name="username"/></td>
		<td>密码：</td>
		<td><input type="text" name="password"></td>
	</tr>
	<tr class="odd">
		<td>所在部门：</td>
		<td>
			<select name="dept.deptId" style="width:121px">
				<option value="">---请选择---</option>
				<c:forEach items="${deptList}" var="d">
					<option value="${d.deptId}">${d.deptName}</option>
				</c:forEach>
			</select>
		</td>
		<td>姓名：</td>
		<td><input type="text" name="userInfo.name"></td>
	</tr>
	<tr class="odd">
		<td>身份证号：</td>
		<td><input type="text" name="userInfo.cardNo"/></td>
		<td>上级领导：</td>
		<td>
			<select name="userInfo.manager.userInfoId" style="width:121px">
				<option value="">---请选择---</option>
				<c:forEach items="${userList}" var="u">
					<option value="${u.userId}">${u.userInfo.name}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
    <tr class="odd">
		<td>入职日期：</td>
		<td>
			<input type="text" style="width:121px;" name="userInfo.joinDate"
	   		onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
		</td>
		<td>薪水：</td>
		<td><input type="text" name="userInfo.salary"/></td>
	</tr>
	<tr class="odd">
		<td>生日：</td>
		<td>
			<!-- <input name="谷歌"  type="date"  2016/11/22/> -->
			<input type="text" style="width:121px;" name="userInfo.birthday"
	   		onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
		</td>
		<td>性别：</td>
		<td>
			<input type="radio" name="userInfo.gender" value="男"/>男
			<input type="radio" name="userInfo.gender" value="女"/>女
		</td>
	</tr>
    <tr class="odd">
		<td>岗位：</td>
		<td><input type="text" name="userInfo.station"/></td>
		<td>电话号码：</td>
		<td><input name="userInfo.telephone" type="text"/></td>
	</tr>
	 <tr class="odd">
		<td>用户级别：</td>
		<td>
			<select name="userInfo.userLevel" style="width:121px">
				<option value="">---请选择---</option>
				<option value="1">总经理</option>
				<option value="2">副总</option>
				<option value="3">部门经理</option>
				<option value="4">普通用户</option>
			</select>
		<td>排序号：</td>
		<td><input name="userInfo.orderNo" type="text"/></td>
	</tr>
	 <tr class="odd">
		<td>备注信息：</td>
		<td colspan="3">
			<textarea style="width:100%;height:120px" name="userInfo.remark"></textarea>
		</td>
	</tr>
	</tbody>
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

