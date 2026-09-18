package b.b.a.a.i.a.j.g;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: compiled from: MyDBCallback.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements b.b.a.a.i.a.j.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f208b = new e();
    private volatile SQLiteDatabase a;

    @Override // b.b.a.a.i.a.j.e
    public SQLiteDatabase a(Context context) {
        if (this.a == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = new d(context).getWritableDatabase();
                    b.b.a.a.i.a.l.c.a("---------------DB CREATE  SUCCESS------------");
                }
            }
        }
        return this.a;
    }

    @Override // b.b.a.a.i.a.j.e
    public String a() {
        return "logstatsbatch";
    }

    @Override // b.b.a.a.i.a.j.e
    public String b() {
        return "adevent";
    }

    @Override // b.b.a.a.i.a.j.e
    public String c() {
        return "logstats";
    }

    @Override // b.b.a.a.i.a.j.e
    public String d() {
        return null;
    }

    @Override // b.b.a.a.i.a.j.e
    public String e() {
        return null;
    }

    @Override // b.b.a.a.i.a.j.e
    public String f() {
        return "loghighpriority";
    }
}
