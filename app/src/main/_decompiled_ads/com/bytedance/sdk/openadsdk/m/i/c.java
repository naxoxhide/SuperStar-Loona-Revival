package com.bytedance.sdk.openadsdk.m.i;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.core.o;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.Map;

/* JADX INFO: compiled from: SPMultiProviderImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements com.bytedance.sdk.openadsdk.m.a {
    private Context a;

    private Context c() {
        Context context = this.a;
        return context == null ? o.a() : context;
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Map<String, ?> mapB;
        if (!uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING)[2].equals("get_all") || (mapB = b.b(c(), uri.getQueryParameter("sp_file_name"))) == null) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"cursor_name", "cursor_type", "cursor_value"});
        for (String str3 : mapB.keySet()) {
            Object[] objArr = new Object[3];
            objArr[0] = str3;
            objArr[2] = mapB.get(str3);
            if (objArr[2] instanceof Boolean) {
                objArr[1] = "boolean";
            } else if (objArr[2] instanceof String) {
                objArr[1] = "string";
            } else if (objArr[2] instanceof Integer) {
                objArr[1] = "int";
            } else if (objArr[2] instanceof Long) {
                objArr[1] = "long";
            } else if (objArr[2] instanceof Float) {
                objArr[1] = "float";
            }
            matrixCursor.addRow(objArr);
        }
        return matrixCursor;
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public String b() {
        return "t_sp";
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public String a(Uri uri) {
        String[] strArrSplit = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING);
        String str = strArrSplit[2];
        String str2 = strArrSplit[3];
        if (str.equals("contain")) {
            return b.b(o.a(), uri.getQueryParameter("sp_file_name"), str2) + "";
        }
        return "" + b.b(c(), uri.getQueryParameter("sp_file_name"), str2, str);
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public Uri a(Uri uri, ContentValues contentValues) {
        if (contentValues == null) {
            return null;
        }
        String[] strArrSplit = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING);
        String str = strArrSplit[2];
        String str2 = strArrSplit[3];
        Object obj = contentValues.get("value");
        if (obj != null) {
            b.a(c(), uri.getQueryParameter("sp_file_name"), str2, obj);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public int a(Uri uri, String str, String[] strArr) {
        String[] strArrSplit = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING);
        if (strArrSplit[2].equals("clean")) {
            b.a(c(), uri.getQueryParameter("sp_file_name"));
            return 0;
        }
        String str2 = strArrSplit[3];
        if (b.b(c(), uri.getQueryParameter("sp_file_name"), str2)) {
            b.a(c(), uri.getQueryParameter("sp_file_name"), str2);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.m.a
    public int a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (contentValues == null) {
            return 0;
        }
        a(uri, contentValues);
        return 0;
    }
}
