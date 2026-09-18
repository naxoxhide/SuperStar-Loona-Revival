package com.applovin.impl.sdk.network;

import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.SessionTracker;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f implements AppLovinBroadcastManager.Receiver {
    private final Object aFr = new Object();
    private final int aHZ;
    private final g aIa;
    private final List<h> aIb;
    private final Set<h> aIc;
    private final List<h> aId;
    private final x logger;
    private final n sdk;

    public f(n nVar) {
        ArrayList arrayList = new ArrayList();
        this.aIb = arrayList;
        this.aIc = new HashSet();
        this.aId = new ArrayList();
        if (nVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.sdk = nVar;
        this.logger = nVar.BL();
        int iIntValue = ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aNA)).intValue();
        this.aHZ = iIntValue;
        if (((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aND)).booleanValue()) {
            g gVar = new g(this, nVar);
            this.aIa = gVar;
            if (u.a(com.applovin.impl.sdk.c.b.aLW, nVar) && u.Lv()) {
                a(new Runnable() { // from class: com.applovin.impl.sdk.network.-$$Lambda$f$rxlvZynBy8MMss2Kleb7mfQUdus
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.ln();
                    }
                }, true, true);
            } else {
                arrayList.addAll(gVar.gH(iIntValue));
            }
            AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
            return;
        }
        this.aIa = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ln() {
        synchronized (this.aFr) {
            this.aIb.addAll(0, this.aIa.gH(this.aHZ));
        }
    }

    public void a(h hVar) {
        a(hVar, true);
    }

    public void a(h hVar, boolean z) {
        a(hVar, z, (AppLovinPostbackListener) null);
    }

    public void a(final h hVar, boolean z, final AppLovinPostbackListener appLovinPostbackListener) {
        if (TextUtils.isEmpty(hVar.Is())) {
            if (x.Fk()) {
                this.logger.i("PersistentPostbackManager", "Requested a postback dispatch for empty URL; nothing to do...");
            }
        } else {
            if (z) {
                hVar.Iz();
            }
            a(new Runnable() { // from class: com.applovin.impl.sdk.network.-$$Lambda$f$-e4t_v5EG12Q5AZ4BY_OIgZSyUE
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(hVar, appLovinPostbackListener);
                }
            }, u.Lv(), hVar.IC());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(h hVar, AppLovinPostbackListener appLovinPostbackListener) {
        synchronized (this.aFr) {
            c(hVar);
            a(hVar, appLovinPostbackListener);
        }
    }

    public void Io() {
        a(new Runnable() { // from class: com.applovin.impl.sdk.network.-$$Lambda$f$EV3_QVkrKjFLz-fdvM5oqQlQjIQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.Ir();
            }
        }, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ir() {
        synchronized (this.aFr) {
            Iterator it = new ArrayList(this.aIb).iterator();
            while (it.hasNext()) {
                b((h) it.next());
            }
        }
    }

    protected List<h> Ip() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.aFr) {
            if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aNC)).booleanValue()) {
                arrayList.ensureCapacity(this.aId.size());
                arrayList.addAll(this.aId);
            } else {
                arrayList.ensureCapacity(this.aIb.size());
                arrayList.addAll(this.aIb);
            }
        }
        return arrayList;
    }

    private void b(h hVar) {
        a(hVar, (AppLovinPostbackListener) null);
    }

    private void a(final h hVar, final AppLovinPostbackListener appLovinPostbackListener) {
        if (x.Fk()) {
            this.logger.f("PersistentPostbackManager", "Preparing to submit postback: " + hVar);
        }
        if (this.sdk.Bn() && !hVar.IC()) {
            if (x.Fk()) {
                this.logger.f("PersistentPostbackManager", "Skipping postback dispatch because SDK is still initializing - postback will be dispatched afterwards");
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(hVar.Is())) {
            if (x.Fk()) {
                this.logger.i("PersistentPostbackManager", "Skipping empty postback dispatch...");
                return;
            }
            return;
        }
        synchronized (this.aFr) {
            if (this.aIc.contains(hVar)) {
                if (x.Fk()) {
                    this.logger.f("PersistentPostbackManager", "Skipping in progress postback: " + hVar.Is());
                }
                return;
            }
            hVar.Iy();
            Integer num = (Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aNz);
            if (hVar.Ix() > num.intValue()) {
                if (x.Fk()) {
                    this.logger.h("PersistentPostbackManager", "Exceeded maximum persisted attempt count of " + num + ". Dequeuing postback: " + hVar);
                }
                d(hVar);
            } else {
                synchronized (this.aFr) {
                    this.aIc.add(hVar);
                }
                i iVarIF = i.E(this.sdk).da(hVar.Is()).dc(hVar.It()).k(hVar.HP()).db(hVar.HO()).l(hVar.HQ()).K(hVar.Iu() != null ? new JSONObject(hVar.Iu()) : null).aU(hVar.Id()).aS(hVar.Ia()).a(hVar.Ib()).bb(hVar.Iv()).dm(hVar.Iw()).Ie();
                if (x.Fk()) {
                    this.logger.f("PersistentPostbackManager", "Submitting postback: " + hVar);
                }
                this.sdk.Cr().dispatchPostbackRequest(iVarIF, new AppLovinPostbackListener() { // from class: com.applovin.impl.sdk.network.f.1
                    @Override // com.applovin.sdk.AppLovinPostbackListener
                    public void onPostbackSuccess(String str) {
                        f.this.d(hVar);
                        x unused = f.this.logger;
                        if (x.Fk()) {
                            f.this.logger.f("PersistentPostbackManager", "Successfully submit postback: " + hVar);
                        }
                        f.this.Iq();
                        m.a(appLovinPostbackListener, str);
                    }

                    @Override // com.applovin.sdk.AppLovinPostbackListener
                    public void onPostbackFailure(String str, int i) {
                        x unused = f.this.logger;
                        if (x.Fk()) {
                            f.this.logger.g("PersistentPostbackManager", "Failed to submit postback: " + hVar + " with error code: " + i + "; will retry later...");
                        }
                        f.this.e(hVar);
                        m.a(appLovinPostbackListener, str, i);
                        if (hVar.Ix() == 1) {
                            f.this.sdk.Cq().b(str, "dispatchPostback", i);
                        }
                    }
                });
            }
        }
    }

    private void c(h hVar) {
        synchronized (this.aFr) {
            while (this.aIb.size() > this.aHZ) {
                this.aIb.remove(0);
            }
            this.aIb.add(hVar);
        }
        if (x.Fk()) {
            this.logger.f("PersistentPostbackManager", "Enqueued postback: " + hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(h hVar) {
        synchronized (this.aFr) {
            this.aIc.remove(hVar);
            this.aIb.remove(hVar);
        }
        if (x.Fk()) {
            this.logger.f("PersistentPostbackManager", "Dequeued postback: " + hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(h hVar) {
        synchronized (this.aFr) {
            this.aIc.remove(hVar);
            this.aId.add(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iq() {
        synchronized (this.aFr) {
            Iterator<h> it = this.aId.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
            this.aId.clear();
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map<String, Object> map) {
        this.sdk.BM().a(this.aIa, q.b.POSTBACKS);
    }

    private void a(Runnable runnable, boolean z, boolean z2) {
        if (z) {
            this.sdk.BM().a(new ab(this.sdk, z2, "runPostbackTask", runnable), q.b.POSTBACKS);
        } else {
            runnable.run();
        }
    }
}
