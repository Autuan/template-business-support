package top.autuan.templatebusinesssupport.member.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.autuan.templatebusinesssupport.member.entity.Member;
import top.autuan.templatebusinesssupport.member.entity.MemberExample;

public interface MemberMapper {
    long countByExample(MemberExample example);

    int deleteByExample(MemberExample example);

    int deleteByPrimaryKey(Integer memberId);

    int insert(Member record);

    int insertSelective(@Param("record") Member record, @Param("selective") Member.Column ... selective);

    Member selectOneByExample(MemberExample example);

    List<Member> selectByExample(MemberExample example);

    Member selectByPrimaryKey(Integer memberId);

    int updateByExampleSelective(@Param("record") Member record, @Param("example") MemberExample example, @Param("selective") Member.Column ... selective);

    int updateByExample(@Param("record") Member record, @Param("example") MemberExample example);

    int updateByPrimaryKeySelective(@Param("record") Member record, @Param("selective") Member.Column ... selective);

    int updateByPrimaryKey(Member record);

    int batchInsert(@Param("list") List<Member> list);

    int batchInsertSelective(@Param("list") List<Member> list, @Param("selective") Member.Column ... selective);
}