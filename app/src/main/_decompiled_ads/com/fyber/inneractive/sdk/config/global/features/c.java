package com.fyber.inneractive.sdk.config.global.features;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class c extends g {
    public com.fyber.inneractive.sdk.model.vast.a e;

    public c() {
        super("cta_locale");
    }

    @Override // com.fyber.inneractive.sdk.config.global.features.g
    public g b() {
        c cVar = new c();
        a(cVar);
        return cVar;
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str) || this.e != null) {
            return;
        }
        this.e = new com.fyber.inneractive.sdk.model.vast.a(a("install_" + str, (String) null), a("skip_ad_" + str, (String) null), a("skip_in_" + str, (String) null));
    }
}
