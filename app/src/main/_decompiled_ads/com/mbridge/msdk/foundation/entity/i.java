package com.mbridge.msdk.foundation.entity;

import java.io.Serializable;

/* JADX INFO: compiled from: LoopEntity.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i implements Serializable {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2093b;
    private int c;

    public i(String str, String str2, int i) {
        this.f2093b = str;
        this.a = str2;
        this.c = i;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.f2093b;
    }
}
