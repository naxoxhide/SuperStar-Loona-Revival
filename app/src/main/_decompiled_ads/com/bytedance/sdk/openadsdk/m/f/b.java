package com.bytedance.sdk.openadsdk.m.f;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.openadsdk.core.e;
import com.bytedance.sdk.openadsdk.core.o;
import com.google.firebase.sessions.settings.RemoteSettings;

/* JADX INFO: compiled from: DBMultiProviderImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements com.bytedance.sdk.openadsdk.m.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f794b = new Object();
    private Context a;

    private boolean b(Uri uri) {
        boolean z = uri == null || TextUtils.isEmpty(uri.getPath());
        if (z) {
            m.a("DBMultiProviderImpl", "==check uri is null==");
        }
        return z;
    }

    private Context c() {
        Context context = this.a;
        return context == null ? o.a() : context;
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        synchronized (f794b) {
            if (b(uri)) {
                return null;
            }
            String[] strArrSplit = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING);
            if (strArrSplit != null && strArrSplit.length >= 4) {
                String str3 = strArrSplit[2];
                String str4 = strArrSplit[3];
                if (!"ttopensdk.db".equals(str3)) {
                    return null;
                }
                return e.a(c()).c().a(str4, strArr, str, strArr2, null, null, str2);
            }
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public String b() {
        return "t_db";
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public String a(Uri uri) {
        synchronized (f794b) {
            if (b(uri)) {
                return null;
            }
            String[] strArrSplit = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING);
            if (strArrSplit != null && strArrSplit.length >= 5) {
                String str = strArrSplit[2];
                String str2 = strArrSplit[3];
                String str3 = strArrSplit[4];
                if ("ttopensdk.db".equals(str)) {
                    if ("execSQL".equals(str3)) {
                        String queryParameter = uri.getQueryParameter("sql");
                        if (!TextUtils.isEmpty(queryParameter)) {
                            e.a(c()).c().a(Uri.decode(queryParameter));
                        }
                    } else if ("transactionBegin".equals(str3)) {
                        e.a(c()).c().a();
                    } else if ("transactionSetSuccess".equals(str3)) {
                        e.a(c()).c().f();
                    } else if ("transactionEnd".equals(str3)) {
                        e.a(c()).c().c();
                    }
                }
                return null;
            }
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public Uri a(Uri uri, ContentValues contentValues) {
        synchronized (f794b) {
            if (b(uri)) {
                return null;
            }
            String[] strArrSplit = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING);
            if (strArrSplit != null && strArrSplit.length >= 4) {
                String str = strArrSplit[2];
                String str2 = strArrSplit[3];
                if ("ttopensdk.db".equals(str)) {
                    e.a(c()).c().a(str2, (String) null, contentValues);
                }
                return null;
            }
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public int a(Uri uri, String str, String[] strArr) {
        synchronized (f794b) {
            if (b(uri)) {
                return 0;
            }
            String[] strArrSplit = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING);
            if (strArrSplit != null && strArrSplit.length >= 4) {
                String str2 = strArrSplit[2];
                String str3 = strArrSplit[3];
                if (!"ttopensdk.db".equals(str2)) {
                    return 0;
                }
                return e.a(c()).c().a(str3, str, strArr);
            }
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public int a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        synchronized (f794b) {
            if (b(uri)) {
                return 0;
            }
            String[] strArrSplit = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING);
            if (strArrSplit != null && strArrSplit.length >= 4) {
                String str2 = strArrSplit[2];
                String str3 = strArrSplit[3];
                if (!"ttopensdk.db".equals(str2)) {
                    return 0;
                }
                return e.a(c()).c().a(str3, contentValues, str, strArr);
            }
            return 0;
        }
    }
}
