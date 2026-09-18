package com.mbridge.msdk.foundation.tools;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.mbridge.msdk.MBridgeConstans;
import com.tapjoy.TapjoyConstants;
import org.json.JSONObject;

/* JADX INFO: compiled from: DomainSameDiTool.java */
/* JADX INFO: loaded from: classes4.dex */
public class g {
    private static volatile String a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f2215b = null;
    private static String c = "";
    private static String d = "";
    private static boolean e = false;
    private static boolean f = false;
    private static int g;

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            Class<?> cls = Class.forName("com.mbridge.msdk.mbsignalcommon.webEnvCheck.WebEnvCheckEntry");
            cls.getMethod("check", Context.class).invoke(cls.newInstance(), context);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String a() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return "";
        }
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.g()) {
            return TextUtils.isEmpty(a) ? "" : a;
        }
        if (TextUtils.isEmpty(a)) {
            w.z();
            if (!f) {
                b(com.mbridge.msdk.foundation.controller.b.d().g());
                f = true;
            }
            return TextUtils.isEmpty(a) ? "" : a;
        }
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.h()) {
            return a;
        }
        return g == 0 ? a : "";
    }

    public static int b() {
        return g;
    }

    public static void a(int i) {
        g = i;
    }

    public static void a(String str) {
        f2215b = u.a(str);
        a = str;
    }

    public static String c() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return "";
        }
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.g()) {
            return TextUtils.isEmpty(f2215b) ? "" : f2215b;
        }
        if (TextUtils.isEmpty(f2215b)) {
            if (!f) {
                b(com.mbridge.msdk.foundation.controller.b.d().g());
                f = true;
            }
            return "";
        }
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.h()) {
            return f2215b;
        }
        return g == 0 ? f2215b : "";
    }

    public static void b(final Context context) {
        new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.g.1
            @Override // java.lang.Runnable
            public final void run() {
                if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID) && com.mbridge.msdk.foundation.controller.authoritycontroller.a.g()) {
                    int i = 1;
                    try {
                        Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                        AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                        g.a(advertisingIdInfo.getId());
                        int unused = g.g = advertisingIdInfo.isLimitAdTrackingEnabled() ? 1 : 0;
                        g.a(context, advertisingIdInfo.getId(), g.g);
                    } catch (Exception e2) {
                        aa.c("DomainSameDiTool", e2.getMessage());
                        try {
                            b.a aVarA = new b().a(context);
                            g.a(aVarA.a());
                            if (!aVarA.b()) {
                                i = 0;
                            }
                            int unused2 = g.g = i;
                            g.a(context, aVarA.a(), g.g);
                        } catch (Exception e3) {
                            aa.c("DomainSameDiTool", e3.getMessage());
                        }
                    } catch (Throwable th) {
                        aa.d("DomainSameDiTool", th.getMessage());
                    }
                }
            }
        }).start();
    }

    public static String d() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return "";
        }
        if (e) {
            return c;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                ContentResolver contentResolver = com.mbridge.msdk.foundation.controller.b.d().g().getContentResolver();
                int i = Settings.Secure.getInt(contentResolver, "limit_ad_tracking");
                String string = Settings.Secure.getString(contentResolver, TapjoyConstants.TJC_ADVERTISING_ID);
                jSONObject.put("status", i);
                jSONObject.put("amazonId", string);
                String string2 = jSONObject.toString();
                if (!TextUtils.isEmpty(string2)) {
                    d = string2;
                    c = u.a(string2);
                }
            } catch (Settings.SettingNotFoundException e2) {
                aa.d("DomainSameDiTool", e2.getMessage());
            }
        } catch (Throwable th) {
            aa.d("DomainSameDiTool", th.getMessage());
        }
        e = true;
        return c;
    }

    public static String e() {
        if (TextUtils.isEmpty(d) && !e) {
            d();
        }
        return d;
    }

    static /* synthetic */ void a(Context context, String str, int i) {
        try {
            if (ak.b(str)) {
                ai.a(context, MBridgeConstans.SP_GA_ID, str);
            }
            ai.a(context, MBridgeConstans.SP_GA_ID_LIMIT, Integer.valueOf(i));
        } catch (Exception e2) {
            aa.d("DomainSameDiTool", e2.getMessage());
        }
    }
}
