package com.tupperware.auto.service;

import com.tupperware.auto.mysql.model.AuthRole;
import com.baomidou.mybatisplus.service.IService;
import com.tupperware.auto.form.AuthRoleHelper;
import com.tupperware.auto.commons.utils.DataInfo;
import com.tupperware.auto.commons.utils.PageInfo;
import com.baomidou.mybatisplus.service.IService;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色信息表  服务类
 * </p>
 *
 * @author patrick.wang
 * @since 2018-09-29
 */
public interface IAuthRoleService extends IService<AuthRole> {
	 
	void setHelper(AuthRoleHelper helper);

	void selectDataGrid(PageInfo pageInfo);
	
	List<AuthRole> getJson(String outletNo,String yearMonth)  ;
	
	List<AuthRole> getByFilter(String organno, String year, String month, String week, String date,
			String organtype);
	
	void selectDataGrid(DataInfo dataInfo);
	
	AuthRole getTop1();
	
	public List<AuthRole> getMapParams(Map<String, String> params) ;
	
}
