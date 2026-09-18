package com.bytedance.sdk.openadsdk.api.reward;

/* JADX INFO: loaded from: classes2.dex */
public class PAGRewardItem {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f436b;

    public PAGRewardItem(int i, String str) {
        this.a = i;
        this.f436b = str;
    }

    public int getRewardAmount() {
        return this.a;
    }

    public String getRewardName() {
        return this.f436b;
    }
}
