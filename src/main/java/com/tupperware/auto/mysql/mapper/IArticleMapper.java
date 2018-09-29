package com.tupperware.auto.mysql.mapper;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.plugins.pagination.Pagination; 
import com.tupperware.auto.mysql.model.IArticle;
import com.baomidou.mybatisplus.mapper.BaseMapper;
/**
 * <p>
 *  文章信息表  Mapper接口
 * </p>
 *
 * @author patrick.wang
 * @since 2018-09-29
 */
public interface IArticleMapper extends BaseMapper<IArticle> {

    Integer insert(IArticle record);

    int insertSelective(IArticle record);
    
    IArticle selectTopIArticle(@Param("n") int n);
    
    List<IArticle> selectByMapParam(Map<String,String> params);
    
    List<IArticle> selectIArticleList(Pagination page, @Param("sort") String sort, @Param("order") String order);
    
   	List<IArticle>  getByFilter(@Param("organno")  String organno, @Param("year")  String year, @Param("month")  String month, @Param("week") String week, @Param("date") String date,
			@Param("organtype") String organtype);
}