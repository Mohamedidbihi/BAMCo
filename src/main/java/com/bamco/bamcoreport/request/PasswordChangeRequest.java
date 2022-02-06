package com.bamco.bamcoreport.request;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Change Password", description = "Password Change Properties")
public class PasswordChangeRequest {

    private String oldPassword;
    private String newPassword;

    public PasswordChangeRequest() {
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
