package com.tupperware.auto.service.impl;

import com.tupperware.auto.mysql.model.JobEmail;
import com.tupperware.auto.mysql.mapper.JobEmailMapper;
import com.tupperware.auto.service.IJobEmailService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tupperware.auto.form.JobEmailHelper;
import com.tupperware.auto.mysql.mapper.JobEmailMapper;
import com.tupperware.auto.mysql.model.JobEmail;
import com.tupperware.auto.service.IJobEmailService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tupperware.auto.commons.utils.DataInfo;
import com.tupperware.auto.commons.utils.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
/**
 * <p>
 *   服务实现类
 * </p>
 * @author patrick.wang
 * @since 2018-12-26 11:16:15
 */
@Service
public class JobEmailServiceImpl extends ServiceImpl<JobEmailMapper, JobEmail> implements IJobEmailService {
	
	 private static Logger logger = Logger.getLogger(JobEmailServiceImpl.class);
	
	@Autowired private JobEmailMapper mapper;	
	 
	private JobEmailHelper helper;

	private int count = 0;

	@Autowired
	public void setBaseMapper() {
		super.baseMapper = mapper;
	}

	
	public void setHelper(JobEmailHelper helper) {
		this.helper = helper;
	}

	
	public boolean Add(JobEmail entity) {
		return super.insert(entity);
	}
	
 	public List<JobEmail> getMapParams(Map<String, String> params) {
		// TODO Auto-generated method stub
		return mapper.selectByMapParam(params);
	}
	public List<JobEmail>getByFilter(String organno, String year, String month, String week, String date,
			String organtype) {
		
		return mapper.getByFilter(organno, year, month, week, date, organtype);
	}
	public JobEmail getTop1(){
		return mapper.selectTopJobEmail(1);	
	}
	
	public void selectDataGrid(PageInfo pageInfo) {
	     	EntityWrapper<JobEmail> wrapper=new EntityWrapper<JobEmail> ();
	   		Page<JobEmail> page = new Page<JobEmail>(pageInfo.getNowpage(), pageInfo.getSize());
	        List<JobEmail> list = mapper.selectJobEmailList(page, pageInfo.getSort(), pageInfo.getOrder());
	        pageInfo.setRows(list); 
	        pageInfo.setTotal(mapper.selectCount(wrapper)); 
	
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<JobEmail> getJson(String outletNo,String yearMonth) {
		 EntityWrapper wrapper=new EntityWrapper();
		 wrapper.setEntity(new JobEmail());
		 wrapper.where("year_Month = {0} and outletNo ={1} ", yearMonth,outletNo);
		 return mapper.selectList(wrapper); 
	}

	public List<JobEmail> list() {
        EntityWrapper wrapper=new EntityWrapper();
        wrapper.setEntity(new JobEmail());
        return mapper.selectList(wrapper);
	}

	@Override
	public void selectDataGrid(DataInfo dataInfo) {
		// TODO Auto-generated method stub 
	}

	/** notes_job_email
	 * @param mail,status,isactive
	 * @return List<JobEmail>
	 * @see List<JobEmail>
	 * 2018-12-26 11:16:15
	 */
	public List<JobEmail>  ii(String mail ,String status ,String isactive ) {
        EntityWrapper<JobEmail> wrapper = new EntityWrapper<>();
        wrapper.setEntity(new JobEmail());
	    wrapper.and("mail = {0}", mail); //''
	    wrapper.and("status = {0}", status); //''
	    wrapper.and("isActive = {0}", isactive); //''
		
		logger.info(wrapper.getSqlSegment());
        return mapper.selectList(wrapper);
    }


}
