package com.mbridge.msdk.mbsignalcommon.windvane;

import android.content.Context;

/* JADX INFO: compiled from: WindVanePlugin.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class h {
    protected Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Object f2334b;
    protected WindVaneWebView c;

    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        this.a = context;
        this.c = windVaneWebView;
    }

    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        this.f2334b = obj;
        this.c = windVaneWebView;
    }
}
