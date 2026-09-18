package com.fyber.inneractive.sdk.external;

import com.fyber.inneractive.sdk.flow.g;
import com.fyber.inneractive.sdk.network.q;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class InneractiveInfrastructureError extends InneractiveError {
    public final InneractiveErrorCode a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f912b;
    public Throwable c;
    public Exception d;
    public final List<q> e;

    public InneractiveInfrastructureError(InneractiveErrorCode inneractiveErrorCode, g gVar) {
        this(inneractiveErrorCode, gVar, null);
    }

    public void addReportedError(q qVar) {
        this.e.add(qVar);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveError
    public String description() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        if (this.c != null) {
            sb.append(" : ").append(this.c);
        }
        return sb.toString();
    }

    public Throwable getCause() {
        Exception exc = this.d;
        return exc == null ? this.c : exc;
    }

    public InneractiveErrorCode getErrorCode() {
        return this.a;
    }

    public g getFyberMarketplaceAdLoadFailureReason() {
        return this.f912b;
    }

    public boolean isErrorAlreadyReported(q qVar) {
        return this.e.contains(qVar);
    }

    public void setCause(Exception exc) {
        this.d = exc;
    }

    public InneractiveInfrastructureError(InneractiveErrorCode inneractiveErrorCode, g gVar, Throwable th) {
        this.e = new ArrayList();
        this.a = inneractiveErrorCode;
        this.f912b = gVar;
        this.c = th;
    }
}
