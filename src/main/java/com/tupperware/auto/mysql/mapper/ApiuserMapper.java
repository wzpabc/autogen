package com.tupperware.auto.mysql.mapper;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.plugins.pagination.Pagination; 
import com.tupperware.auto.mysql.model.Apiuser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
/**
 * <p>
 *    Mapper接口
 * </p>
 *
 * @author patrick.wang
 * @since 2018-12-26 11:16:15
 */
public interface ApiuserMapper extends BaseMapper<Apiuser> {

    Integer insert(Apiuser record);

    int insertSelective(Apiuser record);
    
    Apiuser selectTopApiuser(@Param("n") int n);
    
    List<Apiuser> selectByMapParam(Map<String,String> params);
    
    List<Apiuser> selectApiuserList(Pagination page, @Param("sort") String sort, @Param("order") String order);
    
   	List<Apiuser>  getByFilter(@Param("organno")  String organno, @Param("year")  String year, @Param("month")  String month, @Param("week") String week, @Param("date") String date,
			@Param("organtype") String organtype);
}