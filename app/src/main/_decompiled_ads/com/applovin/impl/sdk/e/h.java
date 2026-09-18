package com.applovin.impl.sdk.e;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class h extends f {
    private final com.applovin.impl.b.a vastAd;

    public h(com.applovin.impl.b.a aVar, com.applovin.impl.sdk.n nVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheVastAd", aVar, nVar, appLovinAdLoadListener);
        this.vastAd = aVar;
    }

    @Override // com.applovin.impl.sdk.e.f, java.lang.Runnable
    public void run() {
        super.run();
        boolean zFD = this.vastAd.FD();
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f(this.tag, "Begin caching for VAST " + (zFD ? "streaming " : "") + "ad #" + this.aiL.getAdIdNumber() + "...");
        }
        if (zFD) {
            if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aLL)).booleanValue()) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(Kj());
                arrayList.addAll(Kw());
                K(arrayList);
                if (this.vastAd.LP()) {
                    Km();
                    ArrayList arrayList2 = new ArrayList();
                    a aVarKx = Kx();
                    if (aVarKx != null) {
                        arrayList2.add(aVarKx);
                    }
                    b bVarKz = Kz();
                    if (bVarKz != null) {
                        arrayList2.add(bVarKz);
                    }
                    c cVarKy = Ky();
                    if (cVarKy != null) {
                        arrayList2.add(cVarKy);
                    }
                    K(arrayList2);
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    if (this.vastAd.LO() == com.applovin.impl.b.a.b.COMPANION_AD) {
                        a aVarKx2 = Kx();
                        if (aVarKx2 != null) {
                            arrayList3.add(aVarKx2);
                        }
                        b bVarKz2 = Kz();
                        if (bVarKz2 != null) {
                            arrayList3.add(bVarKz2);
                        }
                        K(arrayList3);
                        Km();
                        c cVarKy2 = Ky();
                        if (cVarKy2 != null) {
                            arrayList4.add(cVarKy2);
                        }
                        K(arrayList4);
                    } else {
                        c cVarKy3 = Ky();
                        if (cVarKy3 != null) {
                            arrayList3.add(cVarKy3);
                        }
                        K(arrayList3);
                        Km();
                        a aVarKx3 = Kx();
                        if (aVarKx3 != null) {
                            arrayList4.add(aVarKx3);
                        }
                        b bVarKz3 = Kz();
                        if (bVarKz3 != null) {
                            arrayList4.add(bVarKz3);
                        }
                        K(arrayList4);
                    }
                }
            } else {
                Kk();
                Kv();
                if (this.vastAd.LP()) {
                    Km();
                }
                if (this.vastAd.LO() == com.applovin.impl.b.a.b.COMPANION_AD) {
                    Ks();
                    Ku();
                } else {
                    Kt();
                }
                if (!this.vastAd.LP()) {
                    Km();
                }
                if (this.vastAd.LO() == com.applovin.impl.b.a.b.COMPANION_AD) {
                    Kt();
                } else {
                    Ks();
                    Ku();
                }
            }
        } else if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aLL)).booleanValue()) {
            ArrayList arrayList5 = new ArrayList();
            arrayList5.addAll(Kw());
            arrayList5.addAll(Kj());
            a aVarKx4 = Kx();
            if (aVarKx4 != null) {
                arrayList5.add(aVarKx4);
            }
            c cVarKy4 = Ky();
            if (cVarKy4 != null) {
                arrayList5.add(cVarKy4);
            }
            b bVarKz4 = Kz();
            if (bVarKz4 != null) {
                arrayList5.add(bVarKz4);
            }
            K(arrayList5);
            Km();
        } else {
            Kk();
            Kv();
            Ks();
            Kt();
            Ku();
            Km();
        }
        com.applovin.impl.sdk.x xVar2 = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f(this.tag, "Finished caching VAST ad #" + this.vastAd.getAdIdNumber());
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.vastAd.getCreatedAtMillis();
        com.applovin.impl.sdk.d.d.a(this.vastAd, this.sdk);
        com.applovin.impl.sdk.d.d.a(jCurrentTimeMillis, this.vastAd, this.sdk);
        b(this.vastAd);
        this.vastAd.FF();
        Kg();
    }

    private void Ks() {
        if (Kh()) {
            return;
        }
        if (this.vastAd.Mb()) {
            com.applovin.impl.b.d dVarLV = this.vastAd.LV();
            if (dVarLV != null) {
                com.applovin.impl.b.i iVarMm = dVarLV.Mm();
                if (iVarMm != null) {
                    Uri uriMz = iVarMm.Mz();
                    String string = uriMz != null ? uriMz.toString() : "";
                    String strMA = iVarMm.MA();
                    if (URLUtil.isValidUrl(string) || StringUtils.isValidString(strMA)) {
                        if (iVarMm.My() == com.applovin.impl.b.i.a.STATIC) {
                            com.applovin.impl.sdk.x xVar = this.logger;
                            if (com.applovin.impl.sdk.x.Fk()) {
                                this.logger.f(this.tag, "Caching static companion ad at " + string + "...");
                            }
                            Uri uriB = b(string, Collections.emptyList(), false);
                            if (uriB != null) {
                                iVarMm.u(uriB);
                                this.vastAd.aN(true);
                                return;
                            } else {
                                com.applovin.impl.sdk.x xVar2 = this.logger;
                                if (com.applovin.impl.sdk.x.Fk()) {
                                    this.logger.i(this.tag, "Failed to cache static companion ad");
                                    return;
                                }
                                return;
                            }
                        }
                        if (iVarMm.My() == com.applovin.impl.b.i.a.HTML) {
                            if (StringUtils.isValidString(string)) {
                                com.applovin.impl.sdk.x xVar3 = this.logger;
                                if (com.applovin.impl.sdk.x.Fk()) {
                                    this.logger.f(this.tag, "Begin caching HTML companion ad. Fetching from " + string + "...");
                                }
                                String strDx = dx(string);
                                if (StringUtils.isValidString(strDx)) {
                                    com.applovin.impl.sdk.x xVar4 = this.logger;
                                    if (com.applovin.impl.sdk.x.Fk()) {
                                        this.logger.f(this.tag, "HTML fetched. Caching HTML now...");
                                    }
                                    iVarMm.dV(a(strDx, Collections.emptyList(), this.vastAd));
                                    this.vastAd.aN(true);
                                    return;
                                }
                                com.applovin.impl.sdk.x xVar5 = this.logger;
                                if (com.applovin.impl.sdk.x.Fk()) {
                                    this.logger.i(this.tag, "Unable to load companion ad resources from " + string);
                                    return;
                                }
                                return;
                            }
                            com.applovin.impl.sdk.x xVar6 = this.logger;
                            if (com.applovin.impl.sdk.x.Fk()) {
                                this.logger.f(this.tag, "Caching provided HTML for companion ad. No fetch required. HTML: " + strMA);
                            }
                            if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPE)).booleanValue()) {
                                strMA = dz(strMA);
                            }
                            iVarMm.dV(a(strMA, Collections.emptyList(), this.vastAd));
                            this.vastAd.aN(true);
                            return;
                        }
                        if (iVarMm.My() == com.applovin.impl.b.i.a.IFRAME) {
                            com.applovin.impl.sdk.x xVar7 = this.logger;
                            if (com.applovin.impl.sdk.x.Fk()) {
                                this.logger.f(this.tag, "Skip caching of iFrame resource...");
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    com.applovin.impl.sdk.x xVar8 = this.logger;
                    if (com.applovin.impl.sdk.x.Fk()) {
                        this.logger.h(this.tag, "Companion ad does not have any resources attached. Skipping...");
                        return;
                    }
                    return;
                }
                com.applovin.impl.sdk.x xVar9 = this.logger;
                if (com.applovin.impl.sdk.x.Fk()) {
                    this.logger.i(this.tag, "Failed to retrieve non-video resources from companion ad. Skipping...");
                    return;
                }
                return;
            }
            com.applovin.impl.sdk.x xVar10 = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f(this.tag, "No companion ad provided. Skipping...");
                return;
            }
            return;
        }
        com.applovin.impl.sdk.x xVar11 = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f(this.tag, "Companion ad caching disabled. Skipping...");
        }
    }

    private void Kt() {
        com.applovin.impl.b.o oVarLT;
        Uri uriFG;
        if (Kh()) {
            return;
        }
        if (this.vastAd.Mc()) {
            if (this.vastAd.LS() == null || (oVarLT = this.vastAd.LT()) == null || (uriFG = oVarLT.FG()) == null) {
                return;
            }
            Uri uriA = a(uriFG.toString(), Collections.emptyList(), false);
            if (uriA != null) {
                com.applovin.impl.sdk.x xVar = this.logger;
                if (com.applovin.impl.sdk.x.Fk()) {
                    this.logger.f(this.tag, "Video file successfully cached into: " + uriA);
                }
                oVarLT.j(uriA);
                return;
            }
            com.applovin.impl.sdk.x xVar2 = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.i(this.tag, "Failed to cache video file: " + oVarLT);
                return;
            }
            return;
        }
        com.applovin.impl.sdk.x xVar3 = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f(this.tag, "Video caching disabled. Skipping...");
        }
    }

    private void Ku() {
        String strLZ;
        if (Kh()) {
            return;
        }
        if (this.vastAd.Ma() != null) {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f(this.tag, "Begin caching HTML template. Fetching from " + this.vastAd.Ma() + "...");
            }
            strLZ = c(this.vastAd.Ma().toString(), this.vastAd.Gv());
        } else {
            strLZ = this.vastAd.LZ();
        }
        if (StringUtils.isValidString(strLZ)) {
            String strA = a(strLZ, this.vastAd.Gv(), this.aiL);
            if (this.vastAd.shouldInjectOpenMeasurementScriptDuringCaching() && this.vastAd.isOpenMeasurementEnabled()) {
                strA = this.sdk.Cn().dp(strA);
            }
            this.vastAd.dS(strA);
            com.applovin.impl.sdk.x xVar2 = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f(this.tag, "Finish caching HTML template " + this.vastAd.LZ() + " for ad #" + this.vastAd.getAdIdNumber());
                return;
            }
            return;
        }
        com.applovin.impl.sdk.x xVar3 = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f(this.tag, "Unable to load HTML template");
        }
    }

    private void Kv() {
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f(this.tag, "Caching play & pause images...");
        }
        Uri uriC = c(this.aiL.Hr(), "play");
        if (uriC != null) {
            this.aiL.l(uriC);
        }
        Uri uriC2 = c(this.aiL.Hs(), CampaignEx.JSON_NATIVE_VIDEO_PAUSE);
        if (uriC2 != null) {
            this.aiL.m(uriC2);
        }
        com.applovin.impl.sdk.x xVar2 = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f(this.tag, "Ad updated with playImageFilename = " + this.aiL.Hr() + ", pauseImageFilename = " + this.aiL.Hs());
        }
    }

    private String dz(String str) {
        String strReplace = str;
        for (String str2 : StringUtils.getRegexMatches(StringUtils.match(str, (String) this.sdk.a(com.applovin.impl.sdk.c.b.aPF)), 1)) {
            if (!TextUtils.isEmpty(str2)) {
                if (this.aiL.shouldCancelHtmlCachingIfShown() && this.aiL.hasShown()) {
                    com.applovin.impl.sdk.x xVar = this.logger;
                    if (com.applovin.impl.sdk.x.Fk()) {
                        this.logger.f(this.tag, "Cancelling HTML JavaScript caching due to ad being shown already");
                    }
                    this.aHe.JQ();
                    return str;
                }
                Uri uriB = b(str2, Collections.emptyList(), false);
                if (uriB != null) {
                    strReplace = strReplace.replace(str2, uriB.toString());
                    this.aiL.k(uriB);
                    this.aHe.JR();
                } else {
                    com.applovin.impl.sdk.x xVar2 = this.logger;
                    if (com.applovin.impl.sdk.x.Fk()) {
                        this.logger.i(this.tag, "Failed to cache JavaScript resource: " + str2);
                    }
                    this.aHe.JS();
                }
            }
        }
        return strReplace;
    }

    protected List<c> Kw() {
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f(this.tag, "Caching play & pause images...");
        }
        ArrayList arrayList = new ArrayList();
        if (this.aiL.Hr() != null) {
            arrayList.add(a(this.aiL.Hr().toString(), new c.a() { // from class: com.applovin.impl.sdk.e.h.1
                @Override // com.applovin.impl.sdk.e.c.a
                public void q(Uri uri) {
                    h.this.aiL.l(uri);
                    com.applovin.impl.sdk.x xVar2 = h.this.logger;
                    if (com.applovin.impl.sdk.x.Fk()) {
                        h.this.logger.f(h.this.tag, "Ad updated with playImageUri = " + uri);
                    }
                }
            }));
        }
        if (this.aiL.Hs() != null) {
            arrayList.add(a(this.aiL.Hs().toString(), new c.a() { // from class: com.applovin.impl.sdk.e.h.2
                @Override // com.applovin.impl.sdk.e.c.a
                public void q(Uri uri) {
                    h.this.aiL.m(uri);
                    com.applovin.impl.sdk.x xVar2 = h.this.logger;
                    if (com.applovin.impl.sdk.x.Fk()) {
                        h.this.logger.f(h.this.tag, "Ad updated with pauseImageUri = " + uri);
                    }
                }
            }));
        }
        return arrayList;
    }

    private a Kx() {
        if (!this.vastAd.Mb()) {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f(this.tag, "Companion ad caching disabled. Skipping...");
            }
            return null;
        }
        com.applovin.impl.b.d dVarLV = this.vastAd.LV();
        if (dVarLV == null) {
            com.applovin.impl.sdk.x xVar2 = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f(this.tag, "No companion ad provided. Skipping...");
            }
            return null;
        }
        final com.applovin.impl.b.i iVarMm = dVarLV.Mm();
        if (iVarMm == null) {
            com.applovin.impl.sdk.x xVar3 = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.i(this.tag, "Failed to retrieve non-video resources from companion ad. Skipping...");
            }
            return null;
        }
        Uri uriMz = iVarMm.Mz();
        String string = uriMz != null ? uriMz.toString() : "";
        String strMA = iVarMm.MA();
        if (URLUtil.isValidUrl(string) || StringUtils.isValidString(strMA)) {
            if (iVarMm.My() == com.applovin.impl.b.i.a.STATIC) {
                com.applovin.impl.sdk.x xVar4 = this.logger;
                if (com.applovin.impl.sdk.x.Fk()) {
                    this.logger.f(this.tag, "Caching static companion ad at " + string + "...");
                }
                return new c(string, this.vastAd, Collections.emptyList(), false, this.aHe, this.sdk, new c.a() { // from class: com.applovin.impl.sdk.e.h.3
                    @Override // com.applovin.impl.sdk.e.c.a
                    public void q(Uri uri) {
                        if (uri != null) {
                            iVarMm.u(uri);
                            h.this.vastAd.aN(true);
                        } else {
                            com.applovin.impl.sdk.x xVar5 = h.this.logger;
                            if (com.applovin.impl.sdk.x.Fk()) {
                                h.this.logger.i(h.this.tag, "Failed to cache static companion ad");
                            }
                        }
                    }
                });
            }
            if (iVarMm.My() == com.applovin.impl.b.i.a.HTML) {
                if (StringUtils.isValidString(string)) {
                    com.applovin.impl.sdk.x xVar5 = this.logger;
                    if (com.applovin.impl.sdk.x.Fk()) {
                        this.logger.f(this.tag, "Begin caching HTML companion ad. Fetching from " + string + "...");
                    }
                    String strDx = dx(string);
                    if (StringUtils.isValidString(strDx)) {
                        com.applovin.impl.sdk.x xVar6 = this.logger;
                        if (com.applovin.impl.sdk.x.Fk()) {
                            this.logger.f(this.tag, "HTML fetched. Caching HTML now...");
                        }
                        return a(strDx, Collections.emptyList(), new f.a() { // from class: com.applovin.impl.sdk.e.h.4
                            @Override // com.applovin.impl.sdk.e.f.a
                            public void dy(String str) {
                                iVarMm.dV(str);
                                h.this.vastAd.aN(true);
                            }
                        });
                    }
                    com.applovin.impl.sdk.x xVar7 = this.logger;
                    if (com.applovin.impl.sdk.x.Fk()) {
                        this.logger.i(this.tag, "Unable to load companion ad resources from " + string);
                    }
                } else {
                    com.applovin.impl.sdk.x xVar8 = this.logger;
                    if (com.applovin.impl.sdk.x.Fk()) {
                        this.logger.f(this.tag, "Caching provided HTML for companion ad. No fetch required. HTML: " + strMA);
                    }
                    return a(strMA, Collections.emptyList(), new f.a() { // from class: com.applovin.impl.sdk.e.h.5
                        @Override // com.applovin.impl.sdk.e.f.a
                        public void dy(String str) {
                            iVarMm.dV(str);
                            h.this.vastAd.aN(true);
                        }
                    });
                }
            } else if (iVarMm.My() == com.applovin.impl.b.i.a.IFRAME) {
                com.applovin.impl.sdk.x xVar9 = this.logger;
                if (com.applovin.impl.sdk.x.Fk()) {
                    this.logger.f(this.tag, "Skip caching of iFrame resource...");
                }
            }
        } else {
            com.applovin.impl.sdk.x xVar10 = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.h(this.tag, "Companion ad does not have any resources attached. Skipping...");
            }
        }
        return null;
    }

    protected c Ky() {
        final com.applovin.impl.b.o oVarLT;
        Uri uriFG;
        if (!this.vastAd.Mc()) {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f(this.tag, "Video caching disabled. Skipping...");
            }
            return null;
        }
        if (this.vastAd.LS() == null || (oVarLT = this.vastAd.LT()) == null || (uriFG = oVarLT.FG()) == null) {
            return null;
        }
        com.applovin.impl.sdk.x xVar2 = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f(this.tag, "Caching video file " + oVarLT + " creative...");
        }
        return a(uriFG.toString(), Collections.emptyList(), false, new c.a() { // from class: com.applovin.impl.sdk.e.h.6
            @Override // com.applovin.impl.sdk.e.c.a
            public void q(Uri uri) {
                if (uri != null) {
                    com.applovin.impl.sdk.x xVar3 = h.this.logger;
                    if (com.applovin.impl.sdk.x.Fk()) {
                        h.this.logger.f(h.this.tag, "Video file successfully cached into: " + uri);
                    }
                    oVarLT.j(uri);
                    return;
                }
                com.applovin.impl.sdk.x xVar4 = h.this.logger;
                if (com.applovin.impl.sdk.x.Fk()) {
                    h.this.logger.i(h.this.tag, "Failed to cache video file: " + oVarLT);
                }
            }
        });
    }

    protected b Kz() {
        if (TextUtils.isEmpty(this.vastAd.LZ())) {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (!com.applovin.impl.sdk.x.Fk()) {
                return null;
            }
            this.logger.f(this.tag, "Unable to load HTML template");
            return null;
        }
        return a(this.vastAd.LZ(), this.vastAd.Gv(), new f.a() { // from class: com.applovin.impl.sdk.e.h.7
            @Override // com.applovin.impl.sdk.e.f.a
            public void dy(String str) {
                if (h.this.vastAd.shouldInjectOpenMeasurementScriptDuringCaching() && h.this.vastAd.isOpenMeasurementEnabled()) {
                    str = h.this.sdk.Cn().dp(str);
                }
                h.this.vastAd.dS(str);
                com.applovin.impl.sdk.x xVar2 = h.this.logger;
                if (com.applovin.impl.sdk.x.Fk()) {
                    h.this.logger.f(h.this.tag, "Finish caching HTML template " + h.this.vastAd.LZ() + " for ad #" + h.this.vastAd.getAdIdNumber());
                }
            }
        });
    }

    @Override // com.applovin.impl.sdk.e.f
    void Km() {
        this.vastAd.getAdEventTracker().II();
        super.Km();
    }

    @Override // com.applovin.impl.sdk.e.f
    void Kl() {
        this.vastAd.getAdEventTracker().IK();
        super.Kl();
    }
}
