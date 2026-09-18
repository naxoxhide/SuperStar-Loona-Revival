package com.mbridge.msdk.video.dynview.b;

import android.view.View;
import com.mbridge.msdk.video.dynview.c;
import com.mbridge.msdk.video.dynview.e.e;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: DataEnergize.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f2482b;
    public com.mbridge.msdk.video.dynview.d.a a;

    private a() {
    }

    public static a a() {
        a aVar;
        if (f2482b == null) {
            synchronized (a.class) {
                if (f2482b == null) {
                    f2482b = new a();
                }
                aVar = f2482b;
            }
            return aVar;
        }
        return f2482b;
    }

    public final void a(View view, c cVar, Map map, e eVar) {
        int iH = cVar.h();
        if (iH == 1) {
            com.mbridge.msdk.video.dynview.j.a aVar = new com.mbridge.msdk.video.dynview.j.a();
            aVar.a(cVar, view, map, eVar);
            this.a = aVar.a;
        } else {
            if (iH == 102 || iH == 202 || iH == 302 || iH == 802 || iH == 904) {
                new com.mbridge.msdk.video.dynview.j.a().b(cVar, view, map, eVar);
                return;
            }
            if (iH == 4) {
                new com.mbridge.msdk.video.dynview.j.a().a(cVar, view, eVar);
            } else if (iH != 5) {
                eVar.a(view, new ArrayList());
            } else {
                new com.mbridge.msdk.video.dynview.j.a().c(cVar, view, map, eVar);
            }
        }
    }

    public final void b() {
        com.mbridge.msdk.video.dynview.d.a aVar = this.a;
        if (aVar != null) {
            aVar.c();
        }
    }
}
