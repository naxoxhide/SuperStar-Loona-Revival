package com.tapjoy.internal;

import com.tapjoy.TJActionRequest;

/* JADX INFO: loaded from: classes4.dex */
public final class x1 implements TJActionRequest {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2831b;

    public x1(String str, String str2) {
        this.a = str;
        this.f2831b = str2;
    }

    @Override // com.tapjoy.TJActionRequest
    public final void cancelled() {
    }

    @Override // com.tapjoy.TJActionRequest
    public final void completed() {
    }

    @Override // com.tapjoy.TJActionRequest
    public final String getRequestId() {
        return this.a;
    }

    @Override // com.tapjoy.TJActionRequest
    public final String getToken() {
        return this.f2831b;
    }
}
