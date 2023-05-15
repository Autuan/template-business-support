package top.autuan.templatebusinesssupport.notice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoticeNotificationRecord {
    private Long id;

    private Long notificationId;

    private Integer state;

    private Long receiverUserId;

    private LocalDateTime pullTime;

    private Integer kind;

    private String delFlag;

    private LocalDateTime createTime;

    private String createBy;

    private String updateBy;

    private LocalDateTime updateTime;

    private String remark;

    private Long deptId;

    public enum Column {
        id("id", "id", "BIGINT", false),
        notificationId("notification_id", "notificationId", "BIGINT", false),
        state("state", "state", "INTEGER", false),
        receiverUserId("receiver_user_id", "receiverUserId", "BIGINT", false),
        pullTime("pull_time", "pullTime", "TIMESTAMP", false),
        kind("kind", "kind", "INTEGER", false),
        delFlag("del_flag", "delFlag", "CHAR", false),
        createTime("create_time", "createTime", "TIMESTAMP", false),
        createBy("create_by", "createBy", "VARCHAR", false),
        updateBy("update_by", "updateBy", "VARCHAR", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        remark("remark", "remark", "VARCHAR", false),
        deptId("dept_id", "deptId", "BIGINT", false);

        private static final String BEGINNING_DELIMITER = "`";

        private static final String ENDING_DELIMITER = "`";

        private final String column;

        private final boolean isColumnNameDelimited;

        private final String javaProperty;

        private final String jdbcType;

        public String value() {
            return this.column;
        }

        public String getValue() {
            return this.column;
        }

        public String getJavaProperty() {
            return this.javaProperty;
        }

        public String getJdbcType() {
            return this.jdbcType;
        }

        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }

        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }
}