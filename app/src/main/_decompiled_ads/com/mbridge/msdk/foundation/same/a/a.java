package com.mbridge.msdk.foundation.same.a;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: LruMemoryCache.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements c<String, Bitmap> {
    private final LinkedHashMap<String, Bitmap> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2100b;
    private int c;

    @Override // com.mbridge.msdk.foundation.same.a.c
    public final /* synthetic */ void a(String str) {
        String str2 = str;
        Objects.requireNonNull(str2, "key == null");
        synchronized (this) {
            Bitmap bitmapRemove = this.a.remove(str2);
            if (bitmapRemove != null) {
                this.c -= b(str2, bitmapRemove);
            }
        }
    }

    public a(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f2100b = i;
        this.a = new LinkedHashMap<>(0, 0.75f, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.mbridge.msdk.foundation.same.a.c
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Bitmap b(String str) {
        Objects.requireNonNull(str, "key == null");
        synchronized (this) {
            Bitmap bitmap = this.a.get(str);
            if (bitmap == null || bitmap.isRecycled()) {
                return null;
            }
            return bitmap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.mbridge.msdk.foundation.same.a.c
    public boolean a(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.c += b(str, bitmap);
            Bitmap bitmapPut = this.a.put(str, bitmap);
            if (bitmapPut != null) {
                this.c -= b(str, bitmapPut);
            }
        }
        a(this.f2100b);
        return true;
    }

    private void a(int i) {
        while (true) {
            synchronized (this) {
                if (this.c < 0 || (this.a.isEmpty() && this.c != 0)) {
                    break;
                }
                if (this.c > i && !this.a.isEmpty()) {
                    Map.Entry<String, Bitmap> next = this.a.entrySet().iterator().next();
                    if (next == null) {
                        return;
                    }
                    String key = next.getKey();
                    try {
                        int iB = b(key, next.getValue());
                        this.a.remove(key).recycle();
                        this.c -= iB;
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

    private int b(String str, Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.f2100b));
    }
}
