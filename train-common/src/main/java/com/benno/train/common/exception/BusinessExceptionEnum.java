package com.benno.train.common.exception;

public enum BusinessExceptionEnum {

    MEMBER_MOBILE_EXIST("the number is already registered!");

    private String desc;

    BusinessExceptionEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "BusinessExceptionEnum{" +
                "desc='" + desc + '\'' +
                '}' + super.toString();
    }
}
