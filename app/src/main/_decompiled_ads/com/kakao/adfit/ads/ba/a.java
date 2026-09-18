package com.kakao.adfit.ads.ba;

import android.content.Context;
import android.widget.RelativeLayout;
import com.kakao.adfit.a.l;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: AdWebViewHolder.java */
/* JADX INFO: loaded from: classes2.dex */
class a {
    private final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private l f1681b = null;
    private l c = null;
    private final AtomicBoolean d = new AtomicBoolean(false);

    a(RelativeLayout relativeLayout) {
        this.a = relativeLayout;
    }

    l a(Context context) {
        l lVar = this.c;
        if (lVar != null) {
            lVar.destroy();
        }
        l lVar2 = new l(context);
        this.c = lVar2;
        return lVar2;
    }

    l[] b() {
        return new l[]{this.c, this.f1681b};
    }

    boolean c() {
        return this.d.get();
    }

    void a(l lVar) {
        if (this.c != lVar) {
            return;
        }
        this.a.addView(lVar);
        l lVar2 = this.f1681b;
        if (lVar2 != null) {
            this.a.removeView(lVar2);
            this.f1681b.destroy();
        }
        this.f1681b = lVar;
        this.c = null;
    }

    void a() {
        if (this.d.getAndSet(true)) {
            return;
        }
        l lVar = this.c;
        if (lVar != null) {
            lVar.destroy();
            this.c = null;
        }
        l lVar2 = this.f1681b;
        if (lVar2 != null) {
            this.a.removeView(lVar2);
            this.f1681b.destroy();
            this.f1681b = null;
        }
    }
}
