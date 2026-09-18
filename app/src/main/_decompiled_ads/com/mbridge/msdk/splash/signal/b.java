package com.mbridge.msdk.splash.signal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
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

/* JADX INFO: compiled from: SplashSignalCommunicationImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference<Context> f2450b;
    private List<CampaignEx> c;
    private String d;
    private String e;
    private int f;
    private int g;
    private int i;
    private com.mbridge.msdk.splash.d.a j;
    private SplashExpandDialog k;
    private String a = "SplashSignalCommunicationImpl";
    private int h = 5;

    public b(Context context, String str, String str2) {
        this.e = str;
        this.d = str2;
        this.f2450b = new WeakReference<>(context);
    }

    public final void a(Context context) {
        this.f2450b = new WeakReference<>(context);
    }

    public final void a(int i) {
        this.g = i;
    }

    public final void b(int i) {
        this.h = i;
    }

    public final void c(int i) {
        this.i = i;
    }

    public final void a(com.mbridge.msdk.splash.d.a aVar) {
        if (aVar != null) {
            this.j = aVar;
        }
    }

    public final com.mbridge.msdk.splash.d.a a() {
        return this.j;
    }

    public final void a(List<CampaignEx> list) {
        this.c = list;
    }

    public final List<CampaignEx> b() {
        return this.c;
    }

    public final void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            com.mbridge.msdk.splash.a.a aVar = new com.mbridge.msdk.splash.a.a(com.mbridge.msdk.foundation.controller.b.d().g());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("dev_close_state", this.f);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, aVar.a());
            jSONObject.put("campaignList", CampaignEx.parseCamplistToJson(this.c));
            f fVarE = d.a().e(com.mbridge.msdk.foundation.controller.b.d().h(), this.d);
            if (fVarE == null) {
                fVarE = f.d(this.d);
            }
            if (!TextUtils.isEmpty(this.e)) {
                fVarE.g(this.e);
            }
            fVarE.a(this.d);
            fVarE.b(this.h);
            fVarE.a(this.g);
            jSONObject.put("unitSetting", fVarE.t());
            String strC = d.a().c(com.mbridge.msdk.foundation.controller.b.d().h());
            if (!TextUtils.isEmpty(strC)) {
                jSONObject.put("appSetting", new JSONObject(strC));
            }
            jSONObject.put("sdk_info", com.mbridge.msdk.mbsignalcommon.base.d.a);
            aa.d(this.a, "init" + jSONObject.toString());
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            aa.b(this.a, "init", th);
        }
    }

    public final void b(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int iOptInt = new JSONObject(str).optInt("state");
            com.mbridge.msdk.splash.d.a aVar = this.j;
            if (aVar != null) {
                aVar.a(iOptInt);
            }
        } catch (Throwable th) {
            aa.b(this.a, "toggleCloseBtn", th);
        }
    }

    public final void c(Object obj, String str) {
        com.mbridge.msdk.splash.d.a aVar = this.j;
        if (aVar != null) {
            aVar.a(obj, str);
        }
    }

    public final void d(Object obj, String str) {
        aa.d(this.a, "click");
        try {
            if (this.c == null || TextUtils.isEmpty(str)) {
                return;
            }
            CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(new JSONObject(str));
            com.mbridge.msdk.splash.d.a aVar = this.j;
            if (aVar != null) {
                aVar.a(campaignWithBackData);
            }
        } catch (Throwable th) {
            aa.b(this.a, "click", th);
        }
    }

    public final void e(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        aa.d(this.a, "openURL:" + str);
        if (TextUtils.isEmpty(str)) {
            com.mbridge.msdk.mbsignalcommon.communication.b.a(obj, "params is null");
            return;
        }
        Context contextG = com.mbridge.msdk.foundation.controller.b.d().g();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (contextG == null) {
            try {
                if ((obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).a) != null) {
                    contextG = windVaneWebView.getContext();
                }
            } catch (Exception e) {
                aa.d(this.a, e.getMessage());
            }
        }
        if (contextG == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("url");
            int iOptInt = jSONObject.optInt("type");
            if (iOptInt == 1) {
                com.mbridge.msdk.click.b.a(contextG, strOptString);
            } else if (iOptInt == 2) {
                com.mbridge.msdk.click.b.b(contextG, strOptString);
            }
        } catch (JSONException e2) {
            aa.d(this.a, e2.getMessage());
        } catch (Throwable th) {
            aa.d(this.a, th.getMessage());
        }
    }

    public final void f(Object obj, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int i = new JSONObject(str).getInt("countdown");
            com.mbridge.msdk.splash.d.a aVar = this.j;
            if (aVar != null) {
                aVar.b(i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void open(String str) {
        com.mbridge.msdk.splash.d.a aVar = this.j;
        if (aVar != null) {
            aVar.a(true, str);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void close() {
        aa.d(this.a, "close");
        try {
            com.mbridge.msdk.splash.d.a aVar = this.j;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Throwable th) {
            aa.b(this.a, "close", th);
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
            com.mbridge.msdk.splash.d.a aVar = this.j;
            if (aVar != null) {
                aVar.a(i);
            }
        } catch (Throwable th) {
            aa.b(this.a, "useCustomClose", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public final void expand(String str, boolean z) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putBoolean("shouldUseCustomClose", z);
            WeakReference<Context> weakReference = this.f2450b;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            SplashExpandDialog splashExpandDialog = this.k;
            if (splashExpandDialog == null || !splashExpandDialog.isShowing()) {
                SplashExpandDialog splashExpandDialog2 = new SplashExpandDialog(this.f2450b.get(), bundle, this.j);
                this.k = splashExpandDialog2;
                splashExpandDialog2.setCampaignList(this.d, this.c);
                this.k.show();
                com.mbridge.msdk.splash.d.a aVar = this.j;
                if (aVar != null) {
                    aVar.a(true);
                }
                com.mbridge.msdk.splash.e.a.a(this.d, getMraidCampaign(), str);
            }
        } catch (Throwable th) {
            aa.b(this.a, "expand", th);
        }
    }

    public final void g(Object obj, String str) {
        aa.a(this.a, "sendImpressions:" + str);
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
                        com.mbridge.msdk.foundation.same.a.d.a(this.d, campaignEx, "splash");
                        arrayList.add(string);
                    }
                }
            }
            new Thread(new Runnable() { // from class: com.mbridge.msdk.splash.signal.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        k kVarA = k.a(h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            kVarA.b((String) it.next());
                        }
                    } catch (Exception unused) {
                        aa.d(b.this.a, "campain can't insert db");
                    }
                }
            }).start();
        } catch (Throwable th) {
            aa.b(this.a, "sendImpressions", th);
        }
    }

    public final void h(Object obj, String str) {
        aa.a(this.a, "reportUrls:" + str);
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
                    List<CampaignEx> list = this.c;
                    com.mbridge.msdk.click.a.a(contextG, list != null ? list.get(0) : null, "", strA, false, iOptInt != 0);
                } else {
                    Context contextG2 = com.mbridge.msdk.foundation.controller.b.d().g();
                    List<CampaignEx> list2 = this.c;
                    com.mbridge.msdk.click.a.a(contextG2, list2 != null ? list2.get(0) : null, "", strA, false, iOptInt != 0, iOptInt2);
                }
            }
            g.a().a(obj, c.a(0));
        } catch (Throwable th) {
            aa.b(this.a, "reportUrls", th);
        }
    }

    public final void i(Object obj, String str) {
        try {
            if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
                g.a().a(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).a);
            }
        } catch (Throwable th) {
            aa.b(this.a, "onSignalCommunication", th);
        }
    }

    public final void j(Object obj, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", 0);
            jSONObject.put("message", "Call pause count down success.");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("countdown", this.i);
            jSONObject.put("data", jSONObject2);
            g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            aa.d(this.a, e.getMessage());
        }
        com.mbridge.msdk.splash.d.a aVar = this.j;
        if (aVar != null) {
            aVar.a(1, -1);
        }
    }

    public final void k(Object obj, String str) {
        int i = 0;
        if (!TextUtils.isEmpty(str)) {
            try {
                int iOptInt = new JSONObject(str).optInt("countdown");
                try {
                    g.a().a(obj, c.a(0));
                    i = iOptInt;
                } catch (Exception e) {
                    e = e;
                    i = iOptInt;
                    aa.d(this.a, e.getMessage());
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        com.mbridge.msdk.splash.d.a aVar = this.j;
        if (aVar != null) {
            aVar.a(2, i);
        }
    }
}
