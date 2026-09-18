package b.b.a.a.i.a.j.g;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: compiled from: DBMultiUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static void a(Context context, String str, ContentValues contentValues) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            a.a(context).a().a(str, (String) null, contentValues);
        } catch (Throwable unused) {
            b.b.a.a.i.a.l.c.a("insert ignore");
        }
    }

    public static void a(Context context, String str, List<b.b.a.a.i.a.m.a> list) {
        if (list == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            a.a(context).a().a(str, (String) null, list);
        } catch (Throwable unused) {
            b.b.a.a.i.a.l.c.a("insert ignore");
        }
    }

    public static int a(Context context, String str, String str2, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            b.b.a.a.i.a.l.c.a("DBMultiUtils  delete start");
            return a.a(context).a().a(str, str2, strArr);
        } catch (Throwable unused) {
            b.b.a.a.i.a.l.c.a("delete ignore");
            return 0;
        }
    }

    public static int a(Context context, String str, ContentValues contentValues, String str2, String[] strArr) {
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            try {
                return a.a(context).a().a(str, contentValues, str2, strArr);
            } catch (Throwable unused) {
                b.b.a.a.i.a.l.c.a("update ignore");
            }
        }
        return 0;
    }

    public static Cursor a(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return a.a(context).a().a(str, strArr, str2, strArr2, null, null, str5);
        } catch (Throwable unused) {
            b.b.a.a.i.a.l.c.a("query ignore");
            return null;
        }
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            a.a(context).a().a(Uri.decode(str));
        } catch (Throwable unused) {
            b.b.a.a.i.a.l.c.a("execSQL ignore");
        }
    }
}
