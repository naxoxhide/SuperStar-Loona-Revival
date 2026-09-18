package b.b.a.a.i.a.o;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import b.b.a.a.i.a.i;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/* JADX INFO: compiled from: TrackAdUrlImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements b.b.a.a.i.a.o.b {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f225b;

    /* JADX INFO: compiled from: TrackAdUrlImpl.java */
    class a extends b.b.a.a.i.a.n.e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f226b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, String str2) {
            super(str);
            this.f226b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a(c.this.f225b.a(), this.f226b);
        }
    }

    /* JADX INFO: compiled from: TrackAdUrlImpl.java */
    private class b extends b.b.a.a.i.a.n.e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d f227b;
        private final String c;

        /* synthetic */ b(c cVar, d dVar, String str, a aVar) {
            this(dVar, str);
        }

        private String c(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.contains("{TS}") || str.contains("__TS__")) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                str = str.replace("{TS}", String.valueOf(jCurrentTimeMillis)).replace("__TS__", String.valueOf(jCurrentTimeMillis));
            }
            return ((str.contains("{UID}") || str.contains("__UID__")) && !TextUtils.isEmpty(this.c)) ? str.replace("{UID}", this.c).replace("__UID__", this.c) : str;
        }

        String a(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                return str.replace("[ss_random]", String.valueOf(c.c().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
            } catch (Exception e) {
                e.printStackTrace();
                return str;
            }
        }

        boolean b(String str) {
            return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
        }

        @Override // java.lang.Runnable
        public void run() {
            b.b.a.a.i.a.f fVarA = i.f().a();
            if (fVarA == null || i.f().c() == null || !fVarA.g() || !b(this.f227b.c())) {
                return;
            }
            if (this.f227b.b() == 0) {
                c.this.f225b.c(this.f227b);
                return;
            }
            while (this.f227b.b() > 0) {
                try {
                    fVarA.j();
                    if (this.f227b.b() == 5) {
                        c.this.f225b.b(this.f227b);
                    }
                    if (!fVarA.a(c.this.b())) {
                        return;
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    String strC = this.f227b.c();
                    if (fVarA.d() == 0) {
                        strC = c(this.f227b.c());
                        if (this.f227b.d()) {
                            strC = a(strC);
                        }
                    }
                    b.b.a.a.i.a.n.c cVarI = fVarA.i();
                    if (cVarI == null) {
                        return;
                    }
                    cVarI.a("User-Agent", fVarA.k());
                    cVarI.a(strC);
                    b.b.a.a.i.a.n.d dVarB = null;
                    try {
                        dVarB = cVarI.b();
                        fVarA.a(dVarB.b());
                    } catch (Throwable unused) {
                    }
                    if (dVarB != null && dVarB.b()) {
                        c.this.f225b.c(this.f227b);
                        b.b.a.a.i.a.l.c.a("trackurl", "track success : " + this.f227b.c());
                        fVarA.a(true, 200, System.currentTimeMillis() - jCurrentTimeMillis);
                        return;
                    }
                    b.b.a.a.i.a.l.c.a("trackurl", "track fail : " + this.f227b.c());
                    d dVar = this.f227b;
                    dVar.a(dVar.b() - 1);
                    if (this.f227b.b() == 0) {
                        c.this.f225b.c(this.f227b);
                        b.b.a.a.i.a.l.c.a("trackurl", "track fail and delete : " + this.f227b.c());
                        return;
                    } else {
                        c.this.f225b.a(this.f227b);
                        if (dVarB != null) {
                            fVarA.a(false, dVarB.a(), System.currentTimeMillis());
                        } else {
                            fVarA.a(false, 0, System.currentTimeMillis());
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
        }

        private b(d dVar, String str) {
            super("AdsStats");
            this.f227b = dVar;
            this.c = str;
        }
    }

    public c(Context context, e eVar) {
        this.a = context;
        this.f225b = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Random c() {
        if (Build.VERSION.SDK_INT < 26) {
            return new SecureRandom();
        }
        try {
            return SecureRandom.getInstanceStrong();
        } catch (Throwable unused) {
            return new SecureRandom();
        }
    }

    public Context b() {
        Context context = this.a;
        return context == null ? i.f().c() : context;
    }

    @Override // b.b.a.a.i.a.o.b
    public void a(String str, List<String> list, boolean z) {
        b.b.a.a.i.a.f fVarA = i.f().a();
        if (fVarA == null || i.f().c() == null || fVarA.a() == null || !fVarA.g() || list == null || list.size() == 0) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            fVarA.a().execute(new b(this, new d(UUID.randomUUID().toString() + "_" + System.currentTimeMillis(), it.next(), z, 5), str, null));
        }
    }

    @Override // b.b.a.a.i.a.o.b
    public void a(String str) {
        b.b.a.a.i.a.f fVarA = i.f().a();
        if (fVarA == null || i.f().c() == null || !fVarA.g()) {
            return;
        }
        a aVar = new a("trackFailedUrls", str);
        aVar.a(1);
        if (fVarA.a() != null) {
            fVarA.a().execute(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<d> list, String str) {
        if (list == null || list.size() == 0) {
            return;
        }
        b.b.a.a.i.a.f fVarA = i.f().a();
        for (d dVar : list) {
            if (fVarA != null && fVarA.a() != null) {
                fVarA.a().execute(new b(this, dVar, str, null));
            }
        }
    }
}
