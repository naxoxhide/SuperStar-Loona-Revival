package com.tnkfactory.ad.pub.a;

import com.tnkfactory.ad.AdListener;
import com.tnkfactory.ad.Logger;

/* JADX INFO: loaded from: classes4.dex */
public final class f extends com.tnkfactory.ad.pub.b.r {
    public final /* synthetic */ e a;

    public f(e eVar) {
        this.a = eVar;
    }

    @Override // com.tnkfactory.ad.pub.b.r
    public final void a(Object obj) {
        Integer num = (Integer) obj;
        int iIntValue = AdListener.VIDEO_VERIFY_FAILED_ERROR;
        if (num != null) {
            iIntValue = num.intValue();
        }
        j0 j0Var = this.a.c;
        if (j0Var != null) {
            j0Var.b(iIntValue);
        }
    }

    @Override // com.tnkfactory.ad.pub.b.r
    public final void a(Throwable th) {
        Logger.e(u.a("853b41b3fb439e79b3686c4a32fc75a38fd407102a4288861e61be7a1aea85373858cb55b88d6cef0d389448fb0149") + th.toString());
        j0 j0Var = this.a.c;
        if (j0Var != null) {
            j0Var.b(AdListener.VIDEO_VERIFY_FAILED_ERROR);
        }
    }
}
