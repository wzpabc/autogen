package com.tupperware.auto.mysql.mapper;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.plugins.pagination.Pagination; 
import com.tupperware.auto.mysql.model.AuthRoleOperation;
import com.baomidou.mybatisplus.mapper.BaseMapper;
/**
 * <p>
 *  角色权限关系表  Mapper接口
 * </p>
 *
 * @author patrick.wang
 * @since 2018-09-29
 */
public interface AuthRoleOperationMapper extends BaseMapper<AuthRoleOperation> {

    Integer insert(AuthRoleOperation record);

    int insertSelective(AuthRoleOperation record);
    
    AuthRoleOperation selectTopAuthRoleOperation(@Param("n") int n);
    
    List<AuthRoleOperation> selectByMapParam(Map<String,String> params);
    
    List<AuthRoleOperation> selectAuthRoleOperationList(Pagination page, @Param("sort") String sort, @Param("order") String order);
    
   	List<AuthRoleOperation>  getByFilter(@Param("organno")  String organno, @Param("year")  String year, @Param("month")  String month, @Param("week") String week, @Param("date") String date,
			@Param("organtype") String organtype);
}