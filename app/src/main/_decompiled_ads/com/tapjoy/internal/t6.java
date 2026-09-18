package com.tapjoy.internal;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class t6 extends n0 {
    public static final Map f = Collections.unmodifiableMap(new HashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m0 f2816b;
    public final m0 c;
    public final m0 d;
    public final m0 e;

    public t6() {
        a();
        this.f2816b = a();
        m0 m0VarA = a();
        this.c = m0VarA;
        m0VarA.a = new ConcurrentHashMap();
        this.d = a();
        this.e = a();
        a().a = b();
    }

    public static HashMap b() {
        HashMap map = new HashMap();
        map.put("placement_request_content_retry_timeout", -1);
        map.put("placement_request_content_retry_backoff", Arrays.asList(0L, 500L, 10000L, Double.valueOf(2.0d)));
        return map;
    }
}
