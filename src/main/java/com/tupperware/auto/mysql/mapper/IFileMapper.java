package com.tupperware.auto.mysql.mapper;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.plugins.pagination.Pagination; 
import com.tupperware.auto.mysql.model.IFile;
import com.baomidou.mybatisplus.mapper.BaseMapper;
/**
 * <p>
 *  上传的文件信息  Mapper接口
 * </p>
 *
 * @author patrick.wang
 * @since 2018-09-29
 */
public interface IFileMapper extends BaseMapper<IFile> {

    Integer insert(IFile record);

    int insertSelective(IFile record);
    
    IFile selectTopIFile(@Param("n") int n);
    
    List<IFile> selectByMapParam(Map<String,String> params);
    
    List<IFile> selectIFileList(Pagination page, @Param("sort") String sort, @Param("order") String order);
    
   	List<IFile>  getByFilter(@Param("organno")  String organno, @Param("year")  String year, @Param("month")  String month, @Param("week") String week, @Param("date") String date,
			@Param("organtype") String organtype);
}