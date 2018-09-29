package com.tupperware.auto.mysql.mapper;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.plugins.pagination.Pagination; 
import com.tupperware.auto.mysql.model.AuthUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
/**
 * <p>
 *    Mapper接口
 * </p>
 *
 * @author patrick.wang
 * @since 2018-09-29
 */
public interface AuthUserMapper extends BaseMapper<AuthUser> {

    Integer insert(AuthUser record);

    int insertSelective(AuthUser record);
    
    AuthUser selectTopAuthUser(@Param("n") int n);
    
    List<AuthUser> selectByMapParam(Map<String,String> params);
    
    List<AuthUser> selectAuthUserList(Pagination page, @Param("sort") String sort, @Param("order") String order);
    
   	List<AuthUser>  getByFilter(@Param("organno")  String organno, @Param("year")  String year, @Param("month")  String month, @Param("week") String week, @Param("date") String date,
			@Param("organtype") String organtype);
}