package com.mbridge.msdk.advanced.b;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.e;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.NativeAdvancedAdListener;
import java.util.ArrayList;

/* JADX INFO: compiled from: NativeAdvancedLoadListenerImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private NativeAdvancedAdListener a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f1889b;
    private String c;
    private String d;
    private MBridgeIds e;

    public b(c cVar, MBridgeIds mBridgeIds) {
        this.f1889b = cVar;
        this.e = mBridgeIds;
        this.c = mBridgeIds.getUnitId();
    }

    public final void a(NativeAdvancedAdListener nativeAdvancedAdListener) {
        this.a = nativeAdvancedAdListener;
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void a(CampaignEx campaignEx, int i) {
        c cVar;
        c cVar2 = this.f1889b;
        if (cVar2 == null || !cVar2.a() || campaignEx == null) {
            return;
        }
        NativeAdvancedAdListener nativeAdvancedAdListener = this.a;
        if (nativeAdvancedAdListener != null && this.f1889b != null) {
            nativeAdvancedAdListener.onLoadSuccessed(this.e);
        }
        this.f1889b.a(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        q.a(com.mbridge.msdk.foundation.controller.b.d().g(), arrayList, this.c, campaignEx.isBidCampaign());
        if (i != 2 || (cVar = this.f1889b) == null) {
            return;
        }
        cVar.a(campaignEx, true);
    }

    public final void a(e eVar, int i, CampaignEx campaignEx) {
        c cVar = this.f1889b;
        if (cVar == null || !cVar.a()) {
            return;
        }
        NativeAdvancedAdListener nativeAdvancedAdListener = this.a;
        if (nativeAdvancedAdListener != null) {
            nativeAdvancedAdListener.onLoadFailed(this.e, eVar != null ? eVar.d() : "");
        }
        this.f1889b.a(false);
        q.a(com.mbridge.msdk.foundation.controller.b.d().g(), eVar, this.c, !TextUtils.isEmpty(this.d), campaignEx);
    }

    public final void a(e eVar, int i) {
        c cVar = this.f1889b;
        if (cVar == null || !cVar.a()) {
            return;
        }
        NativeAdvancedAdListener nativeAdvancedAdListener = this.a;
        if (nativeAdvancedAdListener != null) {
            nativeAdvancedAdListener.onLoadFailed(this.e, eVar != null ? eVar.d() : "");
        }
        this.f1889b.a(false);
        q.a(com.mbridge.msdk.foundation.controller.b.d().g(), eVar, this.c, !TextUtils.isEmpty(this.d), (CampaignEx) null);
    }
}
