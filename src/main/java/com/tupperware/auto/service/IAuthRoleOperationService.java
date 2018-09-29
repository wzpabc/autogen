package com.tupperware.auto.service;

import com.tupperware.auto.mysql.model.AuthRoleOperation;
import com.baomidou.mybatisplus.service.IService;
import com.tupperware.auto.form.AuthRoleOperationHelper;
import com.tupperware.auto.commons.utils.DataInfo;
import com.tupperware.auto.commons.utils.PageInfo;
import com.baomidou.mybatisplus.service.IService;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色权限关系表  服务类
 * </p>
 *
 * @author patrick.wang
 * @since 2018-09-29
 */
public interface IAuthRoleOperationService extends IService<AuthRoleOperation> {
	 
	void setHelper(AuthRoleOperationHelper helper);

	void selectDataGrid(PageInfo pageInfo);
	
	List<AuthRoleOperation> getJson(String outletNo,String yearMonth)  ;
	
	List<AuthRoleOperation> getByFilter(String organno, String year, String month, String week, String date,
			String organtype);
	
	void selectDataGrid(DataInfo dataInfo);
	
	AuthRoleOperation getTop1();
	
	public List<AuthRoleOperation> getMapParams(Map<String, String> params) ;
	
}
