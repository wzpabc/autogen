package com.tupperware.auto.mysql.mapper;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.plugins.pagination.Pagination; 
import com.tupperware.auto.mysql.model.JobEmail;
import com.baomidou.mybatisplus.mapper.BaseMapper;
/**
 * <p>
 *    Mapper接口
 * </p>
 *
 * @author patrick.wang
 * @since 2018-12-26 11:16:15
 */
public interface JobEmailMapper extends BaseMapper<JobEmail> {

    Integer insert(JobEmail record);

    int insertSelective(JobEmail record);
    
    JobEmail selectTopJobEmail(@Param("n") int n);
    
    List<JobEmail> selectByMapParam(Map<String,String> params);
    
    List<JobEmail> selectJobEmailList(Pagination page, @Param("sort") String sort, @Param("order") String order);
    
   	List<JobEmail>  getByFilter(@Param("organno")  String organno, @Param("year")  String year, @Param("month")  String month, @Param("week") String week, @Param("date") String date,
			@Param("organtype") String organtype);
}