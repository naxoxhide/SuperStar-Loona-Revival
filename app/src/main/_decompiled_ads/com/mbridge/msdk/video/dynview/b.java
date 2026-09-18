package com.mbridge.msdk.video.dynview;

import android.view.View;
import com.mbridge.msdk.video.dynview.e.g;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: MBUIController.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile b f2481b;
    public Map<String, SoftReference<View>> a = new HashMap();

    private b() {
    }

    public static b a() {
        b bVar;
        if (f2481b == null) {
            synchronized (b.class) {
                if (f2481b == null) {
                    f2481b = new b();
                }
                bVar = f2481b;
            }
            return bVar;
        }
        return f2481b;
    }

    public final void a(c cVar, g gVar) {
        new com.mbridge.msdk.video.dynview.h.a(cVar, gVar, new HashMap());
    }
}
