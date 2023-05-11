package top.autuan.templatebusinesssupport.member.service;

import cn.hutool.db.Page;
import top.autuan.templatebusinesssupport.member.entity.Member;
import top.autuan.web.exception.BusinessException;

import java.util.List;

public interface MemberService {
    /**
     * 登录
     * todo login 响应 member 基本信息，SaTokenInfo 由api 处理
     *
     * @return
     */
    Member login(String mobile, String pwd, String verifyCode);

    /**
     * 注册
     *
     * @param member
     * @return
     */
    Member register(Member member);

    /**
     * 分页查询
     * @param page
     * @param member
     * @return
     */
    List<Member> list(Page page, Member member);

    /**
     * 冻结
     * @param memberId
     * @param reason
     * @return
     */
    void freeze(Long memberId, String reason);

    /**
     * 解冻
     * @param memberId
     * @param reason
     * @return
     */
    void unfreeze(Long memberId, String reason);

    /**
     * 逻辑删除
     * @param memberId
     * @return
     */
    void abandon(Long memberId);


    /**
     * 修改昵称
     * @param memberId
     * @param newName
     */
    void nickname(Long memberId,String newName);


    void avatar(Long memberId, String avatarPath);

    Member findByInvitationCodeOrMobile(String invitationCode);


    // todo impl
    default void destory(){
        throw new BusinessException("您的账号未满足注销条件，请联系客服确认资料");
    }



    /**
     * 根据层级查询用户列表
     * @return
     */
    List<Member> queryMemberListByTier(Integer tier);

    /**
     * 根据pid查询用户列表
     * @return
     */
    List<Member> queryMemberListByPid(Long pid);

    List<Long> listIdDirectInvited(Long id);
}
