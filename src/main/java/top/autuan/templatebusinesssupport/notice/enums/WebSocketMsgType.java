package top.autuan.templatebusinesssupport.notice.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WebSocketMsgType {
    NOTIFICATION(0,"通知类型消息"),
    ;
    private Integer type;
    private String description;
}
