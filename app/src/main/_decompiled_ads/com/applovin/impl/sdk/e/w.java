package com.applovin.impl.sdk.e;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class w<T> extends d implements com.applovin.impl.sdk.network.b.d<T> {
    private final com.applovin.impl.sdk.network.c<T> aHh;
    protected com.applovin.impl.sdk.network.b.a aHr;
    private q.b aUT;
    private com.applovin.impl.sdk.c.b<String> aUU;
    private com.applovin.impl.sdk.c.b<String> aUV;
    private final com.applovin.impl.sdk.network.b.d<T> apP;

    public abstract void a(int i, String str, T t);

    public abstract void d(T t, int i);

    public w(com.applovin.impl.sdk.network.c<T> cVar, com.applovin.impl.sdk.n nVar) {
        this(cVar, nVar, false);
    }

    public w(com.applovin.impl.sdk.network.c<T> cVar, final com.applovin.impl.sdk.n nVar, boolean z) {
        super("TaskRepeatRequest", nVar, z);
        this.aUT = q.b.BACKGROUND;
        this.aUU = null;
        this.aUV = null;
        if (cVar == null) {
            throw new IllegalArgumentException("No request specified");
        }
        du(cVar.zJ());
        this.aHh = cVar;
        this.aHr = new com.applovin.impl.sdk.network.b.a();
        this.apP = new com.applovin.impl.sdk.network.b.d<T>() { // from class: com.applovin.impl.sdk.e.w.1
            @Override // com.applovin.impl.sdk.network.b.d
            public void d(T t, int i) {
                w.this.aHh.gB(0);
                w.this.d(t, i);
            }

            @Override // com.applovin.impl.sdk.network.b.d
            public void a(int i, String str, T t) {
                long millis;
                boolean z2 = false;
                boolean z3 = i < 200 || i >= 500;
                boolean z4 = i == 429;
                if (((i != -1009) || w.this.aHh.HZ()) && (z3 || z4 || w.this.aHh.HY())) {
                    String strHR = w.this.aHh.HR();
                    if (w.this.aHh.HT() <= 0) {
                        if (strHR != null && strHR.equals(w.this.aHh.zJ())) {
                            w wVar = w.this;
                            wVar.g(wVar.aUV);
                        } else {
                            w wVar2 = w.this;
                            wVar2.g(wVar2.aUU);
                        }
                        w.this.a(i, str, t);
                        return;
                    }
                    com.applovin.impl.sdk.x xVar = w.this.logger;
                    if (com.applovin.impl.sdk.x.Fk()) {
                        w.this.logger.h(w.this.tag, "Unable to send request due to server failure (code " + i + "). " + w.this.aHh.HT() + " attempts left, retrying in " + TimeUnit.MILLISECONDS.toSeconds(w.this.aHh.HW()) + " seconds...");
                    }
                    int iHT = w.this.aHh.HT() - 1;
                    w.this.aHh.gB(iHT);
                    if ((((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aKE)).booleanValue() && w.this.aHh.zJ().endsWith("4.0/ad")) || iHT == 0) {
                        w wVar3 = w.this;
                        wVar3.g(wVar3.aUU);
                        if (StringUtils.isValidString(strHR) && strHR.length() >= 4) {
                            com.applovin.impl.sdk.x xVar2 = w.this.logger;
                            if (com.applovin.impl.sdk.x.Fk()) {
                                w.this.logger.g(w.this.tag, "Switching to backup endpoint " + strHR);
                            }
                            w.this.aHh.cY(strHR);
                            z2 = true;
                        }
                    }
                    if (((Boolean) nVar.a(com.applovin.impl.sdk.c.b.aNU)).booleanValue() && z2) {
                        millis = 0;
                    } else {
                        millis = w.this.aHh.HX() ? TimeUnit.SECONDS.toMillis((long) Math.pow(2.0d, w.this.aHh.HU())) : w.this.aHh.HW();
                    }
                    q qVarBM = nVar.BM();
                    w wVar4 = w.this;
                    qVarBM.a(wVar4, wVar4.aUT, millis);
                    return;
                }
                w.this.a(i, str, t);
            }
        };
    }

    @Override // java.lang.Runnable
    public void run() {
        com.applovin.impl.sdk.network.b bVarBO = getSdk().BO();
        if (getSdk().Bn() || getSdk().isEnabled()) {
            if (StringUtils.isValidString(this.aHh.zJ()) && this.aHh.zJ().length() >= 4) {
                if (TextUtils.isEmpty(this.aHh.HO())) {
                    this.aHh.cZ(this.aHh.vR() != null ? "POST" : "GET");
                }
                bVarBO.a(this.aHh, this.aHr, this.apP);
                return;
            } else {
                com.applovin.impl.sdk.x xVar = this.logger;
                if (com.applovin.impl.sdk.x.Fk()) {
                    this.logger.i(this.tag, "Task has an invalid or null request endpoint.");
                }
                a(AppLovinErrorCodes.INVALID_URL, null, null);
                return;
            }
        }
        com.applovin.impl.sdk.x.H("AppLovinSdk", "AppLovin SDK is disabled");
        a(-22, null, null);
    }

    public void a(q.b bVar) {
        this.aUT = bVar;
    }

    public void e(com.applovin.impl.sdk.c.b<String> bVar) {
        this.aUU = bVar;
    }

    public void f(com.applovin.impl.sdk.c.b<String> bVar) {
        this.aUV = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <ST> void g(com.applovin.impl.sdk.c.b<ST> bVar) {
        if (bVar != null) {
            getSdk().BN().a((com.applovin.impl.sdk.c.b<?>) bVar, (Object) bVar.JB());
        }
    }
}
