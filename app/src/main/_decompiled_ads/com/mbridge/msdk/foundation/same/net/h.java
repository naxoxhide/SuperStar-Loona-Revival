package com.mbridge.msdk.foundation.same.net;

import android.content.Context;
import android.os.Process;
import com.mbridge.msdk.foundation.same.net.stack.OkHttpStack;
import com.mbridge.msdk.foundation.tools.aa;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: NetworkDispatcher.java */
/* JADX INFO: loaded from: classes4.dex */
public class h {
    private static final String a = "h";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.net.stack.a f2150b;
    private g c;
    private c d;

    public h(Context context, SSLSocketFactory sSLSocketFactory, c cVar) {
        this.f2150b = new OkHttpStack();
        this.c = new com.mbridge.msdk.foundation.same.net.e.a(this.f2150b, cVar);
        this.d = cVar;
    }

    public h(Context context, SSLSocketFactory sSLSocketFactory, c cVar, com.mbridge.msdk.foundation.same.net.stack.a aVar) {
        if (aVar == null) {
            this.f2150b = new OkHttpStack();
        } else {
            this.f2150b = aVar;
        }
        this.c = new com.mbridge.msdk.foundation.same.net.e.a(this.f2150b, cVar);
        this.d = cVar;
    }

    public final void a(i iVar) {
        Process.setThreadPriority(10);
        try {
            this.d.c(iVar);
            if (iVar.c()) {
                iVar.a("network-discard-cancelled");
                this.d.b(iVar);
                this.d.a(iVar);
            } else {
                this.d.d(iVar);
                this.d.a((i<?>) iVar, iVar.a(this.c.a(iVar)));
            }
        } catch (com.mbridge.msdk.foundation.same.net.a.a e) {
            this.d.a((i<?>) iVar, e);
        } catch (Exception e2) {
            aa.d(a, "Unhandled exception " + e2.getMessage());
            this.d.a((i<?>) iVar, new com.mbridge.msdk.foundation.same.net.a.a(4, null));
        }
    }
}
