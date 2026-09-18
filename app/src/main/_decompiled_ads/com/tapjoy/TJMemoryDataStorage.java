package com.tapjoy;

import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class TJMemoryDataStorage {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static TJMemoryDataStorage f2695b;
    public final WeakHashMap a = new WeakHashMap();

    public static TJMemoryDataStorage getInstance() {
        if (f2695b == null) {
            synchronized (TJMemoryDataStorage.class) {
                if (f2695b == null) {
                    f2695b = new TJMemoryDataStorage();
                }
            }
        }
        return f2695b;
    }

    public Object get(String str) {
        return this.a.get(str);
    }

    public void put(String str, Object obj) {
        this.a.put(str, obj);
    }

    public Object remove(String str) {
        return this.a.remove(str);
    }
}
