package com.tupperware.auto.form;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.util.JdbcConstants;
import com.tupperware.auto.mysql.model.ConfigController;

import java.util.*;
import java.util.regex.Pattern;

public class ControllerGenerator {

    private List<ConditionHelper> params;

    private Map<String, String> select;

    private List<OrderbyHelper> order;

    private ConfigController controller;


    private String paramStr;

    private String paramData;

    private String paramValue;

    private String orderColumn;

    private String queryinline;

    private String plaintext;

    private Integer isunique;


    private String h1 = "###";


    public String getH1() {
        return h1;
    }

    public void setH1(String h1) {
        this.h1 = h1;
    }

    public String getPlaintext() {
        return plaintext;
    }

    public void setPlaintext() {
        this.plaintext = sql2notes(controller.getQuery());
    }

    private static String format(String str) {
        return Pattern.compile("\\s+").matcher(Pattern.compile("\\t|\r|\n").matcher(str).replaceAll(" "))
                .replaceAll(" ");

    }

    public static String sql2notes(String sql) {
        String result_lcase = null;
        try {
            result_lcase = SQLUtils.format(sql, JdbcConstants.MYSQL, SQLUtils.DEFAULT_LCASE_FORMAT_OPTION);
        } catch (Exception e) {
            // TODO: handle exception
        }
        result_lcase = (null == result_lcase ? sql : result_lcase);
        return Pattern.compile("\n|\r").matcher(result_lcase).replaceAll("  \\\\n").replaceAll("<", "&lt;");
    }

    public String getQueryinline() {
        return queryinline;

    }

    public void setQueryinline() {
        this.queryinline = format(controller.getQuery());
    }

    public String getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(List<OrderbyHelper> order) {
        if (null == orderColumn) {
            this.orderColumn = "";
            Iterator<OrderbyHelper> it = order.iterator();
            while (it.hasNext()) {
                OrderbyHelper p = it.next();

                this.orderColumn = this.orderColumn + String.format("%s%s", p.getName(), (it.hasNext() ? "," : ""));
            }
        }
        this.orderColumn = (null == this.orderColumn ? "" : this.orderColumn);
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(List<ConditionHelper> params) {
        Set<ConditionHelper> set = new HashSet<>();
        Iterator<ConditionHelper> it = params.iterator();
        while (it.hasNext()) {
            set.add(it.next());
        }

        if (null == paramValue) {
            this.paramValue = "";
            it = set.iterator();
            while (it.hasNext()) {
                ConditionHelper p = it.next();
                this.paramValue = this.paramValue + String.format("%s%s%s", p.getName(), p.getOperator().replaceAll("<", "&lt;"), p.getValue())
                        + (it.hasNext() ? "," : "");
            }
        }
    }

    public String getParamData() {
        return paramData;
    }

    public void setParamData(List<ConditionHelper> params) {
        if (null == paramData) {
            this.paramData = "";
            int count = 1;
            Iterator<ConditionHelper> it = params.iterator();
            while (it.hasNext() && count <= 3) {
                ConditionHelper p = it.next();
                this.paramData = this.paramData + String.format("String.valueOf(%s)", p.getName())
                        + (it.hasNext() && count < 3 ? "," : "");
                count++;
            }
        }
        if (paramData == "") {
            this.paramData = "\"\",\"\",\"\"";
        }
    }

    public String getParamStr() {
        return paramStr;
    }

    public void setParamStr(List<ConditionHelper> params) {
        if (null == paramStr) {
            this.paramStr = "";
            Iterator<ConditionHelper> it = params.iterator();
            while (it.hasNext()) {
                ConditionHelper p = it.next();
                this.paramStr = this.paramStr + p.getName() + (it.hasNext() ? "," : "");
            }
        }
    }

    public ConfigController getController() {
        return controller;
    }

    public void setController(ConfigController controller) {
        this.controller = controller;
    }

    public List<ConditionHelper> getParams() {
        return params;
    }

    public void setParams(List<ConditionHelper> params) {
        this.params = params;
    }

    public Map<String, String> getSelect() {
        return select;
    }

    public void setSelect(Map<String, String> select) {
        this.select = select;
    }

    public List<OrderbyHelper> getOrder() {
        return order;
    }

    public void setOrder(List<OrderbyHelper> order) {
        this.order = order;
    }

    public ControllerGenerator(List<ConditionHelper> params, Map<String, String> select, ConfigController controller) {
        super();
        this.params = params;
        this.select = select;
        this.controller = controller;
        this.setParamStr(params);
        this.setParamData(params);
        this.setParamValue(params);
        setQueryinline();
        setPlaintext();
        setIsunique();
    }

    public ControllerGenerator(List<ConditionHelper> params, Map<String, String> select, ConfigController controller,
                               List<OrderbyHelper> order) {
        super();
        this.params = params;
        this.select = select;
        this.controller = controller;
        this.order = order;
        this.setParamStr(params);
        this.setParamData(params);
        this.setParamValue(params);
        this.setOrderColumn(order);
        setQueryinline();
        setPlaintext();
        setIsunique();
    }

    @Override
    public String toString() {
        return "ControllerGenerator [params=" + params + ", select=" + select + ", order=" + order + ", controller="
                + controller + ", paramStr=" + paramStr + ", paramData=" + paramData + ", paramValue=" + paramValue
                + ", orderColumn=" + orderColumn + "]";
    }

    public Integer getIsunique() {
        return isunique;
    }

    public void setIsunique() {
        this.isunique=controller.getIsunique();
    }
}