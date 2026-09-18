package com.tapjoy.internal;

import android.view.View;
import com.tapjoy.TJSplitWebView;

/* JADX INFO: loaded from: classes4.dex */
public final class k9 implements View.OnClickListener {
    public final /* synthetic */ TJSplitWebView a;

    public k9(TJSplitWebView tJSplitWebView) {
        this.a = tJSplitWebView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.j.dismissSplitView(null, null);
    }
}
