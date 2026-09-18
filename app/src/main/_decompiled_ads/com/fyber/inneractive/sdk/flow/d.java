package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.response.e;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class d<T extends com.fyber.inneractive.sdk.response.e> extends com.fyber.inneractive.sdk.metrics.a {
    public static final String e = String.valueOf(24);
    public static final String f = String.valueOf(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f918b;
    public final InneractiveAdRequest c;
    public final JSONArray d;

    public d(T t, InneractiveAdRequest inneractiveAdRequest, String str, JSONArray jSONArray) {
        super(str);
        this.f918b = t;
        this.c = inneractiveAdRequest;
        this.d = jSONArray;
    }
}
