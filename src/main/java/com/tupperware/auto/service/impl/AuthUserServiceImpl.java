package com.tupperware.auto.service.impl;

import com.tupperware.auto.mysql.model.AuthUser;
import com.tupperware.auto.mysql.mapper.AuthUserMapper;
import com.tupperware.auto.service.IAuthUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tupperware.auto.form.AuthUserHelper;
import com.tupperware.auto.mysql.mapper.AuthUserMapper;
import com.tupperware.auto.mysql.model.AuthUser;
import com.tupperware.auto.service.IAuthUserService;
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
 * @since 2018-09-29
 */
@Service
public class AuthUserServiceImpl extends ServiceImpl<AuthUserMapper, AuthUser> implements IAuthUserService {
	
	 private static Logger logger = Logger.getLogger(AuthUserServiceImpl.class);
	
	@Autowired private AuthUserMapper mapper;	
	 
	private AuthUserHelper helper;

	private int count = 0;

	@Autowired
	public void setBaseMapper() {
		super.baseMapper = mapper;
	}

	
	public void setHelper(AuthUserHelper helper) {
		this.helper = helper;
	}

	
	public boolean Add(AuthUser entity) {
		return super.insert(entity);
	}
	
 	public List<AuthUser> getMapParams(Map<String, String> params) {
		// TODO Auto-generated method stub
		return mapper.selectByMapParam(params);
	}
	public List<AuthUser>getByFilter(String organno, String year, String month, String week, String date,
			String organtype) {
		
		return mapper.getByFilter(organno, year, month, week, date, organtype);
	}
	public AuthUser getTop1(){
		return mapper.selectTopAuthUser(1);	
	}
	
	public void selectDataGrid(PageInfo pageInfo) {
	     	EntityWrapper<AuthUser> wrapper=new EntityWrapper<AuthUser> ();
	   		/*此处写查询条件
	   		   EntityWrapper ew=new EntityWrapper();
		       ew.setEntity(new User());
		       String name="wang";
		       Integer age=16;
		       ew.where("name = {0}",name).andNew("age > {0}",age).orderBy("age");
		       List<User> list = userService.selectList(ew);
		       Page page2 = userService.selectPage(page, ew);
	   		*/
	   		
	        Page<AuthUser> page = new Page<AuthUser>(pageInfo.getNowpage(), pageInfo.getSize());
	        List<AuthUser> list = mapper.selectAuthUserList(page, pageInfo.getSort(), pageInfo.getOrder());
	        pageInfo.setRows(list); 
	        pageInfo.setTotal(mapper.selectCount(wrapper)); 
	
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<AuthUser> getJson(String outletNo,String yearMonth) {
		 EntityWrapper wrapper=new EntityWrapper();
		 wrapper.setEntity(new AuthUser());
		 wrapper.where("year_Month = {0} and outletNo ={1} ", yearMonth,outletNo);
		 return mapper.selectList(wrapper); 
	}

	@Override
	public void selectDataGrid(DataInfo dataInfo) {
		// TODO Auto-generated method stub 
	}
}
