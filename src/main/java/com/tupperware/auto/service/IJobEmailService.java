package com.tupperware.auto.service;

import com.tupperware.auto.mysql.model.JobEmail;
import com.baomidou.mybatisplus.service.IService;
import com.tupperware.auto.form.JobEmailHelper;
import com.tupperware.auto.commons.utils.DataInfo;
import com.tupperware.auto.commons.utils.PageInfo;
import com.baomidou.mybatisplus.service.IService;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *   服务类
 * </p>
 *
 * @author patrick.wang
 * @since 2018-12-26 11:16:15
 */
public interface IJobEmailService extends IService<JobEmail> {
	 
	void setHelper(JobEmailHelper helper);

	void selectDataGrid(PageInfo pageInfo);
	
	List<JobEmail> getJson(String outletNo,String yearMonth)  ;
	
	List<JobEmail> getByFilter(String organno, String year, String month, String week, String date,
			String organtype);
	
	void selectDataGrid(DataInfo dataInfo);

	public List<JobEmail> list();

	
	JobEmail getTop1();
	
	public List<JobEmail> getMapParams(Map<String, String> params) ;

	public List<JobEmail>  ii(
	            String mail ,
	            String status ,
	            String isactive 
	        );

}
