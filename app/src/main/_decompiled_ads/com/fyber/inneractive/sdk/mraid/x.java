package com.fyber.inneractive.sdk.mraid;

/* JADX INFO: loaded from: classes2.dex */
public class x extends u {
    public final com.fyber.inneractive.sdk.web.i.g a;

    public x(com.fyber.inneractive.sdk.web.i.g gVar) {
        this.a = gVar;
    }

    @Override // com.fyber.inneractive.sdk.mraid.u
    public String a() {
        return "placementType: '" + this.a.toString().toLowerCase() + "'";
    }
}
