package com.fyber.inneractive.sdk.mraid;

import com.tapjoy.TJAdUnitConstants;

/* JADX INFO: loaded from: classes2.dex */
public class c0 extends u {
    public final boolean a;

    public c0(boolean z) {
        this.a = z;
    }

    @Override // com.fyber.inneractive.sdk.mraid.u
    public String a() {
        return "viewable: " + (this.a ? "true" : TJAdUnitConstants.String.FALSE);
    }
}
