package com.applovin.impl.sdk.e;

import android.content.Context;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class d implements Runnable {
    private final Context E;
    private String aTy;
    private boolean aTz;
    protected final com.applovin.impl.sdk.x logger;
    protected final com.applovin.impl.sdk.n sdk;
    protected final String tag;

    public com.applovin.impl.sdk.n getSdk() {
        return this.sdk;
    }

    public String Ke() {
        return this.tag;
    }

    public Context rQ() {
        return this.E;
    }

    public void du(String str) {
        this.aTy = str;
    }

    public boolean Kf() {
        return this.aTz;
    }

    public void bf(boolean z) {
        this.aTz = z;
    }

    public d(String str, com.applovin.impl.sdk.n nVar) {
        this(str, nVar, false, null);
    }

    public d(String str, com.applovin.impl.sdk.n nVar, boolean z) {
        this(str, nVar, z, null);
    }

    public d(String str, com.applovin.impl.sdk.n nVar, String str2) {
        this(str, nVar, false, str2);
    }

    public d(String str, com.applovin.impl.sdk.n nVar, boolean z, String str2) {
        this.tag = str;
        this.sdk = nVar;
        this.logger = nVar.BL();
        this.E = com.applovin.impl.sdk.n.getApplicationContext();
        this.aTz = z;
        this.aTy = str2;
    }

    public void q(Throwable th) {
        Map<String, String> map = CollectionUtils.map("source", this.tag);
        map.put("top_main_method", th.toString());
        map.put("details", StringUtils.emptyIfNull(this.aTy));
        this.sdk.Cq().a(com.applovin.impl.sdk.r.a.TASK_EXCEPTION, map);
    }
}
