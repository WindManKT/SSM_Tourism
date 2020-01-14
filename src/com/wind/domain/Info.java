package com.wind.domain;

public class Info {
    private int id;
    private String python;
    private  String message;
    private  int uid;

    public Info(int id, String python, String message, int uid) {
        this.id = id;
        this.python = python;
        this.message = message;
        this.uid = uid;
    }

    public Info() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPython() {
        return python;
    }

    public void setPython(String python) {
        this.python = python;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", python='" + python + '\'' +
                ", message='" + message + '\'' +
                ", uid=" + uid +
                '}';
    }
}
