package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.tapjoy.TJAdUnitConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DomainDeviceInfo.java */
/* JADX INFO: loaded from: classes4.dex */
public class f {
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
    public String p;
    public String q;
    public String r;
    public int s;
    public int t;
    public int u;
    public String v;
    public int w;
    public int x;
    public String c = "android";
    public String a = w.j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2214b = w.n();
    public String d = w.a();

    public f(Context context) {
        int iR = w.r(context);
        this.e = String.valueOf(iR);
        this.f = w.a(context, iR);
        this.g = w.q(context);
        this.h = com.mbridge.msdk.foundation.controller.b.d().j();
        this.i = com.mbridge.msdk.foundation.controller.b.d().h();
        this.j = String.valueOf(af.i(context));
        this.k = String.valueOf(af.h(context));
        this.o = String.valueOf(af.e(context));
        this.p = com.mbridge.msdk.foundation.controller.b.d().l().toString();
        this.r = w.k();
        this.s = af.f();
        if (context.getResources().getConfiguration().orientation == 2) {
            this.l = TJAdUnitConstants.String.LANDSCAPE;
        } else {
            this.l = TJAdUnitConstants.String.PORTRAIT;
        }
        this.m = com.mbridge.msdk.foundation.same.a.l;
        this.n = com.mbridge.msdk.foundation.same.a.m;
        this.q = w.s();
        this.t = w.v();
        this.u = w.t();
        this.v = w.e();
        this.w = w.b();
        this.x = com.mbridge.msdk.foundation.controller.authoritycontroller.a.h() ? 1 : 0;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, this.a);
                jSONObject.put("system_version", this.f2214b);
                jSONObject.put("network_type", this.e);
                jSONObject.put("network_type_str", this.f);
                jSONObject.put("device_ua", this.g);
                jSONObject.put("has_wx", w.f(com.mbridge.msdk.foundation.controller.b.d().g()));
                jSONObject.put("integrated_wx", w.g());
                jSONObject.put("opensdk_ver", w.h() + "");
                jSONObject.put("wx_api_ver", w.c(com.mbridge.msdk.foundation.controller.b.d().i()) + "");
                jSONObject.put("brand", this.r);
                jSONObject.put("mnc", w.e(com.mbridge.msdk.foundation.controller.b.d().g()));
                jSONObject.put("mcc", w.d(com.mbridge.msdk.foundation.controller.b.d().g()));
                jSONObject.put("adid_limit", this.w);
                jSONObject.put("adid_limit_dev", this.x);
            }
            jSONObject.put("plantform", this.c);
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                jSONObject.put("google_ad_id", this.d);
                jSONObject.put("az_aid_info", this.v);
            }
            jSONObject.put("appkey", this.h);
            jSONObject.put("appId", this.i);
            jSONObject.put("screen_width", this.j);
            jSONObject.put("screen_height", this.k);
            jSONObject.put("orientation", this.l);
            jSONObject.put("scale", this.o);
            jSONObject.put(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, this.m);
            jSONObject.put("c", this.n);
            jSONObject.put("web_env", this.p);
            jSONObject.put(InneractiveMediationDefs.GENDER_FEMALE, this.q);
            jSONObject.put("misk_spt", this.s);
            if (w.y() != 0) {
                jSONObject.put("tun", w.y());
            }
            jSONObject.put(com.mbridge.msdk.foundation.same.net.g.d.h, com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().e() + "");
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("dmt", this.t + "");
                jSONObject2.put("dmf", this.u);
                jSONObject2.put("adid_limit", this.w);
                jSONObject2.put("adid_limit_dev", this.x);
                jSONObject.put("dvi", u.a(jSONObject2.toString()));
            }
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.g()) {
                jSONObject.put("dev_source", "2");
            }
            if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
                jSONObject.put("re_domain", "1");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
