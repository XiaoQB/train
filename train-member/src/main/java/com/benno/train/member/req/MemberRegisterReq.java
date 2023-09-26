package com.benno.train.member.req;

import jakarta.validation.constraints.NotBlank;

public class MemberRegisterReq {

    @NotBlank(message = "[mobile number] can not be empty")
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "MemberRegisterReq{" +
                "mobile='" + mobile + '\'' +
                '}';
    }
}