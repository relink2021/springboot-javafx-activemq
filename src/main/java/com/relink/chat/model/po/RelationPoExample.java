package com.relink.chat.model.po;

import java.util.ArrayList;
import java.util.List;

public class RelationPoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table relation
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table relation
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table relation
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table relation
     *
     * @mbg.generated
     */
    public RelationPoExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table relation
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table relation
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table relation
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table relation
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table relation
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table relation
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table relation
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
     * This method corresponds to the database table relation
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
     * This method corresponds to the database table relation
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table relation
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
     * This class corresponds to the database table relation
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

        public Criteria andRelationIdIsNull() {
            addCriterion("`relation_id` is null");
            return (Criteria) this;
        }

        public Criteria andRelationIdIsNotNull() {
            addCriterion("`relation_id` is not null");
            return (Criteria) this;
        }

        public Criteria andRelationIdEqualTo(Integer value) {
            addCriterion("`relation_id` =", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdNotEqualTo(Integer value) {
            addCriterion("`relation_id` <>", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdGreaterThan(Integer value) {
            addCriterion("`relation_id` >", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("`relation_id` >=", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdLessThan(Integer value) {
            addCriterion("`relation_id` <", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdLessThanOrEqualTo(Integer value) {
            addCriterion("`relation_id` <=", value, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdIn(List<Integer> values) {
            addCriterion("`relation_id` in", values, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdNotIn(List<Integer> values) {
            addCriterion("`relation_id` not in", values, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdBetween(Integer value1, Integer value2) {
            addCriterion("`relation_id` between", value1, value2, "relationId");
            return (Criteria) this;
        }

        public Criteria andRelationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("`relation_id` not between", value1, value2, "relationId");
            return (Criteria) this;
        }

        public Criteria andHosterIsNull() {
            addCriterion("`hoster` is null");
            return (Criteria) this;
        }

        public Criteria andHosterIsNotNull() {
            addCriterion("`hoster` is not null");
            return (Criteria) this;
        }

        public Criteria andHosterEqualTo(Integer value) {
            addCriterion("`hoster` =", value, "hoster");
            return (Criteria) this;
        }

        public Criteria andHosterNotEqualTo(Integer value) {
            addCriterion("`hoster` <>", value, "hoster");
            return (Criteria) this;
        }

        public Criteria andHosterGreaterThan(Integer value) {
            addCriterion("`hoster` >", value, "hoster");
            return (Criteria) this;
        }

        public Criteria andHosterGreaterThanOrEqualTo(Integer value) {
            addCriterion("`hoster` >=", value, "hoster");
            return (Criteria) this;
        }

        public Criteria andHosterLessThan(Integer value) {
            addCriterion("`hoster` <", value, "hoster");
            return (Criteria) this;
        }

        public Criteria andHosterLessThanOrEqualTo(Integer value) {
            addCriterion("`hoster` <=", value, "hoster");
            return (Criteria) this;
        }

        public Criteria andHosterIn(List<Integer> values) {
            addCriterion("`hoster` in", values, "hoster");
            return (Criteria) this;
        }

        public Criteria andHosterNotIn(List<Integer> values) {
            addCriterion("`hoster` not in", values, "hoster");
            return (Criteria) this;
        }

        public Criteria andHosterBetween(Integer value1, Integer value2) {
            addCriterion("`hoster` between", value1, value2, "hoster");
            return (Criteria) this;
        }

        public Criteria andHosterNotBetween(Integer value1, Integer value2) {
            addCriterion("`hoster` not between", value1, value2, "hoster");
            return (Criteria) this;
        }

        public Criteria andGuestIsNull() {
            addCriterion("`guest` is null");
            return (Criteria) this;
        }

        public Criteria andGuestIsNotNull() {
            addCriterion("`guest` is not null");
            return (Criteria) this;
        }

        public Criteria andGuestEqualTo(Integer value) {
            addCriterion("`guest` =", value, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestNotEqualTo(Integer value) {
            addCriterion("`guest` <>", value, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestGreaterThan(Integer value) {
            addCriterion("`guest` >", value, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestGreaterThanOrEqualTo(Integer value) {
            addCriterion("`guest` >=", value, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestLessThan(Integer value) {
            addCriterion("`guest` <", value, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestLessThanOrEqualTo(Integer value) {
            addCriterion("`guest` <=", value, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestIn(List<Integer> values) {
            addCriterion("`guest` in", values, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestNotIn(List<Integer> values) {
            addCriterion("`guest` not in", values, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestBetween(Integer value1, Integer value2) {
            addCriterion("`guest` between", value1, value2, "guest");
            return (Criteria) this;
        }

        public Criteria andGuestNotBetween(Integer value1, Integer value2) {
            addCriterion("`guest` not between", value1, value2, "guest");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table relation
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
     * This class corresponds to the database table relation
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