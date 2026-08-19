package com.hdfclife.observer;

import com.hdfclife.model.Claim;

public class InAppNotifier implements ClaimObserver{
    @Override
    public void onClaimUpdate(Claim claim) {
        System.out.println("========== In-App Notification ==========");
        System.out.println("Policy Number : " + claim.getPolicyNo());
        System.out.println("Status Changed To : " + claim.getStatus());
        System.out.println();
    }
}
