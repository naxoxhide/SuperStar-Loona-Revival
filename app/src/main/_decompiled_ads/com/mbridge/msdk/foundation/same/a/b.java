package com.mbridge.msdk.foundation.same.a;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: compiled from: LruReplaceTempCache.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements c<String, JSONObject> {
    private final LinkedHashMap<String, JSONObject> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2101b;
    private int c;

    @Override // com.mbridge.msdk.foundation.same.a.c
    public final /* synthetic */ void a(String str) {
        String str2 = str;
        Objects.requireNonNull(str2, "key == null");
        synchronized (this) {
            if (this.a.remove(str2) != null) {
                this.c--;
            }
        }
    }

    public b(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f2101b = i;
        this.a = new LinkedHashMap<>(0, 0.75f, true);
    }

    @Override // com.mbridge.msdk.foundation.same.a.c
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final JSONObject b(String str) {
        JSONObject jSONObject;
        Objects.requireNonNull(str, "key == null");
        synchronized (this) {
            jSONObject = this.a.get(str);
        }
        return jSONObject;
    }

    @Override // com.mbridge.msdk.foundation.same.a.c
    public final boolean a(String str, JSONObject jSONObject) {
        if (str == null || jSONObject == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.c++;
            if (this.a.put(str, jSONObject) != null) {
                this.c--;
            }
        }
        a(this.f2101b);
        return true;
    }

    private void a(int i) {
        while (true) {
            synchronized (this) {
                if (this.c < 0 || (this.a.isEmpty() && this.c != 0)) {
                    break;
                }
                if (this.c > i && !this.a.isEmpty()) {
                    Map.Entry<String, JSONObject> next = this.a.entrySet().iterator().next();
                    if (next == null) {
                        return;
                    }
                    String key = next.getKey();
                    next.getValue();
                    try {
                        this.a.remove(key);
                        this.c--;
                    } catch (Throwable unused) {
                    }
                }
                return;
            }
        }
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    @Override // com.mbridge.msdk.foundation.same.a.c
    public final Collection<String> a() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.a.keySet());
        }
        return hashSet;
    }

    @Override // com.mbridge.msdk.foundation.same.a.c
    public final void b() {
        a(-1);
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.f2101b));
    }
}
