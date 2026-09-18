package com.applovin.impl.sdk.d;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g {
    private final Map<String, Long> aTh = new HashMap();
    private final n sdk;

    public g(n nVar) {
        if (nVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.sdk = nVar;
    }

    public long a(f fVar) {
        return a(fVar, 1L);
    }

    long a(f fVar, long j) {
        long jLongValue;
        synchronized (this.aTh) {
            Long l = this.aTh.get(fVar.getName());
            if (l == null) {
                l = 0L;
            }
            jLongValue = l.longValue() + j;
            this.aTh.put(fVar.getName(), Long.valueOf(jLongValue));
        }
        JY();
        return jLongValue;
    }

    public long b(f fVar) {
        long jLongValue;
        synchronized (this.aTh) {
            Long l = this.aTh.get(fVar.getName());
            if (l == null) {
                l = 0L;
            }
            jLongValue = l.longValue();
        }
        return jLongValue;
    }

    public void b(f fVar, long j) {
        synchronized (this.aTh) {
            this.aTh.put(fVar.getName(), Long.valueOf(j));
        }
        JY();
    }

    public void JU() {
        synchronized (this.aTh) {
            this.aTh.clear();
        }
        JY();
    }

    public void c(f fVar) {
        synchronized (this.aTh) {
            this.aTh.remove(fVar.getName());
        }
        JY();
    }

    public void JV() {
        synchronized (this.aTh) {
            Iterator<f> it = f.JT().iterator();
            while (it.hasNext()) {
                this.aTh.remove(it.next().getName());
            }
            JY();
        }
    }

    public JSONObject JW() {
        JSONObject jSONObject;
        synchronized (this.aTh) {
            jSONObject = new JSONObject();
            for (Map.Entry<String, Long> entry : this.aTh.entrySet()) {
                JsonUtils.putLong(jSONObject, entry.getKey(), entry.getValue().longValue());
            }
        }
        return jSONObject;
    }

    public void JX() {
        try {
            JSONObject jSONObject = new JSONObject((String) this.sdk.b(com.applovin.impl.sdk.c.d.aRy, JsonUtils.EMPTY_JSON));
            synchronized (this.aTh) {
                try {
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        try {
                            String next = itKeys.next();
                            this.aTh.put(next, Long.valueOf(jSONObject.getLong(next)));
                        } catch (JSONException unused) {
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().c("GlobalStatsManager", "Unable to load stats", th2);
            }
        }
    }

    private void JY() {
        this.sdk.BM().h(new Runnable() { // from class: com.applovin.impl.sdk.d.-$$Lambda$g$Rjvj5uqXtXD2kPOfyKyOZsC_bgo
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.JZ();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void JZ() {
        try {
            this.sdk.a(com.applovin.impl.sdk.c.d.aRy, JW().toString());
        } catch (Throwable th) {
            this.sdk.BL();
            if (x.Fk()) {
                this.sdk.BL().c("GlobalStatsManager", "Unable to save stats", th);
            }
        }
    }
}
