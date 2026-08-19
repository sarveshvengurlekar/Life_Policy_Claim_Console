package com.hdfclife.model;

public class EndownmentPolicy extends Policy{
    public EndownmentPolicy(String policyno, String customer, int premium, String status) {
        super(policyno, customer, premium, status);
    }

    @Override
    public String getpolicytype() {
        return "Endowment";
    }
}
