package com.tapjoy;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.VideoView;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements Runnable {
    public final /* synthetic */ Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TJPlacementData f2717b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ TJAdUnit d;

    public a(TJAdUnit tJAdUnit, Context context, TJPlacementData tJPlacementData, boolean z) {
        this.d = tJAdUnit;
        this.a = context;
        this.f2717b = tJPlacementData;
        this.c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        TJAdUnit tJAdUnit = this.d;
        Context context = this.a;
        tJAdUnit.getClass();
        if (Looper.myLooper() != Looper.getMainLooper() || tJAdUnit.x || context == null) {
            z = tJAdUnit.x;
        } else {
            TapjoyLog.d("TJAdUnit", "Constructing ad unit");
            tJAdUnit.x = true;
            try {
                tJAdUnit.g = new View(context);
                TJWebView tJWebView = new TJWebView(context);
                tJAdUnit.h = tJWebView;
                tJWebView.setWebViewClient(tJAdUnit.H);
                tJAdUnit.h.setWebChromeClient(tJAdUnit.I);
                VideoView videoView = new VideoView(context);
                tJAdUnit.i = videoView;
                videoView.setOnCompletionListener(tJAdUnit);
                tJAdUnit.i.setOnErrorListener(tJAdUnit);
                tJAdUnit.i.setOnPreparedListener(tJAdUnit);
                tJAdUnit.i.setVisibility(4);
                c cVar = new c(tJAdUnit);
                tJAdUnit.f = cVar;
                tJAdUnit.e = new TJAdUnitJSBridge(cVar);
                if (context instanceof TJAdUnitActivity) {
                    tJAdUnit.setAdUnitActivity((TJAdUnitActivity) context);
                }
                z = tJAdUnit.x;
            } catch (Exception e) {
                TapjoyLog.w("TJAdUnit", e.getMessage());
                z = false;
            }
        }
        if (z) {
            TapjoyLog.i("TJAdUnit", "Loading ad unit content");
            this.d.v = true;
            try {
                if (TextUtils.isEmpty(this.f2717b.getRedirectURL())) {
                    if (this.f2717b.getBaseURL() == null || this.f2717b.getHttpResponse() == null) {
                        TapjoyLog.e("TJAdUnit", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Error loading ad unit content"));
                        this.d.v = false;
                    } else {
                        this.d.h.loadDataWithBaseURL(this.f2717b.getBaseURL(), this.f2717b.getHttpResponse(), "text/html", "utf-8", null);
                    }
                } else if (this.f2717b.isPreloadDisabled()) {
                    this.d.h.postUrl(this.f2717b.getRedirectURL(), null);
                } else {
                    this.d.h.loadUrl(this.f2717b.getRedirectURL());
                }
            } catch (Exception unused) {
                TapjoyLog.e("TJAdUnit", new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Error loading ad unit content"));
                this.d.v = false;
            }
            TJAdUnit tJAdUnit2 = this.d;
            tJAdUnit2.w = tJAdUnit2.v && this.c;
        }
    }
}
