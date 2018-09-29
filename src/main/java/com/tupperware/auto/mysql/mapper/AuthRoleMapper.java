package com.tupperware.auto.mysql.mapper;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.plugins.pagination.Pagination; 
import com.tupperware.auto.mysql.model.AuthRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;
/**
 * <p>
 *  角色信息表  Mapper接口
 * </p>
 *
 * @author patrick.wang
 * @since 2018-09-29
 */
public interface AuthRoleMapper extends BaseMapper<AuthRole> {

    Integer insert(AuthRole record);

    int insertSelective(AuthRole record);
    
    AuthRole selectTopAuthRole(@Param("n") int n);
    
    List<AuthRole> selectByMapParam(Map<String,String> params);
    
    List<AuthRole> selectAuthRoleList(Pagination page, @Param("sort") String sort, @Param("order") String order);
    
   	List<AuthRole>  getByFilter(@Param("organno")  String organno, @Param("year")  String year, @Param("month")  String month, @Param("week") String week, @Param("date") String date,
			@Param("organtype") String organtype);
}