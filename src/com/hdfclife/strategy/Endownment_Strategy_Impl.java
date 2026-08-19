package com.hdfclife.strategy;

public class Endownment_Strategy_Impl implements Premium_Strategy{
    @Override
    public int calculate_premium(int base_premium) {
        return base_premium * 108/100;
    }
}
