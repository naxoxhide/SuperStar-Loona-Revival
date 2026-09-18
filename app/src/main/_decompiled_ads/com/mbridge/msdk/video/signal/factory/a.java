package com.mbridge.msdk.video.signal.factory;

import com.mbridge.msdk.video.signal.a.d;
import com.mbridge.msdk.video.signal.a.g;
import com.mbridge.msdk.video.signal.c;
import com.mbridge.msdk.video.signal.e;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.h;
import com.mbridge.msdk.video.signal.i;

/* JADX INFO: compiled from: DefaultJSFactory.java */
/* JADX INFO: loaded from: classes4.dex */
public class a implements IJSFactory {
    protected com.mbridge.msdk.video.signal.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected c f2648b;
    protected i c;
    protected f d;
    protected e e;
    protected h f;
    protected com.mbridge.msdk.video.signal.b g;

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public com.mbridge.msdk.video.signal.a getActivityProxy() {
        if (this.a == null) {
            this.a = new com.mbridge.msdk.video.signal.a.a();
        }
        return this.a;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public c getJSCommon() {
        if (this.f2648b == null) {
            this.f2648b = new com.mbridge.msdk.video.signal.a.c();
        }
        return this.f2648b;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public i getJSVideoModule() {
        if (this.c == null) {
            this.c = new g();
        }
        return this.c;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public f getJSNotifyProxy() {
        if (this.d == null) {
            this.d = new com.mbridge.msdk.video.signal.a.e();
        }
        return this.d;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public e getJSContainerModule() {
        if (this.e == null) {
            this.e = new d();
        }
        return this.e;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public h getIJSRewardVideoV1() {
        if (this.f == null) {
            this.f = new com.mbridge.msdk.video.signal.a.f();
        }
        return this.f;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public com.mbridge.msdk.video.signal.b getJSBTModule() {
        if (this.g == null) {
            this.g = new com.mbridge.msdk.video.signal.a.b();
        }
        return this.g;
    }
}
