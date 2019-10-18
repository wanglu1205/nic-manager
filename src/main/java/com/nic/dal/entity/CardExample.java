package com.nic.dal.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CardExample {
    /**
     * card
     */
    protected String orderByClause;

    /**
     * card
     */
    protected boolean distinct;

    /**
     * card
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbggenerated 2019-10-18
     */
    public CardExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbggenerated 2019-10-18
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbggenerated 2019-10-18
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbggenerated 2019-10-18
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbggenerated 2019-10-18
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbggenerated 2019-10-18
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbggenerated 2019-10-18
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbggenerated 2019-10-18
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbggenerated 2019-10-18
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *
     * @mbggenerated 2019-10-18
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbggenerated 2019-10-18
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * card 2019-10-18
     */
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("`number` is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("`number` is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(String value) {
            addCriterion("`number` =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(String value) {
            addCriterion("`number` <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(String value) {
            addCriterion("`number` >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(String value) {
            addCriterion("`number` >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(String value) {
            addCriterion("`number` <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(String value) {
            addCriterion("`number` <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLike(String value) {
            addCriterion("`number` like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotLike(String value) {
            addCriterion("`number` not like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<String> values) {
            addCriterion("`number` in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<String> values) {
            addCriterion("`number` not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(String value1, String value2) {
            addCriterion("`number` between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(String value1, String value2) {
            addCriterion("`number` not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andResidualFlowValueIsNull() {
            addCriterion("residual_flow_value is null");
            return (Criteria) this;
        }

        public Criteria andResidualFlowValueIsNotNull() {
            addCriterion("residual_flow_value is not null");
            return (Criteria) this;
        }

        public Criteria andResidualFlowValueEqualTo(BigDecimal value) {
            addCriterion("residual_flow_value =", value, "residualFlowValue");
            return (Criteria) this;
        }

        public Criteria andResidualFlowValueNotEqualTo(BigDecimal value) {
            addCriterion("residual_flow_value <>", value, "residualFlowValue");
            return (Criteria) this;
        }

        public Criteria andResidualFlowValueGreaterThan(BigDecimal value) {
            addCriterion("residual_flow_value >", value, "residualFlowValue");
            return (Criteria) this;
        }

        public Criteria andResidualFlowValueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("residual_flow_value >=", value, "residualFlowValue");
            return (Criteria) this;
        }

        public Criteria andResidualFlowValueLessThan(BigDecimal value) {
            addCriterion("residual_flow_value <", value, "residualFlowValue");
            return (Criteria) this;
        }

        public Criteria andResidualFlowValueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("residual_flow_value <=", value, "residualFlowValue");
            return (Criteria) this;
        }

        public Criteria andResidualFlowValueIn(List<BigDecimal> values) {
            addCriterion("residual_flow_value in", values, "residualFlowValue");
            return (Criteria) this;
        }

        public Criteria andResidualFlowValueNotIn(List<BigDecimal> values) {
            addCriterion("residual_flow_value not in", values, "residualFlowValue");
            return (Criteria) this;
        }

        public Criteria andResidualFlowValueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("residual_flow_value between", value1, value2, "residualFlowValue");
            return (Criteria) this;
        }

        public Criteria andResidualFlowValueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("residual_flow_value not between", value1, value2, "residualFlowValue");
            return (Criteria) this;
        }

        public Criteria andMonthUsedValueIsNull() {
            addCriterion("month_used_value is null");
            return (Criteria) this;
        }

        public Criteria andMonthUsedValueIsNotNull() {
            addCriterion("month_used_value is not null");
            return (Criteria) this;
        }

        public Criteria andMonthUsedValueEqualTo(String value) {
            addCriterion("month_used_value =", value, "monthUsedValue");
            return (Criteria) this;
        }

        public Criteria andMonthUsedValueNotEqualTo(String value) {
            addCriterion("month_used_value <>", value, "monthUsedValue");
            return (Criteria) this;
        }

        public Criteria andMonthUsedValueGreaterThan(String value) {
            addCriterion("month_used_value >", value, "monthUsedValue");
            return (Criteria) this;
        }

        public Criteria andMonthUsedValueGreaterThanOrEqualTo(String value) {
            addCriterion("month_used_value >=", value, "monthUsedValue");
            return (Criteria) this;
        }

        public Criteria andMonthUsedValueLessThan(String value) {
            addCriterion("month_used_value <", value, "monthUsedValue");
            return (Criteria) this;
        }

        public Criteria andMonthUsedValueLessThanOrEqualTo(String value) {
            addCriterion("month_used_value <=", value, "monthUsedValue");
            return (Criteria) this;
        }

        public Criteria andMonthUsedValueLike(String value) {
            addCriterion("month_used_value like", value, "monthUsedValue");
            return (Criteria) this;
        }

        public Criteria andMonthUsedValueNotLike(String value) {
            addCriterion("month_used_value not like", value, "monthUsedValue");
            return (Criteria) this;
        }

        public Criteria andMonthUsedValueIn(List<String> values) {
            addCriterion("month_used_value in", values, "monthUsedValue");
            return (Criteria) this;
        }

        public Criteria andMonthUsedValueNotIn(List<String> values) {
            addCriterion("month_used_value not in", values, "monthUsedValue");
            return (Criteria) this;
        }

        public Criteria andMonthUsedValueBetween(String value1, String value2) {
            addCriterion("month_used_value between", value1, value2, "monthUsedValue");
            return (Criteria) this;
        }

        public Criteria andMonthUsedValueNotBetween(String value1, String value2) {
            addCriterion("month_used_value not between", value1, value2, "monthUsedValue");
            return (Criteria) this;
        }

        public Criteria andTotalUsedValueIsNull() {
            addCriterion("total_used_value is null");
            return (Criteria) this;
        }

        public Criteria andTotalUsedValueIsNotNull() {
            addCriterion("total_used_value is not null");
            return (Criteria) this;
        }

        public Criteria andTotalUsedValueEqualTo(String value) {
            addCriterion("total_used_value =", value, "totalUsedValue");
            return (Criteria) this;
        }

        public Criteria andTotalUsedValueNotEqualTo(String value) {
            addCriterion("total_used_value <>", value, "totalUsedValue");
            return (Criteria) this;
        }

        public Criteria andTotalUsedValueGreaterThan(String value) {
            addCriterion("total_used_value >", value, "totalUsedValue");
            return (Criteria) this;
        }

        public Criteria andTotalUsedValueGreaterThanOrEqualTo(String value) {
            addCriterion("total_used_value >=", value, "totalUsedValue");
            return (Criteria) this;
        }

        public Criteria andTotalUsedValueLessThan(String value) {
            addCriterion("total_used_value <", value, "totalUsedValue");
            return (Criteria) this;
        }

        public Criteria andTotalUsedValueLessThanOrEqualTo(String value) {
            addCriterion("total_used_value <=", value, "totalUsedValue");
            return (Criteria) this;
        }

        public Criteria andTotalUsedValueLike(String value) {
            addCriterion("total_used_value like", value, "totalUsedValue");
            return (Criteria) this;
        }

        public Criteria andTotalUsedValueNotLike(String value) {
            addCriterion("total_used_value not like", value, "totalUsedValue");
            return (Criteria) this;
        }

        public Criteria andTotalUsedValueIn(List<String> values) {
            addCriterion("total_used_value in", values, "totalUsedValue");
            return (Criteria) this;
        }

        public Criteria andTotalUsedValueNotIn(List<String> values) {
            addCriterion("total_used_value not in", values, "totalUsedValue");
            return (Criteria) this;
        }

        public Criteria andTotalUsedValueBetween(String value1, String value2) {
            addCriterion("total_used_value between", value1, value2, "totalUsedValue");
            return (Criteria) this;
        }

        public Criteria andTotalUsedValueNotBetween(String value1, String value2) {
            addCriterion("total_used_value not between", value1, value2, "totalUsedValue");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("`status` like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("`status` not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("`operator` is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("`operator` is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("`operator` =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("`operator` <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("`operator` >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("`operator` >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("`operator` <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("`operator` <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("`operator` like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("`operator` not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("`operator` in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("`operator` not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("`operator` between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("`operator` not between", value1, value2, "operator");
            return (Criteria) this;
        }
    }

    /**
     * card
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * card 2019-10-18
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