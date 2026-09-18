package com.tapjoy.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public abstract class t1 {
    public static void a(Activity activity) {
        v1 v1Var = v1.m;
        v1Var.getClass();
        if (activity != null) {
            Looper.myLooper();
            Looper.getMainLooper();
            Application application = activity.getApplication();
            synchronized (t.class) {
                if (t.a != application) {
                    t.a = application;
                }
            }
            t.f2813b++;
            t.c.a(activity);
            t.d.add(activity);
            if (v1Var.b() && v1Var.d()) {
                q.a(activity);
            }
        }
    }

    public static void b(Activity activity) {
        v1 v1Var = v1.m;
        v1Var.getClass();
        if (activity != null) {
            Looper.myLooper();
            Looper.getMainLooper();
            t.f2813b--;
            t.c.a = null;
            t.d.remove(activity);
            if (t.f2813b < 0) {
                t.f2813b = 0;
            }
            if (v1Var.b()) {
                if (t.f2813b > 0) {
                    return;
                }
                y6 y6Var = v1Var.g;
                if (y6Var.f2834b.get()) {
                    y6Var.c.run();
                }
            }
        }
    }

    public static void a(String str, String str2, String str3, String str4) {
        v1 v1Var = v1.m;
        if (v1Var.b()) {
            long jV = 0;
            try {
                d4 d4VarA = b4.a(str);
                d4VarA.a(3);
                String strM = null;
                String strM2 = null;
                String strM3 = null;
                while (d4VarA.c()) {
                    String strL = d4VarA.l();
                    if (InAppPurchaseMetaData.KEY_PRODUCT_ID.equals(strL)) {
                        strM2 = d4VarA.m();
                    } else if ("type".equals(strL)) {
                        d4VarA.m();
                    } else if ("price".equals(strL)) {
                        d4VarA.m();
                    } else if ("title".equals(strL)) {
                        d4VarA.m();
                    } else if ("description".equals(strL)) {
                        d4VarA.m();
                    } else if ("price_currency_code".equals(strL)) {
                        strM3 = d4VarA.m();
                    } else if ("price_amount_micros".equals(strL)) {
                        jV = d4VarA.v();
                    } else {
                        d4VarA.r();
                    }
                }
                d4VarA.a(4);
                String strA = u.a(strM2);
                String strA2 = u.a(strM3);
                if (strA == null || strA2 == null || strA2.length() != 3) {
                    return;
                }
                String strA3 = u.a(str2);
                String strA4 = u.a(str3);
                if (strA3 != null && strA4 != null) {
                    try {
                        d4 d4VarA2 = b4.a(strA3);
                        d4VarA2.a(3);
                        String strM4 = null;
                        String strM5 = null;
                        while (d4VarA2.c()) {
                            String strL2 = d4VarA2.l();
                            if ("orderId".equals(strL2)) {
                                strM = d4VarA2.m();
                            } else if ("packageName".equals(strL2)) {
                                strM4 = d4VarA2.m();
                            } else if (InAppPurchaseMetaData.KEY_PRODUCT_ID.equals(strL2)) {
                                strM5 = d4VarA2.m();
                            } else if ("purchaseTime".equals(strL2)) {
                                d4VarA2.v();
                            } else if ("purchaseState".equals(strL2)) {
                                d4VarA2.i();
                            } else if (SDKConstants.PARAM_DEVELOPER_PAYLOAD.equals(strL2)) {
                                d4VarA2.m();
                            } else if (SDKConstants.PARAM_PURCHASE_TOKEN.equals(strL2)) {
                                d4VarA2.m();
                            } else {
                                d4VarA2.r();
                            }
                        }
                        d4VarA2.a(4);
                        if (!TextUtils.isEmpty(strM) && !TextUtils.isEmpty(strM4)) {
                            TextUtils.isEmpty(strM5);
                        }
                    } catch (IOException unused) {
                    }
                }
                v1Var.f.a(strA, strA2.toUpperCase(Locale.US), jV / 1000000.0d, strA3, strA4, u.a(str4));
            } catch (IOException unused2) {
            }
        }
    }
}
