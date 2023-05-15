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
public class NoticeRemind {
    private Long id;

    private Integer action;

    private Long sourceId;

    private Long sourceType;

    private Integer sourceContent;

    private Integer url;

    private Integer state;

    private Long actionUserId;

    private Long actionAimUserId;

    private LocalDateTime remindTime;

    private String delFlag;

    private LocalDateTime createTime;

    private String createBy;

    private String updateBy;

    private LocalDateTime updateTime;

    private String remark;

    private Long deptId;

    public enum Column {
        id("id", "id", "BIGINT", false),
        action("action", "action", "INTEGER", false),
        sourceId("source_id", "sourceId", "BIGINT", false),
        sourceType("source_type", "sourceType", "BIGINT", false),
        sourceContent("source_content", "sourceContent", "INTEGER", false),
        url("url", "url", "INTEGER", false),
        state("state", "state", "INTEGER", false),
        actionUserId("action_user_id", "actionUserId", "BIGINT", false),
        actionAimUserId("action_aim_user_id", "actionAimUserId", "BIGINT", false),
        remindTime("remind_time", "remindTime", "TIMESTAMP", false),
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