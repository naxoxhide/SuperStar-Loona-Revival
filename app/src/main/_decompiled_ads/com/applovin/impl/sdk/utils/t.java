package com.applovin.impl.sdk.utils;

import android.text.TextUtils;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class t {
    private final String aWg = a(com.applovin.impl.sdk.c.d.aRi, (String) com.applovin.impl.sdk.c.e.b(com.applovin.impl.sdk.c.d.aRh, (Object) null, com.applovin.impl.sdk.n.getApplicationContext()));
    private final String aWh;
    private String avY;
    private final com.applovin.impl.sdk.n sdk;

    public t(com.applovin.impl.sdk.n nVar) {
        this.sdk = nVar;
        this.aWh = a(com.applovin.impl.sdk.c.d.aRj, (String) nVar.a(com.applovin.impl.sdk.c.b.aKh));
        cE(Ls());
    }

    private String Ls() {
        if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOx)).booleanValue()) {
            this.sdk.b(com.applovin.impl.sdk.c.d.aRg);
        }
        String str = (String) this.sdk.a(com.applovin.impl.sdk.c.d.aRg);
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        this.sdk.BL();
        if (com.applovin.impl.sdk.x.Fk()) {
            this.sdk.BL().f("AppLovinSdk", "Using identifier (" + str + ") from previous session");
        }
        return str;
    }

    private String a(com.applovin.impl.sdk.c.d<String> dVar, String str) {
        String str2 = (String) com.applovin.impl.sdk.c.e.b(dVar, (Object) null, com.applovin.impl.sdk.n.getApplicationContext());
        if (StringUtils.isValidString(str2)) {
            return str2;
        }
        if (!StringUtils.isValidString(str)) {
            str = UUID.randomUUID().toString().toLowerCase(Locale.US);
        }
        com.applovin.impl.sdk.c.e.a(dVar, str, com.applovin.impl.sdk.n.getApplicationContext());
        return str;
    }

    public void cE(String str) {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOx)).booleanValue()) {
            this.sdk.a(com.applovin.impl.sdk.c.d.aRg, str);
        }
        this.avY = str;
        this.sdk.Cf().z(str, Lt());
    }

    public static String M(com.applovin.impl.sdk.n nVar) {
        String str = (String) nVar.a(com.applovin.impl.sdk.c.d.aRk);
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String strValueOf = String.valueOf(((int) (Math.random() * 100.0d)) + 1);
        nVar.a(com.applovin.impl.sdk.c.d.aRk, strValueOf);
        return strValueOf;
    }

    public String Bx() {
        return this.avY;
    }

    public String By() {
        return this.aWg;
    }

    public String Lt() {
        return this.aWh;
    }
}
