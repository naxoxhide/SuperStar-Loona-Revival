package com.bytedance.sdk.openadsdk.m.h;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import b.b.a.a.i.a.g;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.m.d;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.tapjoy.TJAdUnitConstants;

/* JADX INFO: compiled from: FrequentCallProviderImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements com.bytedance.sdk.openadsdk.m.a {
    public static boolean a(String str) {
        if (o.a() == null) {
            return false;
        }
        try {
            g gVarD = d();
            if (gVarD != null) {
                return "true".equals(gVarD.a(Uri.parse(e() + "checkFrequency?rit=" + String.valueOf(str))));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String c() {
        if (o.a() == null) {
            return null;
        }
        try {
            g gVarD = d();
            if (gVarD != null) {
                return gVarD.a(Uri.parse(e() + "maxRit"));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static g d() {
        try {
            if (o.a() != null) {
                return com.bytedance.sdk.openadsdk.m.f.a.a(o.a());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String e() {
        return d.f791b + RemoteSettings.FORWARD_SLASH_STRING + "t_frequent" + RemoteSettings.FORWARD_SLASH_STRING;
    }

    public static boolean f() {
        if (o.a() == null) {
            return false;
        }
        try {
            g gVarD = d();
            if (gVarD != null) {
                return "true".equals(gVarD.a(Uri.parse(e() + "isSilent")));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public int a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public int a(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public Uri a(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public String b() {
        return "t_frequent";
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public String a(Uri uri) {
        m.a("FrequentCallProviderImpl", "get type uri: " + String.valueOf(uri));
        String str = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING)[2];
        if ("checkFrequency".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.e0.a.a().a(uri.getQueryParameter("rit")) ? "true" : TJAdUnitConstants.String.FALSE;
        }
        if ("isSilent".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.e0.a.a().c() ? "true" : TJAdUnitConstants.String.FALSE;
        }
        if ("maxRit".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.e0.a.a().b();
        }
        return null;
    }
}
