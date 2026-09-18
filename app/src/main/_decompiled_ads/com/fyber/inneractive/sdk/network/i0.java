package com.fyber.inneractive.sdk.network;

import android.os.Build;
import com.fyber.inneractive.sdk.util.IAlog;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class i0 extends f0<String> {
    public String r;
    public final String s;
    public final AtomicInteger t;

    public i0(w<String> wVar, String str, String str2, g gVar) {
        super(wVar, gVar);
        this.t = new AtomicInteger();
        this.s = str;
        this.r = str2;
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public String a() {
        return this.s;
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public o0 i() {
        return o0.LOW;
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public boolean o() {
        return this.t.getAndIncrement() < 4;
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public z r() {
        return z.POST;
    }

    @Override // com.fyber.inneractive.sdk.network.c0
    public int v() {
        return ((int) Math.pow(2.0d, this.t.get())) * 1000;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [T, java.lang.String] */
    @Override // com.fyber.inneractive.sdk.network.c0
    public b0 a(j jVar, Map<String, List<String>> map, int i) throws Exception {
        try {
            b0 b0Var = new b0();
            b0Var.a = String.valueOf(i);
            return b0Var;
        } catch (Exception e) {
            IAlog.a("failed parse event network request", e, new Object[0]);
            throw new a0(e);
        }
    }

    @Override // com.fyber.inneractive.sdk.network.f0, com.fyber.inneractive.sdk.network.c0
    public byte[] u() {
        byte[] bytes;
        try {
            IAlog.a("NetworkRequestEvent: network request body %s", this.r);
            if (Build.VERSION.SDK_INT >= 19) {
                bytes = this.r.getBytes(StandardCharsets.UTF_8);
            } else {
                bytes = this.r.getBytes("UTF-8");
            }
            return bytes;
        } catch (Exception unused) {
            return new byte[0];
        }
    }
}
