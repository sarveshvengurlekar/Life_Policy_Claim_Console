package com.hdfclife.exception;

public class UnknownPolicyTypeException extends PolicyServiceException {

    public UnknownPolicyTypeException(String type) {
        super("Unknown Policy Type : " + type);
    }
}