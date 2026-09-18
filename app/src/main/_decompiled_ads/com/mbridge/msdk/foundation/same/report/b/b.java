package com.mbridge.msdk.foundation.same.report.b;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

/* JADX INFO: compiled from: AnrMonitor.java */
/* JADX INFO: loaded from: classes4.dex */
public class b extends Thread {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile b f2166b;
    private int a;
    private final Handler c;
    private volatile a d;
    private com.mbridge.msdk.foundation.same.report.b.a e;

    /* JADX INFO: compiled from: AnrMonitor.java */
    private class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f2167b;
        private long c;
        private long d;

        private a() {
            this.d = SystemClock.uptimeMillis();
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (b.this) {
                Log.d("ANRMonitorActivity", "check task done");
                this.f2167b = true;
                this.d = SystemClock.uptimeMillis();
            }
        }

        final void a() {
            this.f2167b = false;
            this.c = SystemClock.uptimeMillis();
            b.this.c.postAtFrontOfQueue(this);
        }

        final boolean b() {
            return !this.f2167b || this.d - this.c >= ((long) b.this.a);
        }
    }

    public final b a(int i, com.mbridge.msdk.foundation.same.report.b.a aVar) {
        this.a = i;
        this.e = aVar;
        return this;
    }

    public static b a() {
        if (f2166b == null) {
            synchronized (b.class) {
                if (f2166b == null) {
                    f2166b = new b();
                }
            }
        }
        return f2166b;
    }

    private b() {
        super("AnrMonitor-Thread");
        this.a = 5000;
        this.c = new Handler(Looper.getMainLooper());
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0089 */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r6 = this;
            r0 = 10
            android.os.Process.setThreadPriority(r0)
        L5:
            boolean r0 = r6.isInterrupted()
            if (r0 != 0) goto L8c
            com.mbridge.msdk.foundation.same.report.b.b$a r0 = r6.d
            if (r0 == 0) goto L17
            com.mbridge.msdk.foundation.same.report.b.b$a r0 = r6.d
            boolean r0 = com.mbridge.msdk.foundation.same.report.b.b.a.a(r0)
            if (r0 == 0) goto L8c
        L17:
            monitor-enter(r6)
            com.mbridge.msdk.foundation.same.report.b.b$a r0 = r6.d     // Catch: java.lang.Throwable -> L89
            if (r0 != 0) goto L24
            com.mbridge.msdk.foundation.same.report.b.b$a r0 = new com.mbridge.msdk.foundation.same.report.b.b$a     // Catch: java.lang.Throwable -> L89
            r1 = 0
            r0.<init>()     // Catch: java.lang.Throwable -> L89
            r6.d = r0     // Catch: java.lang.Throwable -> L89
        L24:
            com.mbridge.msdk.foundation.same.report.b.b$a r0 = r6.d     // Catch: java.lang.Throwable -> L89
            r0.a()     // Catch: java.lang.Throwable -> L89
            int r0 = r6.a     // Catch: java.lang.Throwable -> L89
            long r0 = (long) r0     // Catch: java.lang.Throwable -> L89
            long r2 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.Throwable -> L89
        L30:
            r4 = 0
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 <= 0) goto L4f
            r6.wait(r0)     // Catch: java.lang.InterruptedException -> L3a java.lang.Throwable -> L89
            goto L44
        L3a:
            r0 = move-exception
            java.lang.String r1 = "AnrMonitor"
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L89
            android.util.Log.w(r1, r0)     // Catch: java.lang.Throwable -> L89
        L44:
            long r0 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.Throwable -> L89
            long r0 = r0 - r2
            int r4 = r6.a     // Catch: java.lang.Throwable -> L89
            long r4 = (long) r4     // Catch: java.lang.Throwable -> L89
            long r0 = r4 - r0
            goto L30
        L4f:
            com.mbridge.msdk.foundation.same.report.b.b$a r0 = r6.d     // Catch: java.lang.Throwable -> L89
            boolean r0 = r0.b()     // Catch: java.lang.Throwable -> L89
            if (r0 != 0) goto L60
            com.mbridge.msdk.foundation.same.report.b.a r0 = r6.e     // Catch: java.lang.Throwable -> L89
            if (r0 == 0) goto L5e
            r0.a()     // Catch: java.lang.Throwable -> L89
        L5e:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L89
            goto L5
        L60:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L89
            boolean r0 = android.os.Debug.isDebuggerConnected()
            if (r0 != 0) goto L5
            boolean r0 = android.os.Debug.waitingForDebugger()
            if (r0 == 0) goto L6e
            goto L5
        L6e:
            com.mbridge.msdk.foundation.same.report.b.a r0 = r6.e
            if (r0 == 0) goto L5
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            java.lang.Thread r0 = r0.getThread()
            java.lang.StackTraceElement[] r0 = r0.getStackTrace()
            java.lang.String r1 = com.mbridge.msdk.foundation.same.report.b.c.b(r0)
            com.mbridge.msdk.foundation.same.report.b.a r2 = r6.e
            r2.a(r1, r0)
            goto L5
        L89:
            r0 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L89
            throw r0
        L8c:
            int r0 = r6.a     // Catch: java.lang.Exception -> L5
            long r0 = (long) r0     // Catch: java.lang.Exception -> L5
            sleep(r0)     // Catch: java.lang.Exception -> L5
            goto L5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.report.b.b.run():void");
    }
}
