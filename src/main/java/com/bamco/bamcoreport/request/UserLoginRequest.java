package com.bamco.bamcoreport.request;

import java.io.Serializable;

public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = -7249937977115969457L;

    private String username;
    private String password;

    public UserLoginRequest(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
