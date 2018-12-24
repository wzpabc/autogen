package com.tupperware.auto.service.impl;

import com.tupperware.auto.mysql.model.ConfigController;
import com.tupperware.auto.mysql.mapper.ConfigControllerMapper;
import com.tupperware.auto.service.IConfigControllerService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tupperware.auto.form.ConfigControllerHelper;
import com.tupperware.auto.mysql.mapper.ConfigControllerMapper;
import com.tupperware.auto.mysql.model.ConfigController;
import com.tupperware.auto.service.IConfigControllerService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tupperware.auto.commons.utils.DataInfo;
import com.tupperware.auto.commons.utils.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
/**
 * <p>
 *   服务实现类
 * </p>
 * @author patrick.wang
 * @since 2018-12-24
 */
@Service
public class ConfigControllerServiceImpl extends ServiceImpl<ConfigControllerMapper, ConfigController> implements IConfigControllerService {
	
	 private static Logger logger = Logger.getLogger(ConfigControllerServiceImpl.class);
	
	@Autowired private ConfigControllerMapper mapper;	
	 
	private ConfigControllerHelper helper;

	private int count = 0;

	@Autowired
	public void setBaseMapper() {
		super.baseMapper = mapper;
	}

	
	public void setHelper(ConfigControllerHelper helper) {
		this.helper = helper;
	}

	
	public boolean Add(ConfigController entity) {
		return super.insert(entity);
	}
	
 	public List<ConfigController> getMapParams(Map<String, String> params) {
		// TODO Auto-generated method stub
		return mapper.selectByMapParam(params);
	}
	public List<ConfigController>getByFilter(String organno, String year, String month, String week, String date,
			String organtype) {
		
		return mapper.getByFilter(organno, year, month, week, date, organtype);
	}
	public ConfigController getTop1(){
		return mapper.selectTopConfigController(1);	
	}
	
	public void selectDataGrid(PageInfo pageInfo) {
	     	EntityWrapper<ConfigController> wrapper=new EntityWrapper<ConfigController> ();
	   		/*此处写查询条件
	   		   EntityWrapper ew=new EntityWrapper();
		       ew.setEntity(new User());
		       String name="wang";
		       Integer age=16;
		       ew.where("name = {0}",name).andNew("age > {0}",age).orderBy("age");
		       List<User> list = userService.selectList(ew);
		       Page page2 = userService.selectPage(page, ew);
	   		*/
	   		
	        Page<ConfigController> page = new Page<ConfigController>(pageInfo.getNowpage(), pageInfo.getSize());
	        List<ConfigController> list = mapper.selectConfigControllerList(page, pageInfo.getSort(), pageInfo.getOrder());
	        pageInfo.setRows(list); 
	        pageInfo.setTotal(mapper.selectCount(wrapper)); 
	
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<ConfigController> getJson(String outletNo,String yearMonth) {
		 EntityWrapper wrapper=new EntityWrapper();
		 wrapper.setEntity(new ConfigController());
		 wrapper.where("year_Month = {0} and outletNo ={1} ", yearMonth,outletNo);
		 return mapper.selectList(wrapper); 
	}

	public List<ConfigController> list() {
        EntityWrapper wrapper=new EntityWrapper();
        wrapper.setEntity(new ConfigController());
        return mapper.selectList(wrapper);
	}


	@Override
	public void selectDataGrid(DataInfo dataInfo) {
		// TODO Auto-generated method stub 
	}

	public List<ConfigController> selectController(String table){

		return mapper.selectController(table);
	}
}
