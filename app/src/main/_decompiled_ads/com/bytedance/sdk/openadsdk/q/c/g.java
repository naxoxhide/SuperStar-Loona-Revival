package com.bytedance.sdk.openadsdk.q.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: PAGTimerManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static HandlerThread f819b;

    /* JADX INFO: compiled from: PAGTimerManager.java */
    private static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void a(b bVar) {
            if (bVar == null) {
                return;
            }
            int iIntValue = bVar.g().intValue();
            if (hasMessages(iIntValue)) {
                return;
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = iIntValue;
            messageObtain.obj = bVar;
            sendMessageDelayed(messageObtain, bVar.f());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b bVar = (b) message.obj;
            if (bVar == null) {
                return;
            }
            int iL = bVar.l();
            if (iL == 1) {
                bVar.b();
            } else {
                if (iL != 2) {
                    e.b(bVar.g());
                    return;
                }
                bVar.j();
            }
            if (bVar.h()) {
                e.b(bVar.g());
            } else if (bVar.d()) {
                a(bVar);
            }
        }
    }

    public static void a(b bVar) {
        if (bVar == null) {
            return;
        }
        a();
        a aVar = a;
        if (aVar != null) {
            aVar.a(bVar);
        }
    }

    public static void b() {
    }

    public static void b(b bVar) {
        if (bVar == null || a == null) {
            return;
        }
        try {
            int iIntValue = bVar.g().intValue();
            if (a.hasMessages(iIntValue)) {
                a.removeMessages(iIntValue);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x003a */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0044, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a() {
        /*
            com.bytedance.sdk.openadsdk.q.c.g$a r0 = com.bytedance.sdk.openadsdk.q.c.g.a
            if (r0 == 0) goto L5
            return
        L5:
            android.os.HandlerThread r0 = com.bytedance.sdk.openadsdk.q.c.g.f819b     // Catch: java.lang.Throwable -> L3a
            if (r0 == 0) goto Lf
            boolean r0 = r0.isAlive()     // Catch: java.lang.Throwable -> L3a
            if (r0 != 0) goto L44
        Lf:
            java.lang.Class<com.bytedance.sdk.openadsdk.q.c.g> r0 = com.bytedance.sdk.openadsdk.q.c.g.class
            monitor-enter(r0)     // Catch: java.lang.Throwable -> L3a
            android.os.HandlerThread r1 = com.bytedance.sdk.openadsdk.q.c.g.f819b     // Catch: java.lang.Throwable -> L37
            if (r1 == 0) goto L1c
            boolean r1 = r1.isAlive()     // Catch: java.lang.Throwable -> L37
            if (r1 != 0) goto L35
        L1c:
            android.os.HandlerThread r1 = new android.os.HandlerThread     // Catch: java.lang.Throwable -> L37
            java.lang.String r2 = "csj_MRC"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L37
            com.bytedance.sdk.openadsdk.q.c.g.f819b = r1     // Catch: java.lang.Throwable -> L37
            r1.start()     // Catch: java.lang.Throwable -> L37
            com.bytedance.sdk.openadsdk.q.c.g$a r1 = new com.bytedance.sdk.openadsdk.q.c.g$a     // Catch: java.lang.Throwable -> L37
            android.os.HandlerThread r2 = com.bytedance.sdk.openadsdk.q.c.g.f819b     // Catch: java.lang.Throwable -> L37
            android.os.Looper r2 = r2.getLooper()     // Catch: java.lang.Throwable -> L37
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L37
            com.bytedance.sdk.openadsdk.q.c.g.a = r1     // Catch: java.lang.Throwable -> L37
        L35:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L37
            goto L44
        L37:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L37
            throw r1     // Catch: java.lang.Throwable -> L3a
        L3a:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            java.lang.String r1 = "MRC"
            com.bytedance.sdk.component.utils.m.b(r1, r0)
        L44:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.q.c.g.a():void");
    }
}
