package com.tupperware.auto.service.impl;

import com.tupperware.auto.mysql.model.IArticle;
import com.tupperware.auto.mysql.mapper.IArticleMapper;
import com.tupperware.auto.service.IIArticleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tupperware.auto.form.IArticleHelper;
import com.tupperware.auto.mysql.mapper.IArticleMapper;
import com.tupperware.auto.mysql.model.IArticle;
import com.tupperware.auto.service.IIArticleService;
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
 * 文章信息表  服务实现类
 * </p>
 * @author patrick.wang
 * @since 2018-09-29
 */
@Service
public class IArticleServiceImpl extends ServiceImpl<IArticleMapper, IArticle> implements IIArticleService {
	
	 private static Logger logger = Logger.getLogger(IArticleServiceImpl.class);
	
	@Autowired private IArticleMapper mapper;	
	 
	private IArticleHelper helper;

	private int count = 0;

	@Autowired
	public void setBaseMapper() {
		super.baseMapper = mapper;
	}

	
	public void setHelper(IArticleHelper helper) {
		this.helper = helper;
	}

	
	public boolean Add(IArticle entity) {
		return super.insert(entity);
	}
	
 	public List<IArticle> getMapParams(Map<String, String> params) {
		// TODO Auto-generated method stub
		return mapper.selectByMapParam(params);
	}
	public List<IArticle>getByFilter(String organno, String year, String month, String week, String date,
			String organtype) {
		
		return mapper.getByFilter(organno, year, month, week, date, organtype);
	}
	public IArticle getTop1(){
		return mapper.selectTopIArticle(1);	
	}
	
	public void selectDataGrid(PageInfo pageInfo) {
	     	EntityWrapper<IArticle> wrapper=new EntityWrapper<IArticle> ();
	   		/*此处写查询条件
	   		   EntityWrapper ew=new EntityWrapper();
		       ew.setEntity(new User());
		       String name="wang";
		       Integer age=16;
		       ew.where("name = {0}",name).andNew("age > {0}",age).orderBy("age");
		       List<User> list = userService.selectList(ew);
		       Page page2 = userService.selectPage(page, ew);
	   		*/
	   		
	        Page<IArticle> page = new Page<IArticle>(pageInfo.getNowpage(), pageInfo.getSize());
	        List<IArticle> list = mapper.selectIArticleList(page, pageInfo.getSort(), pageInfo.getOrder());
	        pageInfo.setRows(list); 
	        pageInfo.setTotal(mapper.selectCount(wrapper)); 
	
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<IArticle> getJson(String outletNo,String yearMonth) {
		 EntityWrapper wrapper=new EntityWrapper();
		 wrapper.setEntity(new IArticle());
		 wrapper.where("year_Month = {0} and outletNo ={1} ", yearMonth,outletNo);
		 return mapper.selectList(wrapper); 
	}

	@Override
	public void selectDataGrid(DataInfo dataInfo) {
		// TODO Auto-generated method stub 
	}
}
