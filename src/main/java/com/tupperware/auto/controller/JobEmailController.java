package com.tupperware.auto.controller;

import com.tupperware.auto.form.JobEmailHelper;

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
import com.tupperware.auto.mysql.model.JobEmail;
import com.tupperware.auto.service.IJobEmailService; 

import springfox.documentation.annotations.ApiIgnore;
/**
 * <p>
 *   前端控制器
 * </p>
 * @author patrick.wang
 * @since 2018-12-26 11:16:15
 */
 

@Api(description= "desc_job_email" ,tags={"group_job_email.jobEmail"}) 
@RestController
@RequestMapping("/jobEmail")
public class JobEmailController  extends CommonController<JobEmail>{
	
	private static Logger logger = Logger.getLogger(JobEmailController.class);
	
	@Autowired private IJobEmailService jobEmailService;
	@ApiOperation(value = "表头", notes = "表头",produces="application/json")
	@RequestMapping(value = "/header", method = RequestMethod.GET)
	@ResponseBody 
	public Map<String, String> header() { 
		return JobEmailHelper.getHeader();
	}

	@ApiOperation(value = "List")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<JobEmail> list(){
			return jobEmailService.list();
	}

	@ApiOperation(value = "查询", notes = "按表头中列出的字段名等值过滤,不支持日期过滤", response = DataInfo.class,produces="application/json")
	@ApiResponses(value = { @ApiResponse(code = 405, message = "Invalid input", response = DataInfo.class) })
    @RequestMapping(value="/query", method = RequestMethod.POST)
	@ResponseBody
	public DataInfo query(HttpServletRequest request){
		Map<String, String> map = WebUtils.Requst2Map(request);
		DataInfo datainfo = new DataInfo(map.get("aban8"),  "", "");
		List<JobEmail> list=jobEmailService.getMapParams(map);
		datainfo.setTotal(list.size());
		datainfo.setMessage("");
		datainfo.setRows(list);		
		datainfo.setStatus(true);
		datainfo.setCode(HttpServletResponse.SC_OK);
		return datainfo; 		
	}
	
    /** notes_job_email
	 * @param mail,status,isactive
	 * @return DataInfo
	 * @see DataInfo
	 */

	@ApiOperation(value = "api_job_email",tags={"job_email"}, notes = "###notes_job_email  \n###参数:  \nisactive='',status='',mail=''  \n ###查询:  \nselect *  \nfrom job_email  \nwhere mail = ''  \n	and status = ''  \n	and isActive = ''  \n ###接口生成时间：   \n2018-12-26 11:16:15",produces="application/json")
    @RequestMapping(value = "/ii", method = RequestMethod.GET)
    public DataInfo ii(@RequestParam(value = "mail", required = true ,defaultValue = "")String mail ,@RequestParam(value = "status", required = true ,defaultValue = "")String status ,@RequestParam(value = "isactive", required = true ,defaultValue = "")String isactive ) {
		DataInfo datainfo = new DataInfo("","","");
		List<JobEmail> list= jobEmailService.ii(mail ,status ,isactive ) ;
		datainfo.setTotal(list.size());
		datainfo.setMessage("api_job_email");
		datainfo.setRows(list);
		datainfo.setStatus(true);
		datainfo.setCode(HttpServletResponse.SC_OK);		
		//datainfo.setSqlSegment(ew.getSqlSegment());
		logger.info(datainfo.toString());
		
		return datainfo; 	 
    }
    
    /** notes_job_email
     * @param mail,status,isactive
     * @return List<JobEmail>
     * @see List<JobEmail>
     * 2018-12-26 11:16:15
     */
		
	@ApiOperation(value = "api_job_email列表",tags={"job_email"}, notes = "###notes_job_email列表  \n###参数:  \nisactive='',status='',mail=''  \n ###查询2:  \nselect *  \nfrom job_email  \nwhere mail = ''  \n	and status = ''  \n	and isActive = ''",produces="application/json")
	@RequestMapping(value = "/ii_list", method = RequestMethod.GET)
	@ResponseBody
	public  List<JobEmail>  ii_list(@RequestParam(value = "mail", required = true ,defaultValue = "")String mail ,@RequestParam(value = "status", required = true ,defaultValue = "")String status ,@RequestParam(value = "isactive", required = true ,defaultValue = "")String isactive ){
				return jobEmailService.ii(mail ,status ,isactive ) ;
	}

}