package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.MBridgeConstans;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: LimitExecutor.java */
/* JADX INFO: loaded from: classes4.dex */
public final class p implements Executor {
    private Runnable a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Runnable f2220b;

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable runnable) {
        if (this.a == null) {
            this.a = a(runnable);
            n.a().execute(this.a);
        } else if (this.f2220b == null) {
            this.f2220b = a(runnable);
        }
    }

    private Runnable a(final Runnable runnable) {
        return new Runnable() { // from class: com.mbridge.msdk.foundation.tools.p.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    try {
                        runnable.run();
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            aa.d("LimitExecutor", e.getMessage());
                        }
                    }
                } finally {
                    p.this.a();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        Runnable runnable = this.f2220b;
        this.a = runnable;
        this.f2220b = null;
        if (runnable != null) {
            n.a().execute(this.a);
        }
    }
}
