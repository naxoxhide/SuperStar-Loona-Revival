package com.applovin.impl.adview;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class r extends j {
    public r(Context context) {
        super(context);
    }

    @Override // com.applovin.impl.adview.j
    public j.a getStyle() {
        return j.a.INVISIBLE;
    }

    @Override // com.applovin.impl.adview.j
    public void fZ(int i) {
        setViewScale(i / 30.0f);
    }
}
