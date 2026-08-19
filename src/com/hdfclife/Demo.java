package com.hdfclife;

import com.hdfclife.config.AppConfig;
import com.hdfclife.exception.PolicyServiceException;
import com.hdfclife.factory.PolicyFactory;
import com.hdfclife.model.*;
import com.hdfclife.observer.*;
import com.hdfclife.service.ClaimService;
import com.hdfclife.store.PolicyStore;
import com.hdfclife.strategy.*;

public class Demo {

    public static void main(String[] args) {

        System.out.println("Company : "
                + AppConfig.INSTANCE.getCompanyname());

        PolicyStore store = new PolicyStore();

        store.addPolicy(
                PolicyFactory.create(
                        "TERM",
                        "HDFC-LIFE-1001",
                        "Anita Sharma",
                        18500,
                        "Active"));

        store.addPolicy(
                PolicyFactory.create(
                        "ULIP",
                        "HDFC-LIFE-1002",
                        "Rahul Mehta",
                        42000,
                        "Active"));

        store.addPolicy(
                PolicyFactory.create(
                        "ENDOWMENT",
                        "HDFC-LIFE-1003",
                        "Priya Nair",
                        27000,
                        "Lapsed"));

        store.addPolicy(
                PolicyFactory.create(
                        "TERM",
                        "HDFC-LIFE-1004",
                        "Vikram Singh",
                        15200,
                        "Active"));

        store.addPolicy(
                PolicyFactory.create(
                        "ULIP",
                        "HDFC-LIFE-1005",
                        "Sneha Patel",
                        36000,
                        "Active"));

        store.addPolicy(
                PolicyFactory.create(
                        "ENDOWMENT",
                        "HDFC-LIFE-1006",
                        "Anita Sharma",
                        22000,
                        "Pending"));

        System.out.println("\n------ All Policies ------");
        store.printPolicies();

        // ==========================================
        // 6. Lookup Policy
        // ==========================================

        Policy policy = store.getPolicy("HDFC-LIFE-1004");

        System.out.println("\nLookup Result : "
                + policy.getCustomer());

        // ==========================================
        // 7. TreeMap Keys
        // ==========================================

        // ==========================================
        // 8. Premium Calculation
        // ==========================================

        PremiumCalculator calculator =
                new PremiumCalculator(new ULIP_Strategy_Impl());

        int premium =
                calculator.calculatePremium((policy =
                                        store.getPolicy("HDFC-LIFE-1002")).getPremium());

        System.out.println("\nULIP Premium : "
                + premium);

        // ==========================================
        // 9. Observer
        // ==========================================

        ClaimEventPublisher publisher =
                new ClaimEventPublisher();

        publisher.registerObserver(
                new InAppNotifier());

        publisher.registerObserver(
                new BranchLetterNotifier());

        ClaimService claimService =
                new ClaimService(store, publisher);

        // ==========================================
        // 10. Build Three Claims
        // ==========================================

        Claim highClaim =
                new Claim.Builder(
                        "HDFC-LIFE-1001",
                        25000,
                        Urgency.HIGH)
                        .build();

        Claim mediumClaim =
                new Claim.Builder(
                        "HDFC-LIFE-1002",
                        30000,
                        Urgency.MEDIUM)
                        .build();

        Claim lowClaim =
                new Claim.Builder(
                        "HDFC-LIFE-1004",
                        15000,
                        Urgency.LOW)
                        .build();

        claimService.fileClaim(highClaim);
        claimService.fileClaim(mediumClaim);
        claimService.fileClaim(lowClaim);

        // ==========================================
        // 11. Approve High Claim
        // ==========================================

        claimService.updateClaimStatus(
                highClaim,
                ClaimStatus.APPROVED);

        // ==========================================
        // 12. Priority Queue
        // ==========================================

        store.printClaimsByPriority();

        // ==========================================
        // 13. Exception Demo
        // ==========================================

        try {
            store.getPolicy("HDFC-LIFE-9999");
        } catch (PolicyServiceException e) {
            System.out.println("\n" + e.getMessage());
        }

        try {

            Claim invalidClaim =
                    new Claim.Builder(
                            "HDFC-LIFE-1001",
                            600000,
                            Urgency.HIGH)
                            .build();

            claimService.fileClaim(invalidClaim);

        } catch (PolicyServiceException e) {
            System.out.println(e.getMessage());
        }

        try {

            PolicyFactory.create(
                    "INVALID",
                    "1007",
                    "Dummy",
                    10000,
                    "Active");

        } catch (PolicyServiceException e) {
            System.out.println(e.getMessage());
        }

    }

}