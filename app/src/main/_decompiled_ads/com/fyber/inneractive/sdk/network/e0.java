package com.fyber.inneractive.sdk.network;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e0 {
    public final InneractiveAdRequest a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.serverapi.c f984b;
    public Map<String, String> c;

    public e0(InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.serverapi.c cVar) {
        this.a = inneractiveAdRequest;
        this.f984b = cVar;
    }

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.c.put(str, str2);
    }
}
