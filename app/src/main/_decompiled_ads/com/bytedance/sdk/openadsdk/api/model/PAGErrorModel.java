package com.bytedance.sdk.openadsdk.api.model;

/* JADX INFO: loaded from: classes2.dex */
public class PAGErrorModel {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f433b;

    public PAGErrorModel(int i, String str) {
        this.a = i;
        this.f433b = str;
    }

    public int getErrorCode() {
        return this.a;
    }

    public String getErrorMessage() {
        return this.f433b;
    }
}
