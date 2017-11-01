package com.example.shared.ictbroadcastapp;



public class UserDataClass {

    String uuid,email,password,enroll,semester;

    public UserDataClass() {
    }

    public UserDataClass(String uuid,String email, String password, String enroll, String semester) {
        this.uuid = uuid;
        this.email = email;
        this.password = password;
        this.enroll = enroll;
        this.semester = semester;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnroll() {
        return enroll;
    }

    public void setEnroll(String enroll) {
        this.enroll = enroll;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}

