package com.relink.chat.model.po;

import java.util.ArrayList;
import java.util.List;

public class GroupPoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table group
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table group
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table group
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbg.generated
     */
    public GroupPoExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table group
     *
     * @mbg.generated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andGroupIdIsNull() {
            addCriterion("`group_id` is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("`group_id` is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(Integer value) {
            addCriterion("`group_id` =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(Integer value) {
            addCriterion("`group_id` <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(Integer value) {
            addCriterion("`group_id` >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("`group_id` >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(Integer value) {
            addCriterion("`group_id` <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("`group_id` <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Integer> values) {
            addCriterion("`group_id` in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Integer> values) {
            addCriterion("`group_id` not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("`group_id` between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("`group_id` not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNull() {
            addCriterion("`group_name` is null");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNotNull() {
            addCriterion("`group_name` is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNameEqualTo(String value) {
            addCriterion("`group_name` =", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotEqualTo(String value) {
            addCriterion("`group_name` <>", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThan(String value) {
            addCriterion("`group_name` >", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("`group_name` >=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThan(String value) {
            addCriterion("`group_name` <", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThanOrEqualTo(String value) {
            addCriterion("`group_name` <=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLike(String value) {
            addCriterion("`group_name` like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotLike(String value) {
            addCriterion("`group_name` not like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameIn(List<String> values) {
            addCriterion("`group_name` in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotIn(List<String> values) {
            addCriterion("`group_name` not in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameBetween(String value1, String value2) {
            addCriterion("`group_name` between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotBetween(String value1, String value2) {
            addCriterion("`group_name` not between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupHosterIsNull() {
            addCriterion("`group_hoster` is null");
            return (Criteria) this;
        }

        public Criteria andGroupHosterIsNotNull() {
            addCriterion("`group_hoster` is not null");
            return (Criteria) this;
        }

        public Criteria andGroupHosterEqualTo(Integer value) {
            addCriterion("`group_hoster` =", value, "groupHoster");
            return (Criteria) this;
        }

        public Criteria andGroupHosterNotEqualTo(Integer value) {
            addCriterion("`group_hoster` <>", value, "groupHoster");
            return (Criteria) this;
        }

        public Criteria andGroupHosterGreaterThan(Integer value) {
            addCriterion("`group_hoster` >", value, "groupHoster");
            return (Criteria) this;
        }

        public Criteria andGroupHosterGreaterThanOrEqualTo(Integer value) {
            addCriterion("`group_hoster` >=", value, "groupHoster");
            return (Criteria) this;
        }

        public Criteria andGroupHosterLessThan(Integer value) {
            addCriterion("`group_hoster` <", value, "groupHoster");
            return (Criteria) this;
        }

        public Criteria andGroupHosterLessThanOrEqualTo(Integer value) {
            addCriterion("`group_hoster` <=", value, "groupHoster");
            return (Criteria) this;
        }

        public Criteria andGroupHosterIn(List<Integer> values) {
            addCriterion("`group_hoster` in", values, "groupHoster");
            return (Criteria) this;
        }

        public Criteria andGroupHosterNotIn(List<Integer> values) {
            addCriterion("`group_hoster` not in", values, "groupHoster");
            return (Criteria) this;
        }

        public Criteria andGroupHosterBetween(Integer value1, Integer value2) {
            addCriterion("`group_hoster` between", value1, value2, "groupHoster");
            return (Criteria) this;
        }

        public Criteria andGroupHosterNotBetween(Integer value1, Integer value2) {
            addCriterion("`group_hoster` not between", value1, value2, "groupHoster");
            return (Criteria) this;
        }

        public Criteria andGroupAvatarIsNull() {
            addCriterion("`group_avatar` is null");
            return (Criteria) this;
        }

        public Criteria andGroupAvatarIsNotNull() {
            addCriterion("`group_avatar` is not null");
            return (Criteria) this;
        }

        public Criteria andGroupAvatarEqualTo(String value) {
            addCriterion("`group_avatar` =", value, "groupAvatar");
            return (Criteria) this;
        }

        public Criteria andGroupAvatarNotEqualTo(String value) {
            addCriterion("`group_avatar` <>", value, "groupAvatar");
            return (Criteria) this;
        }

        public Criteria andGroupAvatarGreaterThan(String value) {
            addCriterion("`group_avatar` >", value, "groupAvatar");
            return (Criteria) this;
        }

        public Criteria andGroupAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("`group_avatar` >=", value, "groupAvatar");
            return (Criteria) this;
        }

        public Criteria andGroupAvatarLessThan(String value) {
            addCriterion("`group_avatar` <", value, "groupAvatar");
            return (Criteria) this;
        }

        public Criteria andGroupAvatarLessThanOrEqualTo(String value) {
            addCriterion("`group_avatar` <=", value, "groupAvatar");
            return (Criteria) this;
        }

        public Criteria andGroupAvatarLike(String value) {
            addCriterion("`group_avatar` like", value, "groupAvatar");
            return (Criteria) this;
        }

        public Criteria andGroupAvatarNotLike(String value) {
            addCriterion("`group_avatar` not like", value, "groupAvatar");
            return (Criteria) this;
        }

        public Criteria andGroupAvatarIn(List<String> values) {
            addCriterion("`group_avatar` in", values, "groupAvatar");
            return (Criteria) this;
        }

        public Criteria andGroupAvatarNotIn(List<String> values) {
            addCriterion("`group_avatar` not in", values, "groupAvatar");
            return (Criteria) this;
        }

        public Criteria andGroupAvatarBetween(String value1, String value2) {
            addCriterion("`group_avatar` between", value1, value2, "groupAvatar");
            return (Criteria) this;
        }

        public Criteria andGroupAvatarNotBetween(String value1, String value2) {
            addCriterion("`group_avatar` not between", value1, value2, "groupAvatar");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table group
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table group
     *
     * @mbg.generated
     */
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