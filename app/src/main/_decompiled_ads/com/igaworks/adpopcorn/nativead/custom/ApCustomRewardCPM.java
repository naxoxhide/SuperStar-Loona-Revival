package com.igaworks.adpopcorn.nativead.custom;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.igaworks.adpopcorn.a.d;
import com.igaworks.adpopcorn.cores.common.c;
import com.igaworks.adpopcorn.cores.common.h;
import com.igaworks.adpopcorn.cores.model.f;
import com.mbridge.msdk.MBridgeConstans;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ApCustomRewardCPM implements com.igaworks.adpopcorn.a.g.a.d {
    private WeakReference<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ApCustomRewardCPMEventListener f1632b;
    private List<com.igaworks.adpopcorn.cores.model.a> c;
    private com.igaworks.adpopcorn.cores.model.a d;
    private com.igaworks.adpopcorn.a.g.a e;
    private int f = -1;

    class a implements com.igaworks.adpopcorn.a.g.a.d {
        a(ApCustomRewardCPM apCustomRewardCPM) {
        }

        @Override // com.igaworks.adpopcorn.a.g.a.d
        public void onNetResponseListener(int i, f fVar) {
        }
    }

    class b implements com.igaworks.adpopcorn.a.g.a.d {
        b(ApCustomRewardCPM apCustomRewardCPM) {
        }

        @Override // com.igaworks.adpopcorn.a.g.a.d
        public void onNetResponseListener(int i, f fVar) {
        }
    }

    public ApCustomRewardCPM(Context context) {
        this.a = new WeakReference<>(context);
    }

    private void a() {
        ApCustomRewardCPMEventListener apCustomRewardCPMEventListener = this.f1632b;
        if (apCustomRewardCPMEventListener != null) {
            apCustomRewardCPMEventListener.onCustomRewardCPMClickSuccess();
        }
    }

    private void a(int i, String str) {
        ApCustomRewardCPMError apCustomRewardCPMError = new ApCustomRewardCPMError(i, str);
        ApCustomRewardCPMEventListener apCustomRewardCPMEventListener = this.f1632b;
        if (apCustomRewardCPMEventListener != null) {
            apCustomRewardCPMEventListener.onCustomRewardCPMClickFailed(apCustomRewardCPMError);
        }
    }

    private void a(f fVar) {
        int i;
        String str;
        com.igaworks.adpopcorn.a.g.a aVar;
        String str2;
        if (fVar == null || !fVar.d()) {
            if (fVar != null && fVar.a().length() > 0) {
                try {
                    h.a(this.a.get(), "ApCustomRewardCPM", "callbackCheckCampaign result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    if (!jSONObject.getBoolean("Result")) {
                        a(ApCustomRewardCPMError.PARTICIPATION_FAILED, ApCustomRewardCPMError.PARTICIPATION_FAILED_MESSAGE);
                        return;
                    }
                    String string = jSONObject.getString("Auth");
                    if (this.a.get() != null) {
                        d.a(this.a.get()).b("media_offerwall_tab_content_engagement", this.d.c());
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("auth", string);
                    jSONObject2.put("network", c.b(this.a.get()));
                    jSONObject2.put("channel_code", 6);
                    if (d.E) {
                        aVar = this.e;
                        str2 = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/joincampaign";
                    } else {
                        aVar = this.e;
                        str2 = "https://apapi.adpopcorn.com/ap/v1/sdk/media/joincampaign";
                    }
                    aVar.a(1, str2, jSONObject2, this);
                    return;
                } catch (JSONException unused) {
                }
            }
            i = 200;
            str = ApCustomRewardCPMError.EXCEPTION_MESSAGE;
        } else {
            i = 5000;
            str = "Server Timeout";
        }
        a(i, str);
    }

    private void a(String str) {
        com.igaworks.adpopcorn.a.g.a aVar;
        String str2;
        try {
            String strC = this.d.c();
            if (this.d == null) {
                h.a(this.a.get(), "ApCustomRewardCPM", "completeCampaign failed", 3);
                return;
            }
            h.a(this.a.get(), "ApCustomRewardCPM", "completeCampaign success", 3);
            if (this.e == null) {
                this.e = new com.igaworks.adpopcorn.a.g.a(this.a.get());
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("auth", str);
            jSONObject.put("network", c.b(this.a.get()));
            jSONObject.put("sign", c.a(strC, str));
            if (d.E) {
                aVar = this.e;
                str2 = "https://apapi-staging.adpopcorn.com/ap/v1/common/conversion/CompleteCPMClick";
            } else {
                aVar = this.e;
                str2 = "https://apapi.adpopcorn.com/ap/v1/common/conversion/CompleteCPMClick";
            }
            aVar.a(28, str2, jSONObject, this);
        } catch (Exception e) {
            h.a(this.a.get(), "ApCustomRewardCPM", "completeCampaign failed : " + e.getMessage(), 3);
        }
    }

    private int b(String str) {
        for (com.igaworks.adpopcorn.cores.model.a aVar : this.c) {
            if (aVar.h().contentEquals(str)) {
                return this.c.indexOf(aVar);
            }
        }
        return 0;
    }

    private void b() {
        try {
            h.a(this.a.get(), "ApCustomRewardCPM", "clickTracking", 3);
            if (this.d != null) {
                if (this.e == null) {
                    this.e = new com.igaworks.adpopcorn.a.g.a(this.a.get());
                }
                for (String str : this.d.d()) {
                    this.e.a(14, str, "", new b(this));
                }
            }
        } catch (Exception unused) {
        }
    }

    private void b(int i, String str) {
        ApCustomRewardCPMError apCustomRewardCPMError = new ApCustomRewardCPMError(i, str);
        ApCustomRewardCPMEventListener apCustomRewardCPMEventListener = this.f1632b;
        if (apCustomRewardCPMEventListener != null) {
            apCustomRewardCPMEventListener.onCustomRewardCPMLoadFailed(apCustomRewardCPMError);
        }
    }

    private void b(f fVar) {
        int i;
        String str;
        String strE;
        if (fVar == null || !fVar.d()) {
            if (fVar != null && fVar.a().length() > 0) {
                try {
                    h.a(this.a.get(), "ApCustomRewardCPM", "callbackJoinCPMCampaign result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z = jSONObject.getBoolean("Result");
                    String string = jSONObject.getString("CPMParticipatedTid");
                    if (!z) {
                        a(ApCustomRewardCPMError.PARTICIPATION_FAILED, ApCustomRewardCPMError.PARTICIPATION_FAILED_MESSAGE);
                        return;
                    }
                    b();
                    if (this.d.k() == 16) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(ScarConstants.TOKEN_ID_KEY, string);
                        String string2 = jSONObject2.toString();
                        try {
                            string2 = URLEncoder.encode(jSONObject2.toString(), "utf-8");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        strE = this.d.e() + "&custom=" + string2;
                    } else {
                        if (this.d.k() == 40) {
                            if (this.d.o()) {
                                h.a(this.a.get(), "ApCustomRewardCPM", "callbackJoinCPMCampaign already completed", 3);
                            } else {
                                a(jSONObject.getString("Auth"));
                            }
                        }
                        strE = this.d.e();
                    }
                    c(strE);
                    this.d.b(true);
                    a();
                    return;
                } catch (JSONException unused) {
                }
            }
            i = 200;
            str = ApCustomRewardCPMError.EXCEPTION_MESSAGE;
        } else {
            i = 5000;
            str = "Server Timeout";
        }
        a(i, str);
    }

    private void c() {
        List<com.igaworks.adpopcorn.cores.model.a> list;
        if (this.f1632b == null || (list = this.c) == null || list.size() <= 0) {
            b(1000, "Can not find available campaign");
        } else {
            this.f1632b.onCustomRewardCPMLoadSuccess(com.igaworks.adpopcorn.a.f.a.a(this.c));
        }
    }

    private void c(f fVar) {
        int i;
        String str;
        if (fVar == null || !fVar.d()) {
            if (fVar != null && fVar.a().length() > 0) {
                try {
                    h.a(this.a.get(), "ApCustomRewardCPM", "callbackJoinCampaign result = " + fVar.a(), 3);
                    JSONObject jSONObject = new JSONObject(fVar.a());
                    boolean z = jSONObject.getBoolean("Result");
                    String string = (!jSONObject.has("RedirectURL") || jSONObject.isNull("RedirectURL")) ? "" : jSONObject.getString("RedirectURL");
                    if (!z) {
                        a(ApCustomRewardCPMError.PARTICIPATION_FAILED, ApCustomRewardCPMError.PARTICIPATION_FAILED_MESSAGE);
                        return;
                    }
                    b();
                    h.a(this.a.get(), "ApCustomRewardCPM", "callbackJoinCampaign success, redirectURL = " + string, 3);
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setFlags(268435456);
                    intent.setData(Uri.parse(string));
                    this.a.get().startActivity(intent);
                    this.d.b(true);
                    a();
                    return;
                } catch (Exception unused) {
                }
            }
            i = 200;
            str = ApCustomRewardCPMError.EXCEPTION_MESSAGE;
        } else {
            i = 5000;
            str = "Server Timeout";
        }
        a(i, str);
    }

    private void c(String str) {
        try {
            h.a(this.a.get(), "ApCustomRewardCPM", "openWebBrowser = " + str, 3);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.setData(Uri.parse(str));
            this.a.get().startActivity(intent);
        } catch (Exception unused) {
            a(6001, ApCustomRewardCPMError.LANDING_FAILED_MESSAGE);
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002a  */
    private void d(f fVar) {
        int i;
        String str;
        if (fVar == null) {
            if (fVar != null) {
                return;
            } else {
                return;
            }
        }
        try {
            if (fVar.d()) {
                h.a(this.a.get(), "ApCustomRewardCPM", "callbackLoadNativeAd timeout", 3);
                i = 5000;
                str = "Server Timeout";
            } else {
                if (fVar != null || fVar.a().length() <= 0) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(fVar.a());
                boolean z = jSONObject.has("Result") ? jSONObject.getBoolean("Result") : false;
                int i2 = jSONObject.has("ResultCode") ? jSONObject.getInt("ResultCode") : 0;
                String string = jSONObject.has("ResultMsg") ? jSONObject.getString("ResultMsg") : "";
                if (!z) {
                    b(i2, string);
                    return;
                }
                h.a(this.a.get(), "ApCustomRewardCPM", "callbackLoadNativeAd success", 3);
                List<com.igaworks.adpopcorn.cores.model.a> listA = com.igaworks.adpopcorn.a.f.a.a(fVar.a(), this.f);
                this.c = listA;
                if (listA != null) {
                    c();
                    return;
                } else {
                    h.a(this.a.get(), "ApCustomRewardCPM", "callbackLoadNativeAd success, but no Ad", 3);
                    i = 1000;
                    str = "Can not find available campaign";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            b(200, ApCustomRewardCPMError.EXCEPTION_MESSAGE);
            return;
        }
        b(i, str);
    }

    public void clickCampaign(String str) {
        JSONObject jSONObject;
        int i;
        com.igaworks.adpopcorn.a.g.a aVar;
        String str2;
        try {
            h.a(this.a.get(), "ApCustomRewardCPM", "clickCampaign : " + str, 3);
            int iB = b(str);
            List<com.igaworks.adpopcorn.cores.model.a> list = this.c;
            if (list == null || list.get(iB) == null) {
                h.a(this.a.get(), "ApCustomRewardCPM", "clickCampaign failed", 3);
                return;
            }
            if (this.e == null) {
                this.e = new com.igaworks.adpopcorn.a.g.a(this.a.get());
            }
            com.igaworks.adpopcorn.cores.model.a aVar2 = this.c.get(iB);
            this.d = aVar2;
            if (aVar2.o() && this.d.k() != 16) {
                h.a(this.a.get(), "ApCustomRewardCPM", "clickCampaign already rewarded", 3);
                b();
                c(this.d.e());
                return;
            }
            if (this.d.n()) {
                jSONObject = new JSONObject();
                jSONObject.put("auth", this.d.a());
                jSONObject.put("network", c.b(this.a.get()));
                i = 2;
                if (d.E) {
                    aVar = this.e;
                    str2 = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/checkcampaign";
                } else {
                    aVar = this.e;
                    str2 = "https://apapi.adpopcorn.com/ap/v1/sdk/media/checkcampaign";
                }
            } else {
                jSONObject = new JSONObject();
                jSONObject.put(MBridgeConstans.APP_KEY, d.a(this.a.get()).e().b());
                jSONObject.put("adid", d.a(this.a.get()).e().a());
                jSONObject.put("usn", d.a(this.a.get()).e().g());
                jSONObject.put("integration_type_no", this.d.k());
                jSONObject.put("point", this.d.l());
                i = 27;
                if (d.E) {
                    aVar = this.e;
                    str2 = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/joincpmcampaign";
                } else {
                    aVar = this.e;
                    str2 = "https://apapi.adpopcorn.com/ap/v1/sdk/media/joincpmcampaign";
                }
            }
            aVar.a(i, str2, jSONObject, this);
        } catch (Exception e) {
            h.a(this.a.get(), "ApCustomRewardCPM", "clickCampaign failed : " + e.getMessage(), 3);
        }
    }

    public void destroy() {
        try {
            this.f1632b = null;
            List<com.igaworks.adpopcorn.cores.model.a> list = this.c;
            if (list != null) {
                list.clear();
            }
        } catch (Exception unused) {
        }
    }

    public void impressionCampaign(String str) {
        try {
            h.a(this.a.get(), "ApCustomRewardCPM", "impressionCampaign : " + str, 3);
            int iB = b(str);
            List<com.igaworks.adpopcorn.cores.model.a> list = this.c;
            if (list == null || list.get(iB) == null) {
                return;
            }
            com.igaworks.adpopcorn.cores.model.a aVar = this.c.get(iB);
            if (aVar.p()) {
                return;
            }
            aVar.d(true);
            if (this.e == null) {
                this.e = new com.igaworks.adpopcorn.a.g.a(this.a.get());
            }
            Iterator<String> it = aVar.j().iterator();
            while (it.hasNext()) {
                this.e.a(14, it.next(), "", new a(this));
            }
        } catch (Exception unused) {
        }
    }

    public void loadAd() {
        com.igaworks.adpopcorn.a.g.a aVar;
        String str;
        try {
            if (this.e == null) {
                this.e = new com.igaworks.adpopcorn.a.g.a(this.a.get());
            }
            if (d.E) {
                aVar = this.e;
                str = "https://apapi-staging.adpopcorn.com/ap/v1/sdk/media/nativerewardcpm";
            } else {
                aVar = this.e;
                str = "https://apapi.adpopcorn.com/ap/v1/sdk/media/nativerewardcpm";
            }
            aVar.a(26, str, this);
            if (this.a.get() != null) {
                d.a(this.a.get()).b("load_native_ad", "");
            }
        } catch (Exception unused) {
            b(200, ApCustomRewardCPMError.EXCEPTION_MESSAGE);
        }
    }

    @Override // com.igaworks.adpopcorn.a.g.a.d
    public void onNetResponseListener(int i, f fVar) {
        try {
            if (i == 1) {
                c(fVar);
                return;
            }
            if (i == 2) {
                a(fVar);
            } else if (i == 26) {
                d(fVar);
            } else {
                if (i != 27) {
                    return;
                }
                b(fVar);
            }
        } catch (Exception unused) {
        }
    }

    public void setCustomRewardCPMEventListener(ApCustomRewardCPMEventListener apCustomRewardCPMEventListener) {
        this.f1632b = apCustomRewardCPMEventListener;
    }

    public void setMaxCampaignCount(int i) {
        if (i > 0) {
            this.f = i;
        }
    }
}
