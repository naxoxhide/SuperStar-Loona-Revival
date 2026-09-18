package b.b.a.a.i.a.j.g.h;

import android.content.Context;
import b.b.a.a.i.a.i;
import com.tapjoy.TapjoyConstants;

/* JADX INFO: compiled from: HighPriorityAdEventRepoImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends a {
    public d(Context context, b.b.a.a.i.a.m.d.a aVar) {
        super(context, aVar);
    }

    public static String h() {
        return "CREATE TABLE IF NOT EXISTS " + i.f().d().f() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , " + TapjoyConstants.TJC_RETRY + " INTEGER default 0 , encrypt INTEGER default 0)";
    }

    @Override // b.b.a.a.i.a.j.g.h.a, b.b.a.a.i.a.j.g.h.c
    public String b() {
        b.b.a.a.i.a.j.e eVarD = i.f().d();
        if (eVarD != null) {
            return eVarD.f();
        }
        return null;
    }

    @Override // b.b.a.a.i.a.j.g.h.a
    public byte e() {
        return (byte) 0;
    }

    @Override // b.b.a.a.i.a.j.g.h.a
    public byte f() {
        return (byte) 1;
    }
}
