package com.tupperware.auto.controller;

import com.tupperware.auto.form.ConfigControllerHelper;

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
import com.tupperware.auto.mysql.model.ConfigController;
import com.tupperware.auto.service.IConfigControllerService; 

import springfox.documentation.annotations.ApiIgnore;
/**
 * <p>
 *   前端控制器
 * </p>
 * @author patrick.wang
 * @since 2018-12-24
 */
 
@Api(description= "" ,tags={"configController"})
@ApiIgnore
@RestController
@RequestMapping("/configController")
public class ConfigControllerController  extends CommonController<ConfigController>{
	
	private static Logger logger = Logger.getLogger(ConfigControllerController.class);

	@Autowired private IConfigControllerService configControllerService;
	@ApiOperation(value = "表头", notes = "表头",produces="application/json")
	@RequestMapping(value = "/header", method = RequestMethod.GET)
	@ResponseBody 
	public Map<String, String> header() { 
		return ConfigControllerHelper.getHeader();
	}

	@ApiIgnore
	@ApiOperation(value = "List")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<ConfigController> list(){
			return configControllerService.list();
	}

	@ApiIgnore
	@ApiOperation(value = "查询", notes = "按表头中列出的字段名等值过滤,不支持日期过滤", response = DataInfo.class,produces="application/json")
	@ApiResponses(value = { @ApiResponse(code = 405, message = "Invalid input", response = DataInfo.class) })
    @RequestMapping(value="/query", method = RequestMethod.POST)
	@ResponseBody
	public DataInfo query(HttpServletRequest request){
		Map<String, String> map = WebUtils.Requst2Map(request);
		DataInfo datainfo = new DataInfo(map.get("aban8"),  "", "");
		List<ConfigController> list=configControllerService.getMapParams(map);
		datainfo.setTotal(list.size());
		datainfo.setMessage("");
		datainfo.setRows(list);		
		datainfo.setStatus(true);
		datainfo.setCode(HttpServletResponse.SC_OK);
		return datainfo; 		
	} 
	
	
} 