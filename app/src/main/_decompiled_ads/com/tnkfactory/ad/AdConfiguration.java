package com.tnkfactory.ad;

import android.content.Context;
import com.tnkfactory.ad.pub.a.y0;
import com.tnkfactory.ad.pub.b.f;

/* JADX INFO: loaded from: classes4.dex */
public class AdConfiguration {
    public static void enableLogging(boolean z) {
        Logger.enableLogging(z);
    }

    public static String getAdid() {
        return f.x.c;
    }

    public static void setCOPPA(Context context, boolean z) {
        y0.a(context).a(z ? 1 : 0);
    }

    public static void setContentRating(Context context, int i) {
    }

    public static void setGDPRConsent(Context context, boolean z) {
        y0.a(context).b(z ? 1 : 0);
    }

    public static void setPublisherId(Context context, String str) {
        y0.a(context).b(str.replaceAll("-", "").trim());
    }
}
