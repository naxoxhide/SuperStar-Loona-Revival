package com.mbridge.msdk.advanced.js;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.mbridge.msdk.c.d;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: NativeAdvancedSignalCommunicationImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends com.mbridge.msdk.mbsignalcommon.communication.a {
    private WeakReference<Context> c;
    private List<CampaignEx> d;
    private String e;
    private String f;
    private int g;
    private int h;
    private com.mbridge.msdk.advanced.b.a j;
    private NativeAdvancedExpandDialog k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1897b = "NativeAdvancedSignalCommunicationImpl";
    private int i = 5;

    public b(Context context, String str, String str2) {
        this.f = str;
        this.e = str2;
        this.c = new WeakReference<>(context);
    }

    public final void a(int i) {
        this.h = i;
    }

    public final void b(int i) {
        this.i = i;
    }

    public final void a(com.mbridge.msdk.advanced.b.a aVar) {
        if (aVar != null) {
            this.j = aVar;
        }
    }

    public final void a(List<CampaignEx> list) {
        this.d = list;
    }

    public final List<CampaignEx> a() {
        return this.d;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.c
    public final void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            com.mbridge.msdk.advanced.common.a aVar = new com.mbridge.msdk.advanced.common.a(com.mbridge.msdk.foundation.controller.b.d().g());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dev_close_state", this.g);
            jSONObject2.put("customURLScheme", 1);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, aVar.a());
            jSONObject.put("campaignList", CampaignEx.parseCamplistToJson(this.d));
            f fVarF = d.a().f(com.mbridge.msdk.foundation.controller.b.d().h(), this.e);
            if (fVarF == null) {
                fVarF = f.c(this.e);
            }
            if (!TextUtils.isEmpty(this.f)) {
                fVarF.g(this.f);
            }
            fVarF.a(this.e);
            fVarF.b(this.i);
            fVarF.a(this.h);
            jSONObject.put("unitSetting", fVarF.t());
            String strC = d.a().c(com.mbridge.msdk.foundation.controller.b.d().h());
            if (!TextUtils.isEmpty(strC)) {
                jSONObject.put("appSetting", new JSONObject(strC));
            }
            jSONObject.put("sdk_info", com.mbridge.msdk.mbsignalcommon.base.d.a);
            aa.d(this.f1897b, "init" + jSONObject.toString());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            aa.b(this.f1897b, "init", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.c
    public final void b(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(new JSONObject(str).getJSONObject(DynamicLink.ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_PT));
            com.mbridge.msdk.advanced.b.a aVar = this.j;
            if (aVar != null) {
                aVar.a(campaignWithBackData);
            }
        } catch (Throwable th) {
            aa.b(this.f1897b, "click", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.c
    public final void c(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        try {
            if (!(obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) || (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).a) == null) {
                return;
            }
            try {
                windVaneWebView.getWebViewListener().a(windVaneWebView, new JSONObject(str).getInt("isReady"));
            } catch (Exception unused) {
                windVaneWebView.getWebViewListener().a(windVaneWebView, 2);
            }
        } catch (Throwable th) {
            aa.a(this.f1897b, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.c
    public final void d(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt("state");
            com.mbridge.msdk.advanced.b.a aVar = this.j;
            if (aVar != null) {
                aVar.a(iOptInt);
            }
        } catch (Throwable th) {
            aa.b(this.f1897b, "toggleCloseBtn", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.c
    public final void e(Object obj, String str) {
        if (this.j != null) {
            a.a(obj);
            this.j.a(obj, str);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.c
    public final void f(Object obj, String str) {
        try {
            if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
                g.a().a(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).a);
            }
        } catch (Throwable th) {
            aa.b(this.f1897b, "onSignalCommunicationConnect", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.c
    public final void g(Object obj, String str) {
        aa.d(this.f1897b, "install");
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(new JSONObject(str).optJSONObject(DynamicLink.ItunesConnectAnalyticsParameters.KEY_ITUNES_CONNECT_PT));
            com.mbridge.msdk.advanced.b.a aVar = this.j;
            if (aVar != null) {
                aVar.a(campaignWithBackData);
            }
        } catch (Throwable th) {
            aa.b(this.f1897b, "install", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.c
    public final void h(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int i = new JSONObject(str).getInt("countdown");
            com.mbridge.msdk.advanced.b.a aVar = this.j;
            if (aVar != null) {
                aVar.b(i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void open(String str) {
        com.mbridge.msdk.advanced.b.a aVar = this.j;
        if (aVar != null) {
            aVar.a(true, str);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void close() {
        aa.d(this.f1897b, "close");
        try {
            com.mbridge.msdk.advanced.b.a aVar = this.j;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Throwable th) {
            aa.b(this.f1897b, "close", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void unload() {
        close();
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final CampaignEx getMraidCampaign() {
        List<CampaignEx> list = this.d;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.d.get(0);
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void useCustomClose(boolean z) {
        try {
            if (this.h == -1) {
                int i = z ? 2 : 1;
                com.mbridge.msdk.advanced.b.a aVar = this.j;
                if (aVar != null) {
                    aVar.a(i);
                }
            }
        } catch (Throwable th) {
            aa.b(this.f1897b, "useCustomClose", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void expand(String str, boolean z) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putBoolean("shouldUseCustomClose", z);
            WeakReference<Context> weakReference = this.c;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            NativeAdvancedExpandDialog nativeAdvancedExpandDialog = this.k;
            if (nativeAdvancedExpandDialog == null || !nativeAdvancedExpandDialog.isShowing()) {
                NativeAdvancedExpandDialog nativeAdvancedExpandDialog2 = new NativeAdvancedExpandDialog(this.c.get(), bundle, this.j);
                this.k = nativeAdvancedExpandDialog2;
                nativeAdvancedExpandDialog2.setCampaignList(this.e, this.d);
                this.k.show();
                com.mbridge.msdk.advanced.b.a aVar = this.j;
                if (aVar != null) {
                    aVar.a(true);
                }
                com.mbridge.msdk.advanced.c.a.a(this.e, getMraidCampaign(), str);
            }
        } catch (Throwable th) {
            aa.b(this.f1897b, "expand", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.c
    public final void i(Object obj, String str) {
        aa.a(this.f1897b, "sendImpressions:" + str);
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            final ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                String string = jSONArray.getString(i);
                for (CampaignEx campaignEx : this.d) {
                    if (campaignEx.getId().equals(string)) {
                        com.mbridge.msdk.foundation.same.a.d.a(this.e, campaignEx, "h5_native");
                        arrayList.add(string);
                    }
                }
            }
            new Thread(new Runnable() { // from class: com.mbridge.msdk.advanced.js.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        k kVarA = k.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            kVarA.b((String) it.next());
                        }
                    } catch (Exception unused) {
                        aa.d(b.this.f1897b, "campain can't insert db");
                    }
                }
            }).start();
        } catch (Throwable th) {
            aa.b(this.f1897b, "sendImpressions", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.c
    public final void j(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "params is empty");
            return;
        }
        try {
            a.a(obj, new JSONObject(str));
        } catch (Throwable th) {
            aa.a(this.f1897b, th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.a, com.mbridge.msdk.mbsignalcommon.communication.c
    public final void k(Object obj, String str) {
        aa.a(this.f1897b, "reportUrls:" + str);
        if (TextUtils.isEmpty(str)) {
            com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "params is null");
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
                    List<CampaignEx> list = this.d;
                    com.mbridge.msdk.click.a.a(contextG, list != null ? list.get(0) : null, "", strA, false, iOptInt != 0);
                } else {
                    Context contextG2 = com.mbridge.msdk.foundation.controller.b.d().g();
                    List<CampaignEx> list2 = this.d;
                    com.mbridge.msdk.click.a.a(contextG2, list2 != null ? list2.get(0) : null, "", strA, false, iOptInt != 0, iOptInt2);
                }
            }
            g.a().a(obj, com.mbridge.msdk.mbsignalcommon.communication.b.a(0));
        } catch (Throwable th) {
            aa.b(this.f1897b, "reportUrls", th);
        }
    }
}
