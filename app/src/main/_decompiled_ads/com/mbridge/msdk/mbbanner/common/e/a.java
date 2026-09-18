package com.mbridge.msdk.mbbanner.common.e;

import android.content.Context;
import android.os.Build;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.net.g.e;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.out.MBConfiguration;
import com.tapjoy.TapjoyConstants;

/* JADX INFO: compiled from: BannerRequest.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends com.mbridge.msdk.foundation.same.net.g.a {
    public a(Context context) {
        super(context);
    }

    @Override // com.mbridge.msdk.foundation.same.net.g.a, com.mbridge.msdk.foundation.same.net.g.b
    public final void addExtraParams(String str, d dVar) {
        super.addExtraParams(str, dVar);
        dVar.a(TapjoyConstants.TJC_PLATFORM, "1");
        dVar.a(TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, Build.VERSION.RELEASE);
        dVar.a(CampaignEx.JSON_KEY_PACKAGE_NAME, w.o(this.mContext));
        dVar.a("app_version_name", w.j(this.mContext));
        dVar.a("app_version_code", w.i(this.mContext) + "");
        dVar.a("orientation", w.h(this.mContext) + "");
        dVar.a(DeviceRequestsHelper.DEVICE_INFO_MODEL, w.i());
        dVar.a("brand", w.k());
        dVar.a("gaid", "");
        dVar.a("gaid2", w.c());
        int iR = w.r(this.mContext);
        dVar.a("network_type", iR + "");
        dVar.a("network_str", w.a(this.mContext, iR) + "");
        dVar.a("language", w.g(this.mContext));
        dVar.a(TapjoyConstants.TJC_DEVICE_TIMEZONE, w.m());
        dVar.a("useragent", w.l());
        dVar.a("sdk_version", MBConfiguration.SDK_VERSION);
        dVar.a("screen_size", w.l(this.mContext) + "x" + w.m(this.mContext));
        dVar.a("version_flag", "1");
        e.a(dVar, this.mContext);
        e.a(dVar);
        e.c(dVar);
    }
}
