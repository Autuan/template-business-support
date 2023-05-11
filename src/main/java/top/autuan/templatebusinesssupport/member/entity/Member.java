package top.autuan.templatebusinesssupport.member.entity;

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
public class Member {
    private Long id;

    private Long pid;

    private String nickname;

    private String mobile;

    private String password;

    private String avatar;

    private Integer level;

    private Integer ban;

    private Long teamId;

    private Long ownerTeamId;

    private String payPassword;

    private Integer gender;

    private LocalDateTime lastLoginTime;

    private Integer lastLoginIp;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Long createBy;

    private Long updateBy;

    private Byte delFlag;

    private String invitationCode;

    private String addressProvinceCode;

    private String addressCityCode;

    private String addressAreaCode;

    private String addressMergeName;

    private Integer tier;

    private String no;

    public enum Column {
        id("id", "id", "BIGINT", true),
        pid("pid", "pid", "BIGINT", true),
        nickname("nickname", "nickname", "VARCHAR", true),
        mobile("mobile", "mobile", "VARCHAR", true),
        password("password", "password", "VARCHAR", true),
        avatar("avatar", "avatar", "VARCHAR", true),
        level("level", "level", "INTEGER", true),
        ban("ban", "ban", "INTEGER", true),
        teamId("team_id", "teamId", "BIGINT", true),
        ownerTeamId("owner_team_id", "ownerTeamId", "BIGINT", true),
        payPassword("pay_password", "payPassword", "VARCHAR", true),
        gender("gender", "gender", "INTEGER", true),
        lastLoginTime("last_login_time", "lastLoginTime", "TIMESTAMP", true),
        lastLoginIp("last_login_ip", "lastLoginIp", "INTEGER", true),
        createTime("create_time", "createTime", "TIMESTAMP", true),
        updateTime("update_time", "updateTime", "TIMESTAMP", true),
        createBy("create_by", "createBy", "BIGINT", true),
        updateBy("update_by", "updateBy", "BIGINT", true),
        delFlag("del_flag", "delFlag", "TINYINT", true),
        invitationCode("invitation_code", "invitationCode", "VARCHAR", true),
        addressProvinceCode("address_province_code", "addressProvinceCode", "VARCHAR", true),
        addressCityCode("address_city_code", "addressCityCode", "VARCHAR", true),
        addressAreaCode("address_area_code", "addressAreaCode", "VARCHAR", true),
        addressMergeName("address_merge_name", "addressMergeName", "VARCHAR", true),
        tier("tier", "tier", "INTEGER", true),
        no("no", "no", "VARCHAR", true);

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