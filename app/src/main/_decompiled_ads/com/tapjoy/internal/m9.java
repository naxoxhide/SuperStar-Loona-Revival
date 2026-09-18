package com.tapjoy.internal;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.tapjoy.TJSplitWebView;

/* JADX INFO: loaded from: classes4.dex */
public final class m9 implements DialogInterface.OnClickListener {
    public final /* synthetic */ TJSplitWebView a;

    public m9(TJSplitWebView tJSplitWebView) {
        this.a = tJSplitWebView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (TextUtils.isEmpty(this.a.getLastUrl())) {
            TJSplitWebView tJSplitWebView = this.a;
            tJSplitWebView.loadUrl(tJSplitWebView.d);
        } else {
            TJSplitWebView tJSplitWebView2 = this.a;
            tJSplitWebView2.loadUrl(tJSplitWebView2.getLastUrl());
        }
        dialogInterface.cancel();
    }
}
