package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.config.IAConfigManager;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h0 {
    public boolean a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f921b;

    public boolean getAllowFullscreen() {
        return this.a;
    }

    public String getMediationName() {
        return IAConfigManager.M.m;
    }

    public String getMediationVersion() {
        return IAConfigManager.M.o;
    }
}
