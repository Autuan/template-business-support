package top.autuan.templatebusinesssupport.notice.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum NotificationDict implements NotificationDictInterface {
    DEMO(-1,"新开发票","用户管理","/system/user"),
    EXAMPLE(0,"项目进度","部门列表","/system/dept"),

    // todo 其他消息URL 未定义
    OTHER(999999,"其他消息","",""),
    ;
    private Integer kind;

    private String title;
    private String pageTitle;
    private String pageUrl;



    public static NotificationDict switchDict(Integer kind) {
        for (NotificationDict dict : NotificationDict.values()) {
            if(dict.getKind().equals(kind)) {
                return dict;
            }
        }
        return OTHER;
    }
}
