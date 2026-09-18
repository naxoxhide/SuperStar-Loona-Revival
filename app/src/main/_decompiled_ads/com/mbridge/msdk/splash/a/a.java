package com.mbridge.msdk.splash.a;

import android.content.Context;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.w;
import com.tapjoy.TJAdUnitConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DeviceInfo.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public int p;
    public int q;
    public String c = "android";
    public String a = w.j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2419b = w.n();
    public String d = w.a();

    public a(Context context) {
        int iR = w.r(context);
        this.e = String.valueOf(iR);
        this.f = w.a(context, iR);
        this.g = w.q(context);
        this.h = com.mbridge.msdk.foundation.controller.b.d().j();
        this.i = com.mbridge.msdk.foundation.controller.b.d().h();
        this.j = String.valueOf(af.i(context));
        this.k = String.valueOf(af.h(context));
        this.m = String.valueOf(af.e(context));
        if (context.getResources().getConfiguration().orientation == 2) {
            this.l = TJAdUnitConstants.String.LANDSCAPE;
        } else {
            this.l = TJAdUnitConstants.String.PORTRAIT;
        }
        this.n = w.s();
        this.o = w.e();
        this.p = w.b();
        this.q = com.mbridge.msdk.foundation.controller.authoritycontroller.a.h() ? 1 : 0;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, this.a);
                jSONObject.put("system_version", this.f2419b);
                jSONObject.put("network_type", this.e);
                jSONObject.put("network_type_str", this.f);
                jSONObject.put("device_ua", this.g);
                jSONObject.put("has_wx", w.f(com.mbridge.msdk.foundation.controller.b.d().g()));
                jSONObject.put("integrated_wx", w.g());
                jSONObject.put("mnc", w.e(com.mbridge.msdk.foundation.controller.b.d().g()));
                jSONObject.put("mcc", w.d(com.mbridge.msdk.foundation.controller.b.d().g()));
                jSONObject.put("adid_limit", this.p);
                jSONObject.put("adid_limit_dev", this.q);
            }
            jSONObject.put("plantform", this.c);
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                jSONObject.put("google_ad_id", this.d);
                jSONObject.put("az_aid_info", this.o);
            }
            jSONObject.put("appkey", this.h);
            jSONObject.put("appId", this.i);
            jSONObject.put("screen_width", this.j);
            jSONObject.put("screen_height", this.k);
            jSONObject.put("orientation", this.l);
            jSONObject.put("scale", this.m);
            if (w.y() != 0) {
                jSONObject.put("tun", w.y());
            }
            jSONObject.put(InneractiveMediationDefs.GENDER_FEMALE, this.n);
            if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
                jSONObject.put("re_domain", "1");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
