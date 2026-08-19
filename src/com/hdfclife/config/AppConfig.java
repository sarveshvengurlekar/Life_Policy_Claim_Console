package com.hdfclife.config;

public enum AppConfig {
    INSTANCE;
    private final String companyname;
    private final int maxclaimamt;

    AppConfig(){
        companyname = "HDFC Life";
        maxclaimamt = 100000;
    }

    public String getCompanyname(){
        return companyname;
    }

    public int getMaxclaimamt(){
        return maxclaimamt;
    }

    public int getMaxClaimAmount() {
        return maxclaimamt;
    }
}
