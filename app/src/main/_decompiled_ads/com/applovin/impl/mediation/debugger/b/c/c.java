package com.applovin.impl.mediation.debugger.b.c;

import android.content.Context;
import com.applovin.impl.sdk.utils.h;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private final String aoQ;
    private final boolean aoR;
    private final String name;

    c(String str, String str2, Context context) {
        this.name = str.replace("android.permission.", "");
        this.aoQ = str2;
        this.aoR = h.d(str, context);
    }

    public String getName() {
        return this.name;
    }

    public String vj() {
        return this.aoQ;
    }

    public boolean vk() {
        return this.aoR;
    }
}
