package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class t extends com.applovin.impl.sdk.e.d {
    private final AppLovinAdLoadListener aTB;
    private final a aUO;

    t(com.applovin.impl.b.e eVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.n nVar) {
        super("TaskProcessVastResponse", nVar);
        if (eVar == null) {
            throw new IllegalArgumentException("No context specified.");
        }
        this.aTB = appLovinAdLoadListener;
        this.aUO = (a) eVar;
    }

    public static t a(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.ad.b bVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.n nVar) {
        return new c(new a(jSONObject, jSONObject2, bVar, nVar), appLovinAdLoadListener, nVar);
    }

    public static t a(String str, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.ad.b bVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.n nVar) {
        return new b(str, new a(jSONObject, jSONObject2, bVar, nVar), appLovinAdLoadListener, nVar);
    }

    public static t a(com.applovin.impl.sdk.utils.y yVar, com.applovin.impl.b.e eVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.n nVar) {
        return new d(yVar, eVar, appLovinAdLoadListener, nVar);
    }

    protected com.applovin.impl.sdk.utils.y dA(String str) {
        try {
            return com.applovin.impl.sdk.utils.z.e(str, this.sdk);
        } catch (Throwable th) {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.c(this.tag, "Failed to process VAST response", th);
            }
            a(com.applovin.impl.b.f.XML_PARSING);
            return null;
        }
    }

    void a(com.applovin.impl.sdk.utils.y yVar) {
        int iMp = this.aUO.Mp();
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.f(this.tag, "Finished parsing XML at depth " + iMp);
        }
        this.aUO.b(yVar);
        if (com.applovin.impl.b.m.d(yVar)) {
            int iIntValue = ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPn)).intValue();
            if (iMp < iIntValue) {
                com.applovin.impl.sdk.x xVar2 = this.logger;
                if (com.applovin.impl.sdk.x.Fk()) {
                    this.logger.f(this.tag, "VAST response is wrapper. Resolving...");
                }
                this.sdk.BM().b(new z(this.aUO, this.aTB, this.sdk));
                return;
            }
            com.applovin.impl.sdk.x xVar3 = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.i(this.tag, "Reached beyond max wrapper depth of " + iIntValue);
            }
            a(com.applovin.impl.b.f.WRAPPER_LIMIT_REACHED);
            return;
        }
        if (com.applovin.impl.b.m.e(yVar)) {
            com.applovin.impl.sdk.x xVar4 = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f(this.tag, "VAST response is inline. Rendering ad...");
            }
            this.sdk.BM().b(new v(this.aUO, this.aTB, this.sdk));
            return;
        }
        com.applovin.impl.sdk.x xVar5 = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.i(this.tag, "VAST response is an error");
        }
        a(com.applovin.impl.b.f.NO_WRAPPER_RESPONSE);
    }

    void a(com.applovin.impl.b.f fVar) {
        com.applovin.impl.sdk.x xVar = this.logger;
        if (com.applovin.impl.sdk.x.Fk()) {
            this.logger.i(this.tag, "Failed to process VAST response due to VAST error code " + fVar);
        }
        com.applovin.impl.b.m.a(this.aUO, this.aTB, fVar, -6, this.sdk);
    }

    private static final class c extends t {
        private final JSONObject aUQ;

        c(com.applovin.impl.b.e eVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.n nVar) {
            super(eVar, appLovinAdLoadListener, nVar);
            this.aUQ = eVar.Mr();
        }

        @Override // java.lang.Runnable
        public void run() {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f(this.tag, "Processing SDK JSON response...");
            }
            String string = JsonUtils.getString(this.aUQ, "xml", null);
            if (StringUtils.isValidString(string)) {
                if (string.length() < ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPm)).intValue()) {
                    a(dA(string));
                    return;
                }
                com.applovin.impl.sdk.x xVar2 = this.logger;
                if (com.applovin.impl.sdk.x.Fk()) {
                    this.logger.i(this.tag, "VAST response is over max length");
                }
                a(com.applovin.impl.b.f.XML_PARSING);
                return;
            }
            com.applovin.impl.sdk.x xVar3 = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.i(this.tag, "No VAST response received.");
            }
            a(com.applovin.impl.b.f.NO_WRAPPER_RESPONSE);
        }
    }

    private static final class b extends t {
        private final String aUP;

        b(String str, com.applovin.impl.b.e eVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.n nVar) {
            super(eVar, appLovinAdLoadListener, nVar);
            this.aUP = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a(dA(this.aUP));
        }
    }

    private static final class d extends t {
        private final com.applovin.impl.sdk.utils.y aUR;

        d(com.applovin.impl.sdk.utils.y yVar, com.applovin.impl.b.e eVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.n nVar) {
            super(eVar, appLovinAdLoadListener, nVar);
            if (yVar == null) {
                throw new IllegalArgumentException("No response specified.");
            }
            if (eVar == null) {
                throw new IllegalArgumentException("No context specified.");
            }
            if (appLovinAdLoadListener == null) {
                throw new IllegalArgumentException("No callback specified.");
            }
            this.aUR = yVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.applovin.impl.sdk.x xVar = this.logger;
            if (com.applovin.impl.sdk.x.Fk()) {
                this.logger.f(this.tag, "Processing VAST Wrapper response...");
            }
            a(this.aUR);
        }
    }

    private static final class a extends com.applovin.impl.b.e {
        a(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.sdk.n nVar) {
            super(jSONObject, jSONObject2, bVar, nVar);
        }

        void b(com.applovin.impl.sdk.utils.y yVar) {
            if (yVar == null) {
                throw new IllegalArgumentException("No aggregated vast response specified");
            }
            this.aXg.add(yVar);
        }
    }
}
