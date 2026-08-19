package com.hdfclife.model;

public class UlipPolicy extends Policy{
    public UlipPolicy(String policyno, String customer, int premium, String status) {
        super(policyno, customer, premium, status);
    }

    @Override
    public String getpolicytype() {
        return "Ulip";
    }
}
