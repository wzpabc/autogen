package com.tupperware.auto.service;

import com.tupperware.auto.mysql.model.AuthOperation;
import com.baomidou.mybatisplus.service.IService;
import com.tupperware.auto.form.AuthOperationHelper;
import com.tupperware.auto.commons.utils.DataInfo;
import com.tupperware.auto.commons.utils.PageInfo;
import com.baomidou.mybatisplus.service.IService;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 权限信息表  服务类
 * </p>
 *
 * @author patrick.wang
 * @since 2018-09-29
 */
public interface IAuthOperationService extends IService<AuthOperation> {
	 
	void setHelper(AuthOperationHelper helper);

	void selectDataGrid(PageInfo pageInfo);
	
	List<AuthOperation> getJson(String outletNo,String yearMonth)  ;
	
	List<AuthOperation> getByFilter(String organno, String year, String month, String week, String date,
			String organtype);
	
	void selectDataGrid(DataInfo dataInfo);
	
	AuthOperation getTop1();
	
	public List<AuthOperation> getMapParams(Map<String, String> params) ;
	
}
