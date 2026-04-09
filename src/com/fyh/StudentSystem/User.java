package com.fyh.StudentSystem;

public class User {
    private String uname;
    private int password;
    private String phone;
    private String uid;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public User() {
    }

    public User(String uname, int password, String phone, String uid) {
        this.uname = uname;
        this.password = password;
        this.phone = phone;
        this.uid = uid;
    }
}
