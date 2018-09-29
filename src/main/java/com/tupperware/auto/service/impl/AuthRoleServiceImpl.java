package com.tupperware.auto.service.impl;

import com.tupperware.auto.mysql.model.AuthRole;
import com.tupperware.auto.mysql.mapper.AuthRoleMapper;
import com.tupperware.auto.service.IAuthRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tupperware.auto.form.AuthRoleHelper;
import com.tupperware.auto.mysql.mapper.AuthRoleMapper;
import com.tupperware.auto.mysql.model.AuthRole;
import com.tupperware.auto.service.IAuthRoleService;
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
 * 角色信息表  服务实现类
 * </p>
 * @author patrick.wang
 * @since 2018-09-29
 */
@Service
public class AuthRoleServiceImpl extends ServiceImpl<AuthRoleMapper, AuthRole> implements IAuthRoleService {
	
	 private static Logger logger = Logger.getLogger(AuthRoleServiceImpl.class);
	
	@Autowired private AuthRoleMapper mapper;	
	 
	private AuthRoleHelper helper;

	private int count = 0;

	@Autowired
	public void setBaseMapper() {
		super.baseMapper = mapper;
	}

	
	public void setHelper(AuthRoleHelper helper) {
		this.helper = helper;
	}

	
	public boolean Add(AuthRole entity) {
		return super.insert(entity);
	}
	
 	public List<AuthRole> getMapParams(Map<String, String> params) {
		// TODO Auto-generated method stub
		return mapper.selectByMapParam(params);
	}
	public List<AuthRole>getByFilter(String organno, String year, String month, String week, String date,
			String organtype) {
		
		return mapper.getByFilter(organno, year, month, week, date, organtype);
	}
	public AuthRole getTop1(){
		return mapper.selectTopAuthRole(1);	
	}
	
	public void selectDataGrid(PageInfo pageInfo) {
	     	EntityWrapper<AuthRole> wrapper=new EntityWrapper<AuthRole> ();
	   		/*此处写查询条件
	   		   EntityWrapper ew=new EntityWrapper();
		       ew.setEntity(new User());
		       String name="wang";
		       Integer age=16;
		       ew.where("name = {0}",name).andNew("age > {0}",age).orderBy("age");
		       List<User> list = userService.selectList(ew);
		       Page page2 = userService.selectPage(page, ew);
	   		*/
	   		
	        Page<AuthRole> page = new Page<AuthRole>(pageInfo.getNowpage(), pageInfo.getSize());
	        List<AuthRole> list = mapper.selectAuthRoleList(page, pageInfo.getSort(), pageInfo.getOrder());
	        pageInfo.setRows(list); 
	        pageInfo.setTotal(mapper.selectCount(wrapper)); 
	
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<AuthRole> getJson(String outletNo,String yearMonth) {
		 EntityWrapper wrapper=new EntityWrapper();
		 wrapper.setEntity(new AuthRole());
		 wrapper.where("year_Month = {0} and outletNo ={1} ", yearMonth,outletNo);
		 return mapper.selectList(wrapper); 
	}

	@Override
	public void selectDataGrid(DataInfo dataInfo) {
		// TODO Auto-generated method stub 
	}
}
