package com.bytedance.sdk.openadsdk.m.f;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import b.b.a.a.i.a.g;
import com.bytedance.sdk.openadsdk.core.e;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.m.d;
import com.bytedance.sdk.openadsdk.multipro.aidl.d.f;
import com.bytedance.sdk.openadsdk.utils.a0;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: DBMultiAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Object> f793b = new ConcurrentHashMap<>();

    /* JADX WARN: Code duplicated, block: B:6:0x0009 A[Catch: all -> 0x0026, TryCatch #0 {all -> 0x0026, blocks: (B:3:0x0002, B:4:0x0005, B:6:0x0009, B:8:0x000f, B:9:0x001f), top: B:14:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x000f A[Catch: all -> 0x0026, TryCatch #0 {all -> 0x0026, blocks: (B:3:0x0002, B:4:0x0005, B:6:0x0009, B:8:0x000f, B:9:0x001f), top: B:14:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:9:0x001f A[Catch: all -> 0x0026, TRY_LEAVE, TryCatch #0 {all -> 0x0026, blocks: (B:3:0x0002, B:4:0x0005, B:6:0x0009, B:8:0x000f, B:9:0x001f), top: B:14:0x0002 }] */
    public static g a(Context context) {
        if (context == null) {
            try {
                o.a();
                if (a == null) {
                    if (com.bytedance.sdk.openadsdk.m.b.b()) {
                        a = g.a.a(com.bytedance.sdk.openadsdk.multipro.aidl.a.c().a(5));
                    } else {
                        a = f.b();
                    }
                }
            } catch (Throwable unused) {
                a0.k("binder error");
            }
        } else if (a == null) {
            if (com.bytedance.sdk.openadsdk.m.b.b()) {
                a = g.a.a(com.bytedance.sdk.openadsdk.multipro.aidl.a.c().a(5));
            } else {
                a = f.b();
            }
        }
        return a;
    }

    private static String a() {
        return d.f791b + RemoteSettings.FORWARD_SLASH_STRING + "t_db" + RemoteSettings.FORWARD_SLASH_STRING + "ttopensdk.db" + RemoteSettings.FORWARD_SLASH_STRING;
    }

    public static void a(Context context, String str, ContentValues contentValues) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (a(str)) {
            try {
                try {
                    if (!com.bytedance.sdk.openadsdk.m.b.b()) {
                        e.a(context).c().a(str, (String) null, contentValues);
                        return;
                    }
                    g gVarA = a(context);
                    if (gVarA != null) {
                        gVarA.a(Uri.parse(a() + str), contentValues);
                    }
                } catch (Throwable unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int a(Context context, String str, String str2, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        synchronized (a(str)) {
            try {
                try {
                    if (!com.bytedance.sdk.openadsdk.m.b.b()) {
                        return e.a(context).c().a(str, str2, strArr);
                    }
                    g gVarA = a(context);
                    if (gVarA != null) {
                        return gVarA.a(Uri.parse(a() + str), str2, strArr);
                    }
                    return 0;
                } catch (Throwable unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static int a(Context context, String str, ContentValues contentValues, String str2, String[] strArr) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return 0;
        }
        synchronized (a(str)) {
            try {
                try {
                    if (!com.bytedance.sdk.openadsdk.m.b.b()) {
                        return e.a(context).c().a(str, contentValues, str2, strArr);
                    }
                    g gVarA = a(context);
                    if (gVarA != null) {
                        return gVarA.a(Uri.parse(a() + str), contentValues, str2, strArr);
                    }
                    return 0;
                } catch (Throwable unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Map<String, List<String>> a(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (a(str)) {
            try {
                try {
                    if (!com.bytedance.sdk.openadsdk.m.b.b()) {
                        return a(e.a(context).c().a(str, strArr, str2, strArr2, str3, str4, str5));
                    }
                    g gVarA = a(context);
                    if (gVarA != null) {
                        return gVarA.a(Uri.parse(a() + str), strArr, str2, strArr2, str5);
                    }
                    return null;
                } catch (Throwable unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0044  */
    public static Map<String, List<String>> a(Cursor cursor) {
        HashMap map = new HashMap();
        if (cursor != null) {
            try {
                String[] columnNames = cursor.getColumnNames();
                while (cursor.getCount() > 0 && cursor.moveToNext()) {
                    for (String str : columnNames) {
                        if (!map.containsKey(str)) {
                            map.put(str, new LinkedList());
                        }
                        ((List) map.get(str)).add(cursor.getString(cursor.getColumnIndex(str)));
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable unused) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return map;
    }

    private static Object a(String str) {
        ConcurrentHashMap<String, Object> concurrentHashMap = f793b;
        Object obj = concurrentHashMap.get(str);
        if (obj == null) {
            synchronized (a.class) {
                obj = concurrentHashMap.get(str);
                if (obj == null) {
                    obj = new Object();
                    concurrentHashMap.put(str, obj);
                }
            }
        }
        return obj;
    }
}
