package com.applovin.impl.mediation;

import android.app.Activity;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.adapter.MaxAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private final AtomicBoolean akD = new AtomicBoolean();
    private final JSONArray alV = new JSONArray();
    private final LinkedHashMap<String, Integer> alW = new LinkedHashMap<>();
    private final Object alX = new Object();
    private List<com.applovin.impl.mediation.b.f> alY;
    private final x logger;
    private final n sdk;

    public e(n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BL();
    }

    public boolean isInitialized() {
        return this.akD.get();
    }

    public void b(Activity activity) {
        if (this.akD.compareAndSet(false, true)) {
            String str = (String) this.sdk.a(com.applovin.impl.sdk.c.d.aRG);
            if (StringUtils.isValidString(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    List<com.applovin.impl.mediation.b.f> listA = a(JsonUtils.getJSONArray(jSONObject, this.sdk.CC().isEnabled() ? "test_mode_auto_init_adapters" : "auto_init_adapters", new JSONArray()), jSONObject);
                    this.alY = listA;
                    long j = StringUtils.parseLong(this.sdk.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.ADAPTER_INITIALIZATION_DELAY_MILLIS), -1L);
                    com.applovin.impl.mediation.d.a aVar = new com.applovin.impl.mediation.d.a(listA, activity, this.sdk);
                    if (j > 0) {
                        this.sdk.BM().a(aVar, q.b.BACKGROUND, j);
                    } else {
                        this.sdk.BM().b(aVar);
                    }
                } catch (JSONException e) {
                    if (x.Fk()) {
                        this.logger.c("MediationAdapterInitializationManager", "Failed to parse auto-init adapters JSON", e);
                    }
                }
            }
        }
    }

    public void a(com.applovin.impl.mediation.b.f fVar, Activity activity) {
        a(fVar, activity, null);
    }

    public void a(com.applovin.impl.mediation.b.f fVar, Activity activity, Runnable runnable) {
        List<com.applovin.impl.mediation.b.f> list;
        if (this.sdk.CC().isEnabled() && (list = this.alY) != null) {
            Iterator<com.applovin.impl.mediation.b.f> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    fVar = null;
                    break;
                }
                com.applovin.impl.mediation.b.f next = it.next();
                if (next.vt().equals(fVar.vt())) {
                    fVar = next;
                    break;
                }
            }
        }
        if (fVar == null) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        g gVarC = this.sdk.Cu().c(fVar);
        if (gVarC != null) {
            if (x.Fk()) {
                this.logger.g("MediationAdapterInitializationManager", "Initializing adapter " + fVar);
            }
            gVarC.a(MaxAdapterParametersImpl.a(fVar), activity, runnable);
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public LinkedHashMap<String, Integer> tV() {
        LinkedHashMap<String, Integer> linkedHashMap;
        synchronized (this.alX) {
            linkedHashMap = this.alW;
        }
        return linkedHashMap;
    }

    public JSONArray tW() {
        JSONArray jSONArray;
        synchronized (this.alX) {
            jSONArray = this.alV;
        }
        return jSONArray;
    }

    void a(com.applovin.impl.mediation.b.f fVar, long j, MaxAdapter.InitializationStatus initializationStatus, String str) {
        boolean z;
        if (initializationStatus == null || initializationStatus == MaxAdapter.InitializationStatus.INITIALIZING) {
            return;
        }
        synchronized (this.alX) {
            z = !b(fVar);
            if (z) {
                this.alW.put(fVar.vt(), Integer.valueOf(initializationStatus.getCode()));
                JSONObject jSONObject = new JSONObject();
                JsonUtils.putString(jSONObject, "class", fVar.vt());
                JsonUtils.putString(jSONObject, "init_status", String.valueOf(initializationStatus.getCode()));
                JsonUtils.putString(jSONObject, "error_message", JSONObject.quote(str));
                this.alV.put(jSONObject);
            }
        }
        if (z) {
            this.sdk.e(fVar);
            this.sdk.Cw().processAdapterInitializationPostback(fVar, j, initializationStatus, str);
            this.sdk.Cf().b(initializationStatus, fVar.vt());
        }
    }

    boolean b(com.applovin.impl.mediation.b.f fVar) {
        boolean zContainsKey;
        synchronized (this.alX) {
            zContainsKey = this.alW.containsKey(fVar.vt());
        }
        return zContainsKey;
    }

    private List<com.applovin.impl.mediation.b.f> a(JSONArray jSONArray, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new com.applovin.impl.mediation.b.f(Collections.EMPTY_MAP, JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null), jSONObject, this.sdk));
        }
        return arrayList;
    }

    public void a(MaxAdapter.InitializationStatus initializationStatus) {
        synchronized (this.alX) {
            this.alW.put("com.applovin.mediation.adapters.AppLovinMediationAdapter", Integer.valueOf(initializationStatus.getCode()));
        }
        this.sdk.Cf().b(initializationStatus, "com.applovin.mediation.adapters.AppLovinMediationAdapter");
    }
}
