package com.tupperware.auto.service.impl;

import com.tupperware.auto.mysql.model.Apiuser;
import com.tupperware.auto.mysql.mapper.ApiuserMapper;
import com.tupperware.auto.service.IApiuserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tupperware.auto.form.ApiuserHelper;
import com.tupperware.auto.mysql.mapper.ApiuserMapper;
import com.tupperware.auto.mysql.model.Apiuser;
import com.tupperware.auto.service.IApiuserService;
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
 * @since 2018-12-26 11:16:15
 */
@Service
public class ApiuserServiceImpl extends ServiceImpl<ApiuserMapper, Apiuser> implements IApiuserService {
	
	 private static Logger logger = Logger.getLogger(ApiuserServiceImpl.class);
	
	@Autowired private ApiuserMapper mapper;	
	 
	private ApiuserHelper helper;

	private int count = 0;

	@Autowired
	public void setBaseMapper() {
		super.baseMapper = mapper;
	}

	
	public void setHelper(ApiuserHelper helper) {
		this.helper = helper;
	}

	
	public boolean Add(Apiuser entity) {
		return super.insert(entity);
	}
	
 	public List<Apiuser> getMapParams(Map<String, String> params) {
		// TODO Auto-generated method stub
		return mapper.selectByMapParam(params);
	}
	public List<Apiuser>getByFilter(String organno, String year, String month, String week, String date,
			String organtype) {
		
		return mapper.getByFilter(organno, year, month, week, date, organtype);
	}
	public Apiuser getTop1(){
		return mapper.selectTopApiuser(1);	
	}
	
	public void selectDataGrid(PageInfo pageInfo) {
	     	EntityWrapper<Apiuser> wrapper=new EntityWrapper<Apiuser> ();
	   		Page<Apiuser> page = new Page<Apiuser>(pageInfo.getNowpage(), pageInfo.getSize());
	        List<Apiuser> list = mapper.selectApiuserList(page, pageInfo.getSort(), pageInfo.getOrder());
	        pageInfo.setRows(list); 
	        pageInfo.setTotal(mapper.selectCount(wrapper)); 
	
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Apiuser> getJson(String outletNo,String yearMonth) {
		 EntityWrapper wrapper=new EntityWrapper();
		 wrapper.setEntity(new Apiuser());
		 wrapper.where("year_Month = {0} and outletNo ={1} ", yearMonth,outletNo);
		 return mapper.selectList(wrapper); 
	}

	public List<Apiuser> list() {
        EntityWrapper wrapper=new EntityWrapper();
        wrapper.setEntity(new Apiuser());
        return mapper.selectList(wrapper);
	}

	@Override
	public void selectDataGrid(DataInfo dataInfo) {
		// TODO Auto-generated method stub 
	}

	/** notes_apiuser
	 * @param username
	 * @return List<Apiuser>
	 * @see List<Apiuser>
	 * 2018-12-26 11:16:15
	 */
	public List<Apiuser>  username(String username ) {
        EntityWrapper<Apiuser> wrapper = new EntityWrapper<>();
        wrapper.setEntity(new Apiuser());
	    wrapper.and("username = {0}", username); //''
		
		logger.info(wrapper.getSqlSegment());
        return mapper.selectList(wrapper);
    }


}
