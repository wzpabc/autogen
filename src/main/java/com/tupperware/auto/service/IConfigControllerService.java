package com.tupperware.auto.service;

import com.tupperware.auto.mysql.model.ConfigController;
import com.baomidou.mybatisplus.service.IService;
import com.tupperware.auto.form.ConfigControllerHelper;
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
 * @since 2018-12-21
 */
public interface IConfigControllerService extends IService<ConfigController> {
	 
	void setHelper(ConfigControllerHelper helper);

	void selectDataGrid(PageInfo pageInfo);
	
	List<ConfigController> getJson(String outletNo,String yearMonth)  ;
	
	List<ConfigController> getByFilter(String organno, String year, String month, String week, String date,
			String organtype);
	
	void selectDataGrid(DataInfo dataInfo);
	
	ConfigController getTop1();
	
	public List<ConfigController> getMapParams(Map<String, String> params) ;
	
}
