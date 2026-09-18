package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class v extends View {
    private final p ain;
    private boolean aio;

    interface a {
        void onFailure();

        void rj();
    }

    public boolean sh() {
        return this.aio;
    }

    public v(p pVar, Context context) {
        super(context);
        this.ain = pVar;
        setClickable(false);
        setFocusable(false);
    }

    public void sg() {
        a(null);
    }

    public void a(a aVar) {
        if (this.aio) {
            if (aVar != null) {
                aVar.rj();
                return;
            }
            return;
        }
        Drawable drawableRM = this.ain.rM();
        if (drawableRM == null) {
            if (aVar != null) {
                aVar.onFailure();
            }
        } else {
            setBackground(drawableRM);
            this.aio = true;
            if (aVar != null) {
                aVar.rj();
            }
        }
    }

    public String getIdentifier() {
        return this.ain.getIdentifier();
    }
}
