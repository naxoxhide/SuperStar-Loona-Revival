package com.bytedance.sdk.openadsdk.multipro.aidl.d;

import android.content.ContentValues;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.settings.j;
import java.util.Map;

/* JADX INFO: compiled from: ProviderListenerManagerImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends b.b.a.a.i.a.g.a {
    private static volatile f a;

    public static f b() {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f();
                }
            }
        }
        return a;
    }

    @Override // b.b.a.a.i.a.g
    public Map a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (!j.a()) {
            return null;
        }
        try {
            return com.bytedance.sdk.openadsdk.m.f.a.a(com.bytedance.sdk.openadsdk.m.e.a(o.a()).a(uri, strArr, str, strArr2, str2));
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // b.b.a.a.i.a.g
    public String a(Uri uri) {
        if (j.a()) {
            return com.bytedance.sdk.openadsdk.m.e.a(o.a()).a(uri);
        }
        return null;
    }

    @Override // b.b.a.a.i.a.g
    public String a(Uri uri, ContentValues contentValues) {
        Uri uriA;
        if (j.a() && (uriA = com.bytedance.sdk.openadsdk.m.e.a(o.a()).a(uri, contentValues)) != null) {
            return uriA.toString();
        }
        return null;
    }

    @Override // b.b.a.a.i.a.g
    public int a(Uri uri, String str, String[] strArr) {
        if (j.a()) {
            return com.bytedance.sdk.openadsdk.m.e.a(o.a()).a(uri, str, strArr);
        }
        return 0;
    }

    @Override // b.b.a.a.i.a.g
    public int a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (j.a()) {
            return com.bytedance.sdk.openadsdk.m.e.a(o.a()).a(uri, contentValues, str, strArr);
        }
        return 0;
    }
}
