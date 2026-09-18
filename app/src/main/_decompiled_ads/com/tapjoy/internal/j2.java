package com.tapjoy.internal;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import com.adxcorp.util.ADXLogUtil;
import com.tapjoy.Tapjoy;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class j2 extends h2 {
    public static j2 c;

    public j2(Context context) {
        super(context, new i2());
    }

    /* JADX WARN: Code duplicated, block: B:111:0x0206  */
    /* JADX WARN: Code duplicated, block: B:97:0x01d8  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r4v8, types: [android.text.Spanned] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r8v42 */
    public static void a(Context context, Map map) {
        int iIntValue;
        Intent intent;
        Notification notificationB;
        Spanned spannedFromHtml;
        int iIntValue2;
        int iIntValue3;
        String str;
        int i;
        CharSequence charSequenceSubSequence;
        Bundle bundle;
        CharSequence applicationLabel;
        String str2 = (String) map.get("fiverocks");
        if (str2 != null) {
            Boolean bool = d3.a(context).c.w;
            Boolean bool2 = ra.y;
            if (bool == null) {
                bool2.getClass();
                bool = bool2;
            }
            if (bool.booleanValue()) {
                v1 v1Var = v1.m;
                v1Var.b(context);
                p1 p1Var = v1Var.f;
                p1Var.getClass();
                n1 n1VarA = p1Var.a(r1.APP, "push_ignore");
                Objects.requireNonNull(g0.e, "unknownFields == null");
                p1Var.a(n1VarA);
                return;
            }
            String str3 = (String) map.get("title");
            ?? FromHtml = (String) map.get("message");
            if (FromHtml != 0) {
                String str4 = (String) map.get("rich");
                String str5 = (String) map.get("sound");
                String str6 = (String) map.get("payload");
                String str7 = (String) map.get("always");
                boolean z = "true".equals(str7) || Boolean.TRUE.equals(str7);
                String str8 = (String) map.get("repeatable");
                boolean z2 = "true".equals(str8) || Boolean.TRUE.equals(str8);
                String str9 = (String) map.get("placement");
                Object obj = map.get("nid");
                if (obj instanceof Number) {
                    iIntValue = ((Number) obj).intValue();
                } else if (obj instanceof String) {
                    try {
                        iIntValue = Integer.parseInt((String) obj);
                    } catch (NumberFormatException unused) {
                        iIntValue = 0;
                    }
                } else {
                    iIntValue = 0;
                }
                String string = (String) map.get("channel_id");
                if (!z) {
                    v1 v1Var2 = v1.m;
                    v1Var2.b(context);
                    y6 y6Var = v1Var2.g;
                    if (y6Var != null && y6Var.f2834b.get()) {
                        return;
                    }
                }
                if (str3 == null) {
                    str3 = "";
                }
                Boolean bool3 = Boolean.TRUE;
                boolean z3 = bool3.equals(str4) || "true".equals(str4);
                boolean z4 = bool3.equals(str5) || "true".equals(str5);
                PackageManager packageManager = context.getPackageManager();
                String packageName = context.getPackageName();
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.setPackage(packageName);
                intent2.addCategory("android.intent.category.LAUNCHER");
                List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent2, 0);
                if (listQueryIntentActivities == null || listQueryIntentActivities.size() <= 0) {
                    intent = null;
                } else {
                    intent = new Intent(intent2);
                    intent.setFlags(268435456);
                    intent.setClassName(listQueryIntentActivities.get(0).activityInfo.packageName, listQueryIntentActivities.get(0).activityInfo.name);
                }
                if (intent != null) {
                    intent.setAction("com.tapjoy.PUSH_CLICK");
                    intent.setPackage(context.getPackageName());
                    intent.putExtra("com.tapjoy.PUSH_ID", str2);
                    if (str6 != null) {
                        intent.putExtra(Tapjoy.INTENT_EXTRA_PUSH_PAYLOAD, str6);
                    }
                    if (str9 != null) {
                        intent.putExtra("com.tapjoy.PUSH_PLACEMENT", str9);
                    }
                }
                int i2 = Build.VERSION.SDK_INT;
                PendingIntent activity = PendingIntent.getActivity(context.getApplicationContext(), iIntValue, intent, i2 >= 23 ? 67108864 : 134217728);
                if (activity == null) {
                    notificationB = null;
                } else {
                    PackageManager packageManager2 = context.getPackageManager();
                    try {
                        ApplicationInfo applicationInfo = packageManager2.getApplicationInfo(context.getPackageName(), 128);
                        int length = str3.length();
                        CharSequence charSequence = str3;
                        if (length == 0) {
                            applicationLabel = packageManager2.getApplicationLabel(applicationInfo);
                        } else if (z3) {
                            spannedFromHtml = Html.fromHtml(str3);
                        }
                        if (z3) {
                            charSequence = spannedFromHtml;
                            charSequence = applicationLabel;
                            FromHtml = Html.fromHtml(FromHtml);
                        }
                        charSequence = spannedFromHtml;
                        charSequence = applicationLabel;
                        Bundle bundle2 = applicationInfo.metaData;
                        if (bundle2 != null) {
                            Object obj2 = bundle2.get("com.tapjoy.notification.icon");
                            if (obj2 instanceof Integer) {
                                iIntValue2 = ((Integer) obj2).intValue();
                                try {
                                    if (!"drawable".equals(context.getResources().getResourceTypeName(iIntValue2))) {
                                        iIntValue2 = 0;
                                    }
                                } catch (Resources.NotFoundException unused2) {
                                }
                            } else {
                                iIntValue2 = 0;
                            }
                        } else {
                            iIntValue2 = 0;
                        }
                        if (iIntValue2 == 0 && (iIntValue2 = applicationInfo.icon) == 0) {
                            iIntValue2 = R.drawable.sym_def_app_icon;
                        }
                        Bundle bundle3 = applicationInfo.metaData;
                        if (bundle3 != null) {
                            Object obj3 = bundle3.get("com.tapjoy.notification.icon.large");
                            if (obj3 instanceof Integer) {
                                iIntValue3 = ((Integer) obj3).intValue();
                                try {
                                    if (!"drawable".equals(context.getResources().getResourceTypeName(iIntValue3))) {
                                        iIntValue3 = 0;
                                    }
                                } catch (Resources.NotFoundException unused3) {
                                }
                            } else {
                                iIntValue3 = 0;
                            }
                        } else {
                            iIntValue3 = 0;
                        }
                        Bitmap bitmapDecodeResource = iIntValue3 != 0 ? BitmapFactory.decodeResource(context.getResources(), iIntValue3) : null;
                        if (string == null && (bundle = applicationInfo.metaData) != null) {
                            string = bundle.getString("com.tapjoy.notification.default_channel_id", "tapjoy");
                        }
                        if (i2 >= 26) {
                            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                            if (string == null || notificationManager.getNotificationChannel(string) == null) {
                                notificationManager.createNotificationChannel(new NotificationChannel("tapjoy", ADXLogUtil.PLATFORM_TAPJOY, 3));
                                str = "tapjoy";
                            } else {
                                str = string;
                            }
                        } else {
                            str = null;
                        }
                        y4 y4Var = new y4(context, str);
                        Notification notification = y4Var.k;
                        notification.icon = iIntValue2;
                        if (charSequence != null && charSequence.length() > 5120) {
                            i = 0;
                            charSequenceSubSequence = charSequence.subSequence(0, 5120);
                        } else {
                            i = 0;
                            charSequenceSubSequence = charSequence;
                        }
                        notification.tickerText = charSequenceSubSequence;
                        y4Var.c = (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(i, 5120) : charSequence;
                        y4Var.d = (FromHtml != 0 && FromHtml.length() > 5120) ? FromHtml.subSequence(i, 5120) : FromHtml;
                        y4Var.e = activity;
                        y4Var.k.flags |= 16;
                        y4Var.g = i;
                        x4 x4Var = new x4();
                        CharSequence charSequenceSubSequence2 = charSequence;
                        if (charSequence != null && charSequence.length() > 5120) {
                            charSequenceSubSequence2 = charSequence;
                            charSequenceSubSequence2 = charSequence.subSequence(i, 5120);
                        }
                        charSequenceSubSequence2 = charSequence;
                        x4Var.f2838b = charSequenceSubSequence2;
                        ?? SubSequence = FromHtml;
                        if (FromHtml != 0 && FromHtml.length() > 5120) {
                            SubSequence = FromHtml;
                            SubSequence = FromHtml.subSequence(i, 5120);
                        }
                        SubSequence = FromHtml;
                        x4Var.c = SubSequence;
                        y4 y4VarA = y4Var.a(x4Var);
                        if (z4) {
                            y4VarA.k.defaults = 1;
                        }
                        if (bitmapDecodeResource != null) {
                            y4VarA.f = bitmapDecodeResource;
                        }
                        notificationB = new b5(y4VarA).b();
                    } catch (PackageManager.NameNotFoundException unused4) {
                        notificationB = null;
                    }
                }
                v1 v1Var3 = v1.m;
                v1Var3.b(context);
                if (v1Var3.a(context, str2, z2)) {
                    ((NotificationManager) context.getSystemService("notification")).notify(iIntValue, notificationB);
                }
            }
        }
    }
}
