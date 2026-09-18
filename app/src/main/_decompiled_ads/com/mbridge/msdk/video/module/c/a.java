package com.mbridge.msdk.video.module.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.g.b;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.out.MBConfiguration;
import com.tapjoy.TapjoyConstants;
import org.json.JSONObject;

/* JADX INFO: compiled from: VideoViewRequest.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends b {
    public a(Context context) {
        super(context);
    }

    @Override // com.mbridge.msdk.foundation.same.net.g.b
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
        dVar.a("mnc", w.e(this.mContext));
        dVar.a("mcc", w.d(this.mContext));
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
        if (com.mbridge.msdk.c.d.a().b(com.mbridge.msdk.foundation.controller.b.d().h()) != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (TextUtils.isEmpty(jSONObject.toString())) {
                    return;
                }
                String strA = u.a(jSONObject.toString());
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                dVar.a("dvi", strA);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
