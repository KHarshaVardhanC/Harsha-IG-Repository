package com.ig.model;

public class Scholar {
    private int scholarId;
    private String name;
    private String email;
    private String mobile;

    public Scholar(int scholarId, String name, String email, String mobile) {
        this.scholarId = scholarId;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public Scholar(String name, String email, String mobile) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public int getScholarId() {
        return scholarId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    @Override
    public String toString() {
        return "Scholar [scholarId=" + scholarId + ", name=" + name + ", email=" + email + ", mobile=" + mobile + "]";
    }
}
