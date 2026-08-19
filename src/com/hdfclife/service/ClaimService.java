package com.hdfclife.service;
import com.hdfclife.config.AppConfig;
import com.hdfclife.exception.InvalidClaimException;
import com.hdfclife.model.Claim;
import com.hdfclife.model.ClaimStatus;
import com.hdfclife.observer.ClaimEventPublisher;
import com.hdfclife.store.PolicyStore;

public class ClaimService {
        private PolicyStore store;
        private ClaimEventPublisher publisher;

        public ClaimService(PolicyStore store,
                            ClaimEventPublisher publisher) {

            this.store = store;
            this.publisher = publisher;
        }

        // File a new claim
        public void fileClaim(Claim claim) {

            // Validate Policy
            store.getPolicy(claim.getPolicyNo());

            // Validate Claim Amount
            if (claim.getClaimAmount() <= 0
                    || claim.getClaimAmount() >
                    AppConfig.INSTANCE.getMaxClaimAmount()) {

                throw new InvalidClaimException(
                        "Invalid Claim Amount : "
                                + claim.getClaimAmount());
            }

            // Audit Log
            try (AuditLogger logger = new AuditLogger()) {

                logger.log("Claim Filed : "
                        + claim.getPolicyNo()
                        + " Amount : "
                        + claim.getClaimAmount());
            }

            System.out.println("Claim Filed Successfully");
        }

        // Update Status
        public void updateClaimStatus(Claim claim,
                                      ClaimStatus status) {
            claim.updateStatus(status);
            publisher.notifyObservers(claim);

        }

    }


