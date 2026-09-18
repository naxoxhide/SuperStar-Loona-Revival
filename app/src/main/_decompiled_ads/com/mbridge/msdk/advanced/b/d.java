package com.mbridge.msdk.advanced.b;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.NativeAdvancedAdListener;

/* JADX INFO: compiled from: NativeAdvancedShowListenerImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private NativeAdvancedAdListener a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CampaignEx f1891b;
    private c c;

    public d(c cVar, NativeAdvancedAdListener nativeAdvancedAdListener, CampaignEx campaignEx) {
        this.c = cVar;
        this.a = nativeAdvancedAdListener;
        this.f1891b = campaignEx;
    }

    public final void a(MBridgeIds mBridgeIds) {
        c cVar = this.c;
        if (cVar != null) {
            cVar.a = true;
        }
        q.a(com.mbridge.msdk.foundation.controller.b.d().g(), this.f1891b, mBridgeIds.getUnitId(), new StringBuffer().append("load_to=").append("0").append("&").append("allow_skip=").append(this.c.c()).append("&").toString());
        NativeAdvancedAdListener nativeAdvancedAdListener = this.a;
        if (nativeAdvancedAdListener != null) {
            nativeAdvancedAdListener.onLogImpression(mBridgeIds);
        }
    }

    public final void a(MBridgeIds mBridgeIds, String str) {
        q.b(com.mbridge.msdk.foundation.controller.b.d().g(), this.f1891b, mBridgeIds.getUnitId(), str);
    }

    public final void b(MBridgeIds mBridgeIds) {
        NativeAdvancedAdListener nativeAdvancedAdListener = this.a;
        if (nativeAdvancedAdListener != null) {
            nativeAdvancedAdListener.onClick(mBridgeIds);
        }
    }

    public final void c(MBridgeIds mBridgeIds) {
        NativeAdvancedAdListener nativeAdvancedAdListener = this.a;
        if (nativeAdvancedAdListener != null) {
            nativeAdvancedAdListener.onClose(mBridgeIds);
            c cVar = this.c;
            if (cVar != null) {
                cVar.a = false;
            }
        }
    }

    public final void d(MBridgeIds mBridgeIds) {
        NativeAdvancedAdListener nativeAdvancedAdListener = this.a;
        if (nativeAdvancedAdListener != null) {
            nativeAdvancedAdListener.onLeaveApp(mBridgeIds);
        }
    }

    public final void e(MBridgeIds mBridgeIds) {
        NativeAdvancedAdListener nativeAdvancedAdListener = this.a;
        if (nativeAdvancedAdListener != null) {
            nativeAdvancedAdListener.showFullScreen(mBridgeIds);
        }
    }

    public final void f(MBridgeIds mBridgeIds) {
        NativeAdvancedAdListener nativeAdvancedAdListener = this.a;
        if (nativeAdvancedAdListener != null) {
            nativeAdvancedAdListener.closeFullScreen(mBridgeIds);
        }
    }
}
