package top.autuan.templatebusinesssupport.base.mapper;

import top.autuan.templatebusinesssupport.base.entity.AppVersions;
import top.autuan.templatebusinesssupport.base.entity.AppVersionsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppVersionsMapper {
    long countByExample(AppVersionsExample example);

    int deleteByExample(AppVersionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppVersions record);

    int insertSelective(@Param("record") AppVersions record, @Param("selective") AppVersions.Column ... selective);

    AppVersions selectOneByExample(AppVersionsExample example);

    List<AppVersions> selectByExample(AppVersionsExample example);

    AppVersions selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppVersions record, @Param("example") AppVersionsExample example, @Param("selective") AppVersions.Column ... selective);

    int updateByExample(@Param("record") AppVersions record, @Param("example") AppVersionsExample example);

    int updateByPrimaryKeySelective(@Param("record") AppVersions record, @Param("selective") AppVersions.Column ... selective);

    int updateByPrimaryKey(AppVersions record);

    int batchInsert(@Param("list") List<AppVersions> list);

    int batchInsertSelective(@Param("list") List<AppVersions> list, @Param("selective") AppVersions.Column ... selective);
}