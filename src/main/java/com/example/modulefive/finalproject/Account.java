package com.example.modulefive.finalproject;

import java.util.ArrayList;

public class Account {
    private long accountId;
    private ArrayList<Claim> claims; // List of claims
    private String coverageTier;
    private User user;

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public ArrayList<Claim> getClaims() {
        return claims;
    }

    public void setClaims(ArrayList<Claim> claims) {
        this.claims = claims;
    }

    public String getCoverageTier() {
        return coverageTier;
    }

    public void setCoverageTier(String coverageTier) {
        this.coverageTier = coverageTier;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
