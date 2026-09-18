package com.bytedance.sdk.openadsdk.api.nativeAd;

/* JADX INFO: loaded from: classes2.dex */
public class PAGImageItem {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f434b;
    private String c;
    private float d;

    public PAGImageItem(int i, int i2, String str, float f) {
        this.d = 0.0f;
        this.a = i;
        this.f434b = i2;
        this.c = str;
        this.d = f;
    }

    public float getDuration() {
        return this.d;
    }

    public int getHeight() {
        return this.a;
    }

    public String getImageUrl() {
        return this.c;
    }

    public int getWidth() {
        return this.f434b;
    }

    public PAGImageItem(int i, int i2, String str) {
        this(i, i2, str, 0.0f);
    }
}
