package com.tupperware.auto.controller;

import com.tupperware.auto.form.AuthOperationHelper;

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
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import com.tupperware.auto.mysql.model.AuthOperation;
import com.tupperware.auto.service.IAuthOperationService; 

import springfox.documentation.annotations.ApiIgnore;
/**
 * <p>
 * 权限信息表  前端控制器
 * </p>
 * @author patrick.wang
 * @since 2018-09-29
 */
 
@Api(description= "权限信息表" ,tags={"authOperation"}) 
@RestController
@RequestMapping("/authOperation")
public class AuthOperationController  extends CommonController<AuthOperation>{
	
	private static Logger logger = Logger.getLogger(AuthOperationController.class);
	
	@Autowired private IAuthOperationService authOperationService;
	@ApiOperation(value = "表头", notes = "表头",produces="application/json")
	@RequestMapping(value = "/header", method = RequestMethod.GET)
	@ResponseBody 
	public Map<String, String> header() { 
		return AuthOperationHelper.getHeader();
	}

	@ApiOperation(value = "查询", notes = "按表头中列出的字段名等值过滤,不支持日期过滤", response = DataInfo.class,produces="application/json")
	@ApiResponses(value = { @ApiResponse(code = 405, message = "Invalid input", response = DataInfo.class) })
	   @RequestMapping(value="/query", method = RequestMethod.POST)
	@ResponseBody
	public DataInfo query(HttpServletRequest request){
		Map<String, String> map = WebUtils.Requst2Map(request);
		DataInfo datainfo = new DataInfo(map.get("aban8"),  "", "");
		List<AuthOperation> list=authOperationService.getMapParams(map);
		datainfo.setTotal(list.size());
		datainfo.setMessage("权限信息表");
		datainfo.setRows(list);		
		datainfo.setStatus(true);
		datainfo.setCode(HttpServletResponse.SC_OK);
		return datainfo; 		
	} 
	
	
} 