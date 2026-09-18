package com.fyber.inneractive.sdk;

import android.app.Activity;
import com.fyber.inneractive.sdk.config.b0;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.dv.f;
import com.fyber.inneractive.sdk.network.r;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T> extends com.fyber.inneractive.sdk.dv.a<T> {
    public com.fyber.inneractive.sdk.dv.interstitial.a j;

    public a(b0 b0Var, s sVar, f fVar) {
        super(b0Var, sVar, fVar);
        this.j = null;
    }

    public abstract void a(com.fyber.inneractive.sdk.dv.interstitial.a aVar, Activity activity);

    public void j() {
        try {
            new com.fyber.inneractive.sdk.network.s.a(r.EVENT_READY_ON_CLIENT, this.a, (f) this.f927b, (JSONArray) null).a((String) null);
        } catch (Exception unused) {
        }
    }
}
