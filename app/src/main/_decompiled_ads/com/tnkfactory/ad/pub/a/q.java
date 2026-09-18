package com.tnkfactory.ad.pub.a;

import android.view.ViewTreeObserver;
import com.tnkfactory.ad.Logger;

/* JADX INFO: loaded from: classes4.dex */
public final class q implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f2884b;

    public q(m mVar, boolean z) {
        this.f2884b = mVar;
        this.a = z;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        try {
            this.f2884b.f.getViewTreeObserver().removeOnPreDrawListener(this.f2884b.v);
            m mVar = this.f2884b;
            mVar.v = null;
            m.c cVar = mVar.p;
            if (cVar != null) {
                if (this.a) {
                    cVar.b(300L);
                } else {
                    cVar.b();
                }
            }
            return false;
        } catch (Exception unused) {
            Logger.e(u.a(this.f2884b.n == 3 ? "e4790f98ec43d163f26c24413bfc3bf08edf100d2b57d18c1419" : "e4790f98ec43d163f26c24413bfc3bf08edf100d364ad18c1417b86c5ff6a935305ccf59a28323f65f328c4abb"));
            return false;
        }
    }
}
