package com.hdfclife.observer;

import com.hdfclife.model.Claim;

public class BranchLetterNotifier implements ClaimObserver{
    @Override
    public void onClaimUpdate(Claim claim) {
        System.out.println("========== Branch Letter ==========");
        System.out.println("Generate letter for Policy : "
                + claim.getPolicyNo());
        System.out.println("Current Status : "
                + claim.getStatus());
        System.out.println();
    }
}
