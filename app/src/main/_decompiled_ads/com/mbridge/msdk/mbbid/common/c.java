package com.mbridge.msdk.mbbid.common;

/* JADX INFO: compiled from: BidRequestParams.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class c {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2281b;
    private String c;

    public c(String str, String str2) {
        this.a = str;
        this.f2281b = str2;
    }

    public c(String str, String str2, String str3) {
        this.a = str;
        this.f2281b = str2;
        this.c = str3;
    }

    public String getmUnitId() {
        return this.f2281b;
    }

    public void setmUnitId(String str) {
        this.f2281b = str;
    }

    public String getmFloorPrice() {
        return this.c;
    }

    public void setmFloorPrice(String str) {
        this.c = str;
    }

    public String getmPlacementId() {
        return this.a;
    }

    public void setmPlacementId(String str) {
        this.a = str;
    }
}
