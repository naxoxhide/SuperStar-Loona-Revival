package b.b.a.a.i.a.k.f;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import b.b.a.a.i.a.i;
import b.b.a.a.i.a.j.g.f;
import b.b.a.a.i.a.j.g.g;
import b.b.a.a.i.a.l.c;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: EventProviderImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static ContentResolver a() {
        try {
            if (i.f().c() != null) {
                return i.f().c().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String b() {
        return g.f209b + RemoteSettings.FORWARD_SLASH_STRING + "ad_log_event" + RemoteSettings.FORWARD_SLASH_STRING;
    }

    public static void c() {
        c.a("start()");
        if (i.f().c() == null) {
            return;
        }
        try {
            ContentResolver contentResolverA = a();
            if (contentResolverA != null) {
                contentResolverA.getType(Uri.parse(b() + "adLogStart"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void d() {
        if (i.f().c() == null) {
            return;
        }
        try {
            ContentResolver contentResolverA = a();
            if (contentResolverA != null) {
                contentResolverA.getType(Uri.parse(b() + "adLogStop"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(b.b.a.a.i.a.m.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            ContentResolver contentResolverA = a();
            if (contentResolverA != null) {
                contentResolverA.getType(Uri.parse(b() + "adLogDispatch?event=" + f.b(aVar.h())));
                c.a("dispatch event getType end ");
            }
        } catch (Throwable th) {
            c.b("dispatch event Throwable:" + th.toString());
        }
    }

    public static void a(String str, List<String> list, boolean z) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(f.b(it.next())).append(",");
            }
            String str2 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(f.b(sb.toString())) + "&replace=" + String.valueOf(z);
            ContentResolver contentResolverA = a();
            if (contentResolverA != null) {
                contentResolverA.getType(Uri.parse(b() + "trackAdUrl" + str2));
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverA = a();
            if (contentResolverA != null) {
                contentResolverA.getType(Uri.parse(b() + "trackAdFailed?did=" + String.valueOf(str)));
            }
        } catch (Throwable unused) {
        }
    }
}
