package com.applovin.impl.mediation.d;

import android.content.Context;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinSdkUtils;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.applovin.impl.sdk.e.d {
    private static JSONObject awh;
    private static final Object awi = new Object();
    private static final Map<String, Set<String>> awj = Collections.synchronizedMap(new HashMap());
    private final Context E;
    private final MaxAdFormat adFormat;
    private final String adUnitId;
    private final a awk;
    private final Map<String, Object> localExtraParameters;

    public interface a {
        void a(JSONArray jSONArray);
    }

    public b(String str, MaxAdFormat maxAdFormat, Map<String, Object> map, Context context, n nVar, a aVar) {
        super("TaskCollectSignals", nVar);
        this.adUnitId = str;
        this.adFormat = maxAdFormat;
        this.localExtraParameters = map;
        this.E = context;
        this.awk = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray;
        try {
            synchronized (awi) {
                jSONArray = JsonUtils.getJSONArray(awh, "signal_providers", null);
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                if (awj.size() > 0) {
                    c(jSONArray, awh);
                    return;
                } else {
                    b(jSONArray, awh);
                    return;
                }
            }
            x xVar = this.logger;
            if (x.Fk()) {
                this.logger.h(this.tag, "Unable to find cached signal providers, fetching signal providers from SharedPreferences.");
            }
            JSONObject jSONObject = new JSONObject((String) this.sdk.b(com.applovin.impl.sdk.c.d.aRF, JsonUtils.EMPTY_JSON));
            JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "signal_providers", null);
            if (jSONArray2 != null && jSONArray2.length() != 0) {
                if (awj.size() > 0) {
                    c(jSONArray2, jSONObject);
                    return;
                } else {
                    b(jSONArray2, jSONObject);
                    return;
                }
            }
            f("No signal providers found", null);
        } catch (InterruptedException e) {
            f("Failed to wait for signals", e);
            this.sdk.Cq().d("TaskCollectSignals", "waitForSignals", e);
        } catch (JSONException e2) {
            f("Failed to parse signals JSON", e2);
            this.sdk.Cq().d("TaskCollectSignals", "parseSignalsJSON", e2);
        } catch (Throwable th) {
            f("Failed to collect signals", th);
            this.sdk.Cq().d("TaskCollectSignals", "collectSignals", th);
        }
    }

    private void b(JSONArray jSONArray, JSONObject jSONObject) throws JSONException, InterruptedException {
        RunnableC0120b runnableC0120b = new RunnableC0120b(jSONArray.length(), this.awk, this.sdk);
        for (int i = 0; i < jSONArray.length(); i++) {
            a(new com.applovin.impl.mediation.b.h(this.localExtraParameters, jSONArray.getJSONObject(i), jSONObject, this.sdk), runnableC0120b);
        }
        this.sdk.BM().a(new ab(this.sdk, "timeoutCollectSignal", runnableC0120b), q.b.MAIN, ((Long) this.sdk.a(com.applovin.impl.sdk.c.a.aJj)).longValue());
    }

    private void c(JSONArray jSONArray, JSONObject jSONObject) throws JSONException, InterruptedException {
        Set<String> set = awj.get(this.adUnitId);
        if (set == null || set.isEmpty()) {
            f("No signal providers found for ad unit: " + this.adUnitId, null);
            return;
        }
        RunnableC0120b runnableC0120b = new RunnableC0120b(set.size(), this.awk, this.sdk);
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            if (set.contains(JsonUtils.getString(jSONObject2, "name", null))) {
                a(new com.applovin.impl.mediation.b.h(this.localExtraParameters, jSONObject2, jSONObject, this.sdk), runnableC0120b);
            }
        }
        this.sdk.BM().a(new ab(this.sdk, "timeoutCollectSignal", runnableC0120b), q.b.MAIN, ((Long) this.sdk.a(com.applovin.impl.sdk.c.a.aJj)).longValue());
    }

    private void a(final com.applovin.impl.mediation.b.h hVar, final com.applovin.impl.mediation.b.g.a aVar) {
        if (hVar.yB()) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.mediation.d.-$$Lambda$b$18fTXtCPLbC1MuRoBF3oLzWaA1Q
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(hVar, aVar);
                }
            });
        } else {
            this.sdk.Cw().collectSignal(this.adUnitId, this.adFormat, hVar, this.E, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(com.applovin.impl.mediation.b.h hVar, com.applovin.impl.mediation.b.g.a aVar) {
        this.sdk.Cw().collectSignal(this.adUnitId, this.adFormat, hVar, this.E, aVar);
    }

    private void f(String str, Throwable th) {
        x xVar = this.logger;
        if (x.Fk()) {
            this.logger.c(this.tag, "No signals collected: " + str, th);
        }
        a aVar = this.awk;
        if (aVar != null) {
            aVar.a(new JSONArray());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: com.applovin.impl.mediation.d.b$b, reason: collision with other inner class name */
    static class RunnableC0120b implements com.applovin.impl.mediation.b.g.a, Runnable {
        private final AtomicBoolean amB;
        private final a awk;
        private final Object awl;
        private int awm;
        private final Collection<com.applovin.impl.mediation.b.g> awn;
        private final x logger;
        private final n sdk;

        private RunnableC0120b(int i, a aVar, n nVar) {
            this.awm = i;
            this.awk = aVar;
            this.sdk = nVar;
            this.logger = nVar.BL();
            this.awl = new Object();
            this.awn = new ArrayList(i);
            this.amB = new AtomicBoolean();
        }

        @Override // com.applovin.impl.mediation.b.g.a
        public void a(com.applovin.impl.mediation.b.g gVar) {
            boolean z;
            synchronized (this.awl) {
                this.awn.add(gVar);
                int i = this.awm - 1;
                this.awm = i;
                z = i < 1;
            }
            if (z && this.amB.compareAndSet(false, true)) {
                if (u.Lv() && ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQD)).booleanValue()) {
                    this.sdk.BM().a(new ab(this.sdk, "handleSignalCollectionCompleted", new Runnable() { // from class: com.applovin.impl.mediation.d.-$$Lambda$b$b$eOsFRmKupjdVuspIg6z6MI_IPsU
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.zz();
                        }
                    }), q.b.MEDIATION_MAIN);
                } else {
                    zz();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.amB.compareAndSet(false, true)) {
                zz();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void zz() {
            ArrayList<com.applovin.impl.mediation.b.g> arrayList;
            synchronized (this.awl) {
                arrayList = new ArrayList(this.awn);
            }
            JSONArray jSONArray = new JSONArray();
            for (com.applovin.impl.mediation.b.g gVar : arrayList) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    com.applovin.impl.mediation.b.h hVarYG = gVar.yG();
                    jSONObject.put("name", hVarYG.yz());
                    jSONObject.put("class", hVarYG.vt());
                    jSONObject.put(TapjoyConstants.TJC_ADAPTER_VERSION, gVar.getAdapterVersion());
                    jSONObject.put("sdk_version", gVar.getSdkVersion());
                    JSONObject jSONObject2 = new JSONObject();
                    if (StringUtils.isValidString(gVar.getErrorMessage())) {
                        jSONObject2.put("error_message", gVar.getErrorMessage());
                    } else {
                        jSONObject2.put("signal", gVar.yH());
                    }
                    jSONObject.put("data", jSONObject2);
                    jSONArray.put(jSONObject);
                    if (x.Fk()) {
                        this.logger.f("TaskCollectSignals", "Collected signal from " + hVarYG);
                    }
                } catch (JSONException e) {
                    if (x.Fk()) {
                        this.logger.c("TaskCollectSignals", "Failed to create signal data", e);
                    }
                    this.sdk.Cq().d("TaskCollectSignals", "createSignalsData", e);
                }
            }
            d(jSONArray);
        }

        private void d(JSONArray jSONArray) {
            a aVar = this.awk;
            if (aVar != null) {
                aVar.a(jSONArray);
            }
        }
    }

    public static void p(JSONObject jSONObject) {
        synchronized (awi) {
            awh = jSONObject;
        }
    }

    public static void c(JSONObject jSONObject, n nVar) {
        try {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "ad_unit_signal_providers", (JSONObject) null);
            if (jSONObject2 != null) {
                for (String str : JsonUtils.toList(jSONObject2.names())) {
                    awj.put(str, new HashSet(JsonUtils.getList(jSONObject2, str, null)));
                }
            }
        } catch (JSONException e) {
            x.e("TaskCollectSignals", "Failed to parse ad unit signal providers for JSON object: " + jSONObject, e);
            nVar.Cq().d("TaskCollectSignals", "parseAdUnitSignalProvidersJSON", e);
        }
    }
}
