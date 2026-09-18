package com.bytedance.sdk.openadsdk;

/* JADX INFO: loaded from: classes2.dex */
public class TTImage {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f383b;
    private String c;
    private double d;

    public TTImage(int i, int i2, String str, double d) {
        this.d = 0.0d;
        this.a = i;
        this.f383b = i2;
        this.c = str;
        this.d = d;
    }

    public double getDuration() {
        return this.d;
    }

    public int getHeight() {
        return this.a;
    }

    public String getImageUrl() {
        return this.c;
    }

    public int getWidth() {
        return this.f383b;
    }

    public boolean isValid() {
        String str;
        return this.a > 0 && this.f383b > 0 && (str = this.c) != null && str.length() > 0;
    }

    public TTImage(int i, int i2, String str) {
        this(i, i2, str, 0.0d);
    }
}
