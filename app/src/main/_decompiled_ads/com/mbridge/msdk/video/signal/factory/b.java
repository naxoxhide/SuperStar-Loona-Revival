package com.mbridge.msdk.video.signal.factory;

import android.app.Activity;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.signal.a.h;
import com.mbridge.msdk.video.signal.a.j;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.video.signal.a.l;
import com.mbridge.msdk.video.signal.a.m;
import com.mbridge.msdk.video.signal.a.n;
import com.mbridge.msdk.video.signal.c;
import com.mbridge.msdk.video.signal.e;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.i;
import java.util.List;

/* JADX INFO: compiled from: JSFactory.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends a {
    private Activity h;
    private WebView i;
    private MBridgeVideoView j;
    private MBridgeContainerView k;
    private CampaignEx l;
    private MBridgeBTContainer m;
    private c.a n;
    private String o;
    private List<CampaignEx> p;

    public b(Activity activity) {
        this.h = activity;
    }

    public b(Activity activity, MBridgeBTContainer mBridgeBTContainer, WebView webView) {
        this.h = activity;
        this.m = mBridgeBTContainer;
        this.i = webView;
    }

    public b(Activity activity, WebView webView, MBridgeVideoView mBridgeVideoView, MBridgeContainerView mBridgeContainerView, CampaignEx campaignEx, c.a aVar) {
        this.h = activity;
        this.i = webView;
        this.j = mBridgeVideoView;
        this.k = mBridgeContainerView;
        this.l = campaignEx;
        this.n = aVar;
        this.o = mBridgeVideoView.getUnitId();
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public final com.mbridge.msdk.video.signal.a getActivityProxy() {
        if (this.i == null) {
            return super.getActivityProxy();
        }
        if (this.a == null) {
            this.a = new h(this.i);
        }
        return this.a;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public final f getJSNotifyProxy() {
        if (this.i == null) {
            return super.getJSNotifyProxy();
        }
        if (this.d == null) {
            this.d = new l(this.i);
        }
        return this.d;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public final c getJSCommon() {
        if (this.h == null || this.l == null) {
            return super.getJSCommon();
        }
        if (this.f2648b == null) {
            this.f2648b = new j(this.h, this.l);
        }
        if (this.l.getDynamicTempCode() == 5 && this.p != null && (this.f2648b instanceof j)) {
            ((j) this.f2648b).a(this.p);
        }
        this.f2648b.a(this.h);
        this.f2648b.a(this.o);
        this.f2648b.a(this.n);
        return this.f2648b;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public final i getJSVideoModule() {
        if (this.j == null) {
            return super.getJSVideoModule();
        }
        if (this.c == null) {
            this.c = new n(this.j);
        }
        return this.c;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public final e getJSContainerModule() {
        if (this.k == null) {
            return super.getJSContainerModule();
        }
        if (this.e == null) {
            this.e = new k(this.k);
        }
        return this.e;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public final com.mbridge.msdk.video.signal.h getIJSRewardVideoV1() {
        if (this.k == null || this.h == null) {
            return super.getIJSRewardVideoV1();
        }
        if (this.f == null) {
            this.f = new m(this.h, this.k);
        }
        return this.f;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public final com.mbridge.msdk.video.signal.b getJSBTModule() {
        if (this.h == null || this.m == null) {
            return super.getJSBTModule();
        }
        if (this.g == null) {
            this.g = new com.mbridge.msdk.video.signal.a.i(this.h, this.m);
        }
        return this.g;
    }

    public final void a(j jVar) {
        this.f2648b = jVar;
    }

    public final void a(List<CampaignEx> list) {
        this.p = list;
    }
}
