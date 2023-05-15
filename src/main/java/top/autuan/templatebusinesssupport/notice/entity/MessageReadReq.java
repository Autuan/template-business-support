package top.autuan.templatebusinesssupport.notice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageReadReq {
    private Long msgId;
    private Long userId;
    private Integer type;
    private Integer kind;
}
