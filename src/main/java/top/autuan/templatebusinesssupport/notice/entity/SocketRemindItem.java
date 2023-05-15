package top.autuan.templatebusinesssupport.notice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SocketRemindItem {
    // todo 事件类型
    private Integer sourceType;
    private Integer sourceId;
    private Integer action;

    // 做出动作的用户id
    private Integer action_user_id;
    // 动作目标用户id
    private Integer action_aim_user_id;

    // 要通知的用户名
    private String username;
}
