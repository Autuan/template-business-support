package top.autuan.templatebusinesssupport.notice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SocketNoticeItem {
    private String title;
    private Integer num;
    private String pageTitle;
    private String pageUrl;
    private Integer kind;
}
