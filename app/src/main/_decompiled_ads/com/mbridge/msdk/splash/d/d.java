package com.mbridge.msdk.splash.d;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.out.MBSplashShowListener;
import com.mbridge.msdk.out.MBridgeIds;

/* JADX INFO: compiled from: SplashShowListenerImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d {
    private MBSplashShowListener a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CampaignEx f2445b;
    private c c;

    public d(c cVar, MBSplashShowListener mBSplashShowListener, CampaignEx campaignEx) {
        this.c = cVar;
        this.a = mBSplashShowListener;
        this.f2445b = campaignEx;
    }

    public final void a(MBridgeIds mBridgeIds) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.a = true;
        }
        q.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.f2445b, mBridgeIds.getUnitId(), new StringBuffer().append("load_to=").append(this.c.b()).append("&").append("allow_skip=").append(this.c.c() ? 1 : 0).append("&").append("countdown=").append(this.c.d()).append("&").toString());
        MBSplashShowListener mBSplashShowListener = this.a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onShowSuccessed(mBridgeIds);
        }
    }

    public final void a(MBridgeIds mBridgeIds, String str) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.a = false;
        }
        q.b(com.mbridge.msdk.foundation.controller.b.d().g(), this.f2445b, mBridgeIds.getUnitId(), str);
        MBSplashShowListener mBSplashShowListener = this.a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onShowFailed(mBridgeIds, str);
        }
    }

    public final void b(MBridgeIds mBridgeIds) {
        MBSplashShowListener mBSplashShowListener = this.a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onAdClicked(mBridgeIds);
        }
    }

    public final void a(MBridgeIds mBridgeIds, int i) {
        MBSplashShowListener mBSplashShowListener = this.a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onDismiss(mBridgeIds, i);
        }
        c cVar = this.c;
        if (cVar != null) {
            cVar.a = false;
        }
        if (i == 6 || i == 4 || i == 5) {
            CampaignEx campaignEx = this.f2445b;
            String unitId = mBridgeIds.getUnitId();
            com.mbridge.msdk.splash.a.b bVarA = null;
            if (campaignEx != null) {
                try {
                    bVarA = com.mbridge.msdk.splash.a.b.a().b(unitId).d(campaignEx.getRequestId()).g(campaignEx.getRequestIdNotice()).c(campaignEx.getId()).e(campaignEx.getCreativeId() + "").a(campaignEx.isBidCampaign());
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            com.mbridge.msdk.splash.e.a.a(bVarA, unitId, i);
        }
    }

    public final void a(MBridgeIds mBridgeIds, long j) {
        MBSplashShowListener mBSplashShowListener = this.a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onAdTick(mBridgeIds, j);
        }
    }

    public final void a(MBridgeIds mBridgeIds, int i, int i2, int i3) {
        MBSplashShowListener mBSplashShowListener = this.a;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onZoomOutPlayStart(mBridgeIds);
        }
        try {
            q.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.f2445b, mBridgeIds.getUnitId(), "flb_size=" + i2 + "x" + i + "&flb_type=" + i3 + "&");
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
