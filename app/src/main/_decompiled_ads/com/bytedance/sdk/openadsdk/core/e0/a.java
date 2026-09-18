package com.bytedance.sdk.openadsdk.core.e0;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.settings.d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: compiled from: FrequentCallController.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static volatile a d;
    private static volatile boolean e;
    private static volatile long f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f567b;
    private final Queue<b> a = new LinkedList();
    private final d c = o.d();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.e0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FrequentCallController.java */
    class RunnableC0195a implements Runnable {
        RunnableC0195a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a(false);
        }
    }

    /* JADX INFO: compiled from: FrequentCallController.java */
    private static class b {
        private final long a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f568b;

        /* synthetic */ b(long j, String str, RunnableC0195a runnableC0195a) {
            this(j, str);
        }

        private b(long j, String str) {
            this.a = j;
            this.f568b = str;
        }
    }

    private a() {
    }

    private synchronized boolean b(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iM = this.c.M();
        long jA = this.c.a();
        RunnableC0195a runnableC0195a = null;
        if (this.a.size() <= 0 || this.a.size() < iM) {
            this.a.offer(new b(jCurrentTimeMillis, str, runnableC0195a));
        } else {
            long jAbs = Math.abs(jCurrentTimeMillis - this.a.peek().a);
            if (jAbs <= jA) {
                b(jA - jAbs);
                return true;
            }
            this.a.poll();
            this.a.offer(new b(jCurrentTimeMillis, str, runnableC0195a));
        }
        return false;
    }

    public synchronized boolean c() {
        return e;
    }

    public static a a() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    public synchronized boolean a(String str) {
        if (b(str)) {
            a(true);
            a(f);
        } else {
            a(false);
        }
        return e;
    }

    private synchronized void a(long j) {
        if (this.f567b == null) {
            this.f567b = new Handler(Looper.getMainLooper());
        }
        this.f567b.postDelayed(new RunnableC0195a(), j);
    }

    private synchronized void b(long j) {
        f = j;
    }

    public synchronized String b() {
        String str;
        HashMap map = new HashMap();
        for (b bVar : this.a) {
            if (map.containsKey(bVar.f568b)) {
                map.put(bVar.f568b, Integer.valueOf(((Integer) map.get(bVar.f568b)).intValue() + 1));
            } else {
                map.put(bVar.f568b, 1);
            }
        }
        int i = Integer.MIN_VALUE;
        str = "";
        for (String str2 : map.keySet()) {
            int iIntValue = ((Integer) map.get(str2)).intValue();
            if (i < iIntValue) {
                str = str2;
                i = iIntValue;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z) {
        e = z;
    }
}
