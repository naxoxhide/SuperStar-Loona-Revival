package com.mbridge.msdk.mbbanner.common.bridge;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.d;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.k;
import com.mbridge.msdk.foundation.db.p;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.e;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.mbsignalcommon.communication.b;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BannerSignalCommunicationImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends com.mbridge.msdk.mbsignalcommon.communication.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference<Context> f2257b;
    private List<CampaignEx> c;
    private String d;
    private String e;
    private int f;
    private com.mbridge.msdk.mbbanner.common.b.a g;
    private BannerExpandDialog h;
    private boolean i = false;

    public a(Context context, String str, String str2) {
        this.d = str;
        this.e = str2;
        this.f2257b = new WeakReference<>(context);
    }

    public final void a(com.mbridge.msdk.mbbanner.common.b.a aVar) {
        if (aVar != null) {
            this.g = aVar;
        }
    }

    public final void a(List<CampaignEx> list) {
        this.c = list;
    }

    public final void a(int i) {
        this.f = i;
    }

    public final void a() {
        if (this.g != null) {
            this.g = null;
        }
        if (this.h != null) {
            this.h = null;
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.c
    public final void c(Object obj, String str) {
        if (obj != null) {
            try {
                int iOptInt = new JSONObject(str).optInt("isReady", 1);
                g.a().a(obj, b.a(0));
                com.mbridge.msdk.mbbanner.common.b.a aVar = this.g;
                if (aVar != null) {
                    aVar.b(iOptInt);
                }
            } catch (Throwable th) {
                aa.b("BannerSignalCommunicationImpl", "readyStatus", th);
            }
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.c
    public final void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            e eVar = new e(com.mbridge.msdk.foundation.controller.b.d().g());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dev_close_state", this.f);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, eVar.a());
            jSONObject.put("campaignList", CampaignEx.parseCamplistToJson(this.c));
            f fVarE = d.a().e(com.mbridge.msdk.foundation.controller.b.d().h(), this.e);
            if (fVarE == null) {
                fVarE = f.d(this.e);
            }
            if (!TextUtils.isEmpty(this.d)) {
                fVarE.g(this.d);
            }
            jSONObject.put("unitSetting", fVarE.t());
            String strC = d.a().c(com.mbridge.msdk.foundation.controller.b.d().h());
            if (!TextUtils.isEmpty(strC)) {
                jSONObject.put("appSetting", new JSONObject(strC));
            }
            jSONObject.put("sdk_info", com.mbridge.msdk.mbsignalcommon.base.d.a);
            aa.d("BannerSignalCommunicationImpl", "init" + jSONObject.toString());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            aa.b("BannerSignalCommunicationImpl", "init", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.c
    public final void b(Object obj, String str) {
        aa.d("BannerSignalCommunicationImpl", "click");
        try {
            if (this.c == null || TextUtils.isEmpty(str)) {
                return;
            }
            CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(new JSONObject(str).getJSONObject(DynamicLink.ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_PT));
            com.mbridge.msdk.mbbanner.common.b.a aVar = this.g;
            if (aVar != null) {
                aVar.a(campaignWithBackData);
            }
        } catch (Throwable th) {
            aa.b("BannerSignalCommunicationImpl", "click", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.c
    public final void d(Object obj, String str) {
        aa.d("BannerSignalCommunicationImpl", "toggleCloseBtn");
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt("state");
            com.mbridge.msdk.mbbanner.common.b.a aVar = this.g;
            if (aVar != null) {
                aVar.a(iOptInt);
            }
        } catch (Throwable th) {
            aa.b("BannerSignalCommunicationImpl", "toggleCloseBtn", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.c
    public final void e(Object obj, String str) {
        aa.d("BannerSignalCommunicationImpl", "triggerCloseBtn");
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String strOptString = new JSONObject(str).optString("state");
            com.mbridge.msdk.mbbanner.common.b.a aVar = this.g;
            if (aVar != null) {
                aVar.a(strOptString);
            }
            g.a().a(obj, b.a(0));
        } catch (Throwable th) {
            aa.b("BannerSignalCommunicationImpl", "triggerCloseBtn", th);
            g.a().a(obj, b.a(-1));
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.c
    public final void i(Object obj, String str) {
        aa.a("BannerSignalCommunicationImpl", "sendImpressions:" + str);
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            final ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                String string = jSONArray.getString(i);
                for (CampaignEx campaignEx : this.c) {
                    if (campaignEx.getId().equals(string)) {
                        com.mbridge.msdk.foundation.same.a.d.a(this.e, campaignEx, ReportUtil.INVENTORY_TYPE_BANNER);
                        arrayList.add(string);
                    }
                }
            }
            new Thread(new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.bridge.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        k kVarA = k.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            kVarA.b((String) it.next());
                        }
                    } catch (Exception e) {
                        aa.d("BannerSignalCommunicationImpl", e.getMessage());
                    }
                }
            }).start();
        } catch (Throwable th) {
            aa.b("BannerSignalCommunicationImpl", "sendImpressions", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void open(String str) {
        aa.d("BannerSignalCommunicationImpl", "open");
        try {
            aa.d("BannerSignalCommunicationImpl", str);
            if (this.c.size() > 1) {
                com.mbridge.msdk.foundation.controller.b.d().g().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                str = null;
            }
            com.mbridge.msdk.mbbanner.common.b.a aVar = this.g;
            if (aVar != null) {
                aVar.a(true, str);
            }
        } catch (Throwable th) {
            aa.b("BannerSignalCommunicationImpl", "open", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void close() {
        aa.d("BannerSignalCommunicationImpl", "close");
        try {
            com.mbridge.msdk.mbbanner.common.b.a aVar = this.g;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Throwable th) {
            aa.b("BannerSignalCommunicationImpl", "close", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void unload() {
        close();
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final CampaignEx getMraidCampaign() {
        List<CampaignEx> list = this.c;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.c.get(0);
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void useCustomClose(boolean z) {
        int i = z ? 2 : 1;
        try {
            com.mbridge.msdk.mbbanner.common.b.a aVar = this.g;
            if (aVar != null) {
                aVar.a(i);
            }
        } catch (Throwable th) {
            aa.b("BannerSignalCommunicationImpl", "useCustomClose", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void expand(String str, boolean z) {
        Context context;
        try {
            String bannerUrl = "";
            if (getMraidCampaign() != null) {
                if (TextUtils.isEmpty(getMraidCampaign().getBannerHtml())) {
                    bannerUrl = getMraidCampaign().getBannerUrl();
                } else {
                    bannerUrl = "file:////" + getMraidCampaign().getBannerHtml();
                }
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                bannerUrl = str;
            }
            bundle.putString("url", bannerUrl);
            bundle.putBoolean("shouldUseCustomClose", z);
            WeakReference<Context> weakReference = this.f2257b;
            if (weakReference != null && (context = weakReference.get()) != null) {
                BannerExpandDialog bannerExpandDialog = this.h;
                if (bannerExpandDialog != null && bannerExpandDialog.isShowing()) {
                    return;
                }
                BannerExpandDialog bannerExpandDialog2 = new BannerExpandDialog(context, bundle, this.g);
                this.h = bannerExpandDialog2;
                bannerExpandDialog2.setCampaignList(this.e, this.c);
                this.h.show();
            }
            com.mbridge.msdk.mbbanner.common.b.a aVar = this.g;
            if (aVar != null) {
                aVar.a(true);
            }
            com.mbridge.msdk.mbbanner.common.d.a.a(this.e, getMraidCampaign(), str);
        } catch (Throwable th) {
            aa.b("BannerSignalCommunicationImpl", "expand", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.c
    public final void j(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            b.a(obj, "params is empty");
            return;
        }
        try {
            a(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.a("BannerSignalCommunicationImpl", th.getMessage());
        }
    }

    private static void a(Object obj, JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        boolean z;
        String str5;
        JSONObject jSONObject2 = new JSONObject();
        String str6 = "message";
        String str7 = "code";
        int i2 = 1;
        if (jSONObject == null) {
            try {
                jSONObject2.put("code", 1);
                jSONObject2.put("message", "params is null");
                g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            } catch (JSONException e) {
                aa.a("BannerSignalCommunicationImpl", e.getMessage());
                return;
            }
        }
        try {
            jSONObject2.put("code", 0);
            jSONObject2.put("message", "");
            JSONArray jSONArray = jSONObject.getJSONArray("resource");
            if (jSONArray != null && jSONArray.length() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                int length = jSONArray.length();
                int i3 = 0;
                while (i3 < length) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                    String strOptString = jSONObject3.optString("ref", "");
                    int i4 = jSONObject3.getInt("type");
                    JSONObject jSONObject4 = new JSONObject();
                    JSONArray jSONArray3 = jSONArray;
                    if (i4 == i2 && !TextUtils.isEmpty(strOptString)) {
                        JSONObject jSONObject5 = new JSONObject();
                        m mVarA = p.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g())).a(strOptString);
                        if (mVarA != null) {
                            i = length;
                            aa.a("BannerSignalCommunicationImpl", "VideoBean not null");
                            jSONObject5.put("type", 1);
                            str3 = str6;
                            try {
                                jSONObject5.put("videoDataLength", mVarA.c());
                                String strE = mVarA.e();
                                str4 = str7;
                                if (TextUtils.isEmpty(strE)) {
                                    try {
                                        aa.a("BannerSignalCommunicationImpl", "VideoPath null");
                                        jSONObject5.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, "");
                                        jSONObject5.put("path4Web", "");
                                    } catch (Throwable th) {
                                        th = th;
                                        str = str3;
                                        str2 = str4;
                                    }
                                } else {
                                    aa.a("BannerSignalCommunicationImpl", "VideoPath not null");
                                    jSONObject5.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, strE);
                                    jSONObject5.put("path4Web", strE);
                                }
                                if (mVarA.d() == 5) {
                                    jSONObject5.put("downloaded", 1);
                                    z = false;
                                } else {
                                    z = false;
                                    jSONObject5.put("downloaded", 0);
                                }
                                jSONObject4.put(strOptString, jSONObject5);
                                jSONArray2.put(jSONObject4);
                            } catch (Throwable th2) {
                                th = th2;
                                str2 = str7;
                                str = str3;
                                jSONObject2.put(str2, 1);
                                jSONObject2.put(str, th.getLocalizedMessage());
                                g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                            }
                        } else {
                            str3 = str6;
                            str4 = str7;
                            i = length;
                            z = false;
                            aa.a("BannerSignalCommunicationImpl", "VideoBean null");
                        }
                    } else {
                        str3 = str6;
                        str4 = str7;
                        i = length;
                        z = false;
                        if (i4 == 2 && !TextUtils.isEmpty(strOptString)) {
                            JSONObject jSONObject6 = new JSONObject();
                            jSONObject6.put("type", 2);
                            jSONObject6.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, com.mbridge.msdk.videocommon.download.g.a().a(strOptString) == null ? "" : com.mbridge.msdk.videocommon.download.g.a().b(strOptString));
                            jSONObject4.put(strOptString, jSONObject6);
                            jSONArray2.put(jSONObject4);
                        } else if (i4 == 3 && !TextUtils.isEmpty(strOptString)) {
                            try {
                                File file = new File(strOptString);
                                if (file.exists() && file.isFile() && file.canRead()) {
                                    aa.a("BannerSignalCommunicationImpl", "getFileInfo Mraid file " + strOptString);
                                    str5 = "file:////" + strOptString;
                                } else {
                                    str5 = "";
                                }
                            } catch (Throwable th3) {
                                if (MBridgeConstans.DEBUG) {
                                    th3.printStackTrace();
                                }
                            }
                            JSONObject jSONObject7 = new JSONObject();
                            jSONObject7.put("type", 3);
                            jSONObject7.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, str5);
                            jSONObject4.put(strOptString, jSONObject7);
                            jSONArray2.put(jSONObject4);
                        } else if (i4 == 4 && !TextUtils.isEmpty(strOptString)) {
                            JSONObject jSONObject8 = new JSONObject();
                            jSONObject8.put("type", 4);
                            jSONObject8.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, ae.a(strOptString) == null ? "" : ae.a(strOptString));
                            jSONObject4.put(strOptString, jSONObject8);
                            jSONArray2.put(jSONObject4);
                        }
                    }
                    i3++;
                    jSONArray = jSONArray3;
                    length = i;
                    str6 = str3;
                    str7 = str4;
                    i2 = 1;
                }
                str3 = str6;
                str4 = str7;
                jSONObject2.put("resource", jSONArray2);
                g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                return;
            }
            str3 = "message";
            str2 = "code";
            try {
                jSONObject2.put(str2, 1);
                str = str3;
                try {
                    try {
                        jSONObject2.put(str, "resource is null");
                        g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
                        return;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (JSONException e2) {
                    e = e2;
                    aa.a("BannerSignalCommunicationImpl", e.getMessage());
                    return;
                }
            } catch (JSONException e3) {
                e = e3;
                str = str3;
            } catch (Throwable th5) {
                th = th5;
                str = str3;
                jSONObject2.put(str2, 1);
                jSONObject2.put(str, th.getLocalizedMessage());
                g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
            }
        } catch (Throwable th6) {
            th = th6;
            str = str6;
            str2 = str7;
        }
        try {
            jSONObject2.put(str2, 1);
            jSONObject2.put(str, th.getLocalizedMessage());
            g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (JSONException e4) {
            aa.a("BannerSignalCommunicationImpl", e4.getMessage());
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.c
    public final void k(Object obj, String str) {
        aa.a("BannerSignalCommunicationImpl", "reportUrls:" + str);
        if (TextUtils.isEmpty(str)) {
            b.a(obj, "params is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                int iOptInt = jSONObject.optInt("type");
                String strA = af.a(jSONObject.optString("url"), "&tun=", w.y() + "");
                int iOptInt2 = jSONObject.optInt("report");
                if (iOptInt2 == 0) {
                    Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
                    List<CampaignEx> list = this.c;
                    com.mbridge.msdk.click.a.a(contextG, list != null ? list.get(0) : null, "", strA, false, iOptInt != 0);
                } else {
                    Context contextG2 = com.mbridge.msdk.foundation.controller.b.d().g();
                    List<CampaignEx> list2 = this.c;
                    com.mbridge.msdk.click.a.a(contextG2, list2 != null ? list2.get(0) : null, "", strA, false, iOptInt != 0, iOptInt2);
                }
            }
            g.a().a(obj, b.a(0));
        } catch (Throwable th) {
            aa.b("BannerSignalCommunicationImpl", "reportUrls", th);
        }
    }
}
