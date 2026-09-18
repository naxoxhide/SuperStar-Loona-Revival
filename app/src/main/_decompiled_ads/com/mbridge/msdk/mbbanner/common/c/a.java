package com.mbridge.msdk.mbbanner.common.c;

import android.content.Context;
import android.os.Handler;
import com.mbridge.msdk.c.d;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.entity.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.af;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: BannerLoadManager.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static final String a = "a";
    private static volatile a h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f2259b = com.mbridge.msdk.foundation.controller.b.d().g();
    private com.mbridge.msdk.mbbanner.common.util.a c = new com.mbridge.msdk.mbbanner.common.util.a();
    private Map<String, com.mbridge.msdk.mbbanner.common.a.c> d = new ConcurrentHashMap();
    private Map<String, Boolean> e = new ConcurrentHashMap();
    private Map<String, Handler> f = new ConcurrentHashMap();
    private Map<String, Integer> g = new ConcurrentHashMap();

    public static a a() {
        if (h == null) {
            synchronized (a.class) {
                if (h == null) {
                    h = new a();
                }
            }
        }
        return h;
    }

    private a() {
    }

    public final void a(String str, String str2, final com.mbridge.msdk.mbbanner.common.a.b bVar, com.mbridge.msdk.mbbanner.common.b.b bVar2) {
        com.mbridge.msdk.mbbanner.common.a.c cVar;
        if (this.f2259b == null) {
            this.c.a(bVar2, new e(0, "Banner Context == null!"), str2, null);
            return;
        }
        if (bVar == null || bVar2 == null) {
            this.c.a(bVar2, new e(0, "Banner request parameters or callback empty!"), str2, null);
            return;
        }
        Map<String, Boolean> map = this.e;
        if (map != null && map.containsKey(str2) && this.e.get(str2).booleanValue()) {
            this.c.a(bVar2, new e(16, "Current unit is loading!"), str2, null);
            return;
        }
        this.e.put(str2, true);
        if (this.d.containsKey(str2)) {
            cVar = this.d.get(str2);
        } else {
            f fVarE = d.a().e(com.mbridge.msdk.foundation.controller.b.d().h(), str2);
            if (fVarE == null) {
                fVarE = f.d(str2);
            }
            com.mbridge.msdk.mbbanner.common.a.c cVar2 = new com.mbridge.msdk.mbbanner.common.a.c(str2, "", 0, fVarE.v() * 1);
            this.d.put(str2, cVar2);
            cVar = cVar2;
        }
        new b(this.f2259b, cVar, bVar2, this.c).a(str, str2, bVar, new com.mbridge.msdk.mbbanner.common.b.d() { // from class: com.mbridge.msdk.mbbanner.common.c.a.1
            @Override // com.mbridge.msdk.mbbanner.common.b.d
            public final void a(String str3) {
                synchronized (a.a()) {
                    bVar.a("");
                    a.this.e.put(str3, false);
                }
            }
        });
    }

    public final void b(final String str, final String str2, final com.mbridge.msdk.mbbanner.common.a.b bVar, final com.mbridge.msdk.mbbanner.common.b.b bVar2) {
        Handler handler;
        if (bVar == null || bVar.b() <= 0) {
            return;
        }
        if (this.f.containsKey(str2)) {
            handler = this.f.get(str2);
        } else {
            handler = new Handler();
            this.f.put(str2, handler);
        }
        Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.c.a.2
            @Override // java.lang.Runnable
            public final void run() {
                int iIntValue;
                if (a.this.e != null && a.this.e.containsKey(str2) && ((Boolean) a.this.e.get(str2)).booleanValue()) {
                    return;
                }
                if (a.this.g.containsKey(str2) && ((iIntValue = ((Integer) a.this.g.get(str2)).intValue()) == 2 || iIntValue == 4)) {
                    if (a.this.c != null) {
                        a.this.c.a(bVar2, new e(1, "banner load failed because env is exception"), str2, null);
                    }
                } else {
                    String md5 = SameMD5.getMD5(af.c());
                    try {
                        bVar.a(true);
                        bVar.c(md5);
                        com.mbridge.msdk.mbbanner.common.d.a.a("2000123", str2, md5, "auto_load", 296);
                    } catch (Exception unused) {
                    }
                    a.this.a(str, str2, bVar, bVar2);
                }
            }
        };
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(runnable, bVar.b());
    }

    public final void a(String str) {
        if (this.f.containsKey(str)) {
            this.f.get(str).removeCallbacksAndMessages(null);
            this.f.remove(str);
        }
    }

    public final void a(int i, String str, String str2, com.mbridge.msdk.mbbanner.common.a.b bVar, com.mbridge.msdk.mbbanner.common.b.b bVar2) {
        int iIntValue = this.g.containsKey(str2) ? this.g.get(str2).intValue() : 0;
        if (i == 1) {
            if (this.f.containsKey(str2)) {
                this.f.get(str2).removeCallbacksAndMessages(null);
            }
            this.g.put(str2, Integer.valueOf(i));
            return;
        }
        if (i == 2) {
            if (iIntValue == 1) {
                if (this.f.containsKey(str2)) {
                    this.f.get(str2).removeCallbacksAndMessages(null);
                }
                this.g.put(str2, Integer.valueOf(i));
                return;
            }
            return;
        }
        if (i == 3) {
            if (iIntValue == 2 || iIntValue == 4) {
                this.g.put(str2, 1);
                b(str, str2, bVar, bVar2);
                return;
            }
            return;
        }
        if (i != 4) {
            return;
        }
        if (iIntValue == 0) {
            this.g.put(str2, 0);
            return;
        }
        if (this.f.containsKey(str2)) {
            this.f.get(str2).removeCallbacksAndMessages(null);
        }
        this.g.put(str2, Integer.valueOf(i));
    }

    public final void b() {
        Map<String, com.mbridge.msdk.mbbanner.common.a.c> map = this.d;
        if (map != null) {
            map.clear();
        }
        Map<String, Boolean> map2 = this.e;
        if (map2 != null) {
            map2.clear();
        }
        Map<String, Handler> map3 = this.f;
        if (map3 != null) {
            for (Map.Entry<String, Handler> entry : map3.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().removeCallbacksAndMessages(null);
                }
            }
            this.f.clear();
        }
        Map<String, Integer> map4 = this.g;
        if (map4 != null) {
            map4.clear();
        }
    }
}
