package com.bytedance.sdk.openadsdk.m;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.m;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: TTProviderManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements a {
    private static volatile e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static List<a> f792b;

    static {
        List<a> listSynchronizedList = Collections.synchronizedList(new ArrayList());
        f792b = listSynchronizedList;
        listSynchronizedList.add(new com.bytedance.sdk.openadsdk.m.i.c());
        f792b.add(new com.bytedance.sdk.openadsdk.m.f.b());
        f792b.add(new com.bytedance.sdk.openadsdk.m.h.a());
        f792b.add(new com.bytedance.sdk.openadsdk.d.p.e(new b.b.a.a.i.a.k.f.b()));
        Iterator<a> it = f792b.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    private e() {
    }

    public static e a(Context context) {
        if (context != null) {
            new WeakReference(context.getApplicationContext());
        }
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e();
                }
            }
        }
        return a;
    }

    private boolean b(Uri uri) {
        return true;
    }

    private a c(Uri uri) {
        if (uri == null) {
            return null;
        }
        if (!b(uri)) {
            m.a("TTProviderManager", "uri is error1");
            return null;
        }
        String[] strArrSplit = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING);
        if (strArrSplit.length < 2) {
            m.a("TTProviderManager", "uri is error2");
            return null;
        }
        String str = strArrSplit[1];
        if (TextUtils.isEmpty(str)) {
            m.a("TTProviderManager", "uri is error3");
            return null;
        }
        for (a aVar : f792b) {
            if (str.equals(aVar.b())) {
                return aVar;
            }
        }
        m.a("TTProviderManager", "uri is error4");
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public String b() {
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            a aVarC = c(uri);
            if (aVarC != null) {
                return aVarC.a(uri, strArr, str, strArr2, str2);
            }
        } catch (Throwable th) {
            m.a("TTProviderManager", "==provider query error==", th);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public String a(Uri uri) {
        try {
            a aVarC = c(uri);
            if (aVarC != null) {
                return aVarC.a(uri);
            }
        } catch (Throwable th) {
            m.a("TTProviderManager", "==provider getType error==", th);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public Uri a(Uri uri, ContentValues contentValues) {
        try {
            a aVarC = c(uri);
            if (aVarC != null) {
                return aVarC.a(uri, contentValues);
            }
        } catch (Throwable th) {
            m.a("TTProviderManager", "==provider insert error==", th);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public int a(Uri uri, String str, String[] strArr) {
        try {
            a aVarC = c(uri);
            if (aVarC != null) {
                return aVarC.a(uri, str, strArr);
            }
        } catch (Throwable th) {
            m.a("TTProviderManager", "==provider delete error==", th);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public int a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            a aVarC = c(uri);
            if (aVarC != null) {
                return aVarC.a(uri, contentValues, str, strArr);
            }
        } catch (Throwable th) {
            m.a("TTProviderManager", "==provider update error==", th);
        }
        return 0;
    }
}
