package com.tupperware.auto.service;

import com.tupperware.auto.mysql.model.ILog;
import com.baomidou.mybatisplus.service.IService;
import com.tupperware.auto.form.ILogHelper;
import com.tupperware.auto.commons.utils.DataInfo;
import com.tupperware.auto.commons.utils.PageInfo;
import com.baomidou.mybatisplus.service.IService;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统日志表  服务类
 * </p>
 *
 * @author patrick.wang
 * @since 2018-09-29
 */
public interface IILogService extends IService<ILog> {
	 
	void setHelper(ILogHelper helper);

	void selectDataGrid(PageInfo pageInfo);
	
	List<ILog> getJson(String outletNo,String yearMonth)  ;
	
	List<ILog> getByFilter(String organno, String year, String month, String week, String date,
			String organtype);
	
	void selectDataGrid(DataInfo dataInfo);
	
	ILog getTop1();
	
	public List<ILog> getMapParams(Map<String, String> params) ;
	
}
