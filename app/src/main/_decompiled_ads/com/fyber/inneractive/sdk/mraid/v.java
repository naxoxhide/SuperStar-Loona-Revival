package com.fyber.inneractive.sdk.mraid;

/* JADX INFO: loaded from: classes2.dex */
public class v extends u {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f976b;
    public final int c;
    public final int d;

    public v(int i, int i2, int i3, int i4) {
        this.a = i3;
        this.f976b = i4;
        this.d = i2;
        this.c = i;
    }

    @Override // com.fyber.inneractive.sdk.mraid.u
    public String a() {
        return "currentPosition: { x: " + this.c + ", y: " + this.d + ", width: " + this.a + ", height: " + this.f976b + " }";
    }
}
