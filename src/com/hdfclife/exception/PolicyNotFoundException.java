package com.hdfclife.exception;

public class PolicyNotFoundException extends PolicyServiceException {

    public PolicyNotFoundException(String policyNo) {
        super("Policy not found : " + policyNo);
    }
}


