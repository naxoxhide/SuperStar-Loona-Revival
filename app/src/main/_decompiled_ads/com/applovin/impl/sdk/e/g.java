package com.applovin.impl.sdk.e;

import android.net.Uri;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class g extends f {
    private final com.applovin.impl.sdk.ad.a aTM;
    private boolean aTN;
    private boolean aTO;

    public g(com.applovin.impl.sdk.ad.a aVar, com.applovin.impl.sdk.n nVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheAppLovinAd", aVar, nVar, appLovinAdLoadListener);
        this.aTM = aVar;
    }

    public void bg(boolean z) {
        this.aTN = z;
    }

    public void bh(boolean z) {
        this.aTO = z;
    }

    @Override // com.applovin.impl.sdk.e.f, java.lang.Runnable
    public void run() {
        super.run();
        boolean zFD = this.aTM.FD();
        boolean z = this.aTO;
        if (zFD || z) {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f(this.tag, "Begin caching for streaming ad #" + this.aTM.getAdIdNumber() + "...");
            }
            if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aLL)).booleanValue()) {
                K(Kj());
                ArrayList arrayList = new ArrayList();
                if (zFD) {
                    if (this.aTN) {
                        Km();
                        b bVarKr = Kr();
                        if (bVarKr != null) {
                            arrayList.add(bVarKr);
                        }
                        c cVarKq = Kq();
                        if (cVarKq != null) {
                            arrayList.add(cVarKq);
                        }
                    } else {
                        b bVarKr2 = Kr();
                        if (bVarKr2 != null) {
                            K(Arrays.asList(bVarKr2));
                        }
                        Km();
                        c cVarKq2 = Kq();
                        if (cVarKq2 != null) {
                            arrayList.add(cVarKq2);
                        }
                    }
                } else {
                    Km();
                    b bVarKr3 = Kr();
                    if (bVarKr3 != null) {
                        arrayList.add(bVarKr3);
                    }
                }
                K(arrayList);
                Km();
            } else {
                Kk();
                if (zFD) {
                    if (this.aTN) {
                        Km();
                    }
                    Ko();
                    if (!this.aTN) {
                        Km();
                    }
                    Kp();
                } else {
                    Km();
                    Ko();
                }
            }
        } else {
            com.applovin.impl.sdk.x xVar2 = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f(this.tag, "Begin processing for non-streaming ad #" + this.aTM.getAdIdNumber() + "...");
            }
            if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aLL)).booleanValue()) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(Kj());
                b bVarKr4 = Kr();
                if (bVarKr4 != null) {
                    arrayList2.add(bVarKr4);
                }
                c cVarKq3 = Kq();
                if (cVarKq3 != null) {
                    arrayList2.add(cVarKq3);
                }
                K(arrayList2);
                Km();
            } else {
                Kk();
                Ko();
                Kp();
                Km();
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.aTM.getCreatedAtMillis();
        com.applovin.impl.sdk.d.d.a(this.aTM, this.sdk);
        com.applovin.impl.sdk.d.d.a(jCurrentTimeMillis, this.aTM, this.sdk);
        b(this.aTM);
        Kg();
    }

    private void Ko() {
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f(this.tag, "Caching HTML resources...");
        }
        String strA = a(this.aTM.Fz(), this.aTM.Gv(), this.aTM);
        if (this.aTM.shouldInjectOpenMeasurementScriptDuringCaching() && this.aTM.isOpenMeasurementEnabled()) {
            strA = this.sdk.Cn().dp(strA);
        }
        this.aTM.cT(strA);
        this.aTM.aN(true);
        com.applovin.impl.sdk.x xVar2 = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f(this.tag, "Finish caching non-video resources for ad #" + this.aTM.getAdIdNumber());
        }
        this.logger.C(this.tag, "Ad updated with cachedHTML = " + this.aTM.Fz());
    }

    private void Kp() {
        Uri uriDv;
        if (Kh() || (uriDv = dv(this.aTM.FH())) == null) {
            return;
        }
        if (this.aTM.Hx()) {
            this.aTM.cT(this.aTM.Fz().replaceFirst(this.aTM.FC(), uriDv.toString()));
            com.applovin.impl.sdk.x xVar = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f(this.tag, "Replaced video URL with cached video URI in HTML for web video ad");
            }
        }
        this.aTM.FF();
        this.aTM.j(uriDv);
    }

    private c Kq() {
        return b(this.aTM.FH(), new c.a() { // from class: com.applovin.impl.sdk.e.g.1
            @Override // com.applovin.impl.sdk.e.c.a
            public void q(Uri uri) {
                if (uri != null) {
                    if (g.this.aTM.Hx()) {
                        g.this.aTM.cT(g.this.aTM.Fz().replaceFirst(g.this.aTM.FC(), uri.toString()));
                        com.applovin.impl.sdk.x xVar = g.this.logger;
                        if (com.applovin.impl.sdk.x.Fk()) {
                            g.this.logger.f(g.this.tag, "Replaced video URL with cached video URI in HTML for web video ad");
                        }
                    }
                    g.this.aTM.FF();
                    g.this.aTM.j(uri);
                }
            }
        });
    }

    private b Kr() {
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f(this.tag, "Caching HTML resources...");
        }
        return a(this.aTM.Fz(), this.aTM.Gv(), new f.a() { // from class: com.applovin.impl.sdk.e.g.2
            @Override // com.applovin.impl.sdk.e.f.a
            public void dy(String str) {
                if (g.this.aTM.shouldInjectOpenMeasurementScriptDuringCaching() && g.this.aTM.isOpenMeasurementEnabled()) {
                    str = g.this.sdk.Cn().dp(str);
                }
                g.this.aTM.cT(str);
                g.this.aTM.aN(true);
                com.applovin.impl.sdk.x xVar2 = g.this.logger;
                if (com.applovin.impl.sdk.x.Fk()) {
                    g.this.logger.f(g.this.tag, "Finish caching non-video resources for ad #" + g.this.aTM.getAdIdNumber());
                }
                g.this.logger.C(g.this.tag, "Ad updated with cachedHTML = " + g.this.aTM.Fz());
            }
        });
    }
}
