package com.tupperware.auto.controller;

import com.tupperware.auto.commons.utils.PageInfo;
import com.tupperware.auto.form.AuthRoleHelper;

import com.tupperware.auto.commons.base.CommonController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tupperware.auto.commons.utils.WebUtils;
import com.tupperware.auto.commons.utils.DataInfo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.tupperware.auto.mysql.model.AuthRole;
import com.tupperware.auto.service.IAuthRoleService;
import org.springframework.ui.Model;
import springfox.documentation.annotations.ApiIgnore;
/**
 * <p>
 * 角色信息表  前端控制器
 * </p>
 * @author patrick.wang
 * @since 2018-09-29
 */
 
@Api(description= "角色信息表" ,tags={"authRole"}) 
@RestController
@RequestMapping("/authRole")
public class AuthRoleController  extends CommonController<AuthRole>{
	
	private static Logger logger = Logger.getLogger(AuthRoleController.class);
	
	@Autowired private IAuthRoleService authRoleService;
	@ApiOperation(value = "表头", notes = "表头",produces="application/json")
	@RequestMapping(value = "/header", method = RequestMethod.GET)
	@ResponseBody 
	public Map<String, String> header() { 
		return AuthRoleHelper.getHeader();
	}

	@ApiOperation(value = "查询", notes = "按表头中列出的字段名等值过滤,不支持日期过滤", response = DataInfo.class,produces="application/json")
	@ApiResponses(value = { @ApiResponse(code = 405, message = "Invalid input", response = DataInfo.class) })
	@RequestMapping(value="/query", method = RequestMethod.POST)
	@ResponseBody
	public DataInfo query(HttpServletRequest request){
		Map<String, String> map = WebUtils.Requst2Map(request);
		DataInfo datainfo = new DataInfo(map.get("aban8"),  "", "");
		List<AuthRole> list=authRoleService.getMapParams(map);
		datainfo.setTotal(list.size());
		datainfo.setMessage("角色信息表");
		datainfo.setRows(list);		
		datainfo.setStatus(true);
		datainfo.setCode(HttpServletResponse.SC_OK);
		return datainfo; 		
	}

	@ApiOperation(value = "视图", notes = "视图", response = PageInfo.class,produces="application/json")
	@ApiResponses(value = { @ApiResponse(code = 405, message = "Invalid input", response = PageInfo.class) })
	@RequestMapping(value="/datagrid", method = RequestMethod.POST)
	@ResponseBody
	public PageInfo dataGrid(AuthRoleHelper helper) {
		PageInfo pageInfo = new PageInfo(helper.getPage(), helper.getRows());
		Map<String, Object> condition = new HashMap<String, Object>();
		pageInfo.setCondition(condition);
		authRoleService.setHelper(helper);
		authRoleService.selectDataGrid(pageInfo);
		return pageInfo;
	}



	@RequestMapping(value="/addPage", method = RequestMethod.GET)
	public String addPage() {
		return "admin/roleAdd";
	}

	@RequestMapping(value="/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(AuthRole obj) {
		authRoleService.insert(obj	);
		return renderSuccess("添加成功！");
	}

	@RequestMapping(value="/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public Object delete(Long id) {
//		authRoleService.delete();
		return renderSuccess("删除成功！");
	}

	@RequestMapping(value="/editPage", method = RequestMethod.GET)
	public String editPage(Model model, Long id) {
		//Role role = roleService.selectById(id);
		// model.addAttribute("role", role);
		return "admin/roleEdit";
	}

	@RequestMapping(value="/edit", method = RequestMethod.POST)
	@ResponseBody
	public Object edit(AuthRole role) {
		// roleService.updateById(role);
		return renderSuccess("编辑成功！");
	}

} 