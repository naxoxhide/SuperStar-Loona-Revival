package com.applovin.impl.sdk.a;

import android.text.TextUtils;
import android.webkit.WebView;
import com.applovin.impl.b.h;
import com.applovin.impl.b.m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.x;
import com.iab.omid.library.applovin.adsession.AdSession;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.CreativeType;
import com.iab.omid.library.applovin.adsession.ImpressionType;
import com.iab.omid.library.applovin.adsession.Owner;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import com.iab.omid.library.applovin.adsession.media.InteractionType;
import com.iab.omid.library.applovin.adsession.media.MediaEvents;
import com.iab.omid.library.applovin.adsession.media.Position;
import com.iab.omid.library.applovin.adsession.media.VastProperties;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class g extends b {
    static final /* synthetic */ boolean aII = true;
    private final AtomicBoolean aIB;
    private MediaEvents aIC;
    private final VastProperties aID;
    private final AtomicBoolean aIE;
    private final AtomicBoolean aIF;
    private final AtomicBoolean aIG;
    private final AtomicBoolean aIH;
    private final com.applovin.impl.b.a ajq;

    public g(com.applovin.impl.b.a aVar) {
        super(aVar);
        this.aIB = new AtomicBoolean();
        this.aIE = new AtomicBoolean();
        this.aIF = new AtomicBoolean();
        this.aIG = new AtomicBoolean();
        this.aIH = new AtomicBoolean();
        this.ajq = aVar;
        float fLN = aVar.LN();
        if (aVar.LN() == -1) {
            this.aID = VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE);
        } else {
            this.aID = VastProperties.createVastPropertiesForSkippableMedia(fLN, true, Position.STANDALONE);
        }
    }

    @Override // com.applovin.impl.sdk.a.b
    protected AdSessionContext j(WebView webView) {
        VerificationScriptResource verificationScriptResourceCreateVerificationScriptResourceWithoutParameters;
        if (!aII && this.ajq.Md() == null) {
            throw new AssertionError();
        }
        ArrayList arrayList = new ArrayList();
        for (com.applovin.impl.b.b bVar : this.ajq.Md().Mk()) {
            List<h> listMi = bVar.Mi();
            if (listMi.isEmpty()) {
                m.a(bVar.Mj(), com.applovin.impl.b.f.FAILED_TO_LOAD_RESOURCE, this.sdk);
            } else {
                ArrayList arrayList2 = new ArrayList();
                for (h hVar : listMi) {
                    if (CampaignEx.KEY_OMID.equalsIgnoreCase(hVar.Mw())) {
                        arrayList2.add(hVar);
                    }
                }
                if (arrayList2.isEmpty()) {
                    m.a(bVar.Mj(), com.applovin.impl.b.f.API_FRAMEWORK_OR_LANGUAGE_TYPE_NOT_SUPPORTED, this.sdk);
                } else {
                    ArrayList<URL> arrayList3 = new ArrayList();
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        try {
                            arrayList3.add(new URL(((h) it.next()).Mx()));
                        } catch (Throwable th) {
                            x xVar = this.logger;
                            if (x.Fk()) {
                                this.logger.c(this.tag, "Failed to parse JavaScript resource url", th);
                            }
                        }
                    }
                    if (arrayList3.isEmpty()) {
                        m.a(bVar.Mj(), com.applovin.impl.b.f.FAILED_TO_LOAD_RESOURCE, this.sdk);
                    } else {
                        String verificationParameters = bVar.getVerificationParameters();
                        String strMh = bVar.Mh();
                        if (StringUtils.isValidString(verificationParameters) && !StringUtils.isValidString(strMh)) {
                            m.a(bVar.Mj(), com.applovin.impl.b.f.FAILED_TO_LOAD_RESOURCE, this.sdk);
                        } else {
                            for (URL url : arrayList3) {
                                if (StringUtils.isValidString(verificationParameters)) {
                                    verificationScriptResourceCreateVerificationScriptResourceWithoutParameters = VerificationScriptResource.createVerificationScriptResourceWithParameters(strMh, url, verificationParameters);
                                } else {
                                    verificationScriptResourceCreateVerificationScriptResourceWithoutParameters = VerificationScriptResource.createVerificationScriptResourceWithoutParameters(url);
                                }
                                arrayList.add(verificationScriptResourceCreateVerificationScriptResourceWithoutParameters);
                            }
                        }
                    }
                }
            }
        }
        String strIR = this.sdk.Cn().IR();
        if (TextUtils.isEmpty(strIR)) {
            x xVar2 = this.logger;
            if (x.Fk()) {
                this.logger.i(this.tag, "JavaScript SDK content not loaded successfully");
            }
            return null;
        }
        try {
            return AdSessionContext.createNativeAdSessionContext(this.sdk.Cn().getPartner(), strIR, arrayList, this.ajq.getOpenMeasurementContentUrl(), this.ajq.getOpenMeasurementCustomReferenceData());
        } catch (Throwable th2) {
            x xVar3 = this.logger;
            if (!x.Fk()) {
                return null;
            }
            this.logger.c(this.tag, "Failed to create ad session context", th2);
            return null;
        }
    }

    @Override // com.applovin.impl.sdk.a.b
    protected AdSessionConfiguration IG() {
        try {
            return AdSessionConfiguration.createAdSessionConfiguration(CreativeType.VIDEO, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NATIVE, false);
        } catch (Throwable th) {
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.c(this.tag, "Failed to create ad session configuration", th);
            }
            return null;
        }
    }

    @Override // com.applovin.impl.sdk.a.b
    protected void a(AdSession adSession) {
        try {
            this.aIC = MediaEvents.createMediaEvents(adSession);
        } catch (Throwable th) {
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.c(this.tag, "Failed to create media events", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jp() {
        this.aIx.loaded(this.aID);
    }

    @Override // com.applovin.impl.sdk.a.b
    public void II() {
        b("track loaded", new Runnable() { // from class: com.applovin.impl.sdk.a.-$$Lambda$g$JUl8ZRi1C4lLoUwgw-qwX91_gOc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.Jp();
            }
        });
    }

    public void b(final float f, final boolean z) {
        if (this.aIE.compareAndSet(false, true)) {
            b("track started", new Runnable() { // from class: com.applovin.impl.sdk.a.-$$Lambda$g$qEzxMq2UR02qf5ZtVOjcydEvdgY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.c(f, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(float f, boolean z) {
        this.aIC.start(f, z ? 0.0f : 1.0f);
    }

    public void IV() {
        if (this.aIF.compareAndSet(false, true)) {
            b("track first quartile", new Runnable() { // from class: com.applovin.impl.sdk.a.-$$Lambda$g$9Yg9lkkIpsPEustagM6UYg6wbrs
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.Jo();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jo() {
        this.aIC.firstQuartile();
    }

    public void IW() {
        if (this.aIG.compareAndSet(false, true)) {
            b("track midpoint", new Runnable() { // from class: com.applovin.impl.sdk.a.-$$Lambda$g$8o6uJj5ZbB1jgO2-XB5Sy_GrA28
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.Jn();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jn() {
        this.aIC.midpoint();
    }

    public void IX() {
        if (this.aIH.compareAndSet(false, true)) {
            b("track third quartile", new Runnable() { // from class: com.applovin.impl.sdk.a.-$$Lambda$g$7Nmt38VcX6MaJ86ngYyUwZ9X6aA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.Jm();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jm() {
        this.aIC.thirdQuartile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jl() {
        this.aIC.complete();
    }

    public void IY() {
        b("track completed", new Runnable() { // from class: com.applovin.impl.sdk.a.-$$Lambda$g$UaMFIO6ldDuEFX71efQiHkoXcMk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.Jl();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jk() {
        this.aIC.pause();
    }

    public void IZ() {
        b("track paused", new Runnable() { // from class: com.applovin.impl.sdk.a.-$$Lambda$g$PiKdREtCorfsEH5sVoFxXwCnqcI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.Jk();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jj() {
        this.aIC.resume();
    }

    public void Ja() {
        b("track resumed", new Runnable() { // from class: com.applovin.impl.sdk.a.-$$Lambda$g$O-DNY7vAcuZg810IVYJ9HqghTBw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.Jj();
            }
        });
    }

    public void Jb() {
        if (this.aIB.compareAndSet(false, true)) {
            b("buffer started", new Runnable() { // from class: com.applovin.impl.sdk.a.-$$Lambda$g$JOZJaLIiQUAwcEzDRRmxWpBIw0A
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.Ji();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ji() {
        this.aIC.bufferStart();
    }

    public void Jc() {
        if (this.aIB.compareAndSet(true, false)) {
            b("buffer finished", new Runnable() { // from class: com.applovin.impl.sdk.a.-$$Lambda$g$JpvKR2uTvl6iBaSlx1lmZtjrUJQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.Jh();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jh() {
        this.aIC.bufferFinish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void bd(boolean z) {
        this.aIC.volumeChange(z ? 0.0f : 1.0f);
    }

    public void bc(final boolean z) {
        b("track volume changed", new Runnable() { // from class: com.applovin.impl.sdk.a.-$$Lambda$g$zSeHc2TMXjggHNos9FXkfk7ifZQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.bd(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jg() {
        this.aIC.skipped();
    }

    public void Jd() {
        b("track skipped", new Runnable() { // from class: com.applovin.impl.sdk.a.-$$Lambda$g$mdPrPuzxd99_2EEtuHhaYuQ42Zc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.Jg();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jf() {
        this.aIC.adUserInteraction(InteractionType.CLICK);
    }

    public void Je() {
        b("track clicked", new Runnable() { // from class: com.applovin.impl.sdk.a.-$$Lambda$g$U57nxyB7KqdFZxd7tA6NW27JhVg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.Jf();
            }
        });
    }
}
