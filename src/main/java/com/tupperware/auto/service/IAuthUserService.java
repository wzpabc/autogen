package com.tupperware.auto.service;

import com.tupperware.auto.mysql.model.AuthUser;
import com.baomidou.mybatisplus.service.IService;
import com.tupperware.auto.form.AuthUserHelper;
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
 * @since 2018-09-29
 */
public interface IAuthUserService extends IService<AuthUser> {
	 
	void setHelper(AuthUserHelper helper);

	void selectDataGrid(PageInfo pageInfo);
	
	List<AuthUser> getJson(String outletNo,String yearMonth)  ;
	
	List<AuthUser> getByFilter(String organno, String year, String month, String week, String date,
			String organtype);
	
	void selectDataGrid(DataInfo dataInfo);
	
	AuthUser getTop1();
	
	public List<AuthUser> getMapParams(Map<String, String> params) ;
	
}
