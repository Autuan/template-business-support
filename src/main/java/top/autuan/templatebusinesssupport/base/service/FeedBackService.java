package top.autuan.templatebusinesssupport.base.service;

import top.autuan.templatebusinesssupport.base.entity.Feedback;

import java.util.List;

public interface FeedBackService {
    Feedback detail(Integer id);

    List<Feedback> feedBackList(long memberId, Integer status, Integer feedBackType);

    void changeFeedback( Feedback feedback);

    void changDelFlag(Integer id);

    void addData(Feedback feedback);

    void deal(Integer id, String reply);


}
