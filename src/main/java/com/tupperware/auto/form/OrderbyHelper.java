package com.tupperware.auto.form;

public class OrderbyHelper {
    private String column;
    private String name;
    private String type = " asc ";

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public OrderbyHelper(String column, String type) {
        super();
        this.column = column;
        this.name = column;
        this.type = type;

    }


}
