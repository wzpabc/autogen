package com.tupperware.auto.service;

import com.tupperware.auto.mysql.model.IArticle;
import com.baomidou.mybatisplus.service.IService;
import com.tupperware.auto.form.IArticleHelper;
import com.tupperware.auto.commons.utils.DataInfo;
import com.tupperware.auto.commons.utils.PageInfo;
import com.baomidou.mybatisplus.service.IService;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 文章信息表  服务类
 * </p>
 *
 * @author patrick.wang
 * @since 2018-09-29
 */
public interface IIArticleService extends IService<IArticle> {
	 
	void setHelper(IArticleHelper helper);

	void selectDataGrid(PageInfo pageInfo);
	
	List<IArticle> getJson(String outletNo,String yearMonth)  ;
	
	List<IArticle> getByFilter(String organno, String year, String month, String week, String date,
			String organtype);
	
	void selectDataGrid(DataInfo dataInfo);
	
	IArticle getTop1();
	
	public List<IArticle> getMapParams(Map<String, String> params) ;
	
}
