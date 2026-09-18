package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.util.k0;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f974b;
    public com.fyber.inneractive.sdk.web.i c;
    public k0 d;

    public b(Map<String, String> map, com.fyber.inneractive.sdk.web.i iVar, k0 k0Var) {
        this.f974b = map;
        this.d = k0Var;
        this.c = iVar;
    }

    public int a(String str) {
        String str2 = this.f974b.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Integer.parseInt(str2, 10);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public abstract void a();

    public abstract boolean b();
}
