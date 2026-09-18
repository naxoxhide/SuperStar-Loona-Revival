package com.bytedance.sdk.openadsdk.q.c;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.f0.q;
import com.bytedance.sdk.openadsdk.core.f0.t;
import com.bytedance.sdk.openadsdk.utils.a0;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: PAGMrcTrackerManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    private static final Map<Integer, b> a = new ConcurrentHashMap();

    public static void a(View view, q qVar, int i) {
        if (view == null || qVar == null || qVar.d1()) {
            return;
        }
        boolean zB = b(qVar);
        if (t.i(qVar)) {
            i = -1;
        }
        a(a(view, qVar, zB, i));
    }

    private static boolean b(q qVar) {
        if (qVar == null) {
            return false;
        }
        String strA = a0.a(qVar);
        return ((("open_ad".equals(strA) || "fullscreen_interstitial_ad".equals(strA) || "rewarded_video".equals(strA)) && !t.i(qVar)) && qVar.v() != 5) && q.c(qVar) && qVar.N0() != null;
    }

    public static void c(q qVar) {
        if (qVar == null || qVar.e() == null) {
            return;
        }
        Integer numA = a(qVar);
        Map<Integer, b> map = a;
        b bVar = map.get(numA);
        if (bVar != null) {
            bVar.m();
        }
        b(numA);
        if (map.size() <= 0) {
            g.b();
        }
    }

    public static void b(Integer num) {
        Map<Integer, b> map = a;
        if (map.containsKey(num)) {
            map.remove(num);
        }
    }

    private static b a(View view, q qVar, boolean z, int i) {
        if (view == null || qVar == null || qVar.e() == null) {
            return null;
        }
        Integer numA = a(qVar);
        Map<Integer, b> map = a;
        if (map.containsKey(numA)) {
            b bVar = map.get(numA);
            if (bVar != null) {
                bVar.a(view);
            }
            return bVar;
        }
        b bVarA = b.a(z, numA, view, qVar, i);
        map.put(numA, bVarA);
        return bVarA;
    }

    private static void a(b bVar) {
        if (bVar == null) {
            return;
        }
        bVar.k();
    }

    public static void a(q qVar, int i) {
        if (qVar == null || qVar.e() == null) {
            return;
        }
        a(a.get(a(qVar)), i);
    }

    public static void a(b bVar, int i) {
        if (bVar == null) {
            return;
        }
        bVar.b(i);
    }

    public static b a(Integer num) {
        return a.get(num);
    }

    public static Integer a(q qVar) {
        return Integer.valueOf((qVar.U() + qVar.e()).hashCode());
    }
}
