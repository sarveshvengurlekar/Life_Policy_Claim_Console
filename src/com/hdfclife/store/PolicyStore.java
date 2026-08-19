package com.hdfclife.store;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

import com.hdfclife.exception.PolicyNotFoundException;
import com.hdfclife.model.Policy;

public class PolicyStore {

        // 1. Stores policies in insertion order
        private ArrayList<Policy> policyList = new ArrayList<>();

        // 2. Fast lookup using policy number
        private HashMap<String, Policy> policyMap = new HashMap<>();

        // 3. Sorted by policy number
        private TreeMap<String, Policy> policyTree = new TreeMap<>();

        // 4. Stores unique customer names
        private HashSet<String> customerSet = new HashSet<>();


        // Add Policy
        public void addPolicy(Policy policy) {

            policyList.add(policy);
            policyMap.put(policy.getPolicyno(), policy);
            policyTree.put(policy.getPolicyno(), policy);
            customerSet.add(policy.getCustomer());
        }

        // Get policy using HashMap
        public Policy getPolicy(String policyNo) {

            if (!policyMap.containsKey(policyNo)) {
                throw new PolicyNotFoundException(
                        "Policy not found : " + policyNo
                );
            }

            return policyMap.get(policyNo);
        }

        // Display policies in insertion order
        public void displayPolicyList() {

            for (Policy policy : policyList) {
                System.out.println(policy);
            }
        }

        // Display policies in sorted order
        public void displaySortedPolicies() {

            for (Policy policy : policyTree.values()) {
                System.out.println(policy);
            }
        }

        // Display unique customers
        public void displayCustomers() {

            for (String customer : customerSet) {
                System.out.println(customer);
            }
        }

        // Getters
        public ArrayList<Policy> getPolicyList() {
            return policyList;
        }
        public HashMap<String, Policy> getPolicyMap() {
            return policyMap;
        }
        public TreeMap<String, Policy> getPolicyTree() {
            return policyTree;
        }
        public HashSet<String> getCustomerSet() {
            return customerSet;
        }

    public void printPolicies() {
        System.out.println(policyList);
    }

    public void printClaimsByPriority() {

    }
}

