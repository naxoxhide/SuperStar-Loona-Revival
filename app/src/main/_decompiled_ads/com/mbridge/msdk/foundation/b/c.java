package com.mbridge.msdk.foundation.b;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: CandidateResult.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public static int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f2062b = 1;
    public static int c = 2;
    public static int d = 3;
    private String e;
    private CopyOnWriteArrayList<CampaignEx> f;
    private int g = a;

    public final int a() {
        return this.g;
    }

    public final void a(int i) {
        this.g = i;
    }

    public final String b() {
        return this.e;
    }

    public final void a(String str) {
        this.e = str;
    }

    public final CopyOnWriteArrayList<CampaignEx> c() {
        return this.f;
    }

    public final void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        this.f = copyOnWriteArrayList;
    }
}
