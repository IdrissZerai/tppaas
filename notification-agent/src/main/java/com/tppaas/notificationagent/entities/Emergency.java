package com.tppaas.notificationagent.entities;

public class Emergency {
    private String id;
    private String user_id;
    private String date;
    private String type;
    private String val;

    public Emergency(String id, String user_id, String date, String type, String val) {
        this.id = id;
        this.user_id = user_id;
        this.date = date;
        this.type = type;
        this.val = val;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
