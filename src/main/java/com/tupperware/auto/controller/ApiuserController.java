package com.tupperware.auto.controller;

import com.tupperware.auto.form.ApiuserHelper;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
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
import com.tupperware.auto.mysql.model.Apiuser;
import com.tupperware.auto.service.IApiuserService; 

import springfox.documentation.annotations.ApiIgnore;
/**
 * <p>
 *   前端控制器
 * </p>
 * @author patrick.wang
 * @since 2018-12-26 11:16:15
 */
 

@Api(description= "desc_apiuser" ,tags={"group_apiuser.apiuser"}) 
@RestController
@RequestMapping("/apiuser")
public class ApiuserController  extends CommonController<Apiuser>{
	
	private static Logger logger = Logger.getLogger(ApiuserController.class);
	
	@Autowired private IApiuserService apiuserService;
	@ApiOperation(value = "表头", notes = "表头",produces="application/json")
	@RequestMapping(value = "/header", method = RequestMethod.GET)
	@ResponseBody 
	public Map<String, String> header() { 
		return ApiuserHelper.getHeader();
	}

	@ApiOperation(value = "List")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Apiuser> list(){
			return apiuserService.list();
	}

	@ApiOperation(value = "查询", notes = "按表头中列出的字段名等值过滤,不支持日期过滤", response = DataInfo.class,produces="application/json")
	@ApiResponses(value = { @ApiResponse(code = 405, message = "Invalid input", response = DataInfo.class) })
    @RequestMapping(value="/query", method = RequestMethod.POST)
	@ResponseBody
	public DataInfo query(HttpServletRequest request){
		Map<String, String> map = WebUtils.Requst2Map(request);
		DataInfo datainfo = new DataInfo(map.get("aban8"),  "", "");
		List<Apiuser> list=apiuserService.getMapParams(map);
		datainfo.setTotal(list.size());
		datainfo.setMessage("");
		datainfo.setRows(list);		
		datainfo.setStatus(true);
		datainfo.setCode(HttpServletResponse.SC_OK);
		return datainfo; 		
	}
	
    /** notes_apiuser
	 * @param username
	 * @return DataInfo
	 * @see DataInfo
	 */

	@ApiOperation(value = "api_apiuser",tags={"apiuser"}, notes = "###notes_apiuser  \n###参数:  \nusername=''  \n ###查询:  \nselect *  \nfrom apiuser  \nwhere username = ''  \n ###接口生成时间：   \n2018-12-26 11:16:15",produces="application/json")
    @RequestMapping(value = "/username", method = RequestMethod.GET)
    public DataInfo username(@RequestParam(value = "username", required = true ,defaultValue = "")String username ) {
		DataInfo datainfo = new DataInfo("","","");
		List<Apiuser> list= apiuserService.username(username ) ;
		datainfo.setTotal(list.size());
		datainfo.setMessage("api_apiuser");
		datainfo.setRows(list);
		datainfo.setStatus(true);
		datainfo.setCode(HttpServletResponse.SC_OK);		
		//datainfo.setSqlSegment(ew.getSqlSegment());
		logger.info(datainfo.toString());
		
		return datainfo; 	 
    }
    
    /** notes_apiuser
     * @param username
     * @return List<Apiuser>
     * @see List<Apiuser>
     * 2018-12-26 11:16:15
     */
		
	@ApiOperation(value = "api_apiuser列表",tags={"apiuser"}, notes = "###notes_apiuser列表  \n###参数:  \nusername=''  \n ###查询1:  \nselect *  \nfrom apiuser  \nwhere username = ''",produces="application/json")
	@RequestMapping(value = "/username_list", method = RequestMethod.GET)
	@ResponseBody
	public  List<Apiuser>  username_list(@RequestParam(value = "username", required = true ,defaultValue = "")String username ){
				return apiuserService.username(username ) ;
	}

}