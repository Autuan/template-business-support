package top.autuan.templatebusinesssupport.notice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SocketMsgRes<T> {
    // todo 改为 WebSocketMsgType 对象
    private Integer type;
    private T data;
}
