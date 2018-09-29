package com.tupperware.auto.mysql.mapper;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.plugins.pagination.Pagination; 
import com.tupperware.auto.mysql.model.AuthOperation;
import com.baomidou.mybatisplus.mapper.BaseMapper;
/**
 * <p>
 *  权限信息表  Mapper接口
 * </p>
 *
 * @author patrick.wang
 * @since 2018-09-29
 */
public interface AuthOperationMapper extends BaseMapper<AuthOperation> {

    Integer insert(AuthOperation record);

    int insertSelective(AuthOperation record);
    
    AuthOperation selectTopAuthOperation(@Param("n") int n);
    
    List<AuthOperation> selectByMapParam(Map<String,String> params);
    
    List<AuthOperation> selectAuthOperationList(Pagination page, @Param("sort") String sort, @Param("order") String order);
    
   	List<AuthOperation>  getByFilter(@Param("organno")  String organno, @Param("year")  String year, @Param("month")  String month, @Param("week") String week, @Param("date") String date,
			@Param("organtype") String organtype);
}