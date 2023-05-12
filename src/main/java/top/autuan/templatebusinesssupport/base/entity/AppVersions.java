package top.autuan.templatebusinesssupport.base.entity;

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
public class AppVersions {
    private Integer id;

    private Integer platform;

    private String version;

    private Integer type;

    private Integer forceFlag;

    private String description;

    private String downloadUrl;

    private String md5;

    private String size;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Long createBy;

    private Long updateBy;

    private Byte delFlag;

    public enum Column {
        id("id", "id", "INTEGER", true),
        platform("platform", "platform", "INTEGER", true),
        version("version", "version", "VARCHAR", true),
        type("type", "type", "INTEGER", true),
        forceFlag("force_flag", "forceFlag", "INTEGER", true),
        description("description", "description", "VARCHAR", true),
        downloadUrl("download_url", "downloadUrl", "VARCHAR", true),
        md5("md5", "md5", "VARCHAR", true),
        size("size", "size", "VARCHAR", true),
        createTime("create_time", "createTime", "TIMESTAMP", true),
        updateTime("update_time", "updateTime", "TIMESTAMP", true),
        createBy("create_by", "createBy", "BIGINT", true),
        updateBy("update_by", "updateBy", "BIGINT", true),
        delFlag("del_flag", "delFlag", "TINYINT", true);

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