package com.tupperware.auto.mysql.mapper;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.plugins.pagination.Pagination; 
import com.tupperware.auto.mysql.model.ConfigController;
import com.baomidou.mybatisplus.mapper.BaseMapper;
/**
 * <p>
 *    Mapper接口
 * </p>
 *
 * @author patrick.wang
 * @since 2018-12-21
 */
public interface ConfigControllerMapper extends BaseMapper<ConfigController> {

    Integer insert(ConfigController record);

    int insertSelective(ConfigController record);
    
    ConfigController selectTopConfigController(@Param("n") int n);
    
    List<ConfigController> selectByMapParam(Map<String,String> params);
    
    List<ConfigController> selectConfigControllerList(Pagination page, @Param("sort") String sort, @Param("order") String order);
    
   	List<ConfigController>  getByFilter(@Param("organno")  String organno, @Param("year")  String year, @Param("month")  String month, @Param("week") String week, @Param("date") String date,
			@Param("organtype") String organtype);
}