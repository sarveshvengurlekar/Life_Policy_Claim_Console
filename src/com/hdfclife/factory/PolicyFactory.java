package com.hdfclife.factory;

import com.hdfclife.exception.UnknownPolicyTypeException;
import com.hdfclife.model.EndownmentPolicy;
import com.hdfclife.model.Policy;
import com.hdfclife.model.TermLifePolicy;
import com.hdfclife.model.UlipPolicy;

public class PolicyFactory {
    private PolicyFactory(){}

    public static Policy create(String type,
                                String policyNo,
                                String customer,
                                int premium,
                                String status) {
        Policy policy;


        switch (type.toUpperCase()) {

            case "TERM":
                policy = new TermLifePolicy(
                        policyNo,
                        customer,
                        premium,
                        status
                );
                break;

            case "ULIP":
                policy = new UlipPolicy(
                        policyNo,
                        customer,
                        premium,
                        status
                );
                break;

            case "ENDOWMENT":
                policy = new EndownmentPolicy(
                        policyNo,
                        customer,
                        premium,
                        status
                );
                break;

            default:
                throw new UnknownPolicyTypeException(
                        "Unknown Policy Type : " + type
                );
        }
   return policy;
    }
}

