package b.b.a.a.i.a.j.g.h;

import android.content.Context;
import b.b.a.a.i.a.i;
import com.tapjoy.TapjoyConstants;

/* JADX INFO: compiled from: StatsBatchLogEventRepoImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends g {
    public f(Context context, b.b.a.a.i.a.m.d.a aVar) {
        super(context, aVar);
    }

    public static String h() {
        return "CREATE TABLE IF NOT EXISTS " + i.f().d().a() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , " + TapjoyConstants.TJC_RETRY + " INTEGER default 0 , encrypt INTEGER default 0)";
    }

    @Override // b.b.a.a.i.a.j.g.h.g, b.b.a.a.i.a.j.g.h.c
    public String b() {
        return i.f().d().a();
    }

    @Override // b.b.a.a.i.a.j.g.h.g
    public byte e() {
        return (byte) 1;
    }

    @Override // b.b.a.a.i.a.j.g.h.g
    public byte f() {
        return (byte) 3;
    }
}
