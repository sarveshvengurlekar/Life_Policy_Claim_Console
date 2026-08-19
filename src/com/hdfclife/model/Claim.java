package com.hdfclife.model;

public class Claim {
    private final String policyNo;
    private final int claimAmount;
    private final Urgency urgency;

        // Mutable Field
        private ClaimStatus status;

        /**
         * Private constructor.
         * Can only be called from Builder.
         */
        private Claim(Builder builder) {
            this.policyNo = builder.policyNo;
            this.claimAmount = builder.claimAmount;
            this.urgency = builder.urgency;

            this.status = ClaimStatus.SUBMITTED;
        }

        public String getPolicyNo() {
            return policyNo;
        }

        public int getClaimAmount() {
            return claimAmount;
        }

        public Urgency getUrgency() {
            return urgency;
        }

        public ClaimStatus getStatus() {
            return status;
        }

        /**
         * Only mutable operation allowed.
         */
        public void updateStatus(ClaimStatus status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "Claim{" +
                    "policyNo='" + policyNo + '\'' +
                    ", claimAmount=" + claimAmount +
                    ", urgency=" + urgency +
                    ", status=" + status +
                    '}';
        }

        // ==========================================================
        // Builder
        // ==========================================================

        public static class Builder {

            // Required
            private final String policyNo;
            private final int claimAmount;
            private final Urgency urgency;

            public Builder(String policyNo,
                           int claimAmount,
                           Urgency urgency) {

                this.policyNo = policyNo;
                this.claimAmount = claimAmount;
                this.urgency = urgency;
            }

            public Claim build() {
                return new Claim(this);
            }
        }
    }

