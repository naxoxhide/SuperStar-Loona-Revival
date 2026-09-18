package com.tapjoy.internal;

import android.view.View;
import com.tapjoy.TJSplitWebView;

/* JADX INFO: loaded from: classes4.dex */
public final class i9 implements View.OnClickListener {
    public final /* synthetic */ TJSplitWebView a;

    public i9(TJSplitWebView tJSplitWebView) {
        this.a = tJSplitWebView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.a.a.canGoBack()) {
            this.a.a.goBack();
        }
    }
}
