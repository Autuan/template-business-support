package top.autuan.templatebusinesssupport.member.service.impl;

import cn.hutool.core.util.*;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.db.Page;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import top.autuan.templatebusinesssupport.member.entity.Member;
import top.autuan.templatebusinesssupport.member.entity.MemberExample;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.autuan.captcha.CaptchaComponent;
import top.autuan.shortchain.ShortChainComponent;
import top.autuan.templatebusinesssupport.member.mapper.MemberMapper;
import top.autuan.templatebusinesssupport.member.service.MemberService;
import top.autuan.web.exception.BusinessException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberMapper memberMapper;

    private final CaptchaComponent captchaComponent;

    private final ShortChainComponent shortChainComponent;


    @Override
    public Member login(String mobile, String pwd, String verifyCode) {
        log.info("MemberServiceImpl -> login -> mobile -> {} verifyCode -> {}", mobile, verifyCode);

        // 验证码验证
        Boolean pass = captchaComponent.verifyCaptcha(mobile, verifyCode);
        if (!pass) {
            log.info("MemberServiceImpl -> login -> code error -> mobile -> {}",mobile);
            throw new BusinessException("验证码错误");
        }

        // 密码验证
        String originPwd = pwd;
        String prefix = StrUtil.sub(originPwd, 0, 5);
        String password = SecureUtil.md5(originPwd + prefix);

        MemberExample example = new MemberExample();
        example.createCriteria()
                .andBanEqualTo(0)
                .andPasswordEqualTo(password)
                .andMobileEqualTo(mobile);
        Member member = memberMapper.selectOneByExample(example);
        log.info("MemberServiceImpl -> login -> null == member -> {}", null == member);
        if (null == member) {
            log.info("MemberServiceImpl -> login -> mobile or password error -> mobile -> {}",mobile);
            throw new BusinessException("手机号或密码错误");
        }

        log.info("MemberServiceImpl -> login -> end done -> mobile -> {}",mobile);
        return member;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Member register(Member member) {
        log.info("MemberServiceImpl -> register -> start param -> {}", member);
        // todo 日志调整
        MemberExample example = new MemberExample();
        String mobile = member.getMobile();
        example.createCriteria()
                .andMobileEqualTo(mobile);
        Member record = memberMapper.selectOneByExample(example);
        if (null != record) {
            log.info("MemberServiceImpl -> register -> end : phone register -> mobile -> {}", mobile);
            throw new BusinessException("此手机号已注册，请检查");
        }
        // 邀请码
        String invitationCode = member.getInvitationCode();
        Member parent = findByInvitationCodeOrMobile(invitationCode);
        if (null == parent) {
            log.info("MemberServiceImpl -> register -> end : illegal invitationCode -> mobile -> {}", mobile);
            throw new BusinessException("邀请码无效");
        }
        member.setPid(parent.getId());
        //会员层级在推荐人层级上加一
        member.setTier(parent.getTier() + 1);
        //手机号
        if (ObjectUtil.isEmpty(parent.getId())) {
            parent = findByInvitationCodeOrMobile(mobile);
            if (null == parent) {
                log.info("MemberServiceImpl -> register -> end : mobile error -> mobile -> {}", mobile);
                throw new BusinessException("手机号无效");
            }
            member.setPid(parent.getId());
            member.setTier(parent.getTier() + 1);
        }

        // 短链
        String generateShortCode = shortChainComponent.generateShortCode("invitation", member.getMobile());
        member.setInvitationCode(generateShortCode);

        String originPwd = member.getPassword();
        String prefix = StrUtil.sub(originPwd, 0, 5);
        String password = SecureUtil.md5(originPwd + prefix);
        member.setPassword(password);

        member.setNickname(DesensitizedUtil.mobilePhone(mobile));

        Long parentOwnerTeamId = parent.getOwnerTeamId();
        member.setTeamId(parentOwnerTeamId);

        long id = IdUtil.getSnowflake().nextId();
        member.setId(id);
        member.setNo(getMemberNo());
        memberMapper.insertSelective(member);

        log.info("MemberServiceImpl -> register -> end -> mobile -> {}",mobile);
        // todo 事件提交

        return member;
    }

    @Override
    public List<Member> list(Page page, Member member) {
        MemberExample example = new MemberExample();
        example.page(page.getPageNumber(), page.getPageSize());

        // 查询条件
        MemberExample.Criteria criteria = example.createCriteria();
        if (StrUtil.isNotBlank(member.getMobile())) {
            criteria.andMobileLike("%" + member.getMobile() + "%");
        }
        List<Member> list = memberMapper.selectByExample(example);
        return list;
    }

    @Override
    public void freeze(Long memberId, String reason) {
        log.info("MemberServiceImpl -> freeze -> memberId -> {} reason -> {}", memberId, reason);
        Member member = Member.builder()
                .ban(1)
                .build();
        MemberExample example = new MemberExample();
        example.createCriteria()
                .andIdEqualTo(memberId);
        int i = memberMapper.updateByExample(member, example);
        log.info("MemberServiceImpl -> freeze -> end -> {}", i);
    }

    @Override
    public void unfreeze(Long memberId, String reason) {
        log.info("MemberServiceImpl -> unfreeze -> memberId -> {} reason -> {}", memberId, reason);
        Member member = Member.builder()
                .ban(0)
                .build();
        MemberExample example = new MemberExample();
        example.createCriteria()
                .andIdEqualTo(memberId);
        int i = memberMapper.updateByExample(member, example);
        log.info("MemberServiceImpl -> unfreeze -> end -> {}", i);

    }

    @Override
    public void abandon(Long memberId) {
        log.info("MemberServiceImpl -> abandon -> memberId -> {}", memberId);

        Member member = Member.builder()
                .delFlag((byte) 1)
                .build();
        MemberExample example = new MemberExample();
        example.createCriteria()
                .andIdEqualTo(memberId);
        int i = memberMapper.updateByExample(member, example);
        log.info("MemberServiceImpl -> abandon -> end -> {}", i);

    }



    @Override
    @Transactional
    public void nickname(Long memberId, String newName) {
        Member obj = Member.builder()
                .nickname(newName)
                .build();
        MemberExample example = new MemberExample();
        example.createCriteria()
                .andIdEqualTo(memberId);
        log.info("MemberServiceImpl -> nickname -> start param -> {},{}", obj, example);
        memberMapper.updateByExampleSelective(obj, example);

        // todo 提交事件
        log.info("MemberServiceImpl -> nickname -> end");
    }

    @Override
    @Transactional
    public void avatar(Long memberId, String avatarPath) {
        log.info("MemberServiceImpl -> avatar -> start memberId -> {} avatar -> {}", memberId, avatarPath);
        Member obj = Member.builder()
                .avatar(avatarPath)
                .build();
        MemberExample example = new MemberExample();
        example.createCriteria()
                .andIdEqualTo(memberId);
        memberMapper.updateByExampleSelective(obj, example);

        // todo 提交事件
        log.info("MemberServiceImpl -> avatar -> end");

    }

    @Override
    public Member findByInvitationCodeOrMobile(String invitationCode) {
        MemberExample example = new MemberExample();
        example.createCriteria()
                .andInvitationCodeEqualTo(invitationCode);
        example.or().andMobileEqualTo(invitationCode);
        example.or().andNoEqualTo(invitationCode);
        Member member = memberMapper.selectOneByExample(example);
        return member;
    }



    @Override
    public List<Member> queryMemberListByTier(Integer tier) {
        MemberExample example = new MemberExample();
        example.createCriteria()
                .andTierEqualTo(tier);
        List<Member> members = memberMapper.selectByExample(example);
        return members;
    }

    @Override
    public List<Member> queryMemberListByPid(Long pid) {
        MemberExample example = new MemberExample();
        example.createCriteria()
                .andPidEqualTo(pid);
        List<Member> members = memberMapper.selectByExample(example);
        return members;
    }


    @Override
    public List<Long> listIdDirectInvited(Long id) {
        MemberExample example = new MemberExample();
        example.createCriteria()
                .andDelFlagEqualTo((byte) 0)
                .andPidEqualTo(id);
        List<Member> members = memberMapper.selectByExample(example);

        return members.stream()
                .map(Member::getId)
                .collect(Collectors.toList());
    }

    /**
     * 获取会员唯一编号
     *
     * @return
     */
    public String getMemberNo() {
        // todo 取消递归
        String str = RandomUtil.randomNumbers(8);
        MemberExample example = new MemberExample();
        example.createCriteria()
                .andNoEqualTo(str);
        Member member = memberMapper.selectOneByExample(example);
        if (Objects.nonNull(member)) {
            return getMemberNo();
        }
        return str;
    }
}
