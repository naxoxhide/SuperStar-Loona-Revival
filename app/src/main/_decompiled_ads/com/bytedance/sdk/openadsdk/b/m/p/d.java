package com.bytedance.sdk.openadsdk.b.m.p;

import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.f0.q;
import org.json.JSONObject;

/* JADX INFO: compiled from: RewardFullDownloadManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    private final q a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f493b;
    b.c.a.a.a.a.c c;
    private boolean d;
    private final com.bytedance.sdk.openadsdk.b.m.p.a e;

    /* JADX INFO: compiled from: RewardFullDownloadManager.java */
    public interface a {
        void a(View view, float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a> sparseArray, int i, int i2, int i3);

        void a(String str, JSONObject jSONObject);
    }

    public d(com.bytedance.sdk.openadsdk.b.m.p.a aVar) {
        this.e = aVar;
        this.a = aVar.a;
        this.f493b = aVar.g;
    }

    private void c() {
        if (!com.bytedance.sdk.openadsdk.m.b.b() && this.a.e0() == 4) {
            this.c = b.c.a.a.a.a.d.a(this.e.W, this.a, this.f493b);
        }
        if (this.c == null) {
            this.c = b.c.a.a.a.a.d.a(this.e.V, this.a, this.f493b);
        }
    }

    public b.c.a.a.a.a.c a() {
        return this.c;
    }

    public void b() {
        if (this.d) {
            return;
        }
        this.d = true;
        c();
    }

    public void d() {
        b.c.a.a.a.a.c cVar = this.c;
        if (cVar != null) {
            cVar.b();
        }
    }

    public void a(View view, float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.c0.c.a> sparseArray, int i, int i2, int i3, a aVar) {
        if (this.c == null) {
            aVar.a(view, f, f2, f3, f4, sparseArray, i, i2, i3);
            return;
        }
        int id = view.getId();
        if (id == com.bytedance.sdk.openadsdk.utils.h.e) {
            aVar.a("click_play_star_level", null);
            return;
        }
        if (id == com.bytedance.sdk.openadsdk.utils.h.d) {
            aVar.a("click_play_star_nums", null);
        } else if (id == com.bytedance.sdk.openadsdk.utils.h.c) {
            aVar.a("click_play_source", null);
        } else if (id == com.bytedance.sdk.openadsdk.utils.h.f830b) {
            aVar.a("click_play_logo", null);
        }
    }
}
