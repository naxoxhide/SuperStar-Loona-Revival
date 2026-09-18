package com.mbridge.msdk.foundation.same.report;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: CommonReportEventGroup.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, b> f2171b;

    private c(String str) {
        this.a = str;
        this.f2171b = new ConcurrentHashMap();
    }

    public c() {
        this(null);
    }

    public final b a(b bVar, String str, boolean z, boolean z2) {
        b bVarRemove;
        if (bVar == null) {
            return null;
        }
        if (z) {
            bVarRemove = this.f2171b.remove(str);
        } else {
            bVarRemove = this.f2171b.get(str);
        }
        if (bVarRemove != null) {
            bVar = bVar.a().a(bVar.q() - bVarRemove.q()).a();
        }
        if (!z2) {
            this.f2171b.put(bVar.i(), bVar);
        }
        return bVar;
    }

    public final b a(b bVar) {
        if (bVar == null) {
            return null;
        }
        this.f2171b.put(bVar.i(), bVar);
        return bVar;
    }
}
