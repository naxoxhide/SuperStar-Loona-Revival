package com.applovin.impl.mediation.b;

/* JADX INFO: loaded from: classes.dex */
public class g {
    private final h auC;
    private final String auD;
    private final String auE;
    private final String auF;
    private final String auG;

    public interface a {
        void a(g gVar);
    }

    public static g a(h hVar, com.applovin.impl.mediation.g gVar, String str) {
        if (hVar == null) {
            throw new IllegalArgumentException("No spec specified");
        }
        if (gVar == null) {
            throw new IllegalArgumentException("No adapterWrapper specified");
        }
        return new g(hVar, gVar, str, null);
    }

    public static g a(h hVar, String str) {
        return b(hVar, null, str);
    }

    public static g b(h hVar, com.applovin.impl.mediation.g gVar, String str) {
        if (hVar == null) {
            throw new IllegalArgumentException("No spec specified");
        }
        return new g(hVar, gVar, null, str);
    }

    private g(h hVar, com.applovin.impl.mediation.g gVar, String str, String str2) {
        this.auC = hVar;
        this.auF = str;
        this.auG = str2;
        if (gVar != null) {
            this.auD = gVar.getSdkVersion();
            this.auE = gVar.getAdapterVersion();
        } else {
            this.auD = null;
            this.auE = null;
        }
    }

    public h yG() {
        return this.auC;
    }

    public String getSdkVersion() {
        return this.auD;
    }

    public String getAdapterVersion() {
        return this.auE;
    }

    public String yH() {
        return this.auF;
    }

    public String getErrorMessage() {
        return this.auG;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder().append("SignalCollectionResult{mSignalProviderSpec=").append(this.auC).append(", mSdkVersion='").append(this.auD).append('\'').append(", mAdapterVersion='").append(this.auE).append('\'').append(", mSignalDataLength='");
        String str = this.auF;
        return sbAppend.append(str != null ? str.length() : 0).append('\'').append(", mErrorMessage=").append(this.auG).append('}').toString();
    }
}
