package com.hdfclife.model;

public class TermLifePolicy extends Policy{
    public TermLifePolicy(String policyno, String customer, int premium, String status) {
        super(policyno, customer, premium, status);
    }

    @Override
    public String getpolicytype(){
        return "Term";
    }
}
