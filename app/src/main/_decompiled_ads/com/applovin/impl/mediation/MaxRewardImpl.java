package com.applovin.impl.mediation;

import com.applovin.mediation.MaxReward;

/* JADX INFO: loaded from: classes.dex */
public class MaxRewardImpl implements MaxReward {
    private final int alr;
    private final String dp;

    public static MaxReward createDefault() {
        return create(0, "");
    }

    public static MaxReward create(int i, String str) {
        return new MaxRewardImpl(i, str);
    }

    private MaxRewardImpl(int i, String str) {
        if (i < 0) {
            throw new IllegalArgumentException("Reward amount must be greater than or equal to 0");
        }
        this.dp = str;
        this.alr = i;
    }

    @Override // com.applovin.mediation.MaxReward
    public final String getLabel() {
        return this.dp;
    }

    @Override // com.applovin.mediation.MaxReward
    public final int getAmount() {
        return this.alr;
    }

    public String toString() {
        return "MaxReward{amount=" + this.alr + ", label=" + this.dp + "}";
    }
}
