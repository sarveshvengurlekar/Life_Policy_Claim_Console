package com.hdfclife.strategy;

public class PremiumCalculator {

    // Holds the current premium calculation algorithm
    private Premium_Strategy strategy;

    // Constructor Injection
    public PremiumCalculator(Premium_Strategy strategy) {
        this.strategy = strategy;
    }

    // Change the strategy at runtime
    public void setStrategy(Premium_Strategy strategy) {
        this.strategy = strategy;
    }

    // Delegate the calculation to the current strategy
    public int calculatePremium(int basePremium) {

        if (strategy == null) {
            throw new IllegalStateException("Premium Strategy is not set.");
        }

        return strategy.calculate_premium(basePremium);
    }
}
