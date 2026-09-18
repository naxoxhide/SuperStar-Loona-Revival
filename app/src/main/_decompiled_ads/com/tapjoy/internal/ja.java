package com.tapjoy.internal;

import android.content.Context;
import android.content.IntentFilter;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes4.dex */
public final class ja implements Runnable {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f2774b;
    public final ia c = new ia(this);
    public final /* synthetic */ aa d;

    public ja(aa aaVar) {
        this.d = aaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.a(3);
        aa aaVar = this.d;
        aaVar.a.lock();
        try {
            ga gaVar = aaVar.h;
            if (gaVar != null) {
                aaVar.g = gaVar;
                aaVar.h = null;
            }
            ga gaVar2 = aaVar.g;
            aaVar.a.unlock();
            this.f2774b = gaVar2.a;
            this.f2774b.registerReceiver(this.c, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            while (true) {
                try {
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    k3.f2775b.addObserver(new ha(this, countDownLatch));
                    aa aaVar2 = this.d;
                    aaVar2.a.lock();
                    try {
                        ga gaVar3 = aaVar2.h;
                        if (gaVar3 != null) {
                            aaVar2.g = gaVar3;
                            aaVar2.h = null;
                        }
                        ga gaVar4 = aaVar2.g;
                        aaVar2.a.unlock();
                        aa aaVar3 = this.d;
                        if (!super/*com.tapjoy.e0*/.a(gaVar4.a, gaVar4.f2760b, gaVar4.c, null)) {
                            this.d.a(1, "Failed to connect");
                            this.f2774b.unregisterReceiver(this.c);
                            aa aaVar4 = this.d;
                            if (aaVar4.e == this) {
                                aaVar4.e = null;
                            }
                            if (aaVar4.c == 3) {
                                this.d.a(1);
                                return;
                            }
                            return;
                        }
                        try {
                            countDownLatch.await();
                        } catch (InterruptedException unused) {
                        }
                        if (this.a) {
                            this.d.a(5);
                            this.d.a();
                            this.f2774b.unregisterReceiver(this.c);
                            aa aaVar5 = this.d;
                            if (aaVar5.e == this) {
                                aaVar5.e = null;
                            }
                            if (aaVar5.c == 3) {
                                this.d.a(1);
                                return;
                            }
                            return;
                        }
                        this.d.a(3, "Failed to connect");
                        long jMax = Math.max(this.d.f, 1000L);
                        this.d.f = Math.min(jMax << 2, 3600000L);
                        this.d.a(jMax);
                    } catch (Throwable th) {
                        aaVar2.a.unlock();
                        throw th;
                    }
                } catch (Throwable th2) {
                    this.f2774b.unregisterReceiver(this.c);
                    aa aaVar6 = this.d;
                    if (aaVar6.e == this) {
                        aaVar6.e = null;
                    }
                    if (aaVar6.c == 3) {
                        this.d.a(1);
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            aaVar.a.unlock();
            throw th3;
        }
    }
}
