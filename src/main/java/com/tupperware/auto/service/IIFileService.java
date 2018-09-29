package com.tupperware.auto.service;

import com.tupperware.auto.mysql.model.IFile;
import com.baomidou.mybatisplus.service.IService;
import com.tupperware.auto.form.IFileHelper;
import com.tupperware.auto.commons.utils.DataInfo;
import com.tupperware.auto.commons.utils.PageInfo;
import com.baomidou.mybatisplus.service.IService;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 上传的文件信息  服务类
 * </p>
 *
 * @author patrick.wang
 * @since 2018-09-29
 */
public interface IIFileService extends IService<IFile> {
	 
	void setHelper(IFileHelper helper);

	void selectDataGrid(PageInfo pageInfo);
	
	List<IFile> getJson(String outletNo,String yearMonth)  ;
	
	List<IFile> getByFilter(String organno, String year, String month, String week, String date,
			String organtype);
	
	void selectDataGrid(DataInfo dataInfo);
	
	IFile getTop1();
	
	public List<IFile> getMapParams(Map<String, String> params) ;
	
}
