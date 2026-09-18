package com.tapjoy;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tapjoy.internal.a9;
import com.tapjoy.internal.f9;

/* JADX INFO: loaded from: classes4.dex */
public class TJOfferwallDiscoverView extends FrameLayout {
    public TJWebView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TJAdUnitJSBridge f2696b;
    public TJOfferwallDiscoverListener c;
    public TapjoyHttpURLResponse d;
    public boolean e;
    public boolean f;

    public TJOfferwallDiscoverView(Context context) {
        super(context);
        this.e = false;
        this.f = false;
    }

    public void clearContent() {
        TapjoyUtil.runOnMainThread(new a9(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchVisibilityChanged(View view, int i) {
        super.dispatchVisibilityChanged(view, i);
        if (i == 0) {
            TJAdUnitJSBridge tJAdUnitJSBridge = this.f2696b;
            if (tJAdUnitJSBridge != null) {
                tJAdUnitJSBridge.resume();
                return;
            }
            return;
        }
        TJAdUnitJSBridge tJAdUnitJSBridge2 = this.f2696b;
        if (tJAdUnitJSBridge2 != null) {
            tJAdUnitJSBridge2.pause();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        TJAdUnitJSBridge tJAdUnitJSBridge = this.f2696b;
        if (tJAdUnitJSBridge == null || this.e || !this.f) {
            return;
        }
        tJAdUnitJSBridge.display();
        this.e = true;
    }

    public void requestContent(Context context, String str) {
        if (!TapjoyConnectCore.isConnected()) {
            TJOfferwallDiscoverListener tJOfferwallDiscoverListener = this.c;
            if (tJOfferwallDiscoverListener != null) {
                tJOfferwallDiscoverListener.requestFailure(new TJError(-1, "Tapjoy SDK is not connected"));
                return;
            }
            return;
        }
        if (context == null) {
            TJOfferwallDiscoverListener tJOfferwallDiscoverListener2 = this.c;
            if (tJOfferwallDiscoverListener2 != null) {
                tJOfferwallDiscoverListener2.requestFailure(new TJError(0, "Context is null"));
            }
            clearContent();
            return;
        }
        if (str == null || str.length() == 0) {
            TJOfferwallDiscoverListener tJOfferwallDiscoverListener3 = this.c;
            if (tJOfferwallDiscoverListener3 != null) {
                tJOfferwallDiscoverListener3.requestFailure(new TJError(0, "Placement is null"));
            }
            clearContent();
            return;
        }
        clearContent();
        TJWebView tJWebView = new TJWebView(context);
        this.a = tJWebView;
        tJWebView.setWebViewClient(new f9(this));
        this.f2696b = new TJAdUnitJSBridge(new w(this));
        addView(this.a, -1, -1);
        new v(this, str).start();
    }

    public void setListener(TJOfferwallDiscoverListener tJOfferwallDiscoverListener) {
        this.c = tJOfferwallDiscoverListener;
    }

    public TJOfferwallDiscoverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = false;
        this.f = false;
    }

    public TJOfferwallDiscoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = false;
        this.f = false;
    }

    public TJOfferwallDiscoverView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.e = false;
        this.f = false;
    }
}
