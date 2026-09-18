package com.fyber.inneractive.sdk.bidder.adm;

import android.util.Base64;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.flow.t;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.m;

/* JADX INFO: loaded from: classes2.dex */
public class b implements Runnable {
    public final /* synthetic */ f.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f843b;
    public final /* synthetic */ f c;

    public class a implements Runnable {
        public final /* synthetic */ Exception a;

        public a(Exception exc) {
            this.a = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.a aVar = b.this.a;
            if (aVar != null) {
                ((t.a) aVar).a(this.a, InneractiveErrorCode.INVALID_INPUT, new com.fyber.inneractive.sdk.response.e[0]);
            }
        }
    }

    public b(f fVar, f.a aVar, s sVar) {
        this.c = fVar;
        this.a = aVar;
        this.f843b = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        f.a aVar;
        try {
            this.c.a = AdmParametersOuterClass$AdmParameters.parseFrom(Base64.decode(this.c.f846b, 0));
            if (this.c.a != null && (aVar = this.a) != null) {
                ((t.a) aVar).a();
            }
            f.a(this.c, this.a, this.f843b);
        } catch (Exception e) {
            IAlog.e("failed to parse ad markup payload %s", e.getMessage());
            m.f1343b.post(new a(e));
        }
    }
}
