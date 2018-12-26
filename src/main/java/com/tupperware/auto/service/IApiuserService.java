package com.tupperware.auto.service;

import com.tupperware.auto.mysql.model.Apiuser;
import com.baomidou.mybatisplus.service.IService;
import com.tupperware.auto.form.ApiuserHelper;
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
public interface IApiuserService extends IService<Apiuser> {
	 
	void setHelper(ApiuserHelper helper);

	void selectDataGrid(PageInfo pageInfo);
	
	List<Apiuser> getJson(String outletNo,String yearMonth)  ;
	
	List<Apiuser> getByFilter(String organno, String year, String month, String week, String date,
			String organtype);
	
	void selectDataGrid(DataInfo dataInfo);

	public List<Apiuser> list();

	
	Apiuser getTop1();
	
	public List<Apiuser> getMapParams(Map<String, String> params) ;

	public List<Apiuser>  username(
	            String username 
	        );

}
