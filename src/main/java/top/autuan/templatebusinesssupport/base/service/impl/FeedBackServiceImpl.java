package top.autuan.templatebusinesssupport.base.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import top.autuan.templatebusinesssupport.base.entity.Feedback;
import top.autuan.templatebusinesssupport.base.entity.FeedbackExample;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.autuan.templatebusinesssupport.base.mapper.FeedbackMapper;
import top.autuan.templatebusinesssupport.base.service.FeedBackService;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FeedBackServiceImpl implements FeedBackService {
    private final FeedbackMapper feedbackMapper;

    @Override
    public Feedback detail(Integer id) {
        FeedbackExample feedbackExample = new FeedbackExample();
        feedbackExample.createCriteria()
                .andIdEqualTo(id)
                .andDelFlagEqualTo((byte) 0);
        return feedbackMapper.selectOneByExample(feedbackExample);
    }

    @Override
    public List<Feedback> feedBackList(long memberId, Integer status, Integer feedBackType) {
        FeedbackExample feedbackExample = new FeedbackExample();
        feedbackExample.createCriteria()
                .andMemberIdEqualTo(memberId)
                .andStatusEqualTo(status)
                .andFeedbackTypeEqualTo(feedBackType)
                .andDelFlagEqualTo((byte) 0);
        List<Feedback> feedbacks = feedbackMapper.selectByExample(feedbackExample);
        return feedbacks;
    }

    @Override
    public void changeFeedback(Feedback feedback) {
        log.info("FeedBackServiceImpl -> changeFeedback-> start -> feedback -> {}", feedback);
        FeedbackExample example = new FeedbackExample();
        example.createCriteria()
                .andIdEqualTo(feedback.getId())
                .andDelFlagEqualTo((byte)0);
        feedbackMapper.updateByExampleSelective(feedback,example);
        log.info("FeedBackServiceImpl -> changeFeedback-> end -> feedback -> {}",feedback.getId());
    }

    @Override
    public void changDelFlag(Integer id) {
        log.info("FeedBackServiceImpl -> changDelFlag-> start -> id -> {}", id);
        Feedback feedback = Feedback.builder()
                .delFlag((byte)1)
                .updateTime(LocalDateTime.now())
                .build();
        FeedbackExample example = new FeedbackExample();
        example.createCriteria()
                .andDelFlagEqualTo((byte) 0)
                .andIdEqualTo(id);
        feedbackMapper.updateByExample(feedback,example);
        log.info("FeedBackServiceImpl -> changDelFlag-> end -> feedback -> {}",id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addData(Feedback feedback) {
        log.info("FeedBackServiceImpl -> addData-> start -> feedback -> {}", feedback);
        feedback.setCreateTime(LocalDateTime.now());
        feedbackMapper.insertSelective(feedback);
        log.info("FeedBackServiceImpl -> addData -> end -> feedback -> {}",feedback.getMemberId());
    }

    @Override
    public void deal(Integer id, String reply) {
        log.info("FeedBackServiceImpl -> deal-> start -> id -> {} -> reply -> {}",id, reply);
        Feedback feedback = Feedback.builder()
                .reply(reply)
                .build();
        FeedbackExample example = new FeedbackExample();
        example.createCriteria()
                .andIdEqualTo(id)
                .andDelFlagEqualTo((byte)0);
        feedbackMapper.updateByExampleSelective(feedback,example);
        log.info("FeedBackServiceImpl -> deal-> start -> id ->{}",id);


    }

}
