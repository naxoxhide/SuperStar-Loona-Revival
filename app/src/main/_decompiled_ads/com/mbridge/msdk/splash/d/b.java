package com.mbridge.msdk.splash.d;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.e;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.out.MBSplashLoadListener;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.ArrayList;

/* JADX INFO: compiled from: SplashLoadListenerImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private MBSplashLoadListener a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f2440b;
    private String c;
    private String d;
    private MBridgeIds e;

    public b(c cVar, MBridgeIds mBridgeIds) {
        this.f2440b = cVar;
        this.e = mBridgeIds;
        if (mBridgeIds != null) {
            this.c = mBridgeIds.getUnitId();
        }
    }

    public final void a(MBSplashLoadListener mBSplashLoadListener) {
        this.a = mBSplashLoadListener;
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void a(CampaignEx campaignEx, int i) {
        c cVar;
        c cVar2 = this.f2440b;
        if (cVar2 == null || !cVar2.a() || campaignEx == null) {
            return;
        }
        MBSplashLoadListener mBSplashLoadListener = this.a;
        if (mBSplashLoadListener != null) {
            mBSplashLoadListener.onLoadSuccessed(this.e, i);
            this.a.isSupportZoomOut(this.e, campaignEx.getFlb() == 1);
        }
        this.f2440b.a(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        q.a(com.mbridge.msdk.foundation.controller.b.d().g(), arrayList, this.c, campaignEx.isBidCampaign());
        if (i != 2 || (cVar = this.f2440b) == null) {
            return;
        }
        cVar.a(campaignEx, 0, true);
    }

    public final void a(e eVar, int i, CampaignEx campaignEx) {
        c cVar = this.f2440b;
        if (cVar == null || !cVar.a()) {
            return;
        }
        MBSplashLoadListener mBSplashLoadListener = this.a;
        if (mBSplashLoadListener != null) {
            mBSplashLoadListener.onLoadFailed(this.e, eVar != null ? eVar.d() : "", i);
        }
        this.f2440b.a(false);
        q.a(com.mbridge.msdk.foundation.controller.b.d().g(), eVar, this.c, !TextUtils.isEmpty(this.d), campaignEx);
    }

    public final void a(String str, int i) {
        c cVar = this.f2440b;
        if (cVar == null || !cVar.a()) {
            return;
        }
        MBSplashLoadListener mBSplashLoadListener = this.a;
        if (mBSplashLoadListener != null) {
            mBSplashLoadListener.onLoadFailed(this.e, str, i);
        }
        this.f2440b.a(false);
        q.a(com.mbridge.msdk.foundation.controller.b.d().g(), new e(1, str), this.c, true ^ TextUtils.isEmpty(this.d), (CampaignEx) null);
    }
}
