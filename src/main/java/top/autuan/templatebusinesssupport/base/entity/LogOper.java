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
public class LogOper {
    private Long id;

    private String title;

    private String method;

    private Integer operatorType;

    private Long operUserId;

    private String machineCode;

    private String operUrl;

    private String operIp;

    private String operParam;

    private String jsonResult;

    private Integer status;

    private String errorMsg;

    private LocalDateTime operTime;

    private String version;

    private String token;

    private String remark;

    public enum Column {
        id("id", "id", "BIGINT", true),
        title("title", "title", "VARCHAR", true),
        method("method", "method", "VARCHAR", true),
        operatorType("operator_type", "operatorType", "INTEGER", true),
        operUserId("oper_user_id", "operUserId", "BIGINT", true),
        machineCode("machine_code", "machineCode", "VARCHAR", true),
        operUrl("oper_url", "operUrl", "VARCHAR", true),
        operIp("oper_ip", "operIp", "VARCHAR", true),
        operParam("oper_param", "operParam", "VARCHAR", true),
        jsonResult("json_result", "jsonResult", "VARCHAR", true),
        status("status", "status", "INTEGER", true),
        errorMsg("error_msg", "errorMsg", "VARCHAR", true),
        operTime("oper_time", "operTime", "TIMESTAMP", true),
        version("version", "version", "VARCHAR", true),
        token("token", "token", "VARCHAR", true),
        remark("remark", "remark", "VARCHAR", true);

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