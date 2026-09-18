package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.p;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class i<T> extends c {
    private String aIr;
    private boolean aIt;

    protected i(a aVar) {
        super(aVar);
        this.aIr = aVar.aIr;
        this.aIt = aVar.aIt;
    }

    public boolean IE() {
        return this.aIr != null;
    }

    public String Iw() {
        return this.aIr;
    }

    public boolean Iv() {
        return this.aIt;
    }

    public static a E(n nVar) {
        return new a(nVar);
    }

    public static class a<T> extends c.a<T> {
        private String aIr;
        private boolean aIt;

        public a(n nVar) {
            super(nVar);
            this.aHD = ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aNy)).intValue();
            this.aHE = ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aNx)).intValue();
            this.aHF = ((Integer) nVar.a(com.applovin.impl.sdk.c.b.aNF)).intValue();
        }

        @Override // com.applovin.impl.sdk.network.c.a
        /* JADX INFO: renamed from: dj, reason: merged with bridge method [inline-methods] */
        public a da(String str) {
            this.aHn = str;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.c.a
        /* JADX INFO: renamed from: dk, reason: merged with bridge method [inline-methods] */
        public a dc(String str) {
            this.aHB = str;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.c.a
        /* JADX INFO: renamed from: dl, reason: merged with bridge method [inline-methods] */
        public a db(String str) {
            this.aHy = str;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.c.a
        /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
        public a K(JSONObject jSONObject) {
            this.aHA = jSONObject;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.c.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public a k(Map<String, String> map) {
            this.aHz = map;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.c.a
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public a l(Map<String, String> map) {
            this.awu = map;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.c.a
        /* JADX INFO: renamed from: ae, reason: merged with bridge method [inline-methods] */
        public a ad(T t) {
            this.aHp = t;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.c.a
        /* JADX INFO: renamed from: gI, reason: merged with bridge method [inline-methods] */
        public a gC(int i) {
            this.aHD = i;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.c.a
        /* JADX INFO: renamed from: gJ, reason: merged with bridge method [inline-methods] */
        public a gD(int i) {
            this.aHE = i;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.c.a
        /* JADX INFO: renamed from: gK, reason: merged with bridge method [inline-methods] */
        public a gE(int i) {
            this.aHF = i;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.c.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a a(p.a aVar) {
            this.aHK = aVar;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.c.a
        /* JADX INFO: renamed from: aZ, reason: merged with bridge method [inline-methods] */
        public a aS(boolean z) {
            this.aHJ = z;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.c.a
        /* JADX INFO: renamed from: ba, reason: merged with bridge method [inline-methods] */
        public a aU(boolean z) {
            this.aHM = z;
            return this;
        }

        public a dm(String str) {
            this.aIr = str;
            return this;
        }

        public a bb(boolean z) {
            this.aIt = z;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.c.a
        /* JADX INFO: renamed from: IF, reason: merged with bridge method [inline-methods] */
        public i<T> Ie() {
            return new i<>(this);
        }
    }
}
