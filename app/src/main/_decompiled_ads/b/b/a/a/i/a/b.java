package b.b.a.a.i.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: AdLogManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static volatile List<e> a = new ArrayList();

    public static void a(a aVar, Context context) {
        d.a.b(aVar, context);
        b.b.a.a.i.a.l.c.a("init  end");
    }

    public static boolean b() {
        return i.f().a() == null || i.f().c() == null;
    }

    public static void c() {
        b.b.a.a.i.a.l.c.a("AppLogManager#start");
        d.a.b();
    }

    public static void d() {
        d.a.c();
    }

    public static void e() {
        d.a.d();
    }

    public static List<e> a() {
        return a;
    }

    public static void a(String str) {
        d.a.a(str);
    }

    public static void a(String str, List<String> list, boolean z) {
        d.a.a(str, list, z);
    }

    public static void a(b.b.a.a.i.a.m.a aVar) {
        d.a.b(aVar);
    }
}
