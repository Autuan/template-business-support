package top.autuan.templatebusinesssupport.notice.enums;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseNotificationInstance implements NotificationDictInterface  {
    private Integer kind;
    private String title;
    private String pageTitle;
    private String pageUrl;
}
