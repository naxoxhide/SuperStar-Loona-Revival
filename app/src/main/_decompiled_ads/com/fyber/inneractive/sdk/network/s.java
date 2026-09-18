package com.fyber.inneractive.sdk.network;

import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.Track;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.ImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.ads.mediation.pangle.PangleConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends l {

    public static class a {
        public static final SimpleDateFormat h = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        public InneractiveAdRequest a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public q f992b;
        public r c;
        public JSONArray d;
        public com.fyber.inneractive.sdk.response.e e;
        public JSONArray f;
        public boolean g;

        /* JADX INFO: renamed from: com.fyber.inneractive.sdk.network.s$a$a, reason: collision with other inner class name */
        public class RunnableC0274a implements Runnable {
            public final /* synthetic */ s a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f993b;
            public final /* synthetic */ String c;
            public final /* synthetic */ String d;
            public final /* synthetic */ String e;
            public final /* synthetic */ Object f;
            public final /* synthetic */ String g;

            public RunnableC0274a(s sVar, String str, String str2, String str3, String str4, Object obj, String str5) {
                this.a = sVar;
                this.f993b = str;
                this.c = str2;
                this.d = str3;
                this.e = str4;
                this.f = obj;
                this.g = str5;
            }

            @Override // java.lang.Runnable
            public void run() {
                String strE;
                boolean z;
                Map<String, Object> map;
                com.fyber.inneractive.sdk.response.e eVar;
                this.a.a("contentid", this.f993b);
                this.a.a("fairbidv", this.c);
                a aVar = a.this;
                q qVar = aVar.f992b;
                if (qVar != null) {
                    this.a.a(NotificationCompat.CATEGORY_ERROR, Integer.valueOf(qVar.val));
                    a.this.f992b.getClass();
                    strE = x0.ERROR_TABLE.e();
                    IAlog.a("Event dispatcher - dispatching error: %s", a.this.f992b);
                    int i = IAlog.a;
                    IAlog.a(1, null, "%s %s", "DISPATCHED_SDK_ERROR", Integer.valueOf(a.this.f992b.val));
                } else {
                    r rVar = aVar.c;
                    if (rVar != null) {
                        this.a.a("event", Integer.valueOf(rVar.val));
                        a.this.c.getClass();
                        strE = x0.EVENT_TABLE.e();
                        IAlog.a("Event dispatcher - dispatching event: %s", a.this.c);
                        int i2 = IAlog.a;
                        IAlog.a(1, null, "%s %s", "DISPATCHED_SDK_EVENT", Integer.valueOf(a.this.c.val));
                    } else {
                        strE = null;
                    }
                }
                if (!TextUtils.isEmpty(this.d)) {
                    this.a.a("placement_type", this.d);
                }
                if (!TextUtils.isEmpty(this.e)) {
                    this.a.a("spot_id", this.e);
                }
                if (!InneractiveAdManager.isCurrentUserAChild()) {
                    this.a.a("ciso", com.fyber.inneractive.sdk.util.j.g());
                }
                this.a.a("ad_type", this.f);
                if (a.this.g && !TextUtils.isEmpty(this.g)) {
                    this.a.c = this.g;
                }
                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
                this.a.a("n", com.fyber.inneractive.sdk.util.f0.e().key);
                this.a.a("date_created", Long.valueOf(calendar.getTimeInMillis()));
                try {
                    this.a.a("day", a.h.format(calendar.getTime()));
                } catch (Throwable unused) {
                }
                this.a.a("hour", Integer.valueOf(calendar.get(11)));
                s sVar = this.a;
                StringBuilder sbAppend = new StringBuilder().append(strE);
                a aVar2 = a.this;
                q qVar2 = aVar2.f992b;
                sVar.a("table", sbAppend.append(qVar2 != null ? String.valueOf(qVar2.val) : String.valueOf(aVar2.c.val)).toString());
                JSONArray jSONArray = a.this.d;
                if (jSONArray != null && jSONArray.length() > 0) {
                    this.a.a("experiments", a.this.d);
                }
                com.fyber.inneractive.sdk.response.e eVar2 = a.this.e;
                if (eVar2 != null && eVar2.B) {
                    this.a.a("sdk_bidding", "1");
                }
                if (InneractiveAdManager.isCurrentUserAChild()) {
                    this.a.a("child_mode", "1");
                }
                IAConfigManager iAConfigManager = IAConfigManager.M;
                this.a.a("ignite", iAConfigManager.E.d() && (eVar = a.this.e) != null && eVar.F != com.fyber.inneractive.sdk.ignite.k.NONE ? "1" : "0");
                this.a.a("ignitep", iAConfigManager.E.c);
                this.a.a("ignitev", iAConfigManager.E.d);
                JSONArray jSONArrayC = iAConfigManager.L.c();
                if (jSONArrayC != null && jSONArrayC.length() > 0) {
                    this.a.a("s_experiments", jSONArrayC);
                }
                JSONArray jSONArray2 = a.this.f;
                if (jSONArray2 == null || jSONArray2.length() <= 0) {
                    z = false;
                    break;
                }
                int i3 = 0;
                while (true) {
                    if (i3 >= jSONArray2.length()) {
                        z = false;
                        break;
                    } else {
                        if (jSONArray2.optJSONObject(i3).length() >= 1) {
                            z = true;
                            break;
                        }
                        i3++;
                    }
                }
                if (z) {
                    this.a.a("extra", a.this.f);
                }
                s sVar2 = this.a;
                sVar2.getClass();
                if ((TextUtils.isEmpty(sVar2.a) || (map = sVar2.f990b) == null || map.size() == 0) ? false : true) {
                    c cVar = IAConfigManager.M.H;
                    cVar.getClass();
                    JSONObject jSONObject = new JSONObject();
                    Map<String, Object> map2 = sVar2.f990b;
                    for (String str : map2.keySet()) {
                        Object obj = map2.get(str);
                        if (obj != null) {
                            try {
                                jSONObject.put(str, obj);
                            } catch (JSONException unused2) {
                            }
                        }
                    }
                    String strSubstring = sVar2.c;
                    if (strSubstring != null) {
                        int length = strSubstring.length();
                        if (length > 51200) {
                            int iIndexOf = strSubstring.indexOf("iawrapper");
                            if (iIndexOf == -1) {
                                iIndexOf = 0;
                            }
                            strSubstring = strSubstring.substring(iIndexOf, 51199);
                            IAlog.a("Sdk event dispatcher: message size %d is too long! trimming message to %d Characters", Integer.valueOf(length), 51200);
                        }
                        try {
                            jSONObject.put("ad", strSubstring);
                        } catch (JSONException e) {
                            IAlog.a("Failed inserting ad body to json", e, new Object[0]);
                        }
                    }
                    int i4 = IAlog.a;
                    int i5 = IAlog.a;
                    if (i4 == 1) {
                        try {
                            IAlog.a(1, null, "%s, Event: %s", "SDK_EVENT", jSONObject.toString());
                        } catch (Throwable unused3) {
                        }
                    }
                    cVar.a.offer(jSONObject);
                    if (cVar.a.size() > 30) {
                        Handler handler = cVar.d;
                        if (handler != null && handler.hasMessages(12312329)) {
                            cVar.d.removeMessages(12312329);
                        }
                        cVar.a(12312329, 0L);
                    }
                }
            }
        }

        public a(q qVar) {
            this(qVar, (InneractiveAdRequest) null, (com.fyber.inneractive.sdk.response.e) null, (JSONArray) null);
        }

        public a a(Object... objArr) {
            if (objArr.length > 0) {
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < objArr.length - 1; i += 2) {
                    String string = objArr[i].toString();
                    Object obj = objArr[i + 1];
                    try {
                        jSONObject.put(string, obj);
                    } catch (Exception unused) {
                        IAlog.e("Got exception adding param to json object: %s, %s", string, obj);
                    }
                }
                this.f.put(jSONObject);
            }
            return this;
        }

        public a(q qVar, InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar, JSONArray jSONArray) {
            this(eVar);
            this.f992b = qVar;
            this.a = inneractiveAdRequest;
            this.d = jSONArray;
        }

        public a(r rVar, InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.e eVar, JSONArray jSONArray) {
            this(eVar);
            this.c = rVar;
            this.a = inneractiveAdRequest;
            this.d = jSONArray;
        }

        /* JADX WARN: Code duplicated, block: B:77:0x00f1  */
        /* JADX WARN: Code duplicated, block: B:80:0x0100  */
        /* JADX WARN: Code duplicated, block: B:81:0x0102  */
        /* JADX WARN: Code duplicated, block: B:89:0x011c  */
        /* JADX WARN: Code duplicated, block: B:90:0x0121  */
        /* JADX WARN: Code duplicated, block: B:93:0x012e  */
        /* JADX WARN: Code duplicated, block: B:94:0x0130  */
        /* JADX WARN: Code duplicated, block: B:97:0x013b  */
        /* JADX WARN: Code duplicated, block: B:98:0x013e  */
        public void a(String str) {
            String str2;
            String str3;
            Long l;
            String str4;
            String str5;
            String campaignId;
            String str6;
            String spotId;
            StringBuilder sb;
            com.fyber.inneractive.sdk.response.e eVar;
            UnitDisplayType unitDisplayTypeA;
            String string;
            com.fyber.inneractive.sdk.response.e eVar2;
            Integer numValueOf;
            com.fyber.inneractive.sdk.response.e eVar3;
            String str7;
            InneractiveAdRequest inneractiveAdRequest;
            boolean zIsDeprecated;
            UnitDisplayType unitDisplayType;
            UnitDisplayType unitDisplayType2;
            com.fyber.inneractive.sdk.response.e eVar4 = this.e;
            if (eVar4 != null) {
                ImpressionData impressionData = eVar4.r;
                String impressionId = impressionData != null ? impressionData.getImpressionId() : null;
                ImpressionData impressionData2 = this.e.r;
                String demandSource = impressionData2 != null ? impressionData2.getDemandSource() : null;
                ImpressionData impressionData3 = this.e.r;
                Long demandId = impressionData3 != null ? impressionData3.getDemandId() : null;
                ImpressionData impressionData4 = this.e.r;
                String creativeId = impressionData4 != null ? impressionData4.getCreativeId() : null;
                ImpressionData impressionData5 = this.e.r;
                String advertiserDomain = impressionData5 != null ? impressionData5.getAdvertiserDomain() : null;
                ImpressionData impressionData6 = this.e.r;
                if (impressionData6 != null) {
                    str2 = impressionId;
                    str3 = demandSource;
                    l = demandId;
                    str4 = creativeId;
                    str5 = advertiserDomain;
                    campaignId = impressionData6.getCampaignId();
                } else {
                    str2 = impressionId;
                    campaignId = null;
                    str3 = demandSource;
                    l = demandId;
                    str4 = creativeId;
                    str5 = advertiserDomain;
                }
            } else {
                str2 = null;
                str3 = null;
                l = null;
                str4 = null;
                str5 = null;
                campaignId = null;
            }
            IAConfigManager iAConfigManager = IAConfigManager.M;
            s sVar = new s(iAConfigManager.c, str2, str3, l, str4, str5, campaignId, str);
            InneractiveAdRequest inneractiveAdRequest2 = this.a;
            com.fyber.inneractive.sdk.config.b0 selectedUnitConfig = inneractiveAdRequest2 == null ? null : inneractiveAdRequest2.getSelectedUnitConfig();
            if (selectedUnitConfig != null) {
                com.fyber.inneractive.sdk.config.a0 a0Var = (com.fyber.inneractive.sdk.config.a0) selectedUnitConfig;
                com.fyber.inneractive.sdk.config.x xVar = a0Var.d;
                Track track = Track.ERRORS;
                Set<Track> set = xVar.a;
                if (!(set == null ? false : set.contains(track))) {
                    return;
                }
                com.fyber.inneractive.sdk.config.t tVar = a0Var.c;
                if (tVar != null && (unitDisplayType2 = tVar.f899b) != null) {
                    zIsDeprecated = unitDisplayType2.isDeprecated();
                } else {
                    com.fyber.inneractive.sdk.config.c0 c0Var = a0Var.f;
                    zIsDeprecated = (c0Var == null || (unitDisplayType = c0Var.j) == null) ? false : unitDisplayType.isDeprecated();
                }
                if (zIsDeprecated) {
                    return;
                }
            }
            com.fyber.inneractive.sdk.response.e eVar5 = this.e;
            String str8 = eVar5 == null ? null : eVar5.d;
            String str9 = TextUtils.isEmpty(iAConfigManager.t) ? null : iAConfigManager.t;
            if (this.f992b == null && this.c == null) {
                IAlog.a("Sdk event dispatcher - error id or event id must be provided", new Object[0]);
                return;
            }
            InneractiveAdRequest inneractiveAdRequest3 = this.a;
            if (inneractiveAdRequest3 == null) {
                com.fyber.inneractive.sdk.response.e eVar6 = this.e;
                if (eVar6 != null) {
                    spotId = eVar6.A;
                } else {
                    str6 = null;
                }
                sb = new StringBuilder();
                if (!TextUtils.isEmpty(iAConfigManager.m)) {
                    sb.append(iAConfigManager.m).append("_");
                }
                eVar = this.e;
                if (eVar == null) {
                    unitDisplayTypeA = null;
                } else {
                    unitDisplayTypeA = eVar.n;
                }
                if (unitDisplayTypeA == null && (inneractiveAdRequest = this.a) != null && inneractiveAdRequest.getSpotId() != null) {
                    unitDisplayTypeA = com.fyber.inneractive.sdk.serverapi.a.a(this.a.getSpotId());
                }
                if (unitDisplayTypeA != null) {
                    string = unitDisplayTypeA.toString();
                } else {
                    string = "unknown";
                }
                sb.append(string);
                String string2 = sb.toString();
                eVar2 = this.e;
                if (eVar2 == null) {
                    numValueOf = null;
                } else {
                    numValueOf = Integer.valueOf(eVar2.g);
                }
                eVar3 = this.e;
                if (eVar3 == null) {
                    str7 = "";
                } else {
                    str7 = eVar3.h;
                }
                com.fyber.inneractive.sdk.util.m.a(new RunnableC0274a(sVar, str8, str9, string2, str6, numValueOf, str7));
            }
            spotId = inneractiveAdRequest3.getSpotId();
            str6 = spotId;
            sb = new StringBuilder();
            if (!TextUtils.isEmpty(iAConfigManager.m)) {
                sb.append(iAConfigManager.m).append("_");
            }
            eVar = this.e;
            if (eVar == null) {
                unitDisplayTypeA = null;
            } else {
                unitDisplayTypeA = eVar.n;
            }
            if (unitDisplayTypeA == null) {
                unitDisplayTypeA = com.fyber.inneractive.sdk.serverapi.a.a(this.a.getSpotId());
            }
            if (unitDisplayTypeA != null) {
                string = unitDisplayTypeA.toString();
            } else {
                string = "unknown";
            }
            sb.append(string);
            String string3 = sb.toString();
            eVar2 = this.e;
            if (eVar2 == null) {
                numValueOf = null;
            } else {
                numValueOf = Integer.valueOf(eVar2.g);
            }
            eVar3 = this.e;
            if (eVar3 == null) {
                str7 = "";
            } else {
                str7 = eVar3.h;
            }
            com.fyber.inneractive.sdk.util.m.a(new RunnableC0274a(sVar, str8, str9, string3, str6, numValueOf, str7));
        }

        public a(com.fyber.inneractive.sdk.response.e eVar) {
            this.g = false;
            this.e = eVar;
            this.f = new JSONArray();
        }
    }

    public static class b {
        public JSONObject a = new JSONObject();

        public b a(String str, Object obj) {
            try {
                this.a.put(str, obj);
            } catch (Exception unused) {
                IAlog.e("Got exception adding param to json object: %s, %s", str, obj);
            }
            return this;
        }
    }

    public s(String str, String str2, String str3, Long l, String str4, String str5, String str6, String str7) {
        super(com.fyber.inneractive.sdk.config.a.b());
        a("osn", "Android");
        a("osv", Build.VERSION.RELEASE);
        a(DeviceRequestsHelper.DEVICE_INFO_MODEL, com.fyber.inneractive.sdk.util.j.h());
        a("sdkv", str7 == null ? "8.2.4" : str7);
        a("pkgn", com.fyber.inneractive.sdk.util.j.k());
        a("pkgv", com.fyber.inneractive.sdk.util.j.l());
        a(PangleConstants.APP_ID, str);
        a("session", str2);
        a("adnt", str3);
        a("adnt_id", l);
        a(CampaignEx.JSON_KEY_CREATIVE_ID, str4);
        a("adomain", str5);
        a(FirebaseAnalytics.Param.CAMPAIGN_ID, str6);
    }
}
