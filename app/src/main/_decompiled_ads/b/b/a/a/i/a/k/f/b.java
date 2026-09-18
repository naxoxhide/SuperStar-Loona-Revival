package b.b.a.a.i.a.k.f;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import b.b.a.a.i.a.d;
import b.b.a.a.i.a.g;
import b.b.a.a.i.a.i;
import b.b.a.a.i.a.j.g.f;
import b.b.a.a.i.a.l.c;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: OverSeasEventProviderImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static g a;

    public static g a(Context context) {
        try {
            c.a("getResolver");
            if (a == null) {
                a = i.f().a().m();
            }
        } catch (Exception unused) {
        }
        return a;
    }

    public static void d() {
        c.a("EventProviderImpl#start");
        if (i.f().c() == null) {
            return;
        }
        try {
            g gVarA = a(i.f().c());
            if (gVarA != null) {
                Uri uri = Uri.parse(a() + "adLogStart");
                c.a("EventProviderImpl#gettype");
                gVarA.a(uri);
            }
        } catch (Throwable unused) {
        }
    }

    public static void e() {
        if (i.f().c() == null) {
            return;
        }
        try {
            g gVarA = a(i.f().c());
            if (gVarA != null) {
                gVarA.a(Uri.parse(a() + "adLogStop"));
            }
        } catch (Throwable unused) {
        }
    }

    public int a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public int a(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public Uri a(Uri uri, ContentValues contentValues) {
        return null;
    }

    public String b() {
        return "ad_log_event";
    }

    public void c() {
    }

    public static void a(b.b.a.a.i.a.m.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            c.a("dispatch event getResolver before");
            g gVarA = a(i.f().c());
            c.a("dispatch event getResolver end");
            if (gVarA != null) {
                Uri uri = Uri.parse(a() + "adLogDispatch?event=" + f.b(aVar.h()));
                c.a("dispatch event getType:");
                gVarA.a(uri);
                c.a("dispatch event getType end ");
            }
        } catch (Throwable th) {
            c.b("dispatch event Throwable:" + th.toString());
        }
    }

    public static void a(String str, List<String> list, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(f.b(it.next())).append(",");
            }
            String str2 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(f.b(sb.toString())) + "&replace=" + String.valueOf(z);
            g gVarA = a(i.f().c());
            if (gVarA != null) {
                gVarA.a(Uri.parse(a() + "trackAdUrl" + str2));
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(String str) {
        if (i.f().a().d() == 0 && TextUtils.isEmpty(str)) {
            return;
        }
        try {
            g gVarA = a(i.f().c());
            if (gVarA != null) {
                gVarA.a(Uri.parse(a() + "trackAdFailed?did=" + String.valueOf(str)));
            }
        } catch (Throwable unused) {
        }
    }

    private static String a() {
        return b.b.a.a.i.a.j.g.g.f209b + RemoteSettings.FORWARD_SLASH_STRING + "ad_log_event" + RemoteSettings.FORWARD_SLASH_STRING;
    }

    public String a(Uri uri) {
        b.b.a.a.i.a.m.a aVarC;
        c.a("OverSeasEventProviderImpl#gettype()");
        byte b2 = 2;
        String str = uri.getPath().split(RemoteSettings.FORWARD_SLASH_STRING)[2];
        str.hashCode();
        str.hashCode();
        switch (str.hashCode()) {
            case -482705237:
                b2 = str.equals("trackAdFailed") ? (byte) 0 : (byte) -1;
                break;
            case -171493183:
                b2 = str.equals("adLogStart") ? (byte) 1 : (byte) -1;
                break;
            case 964299715:
                if (!str.equals("adLogStop")) {
                    b2 = -1;
                }
                break;
            case 1025736635:
                b2 = str.equals("adLogDispatch") ? (byte) 3 : (byte) -1;
                break;
            case 1131732929:
                b2 = str.equals("trackAdUrl") ? (byte) 4 : (byte) -1;
                break;
            default:
                b2 = -1;
                break;
        }
        switch (b2) {
            case 0:
                b.b.a.a.i.a.o.a.a().a(uri.getQueryParameter("did"));
                break;
            case 1:
                c.a("EventProviderImpl====ad event function will be start====");
                i.f().l();
                break;
            case 2:
                c.a("EventProviderImpl", "====ad event function will be stop====");
                i.f().m();
                break;
            case 3:
                c.a("EventProviderImpl", "dispatch FUN_AD_EVENT_DISPATCH");
                String queryParameter = uri.getQueryParameter("event");
                if (!TextUtils.isEmpty(queryParameter) && (aVarC = b.b.a.a.i.a.m.c.a.c(f.a(queryParameter))) != null) {
                    d.a.b(aVarC);
                    break;
                }
                break;
            case 4:
                c.a("EventProviderImpl", "dispatch FUN_TRACK_URL");
                try {
                    String queryParameter2 = uri.getQueryParameter("did");
                    boolean zBooleanValue = Boolean.valueOf(uri.getQueryParameter("replace")).booleanValue();
                    String[] strArrSplit = f.a(uri.getQueryParameter("track")).split(",");
                    if (strArrSplit.length > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (String str2 : strArrSplit) {
                            String strA = f.a(str2);
                            if (!TextUtils.isEmpty(strA)) {
                                arrayList.add(strA);
                            }
                        }
                        b.b.a.a.i.a.o.a.a().a(queryParameter2, arrayList, zBooleanValue);
                    }
                } catch (Throwable unused) {
                    return null;
                }
                break;
        }
        return null;
    }
}
