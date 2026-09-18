package com.applovin.impl.adview;

import android.content.Context;
import android.view.MotionEvent;
import android.webkit.WebView;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class i extends WebView {
    private static Boolean ahy;
    private final AtomicReference<MotionEvent> ahz;

    public i(Context context) {
        super(context);
        this.ahz = new AtomicReference<>();
        if (ahy == null) {
            try {
                WebView.class.getDeclaredMethod("onTouchEvent", MotionEvent.class);
                ahy = true;
            } catch (NoSuchMethodException unused) {
                com.applovin.impl.sdk.x.H("AppLovinSdk", "WebView.onTouchEvent() not implemented");
                ahy = false;
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.ahz.set(MotionEvent.obtain(motionEvent));
        if (ahy.booleanValue()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean rz() {
        return this.ahz.get() != null;
    }

    public MotionEvent getLastClickEvent() {
        return this.ahz.get();
    }

    public MotionEvent getAndClearLastClickEvent() {
        return this.ahz.getAndSet(null);
    }
}
