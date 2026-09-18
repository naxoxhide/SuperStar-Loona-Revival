package com.mbridge.msdk.dycreator.g;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: BaseAbstractSubject.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends com.mbridge.msdk.dycreator.c.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<Object> f2008b = new ArrayList();
    protected ConcurrentHashMap<Integer, Object> a = new ConcurrentHashMap<>();

    public final synchronized void a(Object obj, int i) {
        if (obj != null) {
            ConcurrentHashMap<Integer, Object> concurrentHashMap = this.a;
            if (concurrentHashMap != null && !concurrentHashMap.containsValue(obj)) {
                this.a.put(Integer.valueOf(i), obj);
            }
        }
    }

    public final synchronized void a() {
        this.a.clear();
    }
}
