package com.tupperware.auto.mysql.mapper;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.plugins.pagination.Pagination; 
import com.tupperware.auto.mysql.model.ILog;
import com.baomidou.mybatisplus.mapper.BaseMapper;
/**
 * <p>
 *  系统日志表  Mapper接口
 * </p>
 *
 * @author patrick.wang
 * @since 2018-09-29
 */
public interface ILogMapper extends BaseMapper<ILog> {

    Integer insert(ILog record);

    int insertSelective(ILog record);
    
    ILog selectTopILog(@Param("n") int n);
    
    List<ILog> selectByMapParam(Map<String,String> params);
    
    List<ILog> selectILogList(Pagination page, @Param("sort") String sort, @Param("order") String order);
    
   	List<ILog>  getByFilter(@Param("organno")  String organno, @Param("year")  String year, @Param("month")  String month, @Param("week") String week, @Param("date") String date,
			@Param("organtype") String organtype);
}