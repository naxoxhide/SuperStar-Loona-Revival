package com.mbridge.msdk.foundation.same.net.e;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: NetworkResponse.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f2144b;
    public final Map<String, String> c;
    public final List<com.mbridge.msdk.foundation.same.net.c.b> d;

    public c(int i, byte[] bArr, List<com.mbridge.msdk.foundation.same.net.c.b> list) {
        this(i, bArr, a(list), list);
    }

    private c(int i, byte[] bArr, Map<String, String> map, List<com.mbridge.msdk.foundation.same.net.c.b> list) {
        this.a = i;
        this.f2144b = bArr;
        this.c = map;
        if (list == null) {
            this.d = null;
        } else {
            this.d = Collections.unmodifiableList(list);
        }
    }

    private static Map<String, String> a(List<com.mbridge.msdk.foundation.same.net.c.b> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (com.mbridge.msdk.foundation.same.net.c.b bVar : list) {
            treeMap.put(bVar.a(), bVar.b());
        }
        return treeMap;
    }
}
