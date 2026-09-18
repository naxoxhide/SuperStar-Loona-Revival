package com.kakao.adfit.m;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: NetworkResponse.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f1851b;
    public final Map<String, String> c;
    public final List<b> d;
    public final boolean e;
    public final long f;

    @Deprecated
    public d(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this(i, bArr, map, a(map), z, j);
    }

    private static Map<String, String> a(List<b> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (b bVar : list) {
            treeMap.put(bVar.a(), bVar.b());
        }
        return treeMap;
    }

    public d(int i, byte[] bArr, boolean z, long j, List<b> list) {
        this(i, bArr, a(list), list, z, j);
    }

    @Deprecated
    public d(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0L);
    }

    private d(int i, byte[] bArr, Map<String, String> map, List<b> list, boolean z, long j) {
        this.a = i;
        this.f1851b = bArr;
        this.c = map;
        if (list == null) {
            this.d = null;
        } else {
            this.d = Collections.unmodifiableList(list);
        }
        this.e = z;
        this.f = j;
    }

    private static List<b> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new b(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }
}
