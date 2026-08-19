package com.hdfclife.model;

public abstract class Policy {
    public String getPolicyno() {
        return policyno;
    }

    public String getCustomer() {
        return customer;
    }

    public int getPremium() {
        return premium;
    }

    public String getStatus() {
        return status;
    }

    public Policy(String policyno, String customer, int premium, String status) {
        this.policyno = policyno;
        this.customer = customer;
        this.premium = premium;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyno='" + policyno + '\'' +
                ", customer='" + customer + '\'' +
                ", premium=" + premium +
                ", status='" + status + '\'' +
                '}';
    }

    private String policyno;
        private String customer;
        private int premium;
        private String status;


    public abstract String getpolicytype();
}
