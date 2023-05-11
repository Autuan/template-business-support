package top.autuan.templatebusinesssupport.member.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MemberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer offset;

    protected Integer rows;

    public MemberExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
        rows = null;
        offset = null;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return this.offset;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getRows() {
        return this.rows;
    }

    public MemberExample limit(Integer rows) {
        this.rows = rows;
        return this;
    }

    public MemberExample limit(Integer offset, Integer rows) {
        this.offset = offset;
        this.rows = rows;
        return this;
    }

    public MemberExample page(Integer page, Integer pageSize) {
        this.offset = page * pageSize;
        this.rows = pageSize;
        return this;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("`id` is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("`id` is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("`id` =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("`id` <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("`id` >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("`id` >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("`id` <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("`id` <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("`id` in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("`id` not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("`id` between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("`id` not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("`pid` is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("`pid` is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Long value) {
            addCriterion("`pid` =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Long value) {
            addCriterion("`pid` <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Long value) {
            addCriterion("`pid` >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Long value) {
            addCriterion("`pid` >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Long value) {
            addCriterion("`pid` <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Long value) {
            addCriterion("`pid` <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Long> values) {
            addCriterion("`pid` in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Long> values) {
            addCriterion("`pid` not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Long value1, Long value2) {
            addCriterion("`pid` between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Long value1, Long value2) {
            addCriterion("`pid` not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("`nickname` is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("`nickname` is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("`nickname` =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("`nickname` <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("`nickname` >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("`nickname` >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("`nickname` <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("`nickname` <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("`nickname` like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("`nickname` not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("`nickname` in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("`nickname` not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("`nickname` between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("`nickname` not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("`mobile` is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("`mobile` is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("`mobile` =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("`mobile` <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("`mobile` >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("`mobile` >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("`mobile` <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("`mobile` <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("`mobile` like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("`mobile` not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("`mobile` in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("`mobile` not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("`mobile` between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("`mobile` not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("`password` is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("`password` is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("`password` =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("`password` <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("`password` >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("`password` >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("`password` <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("`password` <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("`password` like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("`password` not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("`password` in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("`password` not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("`password` between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("`password` not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNull() {
            addCriterion("`avatar` is null");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNotNull() {
            addCriterion("`avatar` is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarEqualTo(String value) {
            addCriterion("`avatar` =", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotEqualTo(String value) {
            addCriterion("`avatar` <>", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThan(String value) {
            addCriterion("`avatar` >", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("`avatar` >=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThan(String value) {
            addCriterion("`avatar` <", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThanOrEqualTo(String value) {
            addCriterion("`avatar` <=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLike(String value) {
            addCriterion("`avatar` like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotLike(String value) {
            addCriterion("`avatar` not like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarIn(List<String> values) {
            addCriterion("`avatar` in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotIn(List<String> values) {
            addCriterion("`avatar` not in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarBetween(String value1, String value2) {
            addCriterion("`avatar` between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotBetween(String value1, String value2) {
            addCriterion("`avatar` not between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("`level` is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("`level` is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("`level` =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("`level` <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("`level` >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("`level` >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("`level` <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("`level` <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("`level` in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("`level` not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("`level` between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("`level` not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andBanIsNull() {
            addCriterion("`ban` is null");
            return (Criteria) this;
        }

        public Criteria andBanIsNotNull() {
            addCriterion("`ban` is not null");
            return (Criteria) this;
        }

        public Criteria andBanEqualTo(Integer value) {
            addCriterion("`ban` =", value, "ban");
            return (Criteria) this;
        }

        public Criteria andBanNotEqualTo(Integer value) {
            addCriterion("`ban` <>", value, "ban");
            return (Criteria) this;
        }

        public Criteria andBanGreaterThan(Integer value) {
            addCriterion("`ban` >", value, "ban");
            return (Criteria) this;
        }

        public Criteria andBanGreaterThanOrEqualTo(Integer value) {
            addCriterion("`ban` >=", value, "ban");
            return (Criteria) this;
        }

        public Criteria andBanLessThan(Integer value) {
            addCriterion("`ban` <", value, "ban");
            return (Criteria) this;
        }

        public Criteria andBanLessThanOrEqualTo(Integer value) {
            addCriterion("`ban` <=", value, "ban");
            return (Criteria) this;
        }

        public Criteria andBanIn(List<Integer> values) {
            addCriterion("`ban` in", values, "ban");
            return (Criteria) this;
        }

        public Criteria andBanNotIn(List<Integer> values) {
            addCriterion("`ban` not in", values, "ban");
            return (Criteria) this;
        }

        public Criteria andBanBetween(Integer value1, Integer value2) {
            addCriterion("`ban` between", value1, value2, "ban");
            return (Criteria) this;
        }

        public Criteria andBanNotBetween(Integer value1, Integer value2) {
            addCriterion("`ban` not between", value1, value2, "ban");
            return (Criteria) this;
        }

        public Criteria andTeamIdIsNull() {
            addCriterion("`team_id` is null");
            return (Criteria) this;
        }

        public Criteria andTeamIdIsNotNull() {
            addCriterion("`team_id` is not null");
            return (Criteria) this;
        }

        public Criteria andTeamIdEqualTo(Long value) {
            addCriterion("`team_id` =", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotEqualTo(Long value) {
            addCriterion("`team_id` <>", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThan(Long value) {
            addCriterion("`team_id` >", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThanOrEqualTo(Long value) {
            addCriterion("`team_id` >=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThan(Long value) {
            addCriterion("`team_id` <", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThanOrEqualTo(Long value) {
            addCriterion("`team_id` <=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdIn(List<Long> values) {
            addCriterion("`team_id` in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotIn(List<Long> values) {
            addCriterion("`team_id` not in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdBetween(Long value1, Long value2) {
            addCriterion("`team_id` between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotBetween(Long value1, Long value2) {
            addCriterion("`team_id` not between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andOwnerTeamIdIsNull() {
            addCriterion("`owner_team_id` is null");
            return (Criteria) this;
        }

        public Criteria andOwnerTeamIdIsNotNull() {
            addCriterion("`owner_team_id` is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerTeamIdEqualTo(Long value) {
            addCriterion("`owner_team_id` =", value, "ownerTeamId");
            return (Criteria) this;
        }

        public Criteria andOwnerTeamIdNotEqualTo(Long value) {
            addCriterion("`owner_team_id` <>", value, "ownerTeamId");
            return (Criteria) this;
        }

        public Criteria andOwnerTeamIdGreaterThan(Long value) {
            addCriterion("`owner_team_id` >", value, "ownerTeamId");
            return (Criteria) this;
        }

        public Criteria andOwnerTeamIdGreaterThanOrEqualTo(Long value) {
            addCriterion("`owner_team_id` >=", value, "ownerTeamId");
            return (Criteria) this;
        }

        public Criteria andOwnerTeamIdLessThan(Long value) {
            addCriterion("`owner_team_id` <", value, "ownerTeamId");
            return (Criteria) this;
        }

        public Criteria andOwnerTeamIdLessThanOrEqualTo(Long value) {
            addCriterion("`owner_team_id` <=", value, "ownerTeamId");
            return (Criteria) this;
        }

        public Criteria andOwnerTeamIdIn(List<Long> values) {
            addCriterion("`owner_team_id` in", values, "ownerTeamId");
            return (Criteria) this;
        }

        public Criteria andOwnerTeamIdNotIn(List<Long> values) {
            addCriterion("`owner_team_id` not in", values, "ownerTeamId");
            return (Criteria) this;
        }

        public Criteria andOwnerTeamIdBetween(Long value1, Long value2) {
            addCriterion("`owner_team_id` between", value1, value2, "ownerTeamId");
            return (Criteria) this;
        }

        public Criteria andOwnerTeamIdNotBetween(Long value1, Long value2) {
            addCriterion("`owner_team_id` not between", value1, value2, "ownerTeamId");
            return (Criteria) this;
        }

        public Criteria andPayPasswordIsNull() {
            addCriterion("`pay_password` is null");
            return (Criteria) this;
        }

        public Criteria andPayPasswordIsNotNull() {
            addCriterion("`pay_password` is not null");
            return (Criteria) this;
        }

        public Criteria andPayPasswordEqualTo(String value) {
            addCriterion("`pay_password` =", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordNotEqualTo(String value) {
            addCriterion("`pay_password` <>", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordGreaterThan(String value) {
            addCriterion("`pay_password` >", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("`pay_password` >=", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordLessThan(String value) {
            addCriterion("`pay_password` <", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordLessThanOrEqualTo(String value) {
            addCriterion("`pay_password` <=", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordLike(String value) {
            addCriterion("`pay_password` like", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordNotLike(String value) {
            addCriterion("`pay_password` not like", value, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordIn(List<String> values) {
            addCriterion("`pay_password` in", values, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordNotIn(List<String> values) {
            addCriterion("`pay_password` not in", values, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordBetween(String value1, String value2) {
            addCriterion("`pay_password` between", value1, value2, "payPassword");
            return (Criteria) this;
        }

        public Criteria andPayPasswordNotBetween(String value1, String value2) {
            addCriterion("`pay_password` not between", value1, value2, "payPassword");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("`gender` is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("`gender` is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Integer value) {
            addCriterion("`gender` =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Integer value) {
            addCriterion("`gender` <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Integer value) {
            addCriterion("`gender` >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("`gender` >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Integer value) {
            addCriterion("`gender` <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Integer value) {
            addCriterion("`gender` <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Integer> values) {
            addCriterion("`gender` in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Integer> values) {
            addCriterion("`gender` not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Integer value1, Integer value2) {
            addCriterion("`gender` between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("`gender` not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNull() {
            addCriterion("`last_login_time` is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNotNull() {
            addCriterion("`last_login_time` is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeEqualTo(LocalDateTime value) {
            addCriterion("`last_login_time` =", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotEqualTo(LocalDateTime value) {
            addCriterion("`last_login_time` <>", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThan(LocalDateTime value) {
            addCriterion("`last_login_time` >", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("`last_login_time` >=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThan(LocalDateTime value) {
            addCriterion("`last_login_time` <", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("`last_login_time` <=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIn(List<LocalDateTime> values) {
            addCriterion("`last_login_time` in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotIn(List<LocalDateTime> values) {
            addCriterion("`last_login_time` not in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("`last_login_time` between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("`last_login_time` not between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIsNull() {
            addCriterion("`last_login_ip` is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIsNotNull() {
            addCriterion("`last_login_ip` is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpEqualTo(Integer value) {
            addCriterion("`last_login_ip` =", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotEqualTo(Integer value) {
            addCriterion("`last_login_ip` <>", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpGreaterThan(Integer value) {
            addCriterion("`last_login_ip` >", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpGreaterThanOrEqualTo(Integer value) {
            addCriterion("`last_login_ip` >=", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLessThan(Integer value) {
            addCriterion("`last_login_ip` <", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLessThanOrEqualTo(Integer value) {
            addCriterion("`last_login_ip` <=", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIn(List<Integer> values) {
            addCriterion("`last_login_ip` in", values, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotIn(List<Integer> values) {
            addCriterion("`last_login_ip` not in", values, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpBetween(Integer value1, Integer value2) {
            addCriterion("`last_login_ip` between", value1, value2, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotBetween(Integer value1, Integer value2) {
            addCriterion("`last_login_ip` not between", value1, value2, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("`create_time` is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("`create_time` is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(LocalDateTime value) {
            addCriterion("`create_time` =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(LocalDateTime value) {
            addCriterion("`create_time` <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(LocalDateTime value) {
            addCriterion("`create_time` >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("`create_time` >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(LocalDateTime value) {
            addCriterion("`create_time` <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("`create_time` <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<LocalDateTime> values) {
            addCriterion("`create_time` in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<LocalDateTime> values) {
            addCriterion("`create_time` not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("`create_time` between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("`create_time` not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("`update_time` is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("`update_time` is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(LocalDateTime value) {
            addCriterion("`update_time` =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(LocalDateTime value) {
            addCriterion("`update_time` <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(LocalDateTime value) {
            addCriterion("`update_time` >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("`update_time` >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(LocalDateTime value) {
            addCriterion("`update_time` <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("`update_time` <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<LocalDateTime> values) {
            addCriterion("`update_time` in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<LocalDateTime> values) {
            addCriterion("`update_time` not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("`update_time` between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("`update_time` not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("`create_by` is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("`create_by` is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(Long value) {
            addCriterion("`create_by` =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(Long value) {
            addCriterion("`create_by` <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(Long value) {
            addCriterion("`create_by` >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(Long value) {
            addCriterion("`create_by` >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(Long value) {
            addCriterion("`create_by` <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(Long value) {
            addCriterion("`create_by` <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<Long> values) {
            addCriterion("`create_by` in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<Long> values) {
            addCriterion("`create_by` not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(Long value1, Long value2) {
            addCriterion("`create_by` between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(Long value1, Long value2) {
            addCriterion("`create_by` not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("`update_by` is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("`update_by` is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(Long value) {
            addCriterion("`update_by` =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(Long value) {
            addCriterion("`update_by` <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(Long value) {
            addCriterion("`update_by` >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(Long value) {
            addCriterion("`update_by` >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(Long value) {
            addCriterion("`update_by` <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(Long value) {
            addCriterion("`update_by` <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<Long> values) {
            addCriterion("`update_by` in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<Long> values) {
            addCriterion("`update_by` not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(Long value1, Long value2) {
            addCriterion("`update_by` between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(Long value1, Long value2) {
            addCriterion("`update_by` not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("`del_flag` is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("`del_flag` is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(Byte value) {
            addCriterion("`del_flag` =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(Byte value) {
            addCriterion("`del_flag` <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(Byte value) {
            addCriterion("`del_flag` >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("`del_flag` >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(Byte value) {
            addCriterion("`del_flag` <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(Byte value) {
            addCriterion("`del_flag` <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<Byte> values) {
            addCriterion("`del_flag` in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<Byte> values) {
            addCriterion("`del_flag` not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(Byte value1, Byte value2) {
            addCriterion("`del_flag` between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("`del_flag` not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeIsNull() {
            addCriterion("`invitation_code` is null");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeIsNotNull() {
            addCriterion("`invitation_code` is not null");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeEqualTo(String value) {
            addCriterion("`invitation_code` =", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeNotEqualTo(String value) {
            addCriterion("`invitation_code` <>", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeGreaterThan(String value) {
            addCriterion("`invitation_code` >", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("`invitation_code` >=", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeLessThan(String value) {
            addCriterion("`invitation_code` <", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeLessThanOrEqualTo(String value) {
            addCriterion("`invitation_code` <=", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeLike(String value) {
            addCriterion("`invitation_code` like", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeNotLike(String value) {
            addCriterion("`invitation_code` not like", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeIn(List<String> values) {
            addCriterion("`invitation_code` in", values, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeNotIn(List<String> values) {
            addCriterion("`invitation_code` not in", values, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeBetween(String value1, String value2) {
            addCriterion("`invitation_code` between", value1, value2, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeNotBetween(String value1, String value2) {
            addCriterion("`invitation_code` not between", value1, value2, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceCodeIsNull() {
            addCriterion("`address_province_code` is null");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceCodeIsNotNull() {
            addCriterion("`address_province_code` is not null");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceCodeEqualTo(String value) {
            addCriterion("`address_province_code` =", value, "addressProvinceCode");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceCodeNotEqualTo(String value) {
            addCriterion("`address_province_code` <>", value, "addressProvinceCode");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceCodeGreaterThan(String value) {
            addCriterion("`address_province_code` >", value, "addressProvinceCode");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("`address_province_code` >=", value, "addressProvinceCode");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceCodeLessThan(String value) {
            addCriterion("`address_province_code` <", value, "addressProvinceCode");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceCodeLessThanOrEqualTo(String value) {
            addCriterion("`address_province_code` <=", value, "addressProvinceCode");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceCodeLike(String value) {
            addCriterion("`address_province_code` like", value, "addressProvinceCode");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceCodeNotLike(String value) {
            addCriterion("`address_province_code` not like", value, "addressProvinceCode");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceCodeIn(List<String> values) {
            addCriterion("`address_province_code` in", values, "addressProvinceCode");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceCodeNotIn(List<String> values) {
            addCriterion("`address_province_code` not in", values, "addressProvinceCode");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceCodeBetween(String value1, String value2) {
            addCriterion("`address_province_code` between", value1, value2, "addressProvinceCode");
            return (Criteria) this;
        }

        public Criteria andAddressProvinceCodeNotBetween(String value1, String value2) {
            addCriterion("`address_province_code` not between", value1, value2, "addressProvinceCode");
            return (Criteria) this;
        }

        public Criteria andAddressCityCodeIsNull() {
            addCriterion("`address_city_code` is null");
            return (Criteria) this;
        }

        public Criteria andAddressCityCodeIsNotNull() {
            addCriterion("`address_city_code` is not null");
            return (Criteria) this;
        }

        public Criteria andAddressCityCodeEqualTo(String value) {
            addCriterion("`address_city_code` =", value, "addressCityCode");
            return (Criteria) this;
        }

        public Criteria andAddressCityCodeNotEqualTo(String value) {
            addCriterion("`address_city_code` <>", value, "addressCityCode");
            return (Criteria) this;
        }

        public Criteria andAddressCityCodeGreaterThan(String value) {
            addCriterion("`address_city_code` >", value, "addressCityCode");
            return (Criteria) this;
        }

        public Criteria andAddressCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("`address_city_code` >=", value, "addressCityCode");
            return (Criteria) this;
        }

        public Criteria andAddressCityCodeLessThan(String value) {
            addCriterion("`address_city_code` <", value, "addressCityCode");
            return (Criteria) this;
        }

        public Criteria andAddressCityCodeLessThanOrEqualTo(String value) {
            addCriterion("`address_city_code` <=", value, "addressCityCode");
            return (Criteria) this;
        }

        public Criteria andAddressCityCodeLike(String value) {
            addCriterion("`address_city_code` like", value, "addressCityCode");
            return (Criteria) this;
        }

        public Criteria andAddressCityCodeNotLike(String value) {
            addCriterion("`address_city_code` not like", value, "addressCityCode");
            return (Criteria) this;
        }

        public Criteria andAddressCityCodeIn(List<String> values) {
            addCriterion("`address_city_code` in", values, "addressCityCode");
            return (Criteria) this;
        }

        public Criteria andAddressCityCodeNotIn(List<String> values) {
            addCriterion("`address_city_code` not in", values, "addressCityCode");
            return (Criteria) this;
        }

        public Criteria andAddressCityCodeBetween(String value1, String value2) {
            addCriterion("`address_city_code` between", value1, value2, "addressCityCode");
            return (Criteria) this;
        }

        public Criteria andAddressCityCodeNotBetween(String value1, String value2) {
            addCriterion("`address_city_code` not between", value1, value2, "addressCityCode");
            return (Criteria) this;
        }

        public Criteria andAddressAreaCodeIsNull() {
            addCriterion("`address_area_code` is null");
            return (Criteria) this;
        }

        public Criteria andAddressAreaCodeIsNotNull() {
            addCriterion("`address_area_code` is not null");
            return (Criteria) this;
        }

        public Criteria andAddressAreaCodeEqualTo(String value) {
            addCriterion("`address_area_code` =", value, "addressAreaCode");
            return (Criteria) this;
        }

        public Criteria andAddressAreaCodeNotEqualTo(String value) {
            addCriterion("`address_area_code` <>", value, "addressAreaCode");
            return (Criteria) this;
        }

        public Criteria andAddressAreaCodeGreaterThan(String value) {
            addCriterion("`address_area_code` >", value, "addressAreaCode");
            return (Criteria) this;
        }

        public Criteria andAddressAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("`address_area_code` >=", value, "addressAreaCode");
            return (Criteria) this;
        }

        public Criteria andAddressAreaCodeLessThan(String value) {
            addCriterion("`address_area_code` <", value, "addressAreaCode");
            return (Criteria) this;
        }

        public Criteria andAddressAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("`address_area_code` <=", value, "addressAreaCode");
            return (Criteria) this;
        }

        public Criteria andAddressAreaCodeLike(String value) {
            addCriterion("`address_area_code` like", value, "addressAreaCode");
            return (Criteria) this;
        }

        public Criteria andAddressAreaCodeNotLike(String value) {
            addCriterion("`address_area_code` not like", value, "addressAreaCode");
            return (Criteria) this;
        }

        public Criteria andAddressAreaCodeIn(List<String> values) {
            addCriterion("`address_area_code` in", values, "addressAreaCode");
            return (Criteria) this;
        }

        public Criteria andAddressAreaCodeNotIn(List<String> values) {
            addCriterion("`address_area_code` not in", values, "addressAreaCode");
            return (Criteria) this;
        }

        public Criteria andAddressAreaCodeBetween(String value1, String value2) {
            addCriterion("`address_area_code` between", value1, value2, "addressAreaCode");
            return (Criteria) this;
        }

        public Criteria andAddressAreaCodeNotBetween(String value1, String value2) {
            addCriterion("`address_area_code` not between", value1, value2, "addressAreaCode");
            return (Criteria) this;
        }

        public Criteria andAddressMergeNameIsNull() {
            addCriterion("`address_merge_name` is null");
            return (Criteria) this;
        }

        public Criteria andAddressMergeNameIsNotNull() {
            addCriterion("`address_merge_name` is not null");
            return (Criteria) this;
        }

        public Criteria andAddressMergeNameEqualTo(String value) {
            addCriterion("`address_merge_name` =", value, "addressMergeName");
            return (Criteria) this;
        }

        public Criteria andAddressMergeNameNotEqualTo(String value) {
            addCriterion("`address_merge_name` <>", value, "addressMergeName");
            return (Criteria) this;
        }

        public Criteria andAddressMergeNameGreaterThan(String value) {
            addCriterion("`address_merge_name` >", value, "addressMergeName");
            return (Criteria) this;
        }

        public Criteria andAddressMergeNameGreaterThanOrEqualTo(String value) {
            addCriterion("`address_merge_name` >=", value, "addressMergeName");
            return (Criteria) this;
        }

        public Criteria andAddressMergeNameLessThan(String value) {
            addCriterion("`address_merge_name` <", value, "addressMergeName");
            return (Criteria) this;
        }

        public Criteria andAddressMergeNameLessThanOrEqualTo(String value) {
            addCriterion("`address_merge_name` <=", value, "addressMergeName");
            return (Criteria) this;
        }

        public Criteria andAddressMergeNameLike(String value) {
            addCriterion("`address_merge_name` like", value, "addressMergeName");
            return (Criteria) this;
        }

        public Criteria andAddressMergeNameNotLike(String value) {
            addCriterion("`address_merge_name` not like", value, "addressMergeName");
            return (Criteria) this;
        }

        public Criteria andAddressMergeNameIn(List<String> values) {
            addCriterion("`address_merge_name` in", values, "addressMergeName");
            return (Criteria) this;
        }

        public Criteria andAddressMergeNameNotIn(List<String> values) {
            addCriterion("`address_merge_name` not in", values, "addressMergeName");
            return (Criteria) this;
        }

        public Criteria andAddressMergeNameBetween(String value1, String value2) {
            addCriterion("`address_merge_name` between", value1, value2, "addressMergeName");
            return (Criteria) this;
        }

        public Criteria andAddressMergeNameNotBetween(String value1, String value2) {
            addCriterion("`address_merge_name` not between", value1, value2, "addressMergeName");
            return (Criteria) this;
        }

        public Criteria andTierIsNull() {
            addCriterion("`tier` is null");
            return (Criteria) this;
        }

        public Criteria andTierIsNotNull() {
            addCriterion("`tier` is not null");
            return (Criteria) this;
        }

        public Criteria andTierEqualTo(Integer value) {
            addCriterion("`tier` =", value, "tier");
            return (Criteria) this;
        }

        public Criteria andTierNotEqualTo(Integer value) {
            addCriterion("`tier` <>", value, "tier");
            return (Criteria) this;
        }

        public Criteria andTierGreaterThan(Integer value) {
            addCriterion("`tier` >", value, "tier");
            return (Criteria) this;
        }

        public Criteria andTierGreaterThanOrEqualTo(Integer value) {
            addCriterion("`tier` >=", value, "tier");
            return (Criteria) this;
        }

        public Criteria andTierLessThan(Integer value) {
            addCriterion("`tier` <", value, "tier");
            return (Criteria) this;
        }

        public Criteria andTierLessThanOrEqualTo(Integer value) {
            addCriterion("`tier` <=", value, "tier");
            return (Criteria) this;
        }

        public Criteria andTierIn(List<Integer> values) {
            addCriterion("`tier` in", values, "tier");
            return (Criteria) this;
        }

        public Criteria andTierNotIn(List<Integer> values) {
            addCriterion("`tier` not in", values, "tier");
            return (Criteria) this;
        }

        public Criteria andTierBetween(Integer value1, Integer value2) {
            addCriterion("`tier` between", value1, value2, "tier");
            return (Criteria) this;
        }

        public Criteria andTierNotBetween(Integer value1, Integer value2) {
            addCriterion("`tier` not between", value1, value2, "tier");
            return (Criteria) this;
        }

        public Criteria andNoIsNull() {
            addCriterion("`no` is null");
            return (Criteria) this;
        }

        public Criteria andNoIsNotNull() {
            addCriterion("`no` is not null");
            return (Criteria) this;
        }

        public Criteria andNoEqualTo(String value) {
            addCriterion("`no` =", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotEqualTo(String value) {
            addCriterion("`no` <>", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoGreaterThan(String value) {
            addCriterion("`no` >", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoGreaterThanOrEqualTo(String value) {
            addCriterion("`no` >=", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLessThan(String value) {
            addCriterion("`no` <", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLessThanOrEqualTo(String value) {
            addCriterion("`no` <=", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoLike(String value) {
            addCriterion("`no` like", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotLike(String value) {
            addCriterion("`no` not like", value, "no");
            return (Criteria) this;
        }

        public Criteria andNoIn(List<String> values) {
            addCriterion("`no` in", values, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotIn(List<String> values) {
            addCriterion("`no` not in", values, "no");
            return (Criteria) this;
        }

        public Criteria andNoBetween(String value1, String value2) {
            addCriterion("`no` between", value1, value2, "no");
            return (Criteria) this;
        }

        public Criteria andNoNotBetween(String value1, String value2) {
            addCriterion("`no` not between", value1, value2, "no");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}