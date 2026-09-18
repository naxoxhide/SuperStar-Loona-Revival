package com.igaworks.adpopcorn.activity.c;

import android.content.Context;
import android.webkit.WebView;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class g extends WebView {
    private static Field a;

    static {
        try {
            Field declaredField = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
            a = declaredField;
            declaredField.setAccessible(true);
        } catch (Exception unused) {
        }
    }

    public g(Context context) {
        super(context.getApplicationContext());
    }

    @Override // android.webkit.WebView
    public void destroy() {
        super.destroy();
        try {
            Field field = a;
            if (field != null) {
                field.set(null, null);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
