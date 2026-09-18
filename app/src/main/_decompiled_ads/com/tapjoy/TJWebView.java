package com.tapjoy;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.tapjoy.internal.t9;

/* JADX INFO: loaded from: classes4.dex */
public class TJWebView extends WebView {
    public TJWebView(Context context) {
        super(context);
        setScrollContainer(false);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        new GestureDetector(new t9());
        if (getSettings() != null) {
            getSettings().setJavaScriptEnabled(true);
            getSettings().setDomStorageEnabled(true);
            getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        setBackgroundColor(0);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        removeAllViews();
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        super.destroy();
    }

    public TJWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
