package com.fyber.inneractive.sdk.player.cache;

import android.content.Context;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.p;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class n implements c.e {
    public static final n f = new n();
    public Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f1015b;
    public boolean c = false;
    public final List<String> d = new CopyOnWriteArrayList();
    public final Runnable e = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long j;
            File fileA = n.a(n.this.a, "fyb.vamp.vid.cache");
            if (fileA != null) {
                try {
                    IAlog.a("VideoCache opening the cache in directory - %s", fileA);
                    n.this.f1015b = c.a(fileA, 0, 1, 52428800L);
                    c cVar = n.this.f1015b;
                    cVar.getClass();
                    IAlog.d("DiskLruCache delete cache", new Object[0]);
                    cVar.close();
                    m.a(cVar.a);
                    n.this.f1015b = c.a(fileA, 0, 1, 52428800L);
                    Object[] objArr = new Object[2];
                    objArr[0] = fileA;
                    c cVar2 = n.this.f1015b;
                    synchronized (cVar2) {
                        j = cVar2.h;
                    }
                    objArr[1] = Long.valueOf(j);
                    IAlog.a("VideoCache opened the cache in directory - %s current size is %d", objArr);
                    n nVar = n.this;
                    nVar.f1015b.l = nVar;
                    nVar.c = true;
                    n.this.getClass();
                } catch (Throwable th) {
                    t.a("Failed to open cache directory", th.getMessage(), null, null);
                    IAlog.a("Failed to open cache directory", th, new Object[0]);
                }
            }
        }
    }

    public static File a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        if (com.fyber.inneractive.sdk.util.l.a != null && com.fyber.inneractive.sdk.util.l.b("android.permission.WRITE_EXTERNAL_STORAGE") && "mounted".equals(com.fyber.inneractive.sdk.util.l.b())) {
            String strB = com.fyber.inneractive.sdk.util.l.b();
            if ("mounted".equals(strB) || "mounted_ro".equals(strB)) {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir != null && externalCacheDir.getFreeSpace() > 52428800) {
                    return new File(context.getExternalCacheDir(), str);
                }
            }
        }
        File cacheDir = context.getCacheDir();
        if (cacheDir != null && cacheDir.getFreeSpace() > 52428800) {
            return new File(context.getCacheDir(), str);
        }
        return null;
    }

    public boolean a() {
        return this.c && p.a();
    }

    public boolean a(c cVar, String str) {
        Iterator<String> it = this.d.iterator();
        while (it.hasNext()) {
            if (it.next().equalsIgnoreCase(str)) {
                return false;
            }
        }
        return true;
    }
}
