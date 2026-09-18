package com.applovin.impl.privacy.b;

import com.applovin.impl.sdk.n;
import com.applovin.sdk.AppLovinPrivacySettings;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private final String aou;
    private final a ayA;
    private final String ayB;
    private final String ayC;
    private final Integer ayD;
    private Boolean ayE;

    public enum a {
        TCF_VENDOR,
        ATP_NETWORK,
        OTHER
    }

    public a At() {
        return this.ayA;
    }

    public String getDisplayName() {
        return this.aou;
    }

    public String Au() {
        return this.ayC;
    }

    public Integer Av() {
        return this.ayD;
    }

    public void c(Boolean bool) {
        this.ayE = bool;
    }

    public Boolean Aw() {
        return this.ayE;
    }

    public c(com.applovin.impl.mediation.debugger.b.c.b bVar) {
        String name = bVar.getName();
        this.ayB = name;
        this.aou = bVar.getDisplayName();
        Integer numCn = com.applovin.impl.privacy.b.a.cn(name);
        if (numCn != null) {
            this.ayA = a.TCF_VENDOR;
            this.ayD = numCn;
            this.ayC = com.applovin.impl.privacy.b.a.co(name);
            return;
        }
        Integer numCp = com.applovin.impl.privacy.b.a.cp(name);
        if (numCp != null) {
            this.ayA = a.ATP_NETWORK;
            this.ayD = numCp;
            this.ayC = com.applovin.impl.privacy.b.a.cq(name);
        } else {
            this.ayA = a.OTHER;
            this.ayD = null;
            this.ayC = null;
        }
    }

    public String uI() {
        Boolean bool = this.ayE;
        return "\n" + this.aou + " - " + (bool != null ? bool.booleanValue() : AppLovinPrivacySettings.hasUserConsent(n.getApplicationContext()));
    }
}
